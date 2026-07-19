const menu = document.querySelector(".menu-icon");
const nav = document.querySelector(".nav");

menu.addEventListener("click", () => {
    nav.classList.toggle("active");
});