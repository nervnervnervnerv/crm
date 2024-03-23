import { handle } from './handle.js';
import { request } from './request.js';

const usernameInput = document.getElementById("username-input");
const firstNameInput = document.getElementById("firstname-input");
const lastNameInput = document.getElementById("lastname-input");
const passwordInput = document.getElementById("password-input");
let timerId;
usernameInput.addEventListener("input", () => {
    const requestURL = 'username';
    const username = usernameInput.value.trim()
    const data = { username: username };
    clearTimeout(timerId);

    timerId = setTimeout(async () => {
        if (username.length > 0) {
            const response = await request(requestURL, data);
            handle(response);
        }
    }, 500)
});

firstNameInput.addEventListener("blur", async () => {
    const firstName = firstNameInput.value.trim()
    const data = { firstName: firstName };

    const response = await request("firstname", data);
    handle(response);


    console.log(firstName)
});

lastNameInput.addEventListener("blur", () => {
    const lastName = lastNameInput.value.trim()

    console.log(lastName)
});

passwordInput.addEventListener("blur", () => {
    const password = passwordInput.value.trim()

    console.log(password)
});

