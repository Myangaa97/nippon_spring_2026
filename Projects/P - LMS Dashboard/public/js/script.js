const prevBtn = document.getElementById("prevMonth");
const nextBtn = document.getElementById("nextMonth");

const weekdays = document.getElementById("weekdays");
const title = document.getElementById("monthTitle");

const days = ["M", "T", "W", "T", "F", "S", "S"];

let currentDate = new Date();

function renderCalendar() {

    title.textContent = currentDate.toLocaleString("en-US", {
        month: "long",
        year: "numeric"
    });

    weekdays.innerHTML = "";

    // Monday-г олох
    const monday = new Date(currentDate);
    const day = (monday.getDay() + 6) % 7;
    monday.setDate(monday.getDate() - day);

    for (let i = 0; i < 7; i++) {

        const date = new Date(monday);
        date.setDate(monday.getDate() + i);

        const p = document.createElement("p");
        const span = document.createElement("span");

        p.appendChild(document.createTextNode(days[i]));
        span.textContent = date.getDate();

        if (
            date.getDate() === new Date().getDate() &&
            date.getMonth() === new Date().getMonth() &&
            date.getFullYear() === new Date().getFullYear()
        ) {
            p.classList.add("active");
            span.classList.add("active");
        }

        p.appendChild(span);
        weekdays.appendChild(p);
    }
}

renderCalendar();

prevBtn.addEventListener("click", () => {
    currentDate.setDate(currentDate.getDate() - 7);
    renderCalendar();
});

nextBtn.addEventListener("click", () => {
    currentDate.setDate(currentDate.getDate() + 7);
    renderCalendar();
});


document.querySelectorAll('.todo-item-group').forEach(group => {
    const parentBox = group.querySelector('.parent-box');
    const childBoxes = group.querySelectorAll('.child-box');

    // Хэрэв тухайн даалгавар дэд даалгаваргүй бол алгасна
    if (!parentBox || childBoxes.length === 0) return;

    // 1. Үндсэн чекбокс дарагдахад бүх дэд чекбоксыг дагах
    parentBox.addEventListener('change', (e) => {
        childBoxes.forEach(box => {
            box.checked = e.target.checked;
        });
    });

    // 2. Дэд чекбокс дарагдахад үндсэн чекбоксын төлөвийг шинэчлэх
    childBoxes.forEach(box => {
        box.addEventListener('change', () => {
            const checkedCount = group.querySelectorAll('.child-box:checked').length;

            if (checkedCount === 0) {
                // Нэг ч дэд даалгавар сонгогдоогүй
                parentBox.checked = false;
                parentBox.indeterminate = false;
            } else if (checkedCount === childBoxes.length) {
                // Бүх дэд даалгавар сонгогдсон
                parentBox.checked = true;
                parentBox.indeterminate = false;
            } else {
                // Зарим нэг нь сонгогдсон (Дундаж буюу зураастай төлөв)
                parentBox.checked = false;
                parentBox.indeterminate = true;
            }
        });
    });
});


const menuBtn = document.querySelector('#menu');
const closeBtn = document.querySelector('.bx-x')
const sidebar = document.querySelector('#sidebar');
const overlay = document.querySelector('#sidebar-overlay');
const logo = document.querySelector('.logo');


menuBtn.addEventListener('click', () => {
    logo.classList.toggle('active');
    sidebar.classList.toggle('active');
    overlay.classList.toggle('active');
});

overlay.addEventListener('click', () => {
    logo.classList.remove('active');
    sidebar.classList.remove('active');
    overlay.classList.remove('active');
});

closeBtn.addEventListener('click', () => {
    logo.classList.remove('active');
    sidebar.classList.remove('active');
    overlay.classList.remove('active');
});