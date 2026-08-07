const POKEMON_API_V2 = `https://pokeapi.co/api/v2/pokemon`;
const PAGE_SIZE = 20; // neg udaagiin  duudah pokemon too
let currentPage = 0;
let isLoading = false;
const POKEMON_CONTAINER = document.querySelector('#pokemon-grid');


async function loadPokemons() {
    if(isLoading) return;

    isLoading = true;

    try {
        const offset = currentPage * PAGE_SIZE;
        const listUrl = `https://pokeapi.co/api/v2/pokemon?offset=${offset}&limit=${PAGE_SIZE}`;
        

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
const observer = new IntersectionObserver((entries) => {
    if(entries[0].isIntersecting) {
        loadPokemons();
    }
});

observer.observe(loader);
loadPokemons();



const modal = document.querySelector("#pokemon-modal");
const modalBody = document.querySelector("#modal-body");
const closeBtn = document.querySelector(".close-btn");


// Card click

POKEMON_CONTAINER.addEventListener("click", async (e)=>{
    const card = e.target.closest(".card");
    if(!card) return;
    document.body.style.overflow = "hidden";
    const id = card.dataset.id;
    openModal(id);
});



// Modal data авах

async function openModal(id){
    const response = await fetch(
        `${POKEMON_API_V2}/${id}`
    );

    const pokemon = await response.json();

    modalBody.innerHTML = `

        <img 
            class="modal-img"
            src="${pokemon.sprites.other["official-artwork"].front_default}"
        >


        <h2>
            ${pokemon.name}
        </h2>


        <h3>
            #${String(pokemon.id).padStart(3,"0")}
        </h3>


        <div class="modal-types">

            ${
                pokemon.types.map(type=>`

                    <div class="type ${type.type.name}">

                        <img 
                            src="./images/tags/${type.type.name}.svg"
                        >

                        <p>
                            ${type.type.name}
                        </p>

                    </div>

                `).join("")
            }

        </div>

    `;


    modal.classList.add("active");
    

}



// Close

closeBtn.addEventListener("click",() => {
    modal.classList.remove("active");
    document.body.style.overflow = "auto";
});



// outside click close

modal.addEventListener("click",(e) => {
    
    if(e.target === modal){

        modal.classList.remove("active");
        document.body.style.overflow = "auto";
    }

});


const sortBtn = document.querySelector(".sort-btn");
const sortMenu = document.querySelector(".sort-menu");
const selectedSort = document.getElementById("selected-sort");

sortBtn.addEventListener("click", () => {
    sortMenu.classList.toggle("active");
});

document.querySelectorAll(".sort-menu li").forEach(item => {

    item.addEventListener("click", () => {

        selectedSort.textContent = item.textContent;

        const value = item.dataset.value;

        console.log(value);

        sortMenu.classList.remove("active");

        // энд sortPokemon(value) гэж дуудаж болно
    });

});

document.addEventListener("click", e => {

    if (!e.target.closest(".sort-dropdown")) {
        sortMenu.classList.remove("active");
    }

});