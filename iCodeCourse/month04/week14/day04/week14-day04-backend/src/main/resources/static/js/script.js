const course = "Java Fullstack";

function prinfCourse() {
	console.log(course);
}

prinfCourse();

// function scope
function makeMessage(name) {
	const message =`Hello, ${name}`;
	return message;
}

//console.log(message); bolohgvi function gadna

//global scope
const message = "Secrte";
function printMessage() {
	console.log(message);
}

console.log(message);


//block scope
if(true) {
	const status = "inside block";
	let count = 1;
}


//console.log(status);


// Arraw Function
const double = (number) => {
	return number * 2;
}

console.log(double(4)); //8

const doubleImplicit = number => number * 2
console.log(doubleImplicit(4)); // 8


const add = (a, b) => a + b;
console.log(add(4, 10)); // 14

const createStudent = (name, score) => ({name, score});
console.log(createStudent("Myangaa", 100)); // Object garna


// ArrayMethods
const studentName = ["Dorjoo", "Saraa", "Boldoo"];
const upperNames = studentName.map(s => s.toUpperCase());
console.log(upperNames);

// Filter Method
const scores = [55, 98, 78, 99];
const passingScores = scores.filter(score => score >= 60);
console.log(passingScores); // 80, 78. 99

// Reduce method
let sumScore = 0;
for(let s of scores) {
	sumScore += s;
}
console.log(sumScore); //330

const total = scores.reduce((sum, score) => sum + score, 0);
console.log(total); //330

// WK14 EXE - 01
const students = [
    { name: "Bataa", score: 82, program: "java" },
    { name: "Saraa", score: 94, program: "web" },
    { name: "Dorj", score: 58, program: "java" },
    { name: "Naraa", score: 76, program: "web" }
];

const getNames = students.map(s => s.name);
console.log(getNames);

const getPassingStudent = scores.filter(score => score >= 60);
console.log(getPassingStudent.length);

// Function EXE - 03
function averageScore(students) {
	let totalScore = 0;
	for(const stu of students) {
		totalScore += stu.score;
	}
	
	return totalScore / students.length;
}
console.log(averageScore(students));


// Function EXE - 04
function groupCountByProgram(students, program) {
	let totalStu = 0;
	for(const stu of students) {
			if(stu.program === program) {
				totalStu ++;
			}
		}
	return totalStu;
}
console.log(groupCountByProgram(students, "java"));
console.log(groupCountByProgram(students, "web"));




