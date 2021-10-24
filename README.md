Monese Assigment

Requirements:
Create a sandbox Java banking application that can be used for:
● Sending money between two predefined accounts with a positive starting balance
● Requesting account balance and list of transactions

Prerequisites:
● mySQL 8 local database with credentials: User=root, Password=password
● Local Application Server
● Intellij Ultimate Edition IDE (Optional)

Instructions:
● Start your mySQL 8 server and connect to your local database
● Begin by running the scripts found in setup.sql against your local database to create the necessary database/tables & insert dummy accounts
● Using maven, run a clean install to build the .war file
● Configure your local application server to deploy the .war file (this can be done easily by creating a run configuration in Intellij)
● Now that the application server is up and running we can issue requests to get statements and create transactions

Example Requests (Done via cURL but feel free to use fiddler/postman etc):
● Create transaction request: curl -i -X POST -H 'Content-Type: application/json' -d '{"senderId": "1", "recipientId": "2", "amount": "122.39"}' http://localhost:8080/monese-assignment-1.0-SNAPSHOT/api/bank/transaction
● Get statement request: curl -i -X GET -H 'Content-Type: application/json' http://localhost:8080/monese-assignment-1.0-SNAPSHOT/api/bank/statement/1

Happy banking! :)
