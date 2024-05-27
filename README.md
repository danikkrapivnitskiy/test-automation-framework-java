### This is maven demo project written with OOP, SOLID, DRY, KISS and other principles with Framework Development Patterns

---

    There are some different projects. RegioJet for UI and API, Idos for UI,
    MockServer project for testing DB. OpenLibriary project tests UI and API with Cucumber.

---

### Tests were created used Java, Selenium, Rest Assured and Cucumber

#### For correct work you need to:
1. Verify you have installed Java 17+ and maven v3.6.3 or higher
    ```bash
    java --version
    ```

    ```bash
    mvn --version
    ```
2. Run clean install command to download dependencies
    ```bash
   mvn clean install -DskipTests
    ```
3. Verify connection to SQL DB for Mock test
4. You can run tests now :) 