const BASE_URL = 'http://localhost:8080';

export async function getServiceConsumers() {
    const response = await fetch(`${BASE_URL}/serviceConsumers`);
    return response.json();
}

export async function createServiceConsumer(consumer) {
    const response = await fetch(`${BASE_URL}/serviceConsumers`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(consumer),
    });
    return response.json();
}

