const API_KEY = "72f6c44c87f66d48bcb287391484b6d0";
let LATITUDE = 47.922310;
let LONGITUDE = 106.904834
let default_city_name = 'Ulaanbaatar';
// const API_URL = `https://api.openweathermap.org/data/4.0/onecall/current?lat=52.2297&lon=21.0122&units=metric&lang=en&appid={API key}`;


const API_URL =
    `https://api.openweathermap.org/data/2.5/weather?lat=${LATITUDE}&lon=${LONGITUDE}&units=metric&appid=${API_KEY}`;

// let GEO_API_URL = `http://api.openweathermap.org/geo/1.0/direct?q=${default_city_name}&limit=10&appid=${API_KEY}`;

// 2. DOM ELements

const searchInput = document.getElementById('search-input');
const searchBtn = document.getElementById('search-btn');
const weatherInfo = document.getElementById('weather-info');
const spinner = document.getElementById('spinner');

// 3.1 fetch API use
function useFetchAPI() {
    fetch(GEO_API_URL)
        .then(response => response.json())
        .then((data) => {
            // console.log(data);
            if(data.length === 0) {
                throw new Error ('City not found');
            }

            const cityName = data[0].name;
            document.getElementById('city-name').textContent = cityName;
            weatherInfo.style.display = 'block';


        }).catch(error => console.error(error));
}


// 3.2 async wait

async function useAsyncAwait(city) {
    try {
        // spinner
        spinner.style.display ='block';
        weatherInfo.style.display = 'none';

        default_city_name = city;
        console.log(default_city_name);

        // async wait
        // console.log(GEO_API_URL)
        const geoResponse = await fetch(`http://api.openweathermap.org/geo/1.0/direct?q=${city}&limit=10&appid=${API_KEY}`);
        // console.log(geoResponse);

        const geoData = await geoResponse.json();
        LONGITUDE = geoData[0].lon;
        LATITUDE = geoData[0].lat;

        console.log(geoData);

        const weatherResponse = await fetch(`https://api.openweathermap.org/data/2.5/weather?lat=${LATITUDE}&lon=${LONGITUDE}&units=metric&appid=${API_KEY}`);
        // console.log(geoResponse);
        const weatherData = await weatherResponse.json();
        console.log(weatherData);

        document.getElementById('city-name').textContent = geoData[0].name;
        document.getElementById('temp').innerHTML = Math.round(weatherData.main.temp) + '&#8451';
        document.getElementById('description').textContent = weatherData.weather[0].main;
        spinner.style.display = 'none';
        weatherInfo.style.display = 'block';



    } catch (error) {
        spinner.style.display = 'none';
        alert(error.message);
    }
}

useAsyncAwait('Paris');
// useFetchAPI();


searchBtn.addEventListener('click', ()=> {
    const cityName = searchInput.value;
    console.log(cityName);
    useAsyncAwait(cityName);
})

searchInput.addEventListener('keydown', e=> {
    console.log(e);
    if(e.key = 'Enter') {
        console.log('Enter clicked');
    }
})


