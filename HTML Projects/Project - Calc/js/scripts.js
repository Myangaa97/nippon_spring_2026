const buttonSeven = document.querySelector('#seven');
const buttons = document.querySelectorAll("button");
console.log(buttons);

const one = buttons[8];
const two = buttons[9];
const three = buttons[10];
const four = buttons[4];
const five = buttons[5];
const six = buttons[6];
const seven = buttons[7];
const eight = buttons[8];
const nine = buttons[9];
const zero = buttons[12];
const plus = buttons[15];
const multiply = buttons[3];
const subsract = buttons[11];
const divide = buttons[7];
const equal = buttons[14];
const dot = buttons[13];

const output = document.querySelector("#output");

one.addEventListener('click', function () {
    console.log('button one clicked');
    output.textContent = 7;
});
two.addEventListener('click', function () {
    console.log('button two clicked');
});
three.addEventListener('click', function () {
    console.log('button three  clicked');
});
four.addEventListener('click', function () {
    console.log('button four clicked');
});
five.addEventListener('click', function () {
    console.log('button five clicked');
});
six.addEventListener('click', function () {
    console.log('button six clicked');
});
seven.addEventListener('click', function () {
    console.log('button seven clicked');
});
eight.addEventListener('click', function () {
    console.log('button eight clicked');
});
nine.addEventListener('click', function () {
    console.log('button nine clicked');
});
zero.addEventListener('click', function () {
    console.log('button zero clicked');
});
plus.addEventListener('click', function () {
    console.log('button plus clicked');
});
multiply.addEventListener('click', function () {
    console.log('button multiply clicked');
});
subsract.addEventListener('click', function () {
    console.log('button substract clicked');
});
divide.addEventListener('click', function () {
    console.log('button divide clicked');
});
equal.addEventListener('click', function () {
    console.log('button equal clicked');
});
dot.addEventListener('click', function () {
    console.log('button dot clicked');
});

