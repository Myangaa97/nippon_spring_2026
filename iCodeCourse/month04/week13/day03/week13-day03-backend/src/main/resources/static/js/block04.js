// Exe - 01
const shoppingList = [];

shoppingList.push('Laptop');
shoppingList.push('iPhone');
shoppingList.push('Microwave');
shoppingList.push('Rice Cooker');
shoppingList.push('Robot');

shoppingList.pop();

for (const list of shoppingList) {
	console.log(list);
}

console.log(shoppingList.length);

// Exe - 02
const gradeScores= [45, 56, 67, 78];

let sumGrade = 0;
for (const sc of gradeScores) {
	sumGrade += sc;
}

console.log(sumGrade);
console.log(sumGrade / gradeScores.length);
console.log(gradeScores.indexOf(78));