console.log('Arithmethic and Boolean Operations');

const x = 10;
const y = 3;

console.log(x + y);
console.log(x - y);
console.log(x / y);
console.log(x * y);
console.log(x % y); //modulo
console.log(x ** y);

// attention
console.log(5 + 3); //8
console.log("5" + "3"); //53
console.log(5 + "3"); //53
console.log("5" - 3); //2

//boolean operation
const isActive = true;
const isLoggedIn = false;

console.log(5 > 3); //true
console.log(5 === 3); //false
console.log(5 !== 3); //true
console.log(5 !== '3'); //false

//attention
console.log(5 === '5'); //false
console.log(5 == '5'); //true

// logical operator
console.log(isActive && isLoggedIn); //false
console.log(isActive && !isLoggedIn); //true
console.log(isActive || isLoggedIn); //true
console.log(isActive || !isLoggedIn); //true
console.log(isLoggedIn || isActive); //true

// assignment operation
let myNumber = 10;
myNumber += 5; // myNumber + 5; // 15
myNumber -= 3; // 12
myNumber *= 2; // 24
myNumber /= 4; // 6
myNumber ++; // 7
myNumber --; // 6
++ myNumber; //
-- myNumber; //  