# Web-API Automation Project


This project is a Selenium-based UI test automation framework for the [DemoBlaze](https://www.demoblaze.com) website and API Testing to endpoint https://dummyapi.io/data/v1/
It uses Java, Cucumber (Gherkin), Selenium WebDriver, for Web Automation and RestAssured for API Testing, with Gradle as the build tool.

The purpose is to validate functionality of DemoBlaze functionality feature ( register, login, add to cart, purchases ) 

Configurations & Tools
- Java ( Programming Language )
- Selenium WebDriver (Web Automation Framework)
- Rest Assured (API Automation Framework)
- Cucumber (BDD with Gherkin syntax)
- Gradle (Build tool)
- WebDriverManager (Automatic driver management)


🧪 How to Run Tests
1. Test can run from respective .feature under resources package
2. Run the following command from the root of the project in terminal:
   - API : ./gradlew runApiTests
   - Web : ./gradlew runWebTests



