// Exe-01
const scores = [85, 90, 78, 92, 88];

let sum = 0;
for (const score of scores) {
	sum += score;
}

const average = sum / scores.length;
console.log (`Sum: ${sum}`);
console.log (`Average: ${average}`);

// Exe-02
const fruit = ["apple", "banana", "orange", "grapes"];

for (let i = 0; i < fruit.length; i++) {
	console.log(`${i +1}. ${fruit[i]}`);
}

// Exe-03
const tasks = ["Ирц бүртгэх", "Хичээлд бэлдэх"];
tasks.push("Дасгал хийх");
console.log(tasks);

tasks.pop();
console.log(tasks);

// Exe-04
const cities = ["Ulaanbaatar", "Darkhan", "Erdenet", "Bulgan"];

console.log(cities.indexOf("Ulaanbaatar"));
console.log(cities.indexOf("Bulgan"));