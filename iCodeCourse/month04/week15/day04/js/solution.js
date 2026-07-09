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
let first = '';
let operator = ""; // +,- ,* , / vildel hiine

function appendNumber(num) {
    outputString += num;
    output.textContent = outputString;
}

zero.addEventListener('click', function () {
    console.log('button zero clicked');
    appendNumber(0);
});

one.addEventListener('click', function () {
    console.log('button one clicked');
    appendNumber(1);
});

two.addEventListener('click', function () {
    console.log('button two clicked');
    appendNumber(2);
});

three.addEventListener('click', function () {
    console.log('button three  clicked');
    appendNumber(3);
});

four.addEventListener('click', function () {
    console.log('button four clicked');
    appendNumber(4);
});

five.addEventListener('click', function () {
    console.log('button five clicked');
    appendNumber(5);
});

six.addEventListener('click', function () {
    console.log('button six clicked');
    appendNumber(6);
});

seven.addEventListener('click', function () {
    console.log('button seven clicked');
    appendNumber(7);
});

eight.addEventListener('click', function () {
    console.log('button eight clicked');
    appendNumber(8);
});

nine.addEventListener('click', function () {
    console.log('button nine clicked');
    appendNumber(9);
});

// operator
function chooseOperator(op) {
    if (outputString === "") return;
    first = parseFloat(outputString);
    operator = op;
    outputString = "";
}

plus.addEventListener('click', function () {
    console.log('button plus clicked');
    chooseOperator("+");
});

subsract.addEventListener('click', function () {
    console.log('button substract clicked');
    chooseOperator("-");
});

multiply.addEventListener('click', function () {
    console.log('button multiply clicked');
    chooseOperator("*");
});

divide.addEventListener('click', function () {
    console.log('button divide clicked');
    chooseOperator("/");
});

dot.addEventListener('click', function () {
    console.log('button dot clicked');
    if(!outputString.includes(".")) {
        appendNumber(".");
    }
});

clear.addEventListener('click', function() {
    output.textContent = '';
    outputString = '';
    operator = "";
    
})

equal.addEventListener('click', function () {
    console.log('button equal clicked');
    if(operator === "" || outputString === "") return;
    
    let second = parseFloat(outputString);
    let result = 0;
    switch(operator) {
        case "+":
            result = first + second;
            break;

        case "-":
            result = first - second;
            break;

        case "*":
            result = first * second;
            break;

        case "/":
            result = first / second;
            break;

        default:
            break;
    }

    output.textContent = result;
    outputString = result.toString();
    operator = "";
});