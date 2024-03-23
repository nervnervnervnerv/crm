let root = document.querySelector(".root");
let wrapper = document.querySelector(".wrapper-left-area");
let sidebar = document.querySelector(".sidebar-right");
let splitter = document.querySelector(".splitter");
const wrapperMinWidth =  parseInt(window.getComputedStyle(wrapper).width);
const wrapperMaxWidth =  parseInt(window.getComputedStyle(wrapper).maxWidth);


function resize(wrapper, sidebar, root) {
    let x, w;
    let rootWidth;
    wrapper.style.width = `${localStorage.getItem('main-container-width')}%`;

    function mousedownHandler(e) {
        x = e.clientX;
        w = parseFloat(window.getComputedStyle(wrapper).width);
        rootWidth = wrapper.parentElement.offsetWidth;

        document.addEventListener("mousemove", mousemoveHandler);
        document.addEventListener("mouseup", mouseupHandler);
    }

    function mousemoveHandler(e) {
        root.style.userSelect = "none";

        let dx = e.clientX-x;
        let wrapperWidth = (w + dx)/rootWidth*100;

        if (wrapperWidth > wrapperMinWidth && wrapperWidth < wrapperMaxWidth){
            wrapper.style.width = `${wrapperWidth}%`;
        }
    }

    function mouseupHandler() {
        root.style.userSelect = "auto";
        document.removeEventListener("mouseup", mouseupHandler);
        document.removeEventListener("mousemove", mousemoveHandler);
    }

    splitter.addEventListener("mousedown", mousedownHandler);
}
resize(wrapper, sidebar, root);
document.addEventListener("DOMContentLoaded", function() {
    root.style.display = "flex";
});