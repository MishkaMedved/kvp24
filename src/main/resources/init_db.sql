-- Добавление данных в таблицу service_provider
INSERT INTO service_provider (name, bank_name, bank_bik, account_number)
VALUES ('Provider A', 'Bank Alpha', '123456789', '40817810000000123456'),
       ('Provider B', 'Bank Sber', '987654321', '40817810000000654321'),
       ('Provider C', 'Bank VTB', '112233445', '40817810000000334455');

-- Добавление данных в таблицу service_consumer
INSERT INTO service_consumer (provider_id, full_name, account_number)
VALUES (1, 'Consumer One', 'LS1234567890'),
       (2, 'Consumer Two', 'LS0987654321'),
       (3, 'Consumer Three', 'LS1122334455');

-- Добавление данных в таблицу payment
INSERT INTO payment (consumer_id, amount, payment_date, transfer_mark)
VALUES (1, 150.00, '2024-11-01', FALSE),
       (2, 200.50, '2024-11-02', FALSE),
       (3, 300.75, '2024-11-03', TRUE);

-- Добавление данных в таблицу fund_transfer
INSERT INTO fund_transfer (provider_id, amount, transfer_date)
VALUES (1, 150.00, '2024-11-04'),
       (2, 200.50, '2024-11-05'),
       (3, 300.75, '2024-11-06');
