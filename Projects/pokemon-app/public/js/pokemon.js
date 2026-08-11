const POKEMON_API_V2 = `https://pokeapi.co/api/v2/pokemon`;
const PAGE_SIZE = 20; // neg udaagiin  duudah pokemon too
let currentPage = 0;
let isLoading = false;
const POKEMON_CONTAINER = document.querySelector('#pokemon-grid');
const typeSelect = document.getElementById('type-select');
const modal = document.getElementById('pokemon-modal');
const modalContent = document.getElementById('modal-content');
const closeModalBtn = document.getElementById('close-modal');


async function loadPokemons() {
    if (isLoading) return;

    isLoading = true;

    try {
        const offset = currentPage * PAGE_SIZE;
        const listUrl = `https://pokeapi.co/api/v2/pokemon?offset=${offset}&limit=${PAGE_SIZE}`;


        // 1. get all list of pokemons
        const response = await fetch(listUrl);
        const data = await response.json();
        console.log('Full data', data);

        // 2. call every detail of pokemons
        const detailPromise = data.results.map(async (item) => {
            // console.log(item);
            const detailResponse = await fetch(item.url);
            return await detailResponse.json();
        });
        console.log('1 promise', detailPromise);

        // 3. bvh promise hvselt negtgeh
        const pokemonDetails = await Promise.all(detailPromise);
        console.log('all promise', pokemonDetails);

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

// Modal fuction
async function openPokemonModal(id) {
    modalContent.innerHTML = "<p>Loading .....</p>"
    modal.showModal();

    try {
        const res = await fetch(`https://pokeapi.co/api/v2/pokemon/${id}`);
        const pokemon = await res.json();
        console.log('modal pokemon: ', pokemon);

        const artWork = pokemon.sprites.other['official-artwork'].front_default || pokemon.sprites.front_default;
        modalContent.classList.add(pokemon.types[0].type.name);
        modalContent.innerHTML = `

            <div class="modal-head">
                <div class="modal-img">
                    <img src="${artWork}" alt=${pokemon.name} />
                </div>
                <div class="modal-h-text">
                    <h4>#${String(pokemon.id).padStart(3, '0')}</h4>
                    <h3>${pokemon.name}</h3>
                </div>
            </div>

            <div class="modal-main">
                <p>${pokemon.height}</p>
                <p>${pokemon.weight}</p>
            </div>
            
        `;
    } catch (error) {
        modalContent.innerHTML = "<p>Error...</p>";
    }
}

// Setup Event
POKEMON_CONTAINER.addEventListener('click', (event)=> {
    
    const clickedCard = event.target.closest('.card');
    console.log(clickedCard.dataset.id);
    if(clickedCard) {
        const pokenmonId = clickedCard.dataset.id;
        openPokemonModal(pokenmonId);
    }

    closeModalBtn.addEventListener('click', () => {
        
    });
});


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