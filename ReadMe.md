**Selenium with TestNG Automation Framework**

This is a Selenium based automation testing framework integrated with TestNG for managing and running automated test cases. The framework is designed for easy scalability and maintainability and includes essential features like reporting, test configuration, and parallel execution.
Technologies/Tools used in building the framework
=================================================
- IntelliJ - IDE
- Maven - Build automation tool
- Java - Programming language
- TestNG - Test Management library
- Allure Reports - Reporting framework
- GitHub - Version control


This framework using latest Java and TestNg Version.
Framework Structure:


To Run this Project execute below commands:
  mvn -DsuiteXml=testNg.xml test
  To Generate test Report use command, allure-generate or allure serve.

**Project Structure**

The project follows a modular structure, organizing code for easy maintenance.
selenium-testng-framework/

* `├── src/test/java
* │   ├── tests          # Test classes containing test methods
* │   ├── resources      # Test data and config files
* │
* ├── pom.xml            # Maven configuration file for managing dependencies
* ├── testng.xml         # TestNG suite file
* └── README.md          # This file`
