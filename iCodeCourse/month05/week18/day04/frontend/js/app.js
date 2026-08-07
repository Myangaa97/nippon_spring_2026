const searchBox = document.querySelector(".search-box");
const input = document.querySelector(".search-input input");

input.addEventListener("focus", () => {
    searchBox.classList.add("active");
});

input.addEventListener("blur", () => {
    searchBox.classList.remove("active");
});