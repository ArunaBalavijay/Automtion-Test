## Woolworths Coding Challenge

### Challenge

Write a BDD framework to automate the Test cases in _<Test-site>_

### Framework

This coding challenge has been written using **Selenium-Cucumber-Java-Maven-JUnit** frameworks.

This is light-weight automation framework which has the following features: 

1. BDD - Behavior Driven Development
2. Modular Design
3. POM - Page Object Model
4. Hooks
5. Report Generation (cucumber-reporting) 
6. Centralized Configurations (Using Properties file)
7. Multi-Browser support through configuration
8. Multiple Environments support

Framework Architecture
--------------
	Project-Name
		|
		|_src/main/java
		|	|...
		|_src/test/java
		|	|...
		|	|_cucumberOptions
		|	|	|_TestRunner.java
		|	|_features
		|	|	|_Login.feature
		|	|_pages
		|	|	|_DashboardPage.java
		|	|	|_LoginPage.java
		|	|_stepDefinations
		|	|	|_Login.java
		|_src/test/java/framework
		|	|_baseClasses
		|	|	|_PageBase.java
		|	|	|_TestBase.java
		|	|_browsers
		|	|	|_Browser.java
		|	|	|_ChromeBrowser.java
		|	|_interfaces
		|	|	|_IBrowser.java
		|	|	|_IConfiguration.java
		|	|_utilities
		|	|	|_BrowserHelper.java
		|	|	|_Configuration.java
		|_src/test/java/resources
		|	|_drivers
		|	|	|_chromedriver.exe
		|	|_properties
		|	|	|_development.properties
		|	|	|_global.properties
		|	|_utilities
		|	|	|_ResourceHelper.java

* **src/test/java/features** - All the cucumber features files (*.feature files) goes here.
* **src/test/java/stepDefinations** - All the step definations of the required features goes under this package.
* **src/test/java/cucumberOptions** - This package contains all the cucumber runners where glue code location (step definations), test result output format (html, json, xml) and Hooks can be configured.
* **src/test/java/resources** - All the resource files/configurations goes here such as drivers, global and environment based settings etc.
* **src/test/java/framework** - This is the reusability layer where all the base classes, browser and configuration helpers exist.

### To change the Environment and it's configurations

- Under `src/test/java/resources/properties`, modify the environment file `<environment>.properties` in case of any configurations changes.
- Then, modify the `global.properties` file as below to switch to the respective environment.

```java
	environment = <environment-to-be-switched>
```

### To change the browser to run the automation

- Under `src/test/java/resources/properties`, modify the `global.properties` file as below to change the browser.

```java
	browser = <browser-to-be-switched>
```

### Cucumber Report

There is a feature overview page:

![feature overview page](https://github.com/damianszczepanik/cucumber-reporting/raw/master/.README/feature-overview.png)

And there are also feature specific results pages:

![feature specific page passing](https://github.com/damianszczepanik/cucumber-reporting/raw/master/.README/feature-passed.png)

And useful information for failures:

![feature specific page passing](https://github.com/damianszczepanik/cucumber-reporting/raw/master/.README/feature-failed.png)

If you have tags in your cucumber features you can see a tag overview:

![Tag overview](https://github.com/damianszczepanik/cucumber-reporting/raw/master/.README/tag-overview.png)

And you can drill down into tag specific reports:

![Tag report](https://github.com/damianszczepanik/cucumber-reporting/raw/master/.README/tag-report.png)

