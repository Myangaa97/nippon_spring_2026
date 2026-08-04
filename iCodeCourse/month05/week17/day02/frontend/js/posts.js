//API JSON DATA

const QUOTES_URL = 'https://dummyjson.com/quotes';
const mainElement = document.querySelector('main');

fetch(QUOTES_URL)
    .then(response => response.json())
    .then((data) => {
        // console.log(data);
        const quotes = data.quotes;
        // console.log(quotes);
        for(let i = 0; i < quotes.length; i++) {
            // console.log(quotes[i].quotes)
            const pQuote = document.createElement('p');
            pQuote.textContent = quotes[i].quote;
            pQuote.classList.add('quote');
            mainElement.appendChild(pQuote); 
        }
    })