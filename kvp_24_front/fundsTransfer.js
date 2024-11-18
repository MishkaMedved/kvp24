const apiBaseUrl = 'http://localhost:8080';

document.addEventListener('DOMContentLoaded', async () => {
    const serviceProviderSelect = document.getElementById('serviceProvider');
    const totalUntransferred = document.getElementById('totalUntransferred');

    // Получение списка поставщиков услуг
    const providers = await fetch(`${apiBaseUrl}/serviceProviders`).then(res => res.json());

    providers.forEach(provider => {
        const option = document.createElement('option');
        option.value = provider.serviceProviderId;
        option.textContent = provider.name;
        serviceProviderSelect.appendChild(option);
    });

    // Обновление данных при выборе поставщика
    serviceProviderSelect.addEventListener('change', async () => {
        const providerId = serviceProviderSelect.value;

        if (providerId) {
            const untransferredPayments = await fetch(
                `${apiBaseUrl}/payments/untransferred?providerId=${providerId}`
            ).then(res => res.json());

            const total = untransferredPayments.reduce((sum, payment) => sum + payment.amount, 0);
            totalUntransferred.textContent = total.toFixed(2);
        }
    });
});

document.getElementById('serviceProvider').addEventListener('change', async () => {
    const providerId = document.getElementById('serviceProvider').value;

    if (providerId) {
        // Запрашиваем сумму непереведенных платежей
        const total = await fetch(`${apiBaseUrl}/payments/untransferred/total?providerId=${providerId}`)
            .then(res => res.json());

        // Обновляем отображение на странице
        document.getElementById('totalUntransferred').textContent = total.toFixed(2);
    }
});
