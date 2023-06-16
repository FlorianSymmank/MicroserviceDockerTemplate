export async function startPing() {
    try {
        const response = await fetch("http://localhost:8080/ping/ping");
        return await response.json();
    } catch(error){
        return -1;
    }
}