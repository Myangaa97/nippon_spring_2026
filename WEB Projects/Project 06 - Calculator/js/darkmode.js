const body = document.querySelector("body");
const moon = document.querySelector(".moon");
const sun = document.querySelector(".sun");

moon.addEventListener("click", () => {
    body.classList.add("dark");
});

sun.addEventListener("click", () => {
    body.classList.remove("dark");
});

const icon = document.querySelector(".theme-icon");

icon.addEventListener("click", () => {
    body.classList.toggle("dark");

    if(body.classList.contains("dark")){
        icon.classList.replace("bx-moon", "bx-sun");
    } else {
        icon.classList.replace("bx-sun", "bx-moon");
    }
});