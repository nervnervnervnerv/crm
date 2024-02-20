const dialog = document.querySelector("dialog");
const showButton = document.querySelector("dialog + button");
const closeButton = document.querySelector("dialog button");

showButton.addEventListener("click", () => {
    dialog.showModal();
});

closeButton.addEventListener("click", () => {
    dialog.close();
});

function onClick(event) {
    if (event.target === dialog) {
        dialog.close();
    }
}

dialog.addEventListener("mousedown", onClick);