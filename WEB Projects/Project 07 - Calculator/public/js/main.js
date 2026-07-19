const buttonSeven = document.querySelector('#seven');
const buttons = document.querySelectorAll("button");
console.log(buttons);

const clear = buttons[0];
const del = buttons[1];
const percent = buttons[2];
const divide = buttons[3];

const seven = buttons[4];
const eight = buttons[5];
const nine = buttons[6];
const multiply = buttons[7];

const four = buttons[8];
const five = buttons[9];
const six = buttons[10];
const subsract = buttons[11];

const one = buttons[12];
const two = buttons[13];
const three = buttons[14];
const plus = buttons[15];

const zero = buttons[16];
const dot = buttons[17];
const equal = buttons[18];

const input = document.querySelector(".input");
const output = document.querySelector(".output");

let inputString = "";
let outputString = "";
let first = '';
let operator = "";

function appendNumber(num) {
    if (outputString === "0" && num !== ".") {
        outputString = "";
        inputString = operator === "" ? "" : `${first} ${operator} `;
    }
    inputString += num;
    outputString += num;

    if (operator === "") {
        input.textContent = inputString;
    } else {
        input.innerHTML = `${first} <span class="operator">${operator}</span> ${outputString}`;
    }
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

// operator - function
function chooseOperator(op) {
    if (outputString === "") return;
    if (operator !== "") return;

    first = parseFloat(outputString);
    operator = op;

    inputString += " " + op + " ";
    input.innerHTML = `${first} <span class="operator">${operator}</span>`;

    outputString = "";
    output.textContent = "0";
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
    chooseOperator("×");
});

divide.addEventListener('click', function () {
    console.log('button divide clicked');
    chooseOperator("÷");
});

dot.addEventListener('click', function () {
    console.log('button dot clicked');
    if(!outputString.includes(".")) {
        appendNumber(".");
    }
});

clear.addEventListener('click', function() {
    input.textContent = "";
    output.textContent = "0";
    outputString = "";
    inputString = "";
    first = "";
    operator = "";
});

del.addEventListener("click", function () {
    console.log('button delete clicked');
    if (outputString !== "") {
        outputString = outputString.slice(0, -1);
        inputString = inputString.slice(0, -1);
        output.textContent = outputString === "" ? "0" : outputString;

        if (operator === "") {
            input.textContent = inputString;
        } else {
            input.innerHTML = `${first} <span class="operator">${operator}</span> ${outputString}`;
        }
        return;
    }

    if (operator !== "") {
        operator = "";
        first = "";
        inputString = inputString.slice(0, -3);
        input.textContent = inputString;

        outputString = inputString;
        output.textContent = outputString === "" ? "0" : outputString;
        return;
    }

    outputString = outputString.slice(0, -1);
    inputString = inputString.slice(0, -1);
    output.textContent = outputString === "" ? "0" : outputString;
    input.textContent = inputString;
});

percent.addEventListener('click', function() {
    if (outputString === "") return;
    let second = parseFloat(outputString);
    if (operator === "") {
        second = second / 100;
    } else {
        switch (operator) {
            case "+":
            case "-":
                second = first * second / 100;
                break;
            
            case "×":
            case "÷":
                second = second / 100;
                break;
        }
    }
    outputString = second.toString();
    if (operator === "") {
        inputString = outputString;
        input.textContent = inputString;
    } else {
        inputString = `${first} ${operator} ${outputString}`;
        input.innerHTML = `${first} <span class="operator">${operator}</span> ${outputString}`;
    }
    output.textContent = outputString === "" ? "0" : outputString;
});

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

        case "×":
            result = first * second;
            break;

        case "÷":
            result = first / second;
            break;

        default:
            break;
    }
    result = parseFloat(result.toFixed(10));
    input.innerHTML = `${first} <span class="operator">${operator}</span> ${second}`;
    output.textContent = result;

    inputString = result.toString();
    outputString = result.toString();
    operator = "";
    first = "";
});