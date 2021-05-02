
Instructions:
1. Create a database in PostgreSQL called: regodb
2. Connect to the regodb database and run the commands in CREATE.sql to setup (do a manual commit if auto-commit was turned off).
3. Verify that 2 sequences and 3 tables were created and that 5 rows were inserted into the Insurer table.
4. Open the application.properties file (in src\main\resources) and ensure the database URL, username and password is correct.
5. In the regoapp main folder, open a command shell and run: mvn spring-boot:run   (verify there are no errors or exceptions)
6. In a web browser go to: http://localhost:8080
7. If any issues with install contact: johnacooney@yahoo.com

Notes:
1. I spent over a day on the assignment, because I wanted to ensure the GUI looks neat.
2. I assumed the number plates have a maximum length of 8 characters.
3. I added input validation for the number plates and other fields based on best guesses.