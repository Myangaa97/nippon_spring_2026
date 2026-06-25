// Exe - 01
console.log('=========== Exercises - 01 ===========')
const user = 'admin';
switch (user) {
    case "admin":
        console.log('Зөвшөрөлтэй');
        break;
    case "user":
        console.log('Энгийн хэрэглэгч');
        break;
    default:
        console.log('Танихгүй хэрэглэгч');
}

// Exe - 02
console.log('=========== Exercises - 02 ===========')
const game = 'Minecraft';
switch (game) {
    case "Minecraft":
        console.log('Сулac блок тоглоом');
        break;
    case "PUBG":
        console.log('Буудлагын тоглоом');
        break;
    case "FIFA":
        console.log('Хөл бөмбөгийн тоглоом');
        break;
    default:
        console.log('Танихгүй тоглоом');
}

// Exe - 03
console.log('=========== Exercises - 03 ===========')
for (let i = 1; i < 21; i++) {
	if(i % 2 === 0) {
		console.log(`${i} = Тэгш`);
	}
	else console.log(`${i} = Сондгой`);
}

// Exe - 04
console.log('=========== Exercises - 04 ===========')
const names = ["Хонгор", "Сарнай", "Дорж", "Оюунаа"];
let j = 0;
while(j < names.length) {
	console.log(`${j}-th index of element is ${names[j]}`);
	j++;
}

// Exe - 05
console.log('=========== Exercises - 05 ===========')
let k = 1;
sum = 0;
while(k <= 100) {
	sum += k;
	k++;
}
console.log(`Total sum: ${sum}`);