const body = document.querySelector("body");
const moon = document.querySelector(".moon");
const sun = document.querySelector(".sun");


moon.addEventListener("click", () => {
    body.classList.add("dark");

    moon.classList.remove("active");
    sun.classList.add("active");
});


sun.addEventListener("click", () => {
    body.classList.remove("dark");

    sun.classList.remove("active");
    moon.classList.add("active");
});