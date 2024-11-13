const apiBaseUrl = 'http://localhost:8080';

// Fetch and display providers
async function loadServiceProviders() {
    const response = await fetch(`${apiBaseUrl}/serviceProviders`);
    const providers = await response.json();
    const list = document.getElementById('providersList');
    list.innerHTML = '';
    providers.forEach(provider => {
        list.innerHTML += `<li>${provider.name}</li>`;
    });
}

// Create provider
async function createServiceProvider() {
    const provider = {
        name: document.getElementById('providerName').value,
        bankName: document.getElementById('bankName').value,
        bankBik: document.getElementById('bankBik').value,
        accountNumber: document.getElementById('accountNumber').value
    };
    await fetch(`${apiBaseUrl}/serviceProviders`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(provider)
    });
    loadServiceProviders();
}

// Fetch and display consumers
async function loadServiceConsumers() {
    const response = await fetch(`${apiBaseUrl}/serviceConsumers`);
    const consumers = await response.json();
    const list = document.getElementById('consumersList');
    list.innerHTML = '';
    consumers.forEach(consumer => {
        list.innerHTML += `<li>${consumer.fullName}</li>`;
    });
}

// Create consumer
async function createServiceConsumer() {
    const consumer = {
        fullName: document.getElementById('consumerName').value,
        accountNumber: document.getElementById('consumerAccountNumber').value
    };
    await fetch(`${apiBaseUrl}/serviceConsumers`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(consumer)
    });
    loadServiceConsumers();
}

// Fetch and display payments
async function loadPayments() {
    const response = await fetch(`${apiBaseUrl}/payments`);
    const payments = await response.json();
    const list = document.getElementById('paymentsList');
    list.innerHTML = '';
    payments.forEach(payment => {
        list.innerHTML += `<li>Consumer ID: ${payment.consumerId}, Amount: ${payment.amount}</li>`;
    });
}

// Create payment
async function createPayment() {
    const payment = {
        consumerId: document.getElementById('consumerId').value,
        amount: document.getElementById('paymentAmount').value,
        paymentDate: document.getElementById('paymentDate').value
    };
    await fetch(`${apiBaseUrl}/payments/create`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(payment)
    });
    loadPayments();
}

// Create funds transfer
async function createFundsTransfer() {
    const transferData = {
        serviceProviderId: document.getElementById('transferProviderSelect').value,
        amount: document.getElementById('transferAmount').value
    };
    await fetch(`${apiBaseUrl}/fundsTransfers/create`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(transferData)
    });
}
