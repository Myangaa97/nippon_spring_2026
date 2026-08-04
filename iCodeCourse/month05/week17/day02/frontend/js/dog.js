const DOG_URL = 'https://dog.ceo/api/breeds/image/random';
const dogElement = document.getElementById('dog-container');

fetch(DOG_URL)
    .then(response => response.json())
    .then(data => {
        console.log(data);
        const img = document.createElement('img');
        img.src = data.message;

        dogElement.appendChild(img);
    })
    .catch(error => console.error('Aldaa garlaa: ', error));