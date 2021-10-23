CREATE DATABASE monese;

USE monese;

CREATE TABLE account (
    account_id int NOT NULL AUTO_INCREMENT,
    sort_code varchar (6) NOT NULL,
    account_number varchar(17) NOT NULL,
    balance decimal(10,2) NOT NULL,
    PRIMARY KEY (account_id)
);

INSERT INTO account (sort_code, account_number, balance)
VALUES
('112233', '11112222', '1232.52'),
('998877', '99998888', '752.95');

CREATE TABLE transaction (
    transaction_id int NOT NULL AUTO_INCREMENT,
    sender_id int NOT NULL,
    recipient_id int NOT NULL,
    amount decimal(10,2) NOT NULL,
    transaction_date timestamp NOT NULL,
    PRIMARY KEY (transaction_id),
    FOREIGN KEY (sender_id) REFERENCES account(account_id),
    FOREIGN KEY (recipient_id) REFERENCES account(account_id)
);