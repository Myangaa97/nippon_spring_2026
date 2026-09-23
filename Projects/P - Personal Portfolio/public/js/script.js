const filterButtons = document.querySelectorAll(".filter-btn");
const skills = document.querySelectorAll(".skill");
const contactForm = document.querySelector(".contact-form");

filterButtons.forEach(button => {
    button.addEventListener("click", () => {
        filterButtons.forEach(btn => btn.classList.remove("active"));
        button.classList.add("active");
        const filter = button.dataset.filter;
        skills.forEach(skill => {
            const category = skill.dataset.category;
            skill.style.display =
                filter === "all" || category === filter ? "grid" : "none";
        });
    });
});

if (contactForm) {
    contactForm.addEventListener("submit", (event) => {
        event.preventDefault();
        alert(I18N[currentLang]["send-alert"]);
    });
}