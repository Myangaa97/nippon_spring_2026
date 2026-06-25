// array
console.log('Array of Javascript');

const fruits = ['apple', 'banana', 'kiwi'];
console.log(fruits);

const scores = [23, 45, 56, 78];
console.log(scores);

const mixed = ['Barry', 20, true, null, undefined, [1, 2]];
console.log(mixed);

// Indef of Array
console.log(fruits[0]); // apple
console.log(fruits[1]); // banana
console.log(fruits[2]); // kiwi

console.log(fruits.length);

fruits.push('Cherry');
console.log(fruits);

fruits.pop();
console.log(fruits);

console.log(scores.indexOf(45)); // 1