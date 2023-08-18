

## Getting Started

### Prerequisites

The following software are required:

- Java JDK 11.
- IntelliJ.
- Selenium 4.
- TestNG.
- Maven.
- Allure.
- Google Chrome version should be greater than 109 because I run in headless mode by "--headless=new".

### Installation

1. Clone the repo using below URL

```sh
https://github.com/husseinhawary/selenium-nop-commerce
```

2. All project dependencies will be installed automatically from pom.xml file once you refresh it:



## Running local and show the report

1. Run local by clicking on testng.xml file and run it
   1. Running local will run in the headless.
   2. If you need to run local in the non-headless mode, please change the browser value to "chrome" or "firefox" in testng.xml file" but make sure, that will fail a GitHub Actions job because it works in a headless mode. 
2. OR you can run the tests by using this command
```
mvn clean test
```
3. Show the report
```
allure serve allure-results
```

## GitHub Actions
The project integrated with GitHub actions, and you can see the runs build and rerun again if you want, from here

```
https://github.com/husseinhawary/selenium-nop-commerce/actions
```

