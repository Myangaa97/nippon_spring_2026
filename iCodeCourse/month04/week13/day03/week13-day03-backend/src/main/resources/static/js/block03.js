// Exe - 01
const numbers = [10, 20, 30, 40, 50];
const last = numbers[numbers.length - 1];
console.log(last);

// Exe - 02
const prices = [1000, 2000, 3000];
const increased = [];

for (const price of prices) {
	increased.push(price + 500);
}

console.log(increased);

// Exe - 03
const halves = [];

for (const number of numbers) {
	halves.push(number / 2);
}

console.log(halves);

// Exe - 04
const groupA = ['Bat', 'Dorj'];
const groupB = ['Dulmaa', 'Bold'];
const all = [];

for (const name of groupA) {
	all.push(name);
}

for (const name of groupB) {
	all.push(name);
}

console.log(all);

// Exe - 05
const letters = ['a', 'b', 'c', 'd'];
for (let i = letters.length - 1; i >=0; i--) {
	console.log(letters[i]);
}