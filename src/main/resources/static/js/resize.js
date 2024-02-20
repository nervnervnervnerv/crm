let root = document.querySelector(".root");
let main_content = document.querySelector(".main-content");
let sidebar = document.querySelector(".sidebar-right");
let splitter = document.querySelector(".splitter");

function resize(mainContent, sidebar, root) {
    let x, w;
    let wrapperWidth;
    mainContent.style.width = `${localStorage.getItem('main-container-width')}%`;
    function mousedownHandler(e) {
        x = e.clientX;
        w = parseFloat(window.getComputedStyle(mainContent).width);
        wrapperWidth = mainContent.parentElement.offsetWidth;

        document.addEventListener("mousemove", mousemoveHandler);
        document.addEventListener("mouseup", mouseupHandler);
    }

    function mousemoveHandler(e) {
        root.style.userSelect = "none";

        let dx = e.clientX-x;
        let mainContentWidth = (w + dx)/wrapperWidth*100;
        let sidebarWidth = 100-(w + dx)/wrapperWidth*100;

        if (mainContentWidth > mainContent.style.minWidth && sidebarWidth > sidebar.style.minWidth){
            mainContent.style.width = `${mainContentWidth}%`;
        }
    }

    function mouseupHandler() {
        root.style.userSelect = "auto";
        document.removeEventListener("mouseup", mouseupHandler);
        document.removeEventListener("mousemove", mousemoveHandler);
    }

    splitter.addEventListener("mousedown", mousedownHandler);
}
resize(main_content, sidebar, root);
document.addEventListener("DOMContentLoaded", function() {
    root.style.display = "flex";
});