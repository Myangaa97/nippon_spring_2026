let LATITUDE = 47.922310;
let LONGITUDE = 106.904834
let default_city_name = 'Ulaanbaatar';

let currentUnit = 'C';
let globalWeatherData = null;
let globalGeoData = null;

const searchInput = document.getElementById('search-input');
const suggestions = document.getElementById('city-suggestions');
const weatherMain = document.querySelector('.weather-main');
const spinner = document.getElementById('spinner');
const unitToggleBtn = document.getElementById('unit-toggle-btn');

let searchTimer;

async function weatherAsync(city) {
    try {
        // 0. spinner
        if (spinner) {
            spinner.style.display = 'block';
        }
        if (weatherMain) {
            weatherMain.style.display = 'none';
        }
        default_city_name = city;

        // 1. CITY - LATITUDE / LONGITUDE
        const geoResponse = await fetch(`https://geocoding-api.open-meteo.com/v1/search?name=${encodeURIComponent(city)}&count=1&language=en&format=json`);
        const geoData = await geoResponse.json();
        console.log('City Data:', geoData);

        if (!geoData.results || geoData.results.length === 0) {
            throw new Error('City not found');
        }

        globalGeoData = geoData.results[0];
        LATITUDE = geoData.results[0].latitude;
        LONGITUDE = geoData.results[0].longitude;

        // 2. WEATHER DATA
        const weatherResponse = await fetch(
            `https://api.open-meteo.com/v1/forecast?` +
            `latitude=${LATITUDE}` +
            `&longitude=${LONGITUDE}` +
            `&current=temperature_2m,apparent_temperature,relative_humidity_2m,weather_code,wind_speed_10m` +
            `&hourly=temperature_2m,weather_code,precipitation_probability,uv_index` + // weather_code нэмэв
            `&daily=weather_code,temperature_2m_max,temperature_2m_min,precipitation_probability_max,uv_index_max,sunrise,sunset` +
            `&timezone=auto`
        );

        const weatherData = await weatherResponse.json();
        console.log('Weather Data:', weatherData);
        globalWeatherData = weatherData;
        updateWeatherDOM();

    } catch (error) {
        if (spinner) {
            spinner.style.display = 'none';
        }
        if (weatherMain) {
            weatherMain.style.display = 'flex';
        }
        alert(error.message);
    }
}

