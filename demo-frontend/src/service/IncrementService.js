export async function getIncrement() {
    try {
        const response = await fetch("http://localhost:8080/increment");
        return await response.json();
    } catch(error){
        return -1;
    }
}