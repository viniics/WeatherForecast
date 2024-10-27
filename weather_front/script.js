function getText() {
    const currentInput = document.getElementById("city")
    return currentInput;
}
function clearInput() {
    document.getElementById("city").value = "";
}

document.getElementById("fetchWeather").addEventListener("click", function () {
    fetch("http://localhost:8080/weather" + "?city=" + getText().value)
        .then(response => {
            if (!response.ok) {
                throw new Error('Erro na requisição');
            }
            return response.json();
        })
        .then(data => {
            const weatherResult = document.getElementById("weatherResult");
            weatherResult.innerHTML = `
                <p>Cidade: ${data.name}</p>
                <p>País: ${data.country}</p>
                <p>Temperatura: ${data.temperatura_atual} °C</p>
            `;
        })
        .catch(error => {
            console.error('Erro:', error);
            const weatherResult = document.getElementById("weatherResult");
            weatherResult.innerHTML = `<p style="color: red;">${error.message}</p>`;
        });

    clearInput();
});
