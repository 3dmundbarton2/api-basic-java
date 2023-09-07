# Getting Started Instructions - java

1. you will need openJDK installed (tested with v17) - i used Chocolatey package manager for Windows (https://chocolatey.org/install) - for mac users you can use Brew (https://brew.sh/) - and for linux users you have a package manager of your choice to use :) 
1. you will also need to install Apache Maven - use a package manager of your choice to do this - check it's installed by running `mvn -version` - if you get a response from maven (instead of not found), you're good to go.
1. having cloned the repository from GitHub, running the tests is as straightforward as running `mvn test` in the project root 

# High-Level Design

## Feature Files 
`/src/test/java/com/bartonsoft/apibasicjava/features`
This framework uses BDD (Behaviour Driven Design) to provide validation of acceptance criteria.
These criteria are expressed as Gherkin (https://specflow.org/learn/gherkin/, https://cucumber.io/docs/gherkin/reference/) feature files to capture these in human-readable format.
Expressing test scenario behaviours and actions in a common way promotes re-usability

## Step Definitions
`src/test/resources/com/bartonsoft/apibasicjava/steps`
Step definition files are the java implementation of the human-readable steps.  
In this example we're using the following libraries 
- `RESTAssured` to provide HTTP REST (API) calls.  RESTAssured provides a great deal of syntactic sugar which allows you to express your requests and your assertions in a readable and fluent manner
- `AssertJ` to provide more flexible, more intuitive assertions of expected behaviour - assertions are written in a "fluent" style which make it easier to read and understand - e.g. AssertThat(actualthing).contains(expectedthing) 

## Test Runner
- `TestNG` : long-standing and favourite in the java testing world, TestNG provides a flexible and configurable framework for managing large test suites.  In this framework, TestNG provides the orchestration of the BDD tests, glueing them together to the step definitions

## Other possible enhancements
- export test results to xml result file for import into pipeline test results or test management tooling
- html reporting of BDD test results - using something like `extent` or `trivago/cluecumber` - this would give humans reading the test results a more approachable and visual presentation of both the steps executed and the results
- pipeline integration - typically, test execution of this framework wouldn't be executed on a local machine (unless maintaining / triaging failures) - this framework will run at command line in a pipeline, but needs richer result file to clearly describe success / failures in this scenario
- leveraging TestNG's CucumberRunner to setup and teardown RESTAssured api client (in this test we create a new client in each test, but in a bigger suite you would want to perform authentication tasks up front and possibly share these across tests)