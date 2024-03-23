const targetElement = document.querySelector(".wrapper-left-area");
const resizeObserver = new ResizeObserver(entries => {
    for (let entry of entries) {
        let parentWidth = entry.target.parentElement.offsetWidth;
        let width = entry.borderBoxSize[0].inlineSize;
        let percentageWidth = (width / parentWidth) * 100;

        if (percentageWidth > wrapperMinWidth && percentageWidth < wrapperMaxWidth){
            localStorage.setItem('main-container-width', percentageWidth.toString());
        }
    }
});
resizeObserver.observe(targetElement);