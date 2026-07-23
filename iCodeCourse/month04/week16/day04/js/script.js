const mainElement = document.querySelector('main');

//main
const menuUlElement = document.createElement('ul');

// menu deer class
menuUlElement.classList.add('menu');
const liElementCollection = ['Home', 'FIFA2026', 'Policy', 'Economy', 'Society', 'Health']

for(let i = 0; i < liElementCollection.length; i++) {
    const liElement = document.createElement('li');
    liElement.innerText = liElementCollection[i];
    liElement.classList.add('sub-menu');
    menuUlElement.appendChild(liElement);
}

console.log(menuUlElement);

// add to main element
mainElement.appendChild(menuUlElement);

const asideButton = document.createElement('button');
asideButton.textContent = 'Aside add';

asideButton.addEventListener("click", () => {
    //TODO
    const existingAsideElement = mainElement.querySelector('aside.aside');

    if(!existingAsideElement) {
        const asideElement = document.createElement('aside');
        asideElement.classList.add('aside');
        asideElement.textContent = ('Aside Menu');
        mainElement.appendChild(asideElement);
    }
});

mainElement.appendChild(asideButton);

// article ele
const articleElement = document.createElement('article');
articleElement.classList.add('content');
articleElement.textContent = 'Lorem';

console.log(articleElement);
mainElement.appendChild(articleElement);