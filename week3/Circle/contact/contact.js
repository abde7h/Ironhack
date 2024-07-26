document.getElementById('contactForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const fullName = document.getElementById('fullName');
    const email = document.getElementById('email');
    const phone = document.getElementById('phone');
    const message = document.getElementById('message');

    let valid = true;

    // Reset error messages
    const errorMessages = document.querySelectorAll('.error-message');
    errorMessages.forEach(error => {
        error.style.visibility = 'hidden';
    });

    // Full Name validation
    if (fullName.value.trim() === '') {
        showError(fullName, 'Full Name is required');
        valid = false;
    } else {
        setValid(fullName);
    }

    // Email validation
    if (email.value.trim() === '') {
        showError(email, 'Email is required');
        valid = false;
    } else if (!isValidEmail(email.value)) {
        showError(email, 'Please enter a valid email address');
        valid = false;
    } else {
        setValid(email);
    }

    // Phone validation
    if (phone.value.trim() === '') {
        showError(phone, 'Phone number is required');
        valid = false;
    } else if (!isValidPhone(phone.value)) {
        showError(phone, 'Please enter a valid phone number');
        valid = false;
    } else {
        setValid(phone);
    }

    // Message validation
    if (message.value.trim() === '') {
        showError(message, 'Message cannot be empty');
        valid = false;
    } else if (message.value.trim().length < 5) {
        showError(message, 'Message must be at least 5 characters long');
        valid = false;
    } else {
        setValid(message);
    }

    if (valid) {
        alert('Formulario enviado correctamente!');
    }
});

function showError(input, message) {
    const formGroup = input.parentElement;
    const errorMessage = formGroup.querySelector('.error-message');
    errorMessage.textContent = message;
    errorMessage.style.visibility = 'visible';
    input.classList.add('invalid');
    input.classList.remove('valid');
}

function setValid(input) {
    input.classList.add('valid');
    input.classList.remove('invalid');
}

function isValidEmail(email) {
    const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return re.test(email);
}

function isValidPhone(phone) {
    const re = /^\+?(\d.*){3,}$/;
    return re.test(phone);
}
