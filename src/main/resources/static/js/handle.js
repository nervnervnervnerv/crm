// TODO rename

export function handle(response) {
    const resultDiv = document.getElementById("firstname-err");
    if (!resultDiv) {
        console.error('Result div not found');
    }

    resultDiv.innerHTML = response;
}