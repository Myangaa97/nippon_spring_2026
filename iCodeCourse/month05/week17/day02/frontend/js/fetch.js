const IMAGE_URL = 'https://dummyjson.com/image/300';
const mainContainer = document.getElementById('main');

function fetchImage(URL) {
    return fetch(URL); //FETCH api browser - iin function
}

const result = fetchImage(IMAGE_URL).then((response) => {
        return response.blob();
    });

console.log(result);

result.then((blob) => {
    const url = URL.createObjectURL(blob);
    console.log(url);
    const img = document.createElement('img');
    img.src = url;
    mainContainer.appendChild(img);
});