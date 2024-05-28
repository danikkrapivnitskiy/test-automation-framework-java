### Maven Demo Project: A Journey Through Best Practices

---

    This project showcases a robust Maven demo, built with a focus on best practices and a commitment to clean, maintainable code.

---

### Core Principles

#### This project embodies the following principles:
1. OOP
2. SOLID principles
3. DRY
4. KISS
5. Framework Development Patterns and etc

### Project Structure
#### The project is organized into distinct modules:
1. __RegioJet:__ UI and API projects for the RegioJet service.
2. __Idos:__ UI project for the Idos service.
3. __MockServer:__ Project for testing the database with created mock server.
4. __OpenLibriary:__ UI and API tests with Cucumber for the Open Library service.

### Technology Stack
#### I utilize a powerful set of technologies:
1. __Java:__ The core programming language.
2. __Selenium:__ Used for UI automation testing.
3. __Rest Assured:__ Used for API testing.
4. __Cucumber:__ A framework for behavior-driven development.
5. Additional technologies as: JUnit5, TestNG, SL4J and etc.

### Getting Started:
#### 1. Prerequisites:
- Java 17+: Ensure you have Java 17 or later installed.
    ```bash
    java --version
    ```
- Maven v3.6.3 or higher: Make sure you have Maven 3.6.3 or later installed.
    ```bash
    mvn --version
    ```
#### 2. Download Dependencies: 
- Run the following command to download dependencies
    ```bash
    mvn clean install -DskipTests
    ```
#### 3. Database Connection: Verify you have a connection to the SQL database for the Mock tests.
#### 4. Run Tests:
- You are ready to run tests!

### Project Structure:
1. __api.mock:__ Contains the Mock tests.
2. __com.regiojet:__ Contains the RegioJet tests.
3. __cucumber:__ Contains the Open Library tests, runner, and step definitions.
4. __cz.idos:__ Contains the Idos tests.