document.addEventListener("DOMContentLoaded", () => {
    fetchConsumers(); // Загружаем потребителей при загрузке страницы
});

async function fetchConsumers() {
    try {
        const response = await fetch('/serviceConsumers'); // Укажите свой URL для получения потребителей
        if (response.ok) {
            const consumers = await response.json();
            populateConsumerSelect(consumers);
        } else {
            console.error("Не удалось получить данные о потребителях");
        }
    } catch (error) {
        console.error("Ошибка при загрузке потребителей:", error);
    }
}

// Заполняем выпадающий список
function populateConsumerSelect(consumers) {
    const select = document.getElementById("consumer-select");
    consumers.forEach(consumer => {
        const option = document.createElement("option");
        option.value = consumer.id;  // предполагаем, что у объекта есть поле "id"
        option.textContent = consumer.name;  // и поле "name"
        select.appendChild(option);
    });
}

// При выборе потребителя из списка заполняем форму
function fillConsumerForm() {
    const select = document.getElementById("consumer-select");
    const selectedConsumerId = select.value;

    if (selectedConsumerId) {
        const consumer = getConsumerById(selectedConsumerId);
        document.getElementById("consumer-name").value = consumer.name;
        document.getElementById("consumer-account").value = consumer.account;
        document.getElementById("consumer-form").style.display = "block"; // Показываем форму
    } else {
        document.getElementById("consumer-form").style.display = "none"; // Скрываем форму, если ничего не выбрано
    }
}

// Функция для получения данных потребителя по ID (можно делать запрос на сервер или использовать локальные данные)
function getConsumerById(id) {
    // Пример: загружать данные для конкретного потребителя, если они у вас уже есть
    const consumers = JSON.parse(localStorage.getItem("consumers")) || [];
    return consumers.find(consumer => consumer.id === id);
}

// Функция сохранения данных (пока пример)
function saveConsumer() {
    const name = document.getElementById("consumer-name").value;
    const account = document.getElementById("consumer-account").value;
    
    // Можно добавить запрос для сохранения данных на сервере
    console.log("Сохранение данных:", { name, account });
}
