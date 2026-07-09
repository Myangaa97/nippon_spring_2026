const buttonSeven = document.querySelector('#seven');
const buttons = document.querySelectorAll("button");
console.log(buttons);

const seven = buttons[0];
const eight = buttons[1];
const nine = buttons[2];
const multiply = buttons[3];

const four = buttons[4];
const five = buttons[5];
const six = buttons[6];
const divide = buttons[7];

const one = buttons[8];
const two = buttons[9];
const three = buttons[10];
const subsract = buttons[11];


const zero = buttons[12];
const dot = buttons[13];
const equal = buttons[14];
const plus = buttons[15];

const clear = buttons[16];

const output = document.querySelector("#output");

let outputString = "";
let isSecond = false;
let first = '';
let second = '';

one.addEventListener('click', function () {
    console.log('button one clicked');
    outputString += 1;
    output.textContent = outputString;
});
two.addEventListener('click', function () {
    console.log('button two clicked');
    outputString += 2;
    output.textContent = outputString;
});

plus.addEventListener('click', function () {
    console.log('button plus clicked');
    first = output.textContent;
    isSecond = true;
    if(isSecond) {
        output.textContent = '';
        outputString = '';
    } else {
        second = output.textContent;
        const result = first + second;
        output.textContent = result;
    }
});

clear.addEventListener('click', function() {
    output.textContent = '';
    outputString = '';
});

equal.addEventListener('click', function () {
    console.log('button equal clicked');

});


three.addEventListener('click', function () {
    console.log('button three  clicked');
    outputString += 3;
    output.textContent = outputString;
});

four.addEventListener('click', function () {
    console.log('button four clicked');
    outputString += 4;
    output.textContent = outputString;
});

five.addEventListener('click', function () {
    console.log('button five clicked');
    outputString += 5;
    output.textContent = outputString;
});

six.addEventListener('click', function () {
    console.log('button six clicked');
    outputString += 6;
    output.textContent = outputString;
});

seven.addEventListener('click', function () {
    console.log('button seven clicked');
    outputString += 7;
    output.textContent = outputString;
});

eight.addEventListener('click', function () {
    console.log('button eight clicked');
    outputString += 8;
    output.textContent = outputString;
});

nine.addEventListener('click', function () {
    console.log('button nine clicked');
    outputString += 9;
    output.textContent = outputString;
});

zero.addEventListener('click', function () {
    console.log('button zero clicked');
    outputString += 0;
    output.textContent = outputString;
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

dot.addEventListener('click', function () {
    console.log('button dot clicked');
    outputString += ".";
    output.textContent = outputString;
});

