console.log('=========== Exercises02 - 01 ===========')
const student = {
    name: "Бат",
    age: 20,
    major: "Computer Science",
    scores: [85, 90, 78]
};

// 1. Нэр, нас, мэргэжил хэвлэх
console.log(`${student.name}, ${student.age}, ${student.major}`);

// 2. Дүнгүүдийн дундаж тооцоолох
let sum = 0;
for (const score of student.scores) {
    sum += score;
}
const average = sum / student.scores.length;
console.log(`Дундаж: ${average}`);

// 3. Шинэ property нэмэх
student.email = "bat@example.com";


console.log('=========== Exercises02 - 02 ===========')
const students = [
	{ name: "John", age: 22, major: "Computer Science", scores: [87, 90, 78] },
	{ name: "Wall", age: 21, major: "Computer Science", scores: [99, 90, 90] },
	{ name: "Street", age: 18, major: "Science", scores: [81, 60, 78] }
];
for (const student of students) {
    if (student.age > 20) {
		console.log(`${student.name}: ${student.age} years old`);
	}
}

let max = 0;
for (const student of students) {
	let scoreSum = 0;
	for (const score of student.scores) {
	    scoreSum += score;
	}
	if(max < scoreSum) {
		max = scoreSum;
	}
}
const scoreAverage = max / student.scores.length;
console.log(`Max Avarage: ${scoreAverage}`);

console.log('=========== Exercises02 - 03 ===========')


console.log('=========== Exercises02 - 04 ===========')


console.log('=========== Exercises02 - 05 ===========')


console.log('=========== Exercises02 - 06 ===========')