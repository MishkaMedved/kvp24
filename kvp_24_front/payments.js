const consumersApiUrl = "http://localhost:8080/serviceConsumers"; // URL для получения потребителей
const paymentsApiUrl = "http://localhost:8080/payments"; // URL для создания платежей

// Загрузка потребителей в селект
async function loadConsumers() {
    console.log("Загрузка потребителей...");
    try {
        const response = await fetch(consumersApiUrl);
        if (!response.ok) {
            throw new Error(`Ошибка HTTP: ${response.status}`);
        }
        const consumers = await response.json();
        console.log("Потребители загружены:", consumers);
        populateConsumerSelect(consumers);
    } catch (error) {
        console.error("Ошибка загрузки потребителей:", error);
    }
}

// Заполнение выпадающего списка потребителей
function populateConsumerSelect(consumers) {
    const consumerSelect = document.getElementById("consumer-select");
    consumerSelect.innerHTML = '<option value="">-- Выберите --</option>'; // Сброс значений

    consumers.forEach(consumer => {
        const option = document.createElement("option");
        option.value = consumer.id; // Уникальный ID потребителя
        option.textContent = `${consumer.fullName} (Account: ${consumer.accountNumber})`;
        consumerSelect.appendChild(option);
    });
}

async function createPayment() {
    const consumerId = document.getElementById("consumer-select").value;
    const amount = document.getElementById("amount").value;
    const paymentDate = document.getElementById("payment-date").value;

    if (!consumerId) {
        alert("Пожалуйста, выберите потребителя.");
        return;
    }

    const url = new URL("http://localhost:8080/payments/create");
    url.searchParams.append("consumerId", consumerId);
    url.searchParams.append("amount", amount);
    url.searchParams.append("paymentDate", paymentDate);

    try {
        const response = await fetch(url, {
            method: "POST",
        });

        if (response.ok) {
            alert("Платеж успешно создан!");
            document.getElementById("payment-form").reset(); // Очистка формы
        } else {
            throw new Error(`Ошибка HTTP: ${response.status}`);
        }
    } catch (error) {
        console.error("Ошибка создания платежа:", error);
    }
}
