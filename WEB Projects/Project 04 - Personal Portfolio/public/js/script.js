const content = document.getElementById("page");
const sidebar = document.querySelector(".side-bar");
const overlay = document.querySelector(".overlay");
const menu = document.querySelector(".mobile-menu");
const closeBtn = document.querySelector(".close-btn");

// Page Load
async function loadPage(page, element) {
    try {
        // Fade Out
        content.classList.remove("show");
        content.classList.add("hide");

        await new Promise(resolve => setTimeout(resolve, 250));

        // Fetch page
        const response = await fetch(`pages/${page}.html`);

        if (!response.ok) {
            throw new Error("Page not found");
        }

        const html = await response.text();
        content.innerHTML = html;

        // Restart animation
        content.classList.remove("hide");
        void content.offsetWidth;
        content.classList.add("show");

        // Active Menu
        document.querySelectorAll(".menu").forEach(item => {
            item.classList.remove("active");
        });

        if (element) {
            element.classList.add("active");
        }

        // Close sidebar on mobile
        if (window.innerWidth < 768) {
            closeSidebar();
        }

    } catch (error) {
        content.innerHTML = `
            <div style="padding:40px">
                <h2>404</h2>
                <p>Page not found.</p>
            </div>
        `;
    }
}

// First Load
window.addEventListener("DOMContentLoaded", () => {
    loadPage("home", document.querySelector(".menu"));
});

// Sidebar
menu.addEventListener("click", () => {
    sidebar.classList.add("open");
    overlay.classList.add("show");
});

closeBtn.addEventListener("click", closeSidebar);
overlay.addEventListener("click", closeSidebar);

function closeSidebar() {
    sidebar.classList.remove("open");
    overlay.classList.remove("show");
}