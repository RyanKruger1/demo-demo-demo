# Groot
The [Global Kinetic](https://www.globalkinetic.com/) Framework named after the intelligent tree-like [Marvel character](https://marvelcinematicuniverse.fandom.com/wiki/Groot) because of it's flexibility and ability to grow.

Groot was created for web automation projects based on selenium webdriver, mostly using Java as the programming language.
This project is used to build, create and publish two artifacts :
* The Groot framework library
* The Groot stub artifact which is is downloaded and extracted by automation engineers as a template for new projects.

## PRE-REQUISITES ##
- Gradle 4+
- Java 1.8 +
- IDE - preferably IntelliJ IDEA
- Web browser - preferably latest stable version of Chrome or Firefox

# Info and usage instructions

## FEATURES ##

This framework implements a [Page Factory](https://github.com/SeleniumHQ/selenium/wiki/PageFactory) Design approach.

Groot allows us to run selenium webdriver tests locally as well remotely on zalenium grid, saucelabs or external machines

## FRAMEWORK STRUCTURE & LOGIC ##

**BaseTest.java**

Contains the webdriver setup and tear down methods. BaseTest may also include common methods that are shared across tests.
For example, navigateToUrl() method is a common method that will be required by all tests hence it is in the BaseTest. 
This method is then called in the BaseTest setup method. Test classes that override the BaseTest setup method will then use the default url (see **SampleTest1.java**), 
unless overridden with a custom url (see **CustomUrlSampleTest.java**) 

**CustomConfig.java**

Contains custom properties from the stub's **"groot.properties"** file. Tester can add variables and getter methods for custom properties, extending the default properties defined in the library.
The test can add, for example, multiple test urls and not be limited to the default test url that is set up in the library

**PageObjSample.java**
- provides the base structure and properties of a page object which extend onto the tests
- using page factory design pattern, web elements are initialized within these page object

**CustomUrlSampleTest.java**
- contains actual test(s) i.e all necessary test steps to verify a specific business process.
- these tests use the methods found in the above-mentioned page objects
- This sample test is created as proof of concept for tests that use custom properties

**SampleTest1.java**
- Same as above-mentioned *CustomUrlSampleTest.java* except that this test class uses the default properties instead of custom.

### build.gradle files ###

The stub build.gradle file(s) found in the *stub folder* contains all the dependencies that are used are required to compile the stub, including dependencies inherited from the library.
Within this gradle file, a tester can specify which unit testing framework to use.
For example, in *tasks.withType(Test)*, *useTestNG() {}* is used to specify that TestNG will be the unit testing framework that will be used to run the tests.

## EXECUTING TEST SUITE ##

### Running tests locally (Command Line or IDE:) ###

1. If you plan to run the tests via your IDE e.g. IntelliJ then make sure the following parameters are set:  
**"selenium.driver.remote"** - must be set to **'false'** to run tests on local webdriver  
**"selenium.browser.name"** - specify name of browser that is available on your local machine e.g. chrome, firefox  
**"selenium.browser.version"** - specify version of the browser on your local machine e.g. 58 (for chrome)  
**"groot.test.platform"** - specify your machine's operating system e.g. MAC, WINDOWS, LINUX  
2. Disable any tests you want to exclude in you test run using the TestNG enabled parameter e.g. *@Test(enabled=false)*
3. Save changes
4. Execute the following commands in your IDE terminal:
```$xslt
In Windows terminal: ./gradlew.bat clean test  
In Mac terminal: ./gradlew clean test
```

### Running tests via Saucelabs or External machine ###

You will need access to saucelabs account or a dedicated machine.
Basically follow the instructions above but ensure "selenium.driver.remote" = true for saucelabs

## HINTS AND TIPS ##

### To clean specific projects, run the following commands: ###
```$xslt
In Windows terminal: ./gradlew.bat clean
In Mac terminal: ./gradlew clean
```

### To run tests concurrently: ###

1. Go to the **build.gradle** file of the project
2. Set value of the **"maxParallelForks"** parameter to the number of tests you want to run concurrently

### Using safari browser to run tests on your local machine: ###
For safari driver to work locally you must manually install the SafariDriver browser extension on Safari.

See below links for more info: 
- [toolsqa website](https://www.toolsqa.com/selenium-webdriver/running-tests-in-safari-browser)
- [apple developer website](https://developer.apple.com/documentation/webkit/testing_with_webdriver_in_safari)

### To add and use custom properties: ###
1. Add the property in the Stub's groot.properties file
2. In the CustomConfig object, create a variable and getter method for the custom property
3. Create a method in BaseTest.java that utilises that custom property
4. If you wish to use the method in selected tests, you may call the method in the respective tests only
5. If you wish to use the method across all your tests, you may call the method in the BaseTest setup method and over setup method in all test classes