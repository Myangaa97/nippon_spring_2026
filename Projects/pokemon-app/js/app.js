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

    if (loading) return;

    loading = true;


    const skeletons = showSkeleton(limit);


    try {

        const response = await fetch(
            `${POKEMON_URL}?offset=${offset}&limit=${limit}`
        );


        const data = await response.json();



        const pokemonData = await Promise.all(

            data.results.map(async pokemon => {

                const response = await fetch(pokemon.url);

                return await response.json();

            })

        );



        // remove skeleton

        skeletons.forEach(item => item.remove());



        // create cards

        pokemonData.forEach(data => {

            createCard(data);

        });



        offset += limit;


    } catch(error) {

        console.log(error);

    }


    loading = false;

}




// Create pokemon card

function createCard(data) {


    const card = document.createElement("div");


    // Card background type авах
    const mainType = data.types[0].type.name;


    card.className = `pokemon-card ${mainType}`;



    card.innerHTML = `


        <div class="pok-img">

            <img 
                loading="lazy"
                src="${data.sprites.other["official-artwork"].front_default}"
                alt="${data.name}"
            >

        </div>



        <p class="pok-name">

            ${capitalize(data.name)}

        </p>



        <p class="pok-num">

            #${String(data.id).padStart(3,"0")}

        </p>



        <div class="pok-tags">


            ${data.types.map(type => {


                const typeName = type.type.name;


                return `

                <div class="pok-tag ${typeName}">


                    <img 
                        src="./images/tags/${typeName}.svg"
                        alt="${typeName}"
                    >


                    <p class="tag-name">

                        ${capitalize(typeName)}

                    </p>


                </div>

                `;


            }).join("")}



        </div>


    `;



    pokemonList.appendChild(card);

}




// First letter uppercase

function capitalize(text) {

    return text.charAt(0).toUpperCase() + text.slice(1);

}




// First load

loadPokemon();





// Infinite scroll

const observer = new IntersectionObserver(entries => {


    if(entries[0].isIntersecting){

        loadPokemon();

    }


});



observer.observe(loader);