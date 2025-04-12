# Test Automation Framework

[![Quality Gate](https://img.shields.io/badge/Quality-Approved-success)](https://github.com/yourorganization/test-automation-framework)
[![Java Version](https://img.shields.io/badge/Java-17%2B-blue)](https://www.oracle.com/java/technologies/javase-downloads.html)
[![Maven](https://img.shields.io/badge/Maven-3.8.0%2B-purple)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-green)](LICENSE)

A comprehensive, modular, and maintainable test automation framework built with Java. This framework seamlessly integrates UI and API testing capabilities for web applications, with a focus on creating robust, reusable, and easily maintained test suites.

## 🌟 Key Features

- **Modular Architecture**: Clear separation of concerns with dedicated modules for specific applications and utilities
- **Dual Testing Capabilities**: Supports both UI testing (Selenium) and API testing (REST Assured)
- **BDD Integration**: Cucumber implementation for behavior-driven development
- **Database Testing**: MockServer integration for database verification
- **Comprehensive Reporting**: Allure reports for detailed test execution insights
- **Multi-Browser Support**: Chrome, Firefox, and other browsers
- **Parallel Execution**: Speed up test runs with concurrent execution
- **Design Patterns**: Implementation of POP, OOP, Factories and other design patterns

## 🏗️ Architecture

The project follows a modular architecture with a clear separation of test components:

```
test-automation-framework/
├── RegioJet/               # UI and API tests for RegioJet service
├── Idos/                   # UI tests for Idos service
├── MockServer/             # Database testing with mock server
├── CucumberExample/        # BDD tests for Open Library service
└── Util/                   # Common utilities and configurations
```

## 🚀 Technology Stack

- **Core**: Java 17+
- **Build Tool**: Maven
- **UI Testing**: Selenium WebDriver
- **API Testing**: REST Assured
- **BDD Framework**: Cucumber
- **Test Frameworks**: JUnit 5, TestNG
- **Reporting**: Allure, SL4J
- **Design**: Listeners, Extensions, Page Object Pattern

## 🔧 Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.8.0 or higher
- Chrome/Firefox browser
- Allure (for reporting)

### Installation

1. Clone the repository
```bash
git clone https://github.com/yourusername/test-automation-framework.git
cd test-automation-framework
```

2. Install dependencies
```bash
mvn clean install -DskipTests
```

3. Install Allure (for report generation)
```bash
npm install -g allure-commandline
```

### Running Tests

#### Run All Tests
```bash
mvn test
```

#### Run Tests for Specific Module
```bash
mvn test -pl RegioJet
```

#### Run with Specific Browser
```bash
mvn test -DbrowserType=chrome
```

#### Run in Headless Mode
```bash
mvn test -Dheadless=true
```

### Generating Reports

After test execution, generate the Allure report:
```bash
allure serve allure-results
```

## 📚 Project Modules

### RegioJet
Contains UI and API tests for the RegioJet transportation service. Implements both front-end validation and API endpoint testing.

### Idos
Focuses on UI testing for the Idos transportation information service with complete journey search flows.

### MockServer
Provides database testing capabilities with a mock server implementation, allowing for isolated data validation.

### CucumberExample
Demonstrates BDD testing approach using Cucumber for both UI and API tests of the Open Library service.

### Util
Houses common utilities, configurations, and reusable components that support all other modules.

## 🧪 Test Types

- **UI Tests**: Front-end validation across multiple browsers
- **API Tests**: RESTful endpoint verification
- **Database Tests**: Data integrity validation
- **BDD Tests**: Behavior-driven scenarios
- **Regression Tests**: Comprehensive coverage of critical paths
- **Performance Tests**: Basic performance metrics

## 📊 Code Quality & Best Practices

- **Clean Code**: Follows SOLID, DRY, and KISS principles
- **Consistency**: Uniform coding style and naming conventions
- **Documentation**: Comprehensive JavaDoc for key components
- **Error Handling**: Robust exception management
- **Logging**: Detailed execution logs for troubleshooting
- **Version Control**: Structured Git workflow

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.