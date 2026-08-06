const POKEMON_URL = "https://pokeapi.co/api/v2/pokemon";

const pokemonList = document.getElementById("pokemon-list");
const loader = document.getElementById("loader");

let offset = 0;
const limit = 20;
let loading = false;


// Skeleton loader
function showSkeleton(count = 20) {

    const skeletons = [];

    for (let i = 0; i < count; i++) {

        const card = document.createElement("div");

        card.className = "pokemon-card skeleton-card";

        card.innerHTML = `
            <div class="skeleton skeleton-img"></div>

            <div class="skeleton skeleton-name"></div>

            <div class="skeleton skeleton-num"></div>

            <div class="pok-tags">
                <div class="skeleton skeleton-tag"></div>
                <div class="skeleton skeleton-tag"></div>
            </div>
        `;


        pokemonList.appendChild(card);

        skeletons.push(card);
    }

    return skeletons;
}



// Pokemon load
async function loadPokemon() {

    // Давхар fetch-ээс хамгаална
    if (loading) return;

    loading = true;


    // Skeleton харуулах
    const skeletons = showSkeleton(limit);


    try {

        const response = await fetch(
            `${POKEMON_URL}?offset=${offset}&limit=${limit}`
        );


        const data = await response.json();


        // Detail мэдээлэл зэрэг авах
        const pokemonData = await Promise.all(

            data.results.map(async (pokemon) => {

                const response = await fetch(pokemon.url);

                return await response.json();

            })

        );


        // Skeleton устгах
        skeletons.forEach(item => {
            item.remove();
        });



        // Card үүсгэх
        pokemonData.forEach(data => {

            createCard(data);

        });


        offset += limit;


    } catch(error) {

        console.log(error);

    }


    loading = false;

}



// Card create
function createCard(data) {


    const card = document.createElement("div");

    card.className = "pokemon-card";


    card.innerHTML = `

        <div class="pok-img">

            <img 
                loading="lazy"
                src="${data.sprites.other["official-artwork"].front_default}" 
                alt="${data.name}"
            >

        </div>


        <p class="pok-name">

            ${data.name.charAt(0).toUpperCase() + data.name.slice(1)}

        </p>


        <p class="pok-num">

            #${String(data.id).padStart(3, "0")}

        </p>


        <div class="pok-tags">

            ${data.types.map(type => `

                <div class="pok-tag ${type.type.name}">

                    <img 
                        src="./images/tags/${type.type.name}.svg"
                        alt="${type.type.name}"
                    >

                    <p class="tag-name">
                        ${type.type.name.charAt(0).toUpperCase() + type.type.name.slice(1)}
                    </p>

                </div>


            `).join("")}

        </div>

    `;


    pokemonList.appendChild(card);

}



// First load
loadPokemon();



// Infinite scroll observer
const observer = new IntersectionObserver((entries)=>{


    if(entries[0].isIntersecting){

        loadPokemon();

    }


});


observer.observe(loader);