const menu = document.querySelector('#mobile-menu');
const menuOptions = document.querySelector('.navbar__menu');
const navLogo = document.querySelector('#navbar__logo');
const menuLinks = document.querySelectorAll('.navbar__links');

// Display mobile menu
const mobileMenu = () => {
    menu.classList.toggle('is-active');
    menuOptions.classList.toggle('active');
}

menu.addEventListener('click', mobileMenu);

// Scroll to target section and close mobile menu
const scrollToSection = (target) => {
    const section = document.querySelector(target);
    if (section) {
        window.scrollTo({
            top: section.offsetTop - 80, // Adjust the offset as needed
            behavior: 'smooth' // Smooth scrolling behavior
        });
        menu.classList.remove('is-active');
        menuOptions.classList.remove('active');
    }
}

// Show active menu when scrolling
const highlightMenu = () => {
    // Your highlightMenu function code here
}

window.addEventListener('scroll', highlightMenu);
window.addEventListener('click', highlightMenu);

// Close mobile menu
const hideMobileMenu = (e) => {
    const menuBars = document.querySelector('.is-active');
    if (window.innerWidth < 768 && menuBars && e.target.classList.contains('navbar__links')) {
        menu.classList.remove('is-active');
        menuOptions.classList.remove('active');
    }
}

menuLinks.forEach((link) => {
    link.addEventListener('click', (e) => {
        e.preventDefault(); // Prevent default link behavior
        const targetId = link.getAttribute('href');
        scrollToSection(targetId);
    });
});

navLogo.addEventListener('click', hideMobileMenu);
document.addEventListener('click', hideMobileMenu);
