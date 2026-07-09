const input = document.querySelector(".input");
const output = document.querySelector(".output");
const buttons = document.querySelectorAll(".key");
const operators = ["+", "-", "*", "/", "%"];

function updateInput() {
    let displayExpression = expression.replace(
        /[*/+\-%]/g,
        (operator) => {
            const symbols = {
                "*": "×",
                "/": "÷",
                "+": "+",
                "-": "-",
                "%": "%"
            };

            return `<span class="operator"> ${symbols[operator]} </span>`;
        }
    );

    input.innerHTML = displayExpression;
}

let expression = "";

buttons.forEach(button => {
    button.addEventListener("click", () => {
        const value = button.dataset.value;
        const lastNumber = expression.split(/[\+\-\*\/%]/).pop();

        if (value == "AC") {
            expression = "";
            updateInput();
            output.textContent = "0";

        } else if (value === "C") {
            expression = expression.slice(0, -1);
            updateInput();
            if (expression === "") {
                output.textContent = "0";
            }

        } else if (value === "=") {
            try {
                const result = eval(expression);
                const roundedResult = Number(result.toFixed(10));
                output.textContent = roundedResult.toLocaleString();
                expression = roundedResult.toString();
                updateInput();

            } catch {
                output.textContent = "Error";
                expression = "";

            }

        } else if (value === "%") {

            if (lastNumber !== "") {
                const percent = Number(lastNumber) / 100;
                expression = expression.slice(0, -lastNumber.length) + percent;
                updateInput();
            }

        } else if (value === ".") {
            if (lastNumber.includes(".")) {
               return; 
            }
            
            if (lastNumber === "" || operators.includes(expression.slice(-1))) {
                expression += "0";
            }

            expression += ".";
            updateInput();
            return;

        } else {
            const lastChar = expression.slice(-1);

            if (operators.includes(value) && operators.includes(lastChar)) {
                expression = expression.slice(0, -1);
            }

            if (lastNumber === "0" && value !== "." && !operators.includes(value)) {
                expression = expression.slice(0, -1);
            }
            expression += value;
            updateInput();
        }
    })
})