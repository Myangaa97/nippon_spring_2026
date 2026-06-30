console.log('Javascript Functions');

//alert('This is alert');
// Browser API

const result = prompt('What is your name');

// Function Create
// Function Declaration
function greet(name) {
	return `Hello my name is ${name}`;
}
// Function Call
console.log(greet(result));

function add(a, b) {
	return a + b;
}

console.log(add(3, 4));

function introduce(name, age) {
	console.log(`My name is ${name}. I am ${age} years old`);
}

introduce('myangaa', 32);

function printSum(a, b){
	console.log(a + b);
}

const printSumResult = printSum(5, 6);
console.log(printSumResult);

// function expression - nergvi function
const minus = function(a, b) {
	return a - b;
}
console.log(minus(10, 5));

// Arrow function expression - suman function
const subtract = (a, b) => {
	return a - b;
}
console.log(subtract(10, 6));



// Function Dec - EXE
function divide(a, b) {
	return a / b;
}
console.log(divide(6, 3));

function multiply(a, b) {
	return a * b;
}
console.log(multiply(6, 3));

// Function EXP - EXE
const power = function(a, b) {
	return Math.pow(a, b);
}
console.log(power(3, 3));


// Arrow Function EXP - EXE
const circleArea = (r) => {
	return Math.PI * r * r;
}
console.log(circleArea(4));



// Object Literal
console.log('=============');
console.log("Object Literal");

//object literal
//name, age => keys
// Sarah, 20 => values

const student = {
	name: "Sarah",
	age: 20
};

console.log(student);

const mixedObject = {
	name: "Dog",
	gender: 'male',
	age: 6,
	isBig: false,
	weight: 5.6,
	kids: ['shiro', 'kuro', 'aka']
}
console.log(mixedObject);

// dot notation
console.log(mixedObject.age);
const complicatedObject = {
	"high-grade": 100,
	"low-grade": 70
}

// bracket notation
console.log(complicatedObject["high-grade"]);

// 
mixedObject.name = "cat";
complicatedObject["high-grade"] = 95;
console.log(complicatedObject["high-grade"]);

const funcObject = {
	name: "Bird",
	color: "Black",
	say: function(){
		console.log("GUA GUA");
	}
}
funcObject.say();

// difference of function
printMe();
function printMe() {
	console.log("Hello");
}

printMe();

// console.log(a); ingej bolohgvi
const a = 6;
const printMeFunc = function() {
	console.log("Hello");
}

printMeFunc();





console.log("=============================")
console.log("========== EXE - 01 =========")
function max(a, b) {
    if (a > b) {
        return a;
    }
    return b;
}
console.log(max(4, 6));



console.log("========== EXE - 02 =========")
function gradeLabel(score) {
    if (score >= 90) return "A";
    if (score >= 80) return "B";
    if (score >= 70) return "C";
    if (score >= 60) return "D";
    return "F";
}
console.log(gradeLabel(95));



console.log("========== EXE - 03 =========")
function createStudent(name, score) {
    return {
        name,
        score,
        passed: score >= 60
    };
}
console.log(createStudent("Myangaa", 95));



console.log("========== EXE - 04 =========")
function studentLabel(studentK) {
    return `${studentK.name} - ${studentK.score}`;
}

const studentK = {
	name: "Bataa",
	score: 45
};

console.log(studentLabel(studentK));



console.log("========== EXE - 05 =========")
function countPassing(students) {
    let count = 0;

    for (const student of students) {
        if (student.score >= 60) {
            count++;
        }
    }

    return count;
}
const students = [
    { name: "Bataa", score: 45 },
    { name: "Saraa", score: 94 },
    { name: "Dorj", score: 58 }
];
console.log(countPassing(students));


