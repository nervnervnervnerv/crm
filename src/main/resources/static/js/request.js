export async function request(fieldNamePath, data){
    return await fetch(`/validate/${fieldNamePath}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(res => res.text());
}