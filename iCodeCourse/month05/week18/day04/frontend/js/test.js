const POKEMON_API_V2 = `https://pokeapi.co/api/v2/pokemon`;

async function loadPokemons() {
    try {
        const response = await fetch(POKEMON_API_V2);
        const data = await response.json();

        const detailPromise = data.results.map(async(item) => {
            const detailResponse = await fetch(item.url);
            return await detailResponse.json();
        });
        
        const pokemonDetails = await Promise.all(detailPromise);
        console.log(pokemonDetails);

    } catch (error) {
        console.log(error);
    }
}

loadPokemons();