function updateWeatherDOM() {
    if (!globalGeoData || !globalWeatherData) {
        return;
    }

    const geoData = globalGeoData;
    const weatherData = globalWeatherData;
    
    const date = weatherData.daily.time[0];
    let maxTemp = weatherData.daily.temperature_2m_max[0];
    let minTemp = weatherData.daily.temperature_2m_min[0];
    const weatherCode = weatherData.daily.weather_code[0];

    const sunrise = weatherData.daily.sunrise[0];
    const sunset = weatherData.daily.sunset[0];
    const rain = weatherData.daily.precipitation_probability_max[0];
    let windSpeed = weatherData.current.wind_speed_10m;
    const uvIndex = weatherData.daily.uv_index_max[0];
    let feelsLike = weatherData.current.apparent_temperature;

    let tempUnit = '°C';
    let speedUnit = 'KM/H';

    if (currentUnit === 'F') {
        maxTemp = maxTemp * 9 / 5 + 32;
        minTemp = minTemp * 9 / 5 + 32;
        feelsLike = feelsLike * 9 / 5 + 32;
        windSpeed = windSpeed * 0.621371;
        tempUnit = '°F';
        speedUnit = 'MPH'
    }

    // DOM - MAIN
    document.querySelector('.city-date').textContent = formatDate(date);
    document.querySelector('.city-name').textContent = geoData.name;
    document.querySelector('.city-temp').textContent = `${Math.round(maxTemp)}${(tempUnit)}/${Math.round(minTemp)}${(tempUnit)}`;
    document.querySelector('.city-w-img').innerHTML = `<img src="./images/${weatherCode}.png" alt="${weatherCode}">`;

    //DOM - DETAILS
    document.querySelector('.sunrise').textContent = formatTime(sunrise);
    document.querySelector('.sunset').textContent = formatTime(sunset);
    document.querySelector('.rain').textContent = `${Math.round(rain)} %`;
    document.querySelector('.wind-speed').textContent = `${Math.round(windSpeed)}${(speedUnit)}`;
    document.querySelector('.uv-index').textContent = `${Math.round(uvIndex)} of 10`;
    document.querySelector('.feels-like').textContent = `${Math.round(feelsLike)}${(tempUnit)}`;

    // DOM - HOURLY
    const todayTrack = document.querySelector('.today-track');
    todayTrack.innerHTML = '';

    const today = weatherData.current.time.split('T')[0];
    const currentTime = new Date(weatherData.current.time);

    weatherData.hourly.time.forEach((time, index) => {
        if(!time.startsWith(today)) {
            return;
        }

        if(new Date(time) < currentTime) {
            return;
        }

        let temp = weatherData.hourly.temperature_2m[index];
        if (currentUnit === 'F') {
            temp = temp * 9 / 5 + 32;
        }
        const hourWeathercode = weatherData.hourly.weather_code[index];
        const card = document.createElement('div');
        card.classList.add('forecast-card');
        card.innerHTML = `
            <p>${formatTime(time)}</p>
            <img src="./images/${hourWeathercode}.png" alt="${hourWeathercode}"></img>
            <h4>${Math.round(temp)}${(tempUnit)}</h4>
        `;
        todayTrack.appendChild(card);
    });

    // DOM - WEEKLY
    const weekList = document.querySelector('.week-list');
    weekList.innerHTML = '';

    weatherData.daily.time.forEach((date, index) => {
        let maxTempWeek = weatherData.daily.temperature_2m_max[index];
        let minTempWeek = weatherData.daily.temperature_2m_min[index];
        if (currentUnit === 'F') {
            maxTempWeek = maxTempWeek * 9 / 5 + 32;
            minTempWeek = minTempWeek * 9 / 5 + 32;
        }
        const weeklyCode = weatherData.daily.weather_code[index];
        const card = document.createElement('div');
        card.classList.add('week-card');
        card.innerHTML = `
            <div class="date">
                <p class="week-month">${formatMonthDay(date)}</p>
                <p class="week-day">${formatWeekday(date)}</p>
            </div>
            <div class="forecast">
                <img src="./images/${weeklyCode}.png" alt="${getWeatherDescription(weeklyCode)}">
                <p class="week-forecast">${getWeatherDescription(weeklyCode)}</p>
            </div>
            <p class="week-meter">${Math.round(maxTempWeek)}${tempUnit}/${Math.round(minTempWeek)}${tempUnit}</p>
        `;
        weekList.appendChild(card);
    });

    spinner.style.display = 'none';
    weatherMain.style.display = 'flex';
}

// SEARCH
if (searchInput && suggestions) {
    searchInput.addEventListener('input', ()=> {
        const city = searchInput.value.trim();
        clearTimeout(searchTimer);

        if (city.length < 2) {
            suggestions.innerHTML = '';
            suggestions.style.display = 'none';
            return;
        }

        searchTimer = setTimeout(() => {
            searchCities(city);
        }, 300);
    });

    searchInput.addEventListener('keydown', (event) => {
        if (event.key === 'Enter') {
            const city = searchInput.value.trim();
            if (city) {
                weatherAsync(city);
                suggestions.innerHTML = '';
                suggestions.style.display = 'none';
                searchInput.value = '';
            }
        }
    });
}

// SEARCH - CITIES
async function searchCities(city) {
    try {
        const response = await fetch(`https://geocoding-api.open-meteo.com/v1/search?name=${encodeURIComponent(city)}&count=5&language=en&format=json`);
        const data = await response.json();
        suggestions.innerHTML = '';

        if (!data.results || !data.results.length === 0) {
            suggestions.style.display = 'none';
            return;
        }

        data.results.forEach((item) => {
            const cityItem = document.createElement('div');
            cityItem.classList.add('city-suggestion');
            cityItem.innerHTML = `
                <span>
                    ${item.name},
                    ${item.country || ''} ${item.admin1 ? `, ${item.admin1}`: ''}
                </span>
            `;

            cityItem.addEventListener('click', () => {
                searchInput.value = item.name;
                suggestions.innerHTML = '';
                suggestions.style.display = 'none';
                weatherAsync(item.name);
            });

            suggestions.appendChild(cityItem);
        });

        suggestions.style.display = 'block';

    } catch (error) {
        console.log('City search error:', error);
    }
}

