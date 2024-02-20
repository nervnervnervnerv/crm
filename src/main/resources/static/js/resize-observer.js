const targetElement = document.querySelector(".main-content");
const resizeObserver = new ResizeObserver(entries => {
    for (let entry of entries) {
        let parentWidth = entry.target.parentElement.offsetWidth;
        let width = entry.borderBoxSize[0].inlineSize;
        let percentageWidth = (width / parentWidth) * 100;
        localStorage.setItem('main-container-width', percentageWidth.toString());
    }
});
resizeObserver.observe(targetElement);