const dialog = document.querySelector("dialog");
const showButton = document.querySelector("dialog + button");
const closeButton = document.querySelector("dialog button");
const dialogInputs = dialog.querySelectorAll('dialog input');

function closeDialog(){
    dialogInputs.forEach(input => {
        input.value = '';
    });

    // TODO исправить это гамно разбить на функции переименовать файлы
    mes.textContent='';

    dialog.close();
}

dialog.addEventListener("mousedown", event => {
    if (event.target === dialog) {
        closeDialog();
    }
});

closeButton.addEventListener("click", () => {
    closeDialog();
});

showButton.addEventListener("click", () => {
    dialog.showModal();
});