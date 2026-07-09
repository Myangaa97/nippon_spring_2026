const myParagraph = document.getElementById("text");
myParagraph.innerHTML = "Hello World!";


const myBtns = document.querySelectorAll(".btn");
console.log(myParagraph);
console.log(myBtns);

console.log(myBtns.length)

for(let i = 0; i < myBtns.length; i++) {
	console.log(myBtns);
}

const h1 = document.querySelector("h1");
console.log(h1.textContent);
h1.textContent = "My Web";

const div = document.getElementById("content");
console.log(div.innerHTML);
div.innerHTML = "<strong>Home Page</strong>"

const input = document.querySelector("input");
console.log(input.value);
input.value = "Search ....";


const button = document.getElementById("btn1");
button.addEventListener("click", function() {
	alert("Clicked!");
});

const button2 = document.getElementById("btn2");
button2.addEventListener("click", function() {
	alert("sign out");
});


input.addEventListener("click", () => {
	input.value = "";
});

input.addEventListener("input", (e) => {
	console.log(e.target.value);
});

add.addEventListener("mouseover", () => {
	add.style.backgroundColor = "red";
});

add.addEventListener("mouseleave", () => {
	add.style.backgroundColor = "black";
});

document.addEventListener("keydown", (e) => {
    console.log(e.key);
});

let a = 6; 
let b= 5;
const addButton = document.getElementById("add");
addButton.addEventListener("click", () => {
	const sum = a + b;
	console.log(sum);
});


const greetButton = document.getElementById("greet");
greetButton.addEventListener("click", function() {
	alert("Hello!")
});

const inputGreet = document.getElementById("hello");
const submit = document.getElementById("submit");
inputGreet.addEventListener("input", (e) => {
	if(e.target.value === "")
		alert("Input name pls");
});






