const body = document.querySelector("body");
const moon = document.querySelector(".moon");
const sun = document.querySelector(".sun");

const icon = document.querySelector(".dark-light");

icon.addEventListener("click", () => {
    body.classList.toggle("dark");

    if (body.classList.contains("dark")) {
        sun.classList.add("active");
        moon.classList.remove("active");
    } else {
        moon.classList.add("active");
        sun.classList.remove("active");
    }
});