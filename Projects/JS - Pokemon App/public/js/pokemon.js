const POKEMON_API_V2 = `https://pokeapi.co/api/v2/pokemon`;
const BROWSE_PAGE_SIZE = 20;
const SEARCH_PAGE_SIZE = 100;
let currentPage = 0;
let isLoading = false;
const POKEMON_CONTAINER = document.querySelector('#pokemon-grid');


async function loadPokemons() {
    if (isLoading) return;

    isLoading = true;

    try {
        const offset = currentPage * BROWSE_PAGE_SIZE;
        const listUrl = `https://pokeapi.co/api/v2/pokemon?offset=${offset}&limit=${BROWSE_PAGE_SIZE}`;


        // 1. get all list of pokemons
        const response = await fetch(listUrl);
        const data = await response.json();
        console.log(data);

        // 2. call every detail of pokemons
        const detailPromise = data.results.map(async (item) => {
            // console.log(item);
            const detailResponse = await fetch(item.url);
            return await detailResponse.json();
        });
        console.log(detailPromise);

        // 3. bvh promise hvselt negtgeh
        const pokemonDetails = await Promise.all(detailPromise);
        console.log(pokemonDetails);

        // 4. Render pokemons to the pokemon containers
        pokemonDetails.forEach((pokemon) => {
            console.log(pokemon);

            renderCard(pokemon);
        });

        currentPage++;

    } catch (error) {
        console.error('Error during loading', error);
    } finally {
        isLoading = false;
    }
}

function renderCard(pokemon) {
    if (!POKEMON_CONTAINER) return;
    const card = document.createElement('div');
    card.classList.add("card", pokemon.types[0].type.name);
    card.dataset.id = pokemon.id;

    const artWork = pokemon.sprites.other['official-artwork'].front_default || pokemon.sprites.front_default;
    const types = pokemon.types.map(item => `
        <div class="type ${item.type.name}">
            <img src="./images/tags/${item.type.name}.svg" alt="${item.type.name}">
            <p class="num">${item.type.name}</p>
        </div>
    `).join("");

    card.innerHTML = `
        <div class="pokemon-img"><img src="${artWork}" alt=${pokemon.name} /></div>
        <h3>${pokemon.name}</h3>
        <h4>#${String(pokemon.id).padStart(3, '0')}</h4>
        <div class="types">${types}</div>
    `;

    POKEMON_CONTAINER.appendChild(card);
}

const loader = document.querySelector("#loading-trigger");
if (loader) {
    const observer = new IntersectionObserver((entries) => {
        if (entries[0].isIntersecting) {
            loadPokemons();
        }
    });
    observer.observe(loader);
} else {
    loadPokemons();
}