// ENTER SEARCH
if (searchInput) {
    searchInput.addEventListener('keydown', (event) => {
        if (event.key === 'Enter') {
            const cityName = searchInput.value.trim();
            if (cityName) {
                weatherAsync(cityName);
                searchInput.value = '';
                suggestions.innerHTML = '';
                suggestions.style.display = 'none';
            }
        }
    });
}

// CLICK OUTSIDE, CLOSE SUGGESSION
document.addEventListener('click', (event) => {
    console.log('CLICK');
    if(
        suggestions &&
        searchInput &&
        !searchInput.contains(event.target) &&
        !suggestions.contains(event.target)
    ) {
        suggestions.innerHTML = '';
        suggestions.style.display = 'none';
    }
});

// TOGGLE BUTTON
if (unitToggleBtn) {
    unitToggleBtn.addEventListener('click', () => {
        const units = unitToggleBtn.querySelectorAll('p');
        units.forEach(unit => {
        unit.classList.toggle('active');
        });
    currentUnit = currentUnit === 'C' ? 'F' : 'C';
    updateWeatherDOM();
    });
}

weatherAsync('Ulaanbaatar');

// TIME FORMAT
function formatTime(time) {
    return new Date(time).toLocaleTimeString("en-US", {
        hour: "numeric",
        minute: "2-digit"
    });
}

// DATE FORMAT
function formatDate(dateString) {
    const date = new Date(dateString);
    const day = date.getDate();

    let suffix = 'th';
    if(day % 10 === 1 && day !== 11) {
        suffix = 'st';
    } else if (day % 10 === 2 && day !== 12) {
        suffix = 'nd';
    } else if (day % 10 === 3 && day !== 13) {
        suffix = 'rd';
    }

    const month = date.toLocaleDateString('en-US', {
        month: 'short'
    });

    const weekday = date.toLocaleDateString('en-US', {
        weekday: 'long'
    });

    return `${day}${suffix} ${month}, ${weekday}`;
}

function formatMonthDay(dateString) {
    const date = new Date(dateString);
    const day = date.getDate();

    let suffix = 'th';
    if(day % 10 === 1 && day !== 11) {
        suffix = 'st';
    } else if (day % 10 === 2 && day !== 12) {
        suffix = 'nd';
    } else if (day % 10 === 3 && day !== 13) {
        suffix = 'rd';
    }

    const month = date.toLocaleDateString('en-US', {
        month: 'long' 
    });

    return `${day}${suffix} ${month}`;
}

function formatWeekday(dateString) {
    return new Date(dateString).toLocaleDateString('en-US', {
        weekday: 'long'
    });
}

function getWeatherDescription(weatherCode) {

    const descriptions = {
        0: 'Clear Sky',
        1: 'Mainly Clear',
        2: 'Partly Cloudy',
        3: 'Overcast',
        45: 'Fog',
        48: 'Rime Fog',
        51: 'Light Drizzle',
        53: 'Drizzle',
        55: 'Dense Drizzle',
        61: 'Light Rain',
        63: 'Rain',
        65: 'Heavy Rain',
        71: 'Light Snow',
        73: 'Snow',
        75: 'Heavy Snow',
        80: 'Rain Showers',
        81: 'Rain Showers',
        82: 'Heavy Rain Showers',
        85: 'Snow Showers',
        86: 'Heavy Snow Showers',
        95: 'Thunderstorm',
        96: 'Thunderstorm with Hail',
        99: 'Thunderstorm with Heavy Hail'
    };

    return descriptions[weatherCode] || 'Unknown';
}