# Entrata Website Selenium Tests

## Project Description
This project includes automated Selenium WebDriver tests for the Entrata website. The tests cover homepage loading, footer presence, verifying a specific phone number in the footer, and the functionality of the "Watch Demo" button.

## Setup Instructions
### Prerequisites
- Java 21.0.1
- Selenium WebDriver
- Maven
- eclipse IDE Version: 2023-09 (4.29.0)
- ChromeDriver
- TestNG

### Dependencies
Add the following dependencies to your pom.xml:
- Selenium Java 4.17.0
- TestNG 7.9.0
- WebDriverManager 5.6.3
-  SLF4J Implementation 2.22.1

### Installation
1. Install Java and set up the JAVA_HOME environment variable.
2. Install Selenium WebDriver and ChromeDriver.
3. Add TestNG to your project via a build tool like Maven 
4. Clone or download this project.

## Running the Tests
- Open the project in your IDE.
- Run the EntrataHomePageTest class as a TestNG test, or use mvn test with Maven.

## Test Cases
1. *Homepage Load Test*: Validates the correct loading of the Entrata homepage.
2. *Footer Presence Test*: Ensures the footer is displayed on the homepage.
3. *Footer Phone Number Test*: Checks for the specific phone number in the footer.
4. *Watch Demo Button Test*: Tests the functionality of the "Watch Demo" button.
