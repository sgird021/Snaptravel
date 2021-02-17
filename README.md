# **About**

This repository will contain all UI automation for SnapTravel

## **How to setup**

1.	Setup Ant on local machine.
	- Link to Download [Apache ant 1.9.9](https://ant.apache.org/bindownload.cgi)
	- Set environment variable, define a System variable and set the apache ant path to ANT_HOME 
	- Add Apache ant BIN path to the System Path variable.
3.	On the cmd prompt navigate to the Build.xml folder
4. Run ant command
5. It should start the automation scripts.
6. Single test run can be executed by configuring the TestNG run. 

## **Test Plan**
##  Scope: 
- Scenario : Booking a hotel: A customer searches for a hotel and then reserve the room by completing the payment.
Perform regression(manual and automation) and E2E tests and generate test results. 

######  Quality Objective: 
- Ensure the Application Under Test: Snap Travel conforms to functional and non-functional requirements. 
- Ensure the E2E and regression tests are executed gigivng confidence to the release. 
- Ensure test results are generated and there is SOP for the failed testcases.
- Define the Test Methodology.

###### Testing tools: 
- Automation tools: Selenium, java.
- Testcase repository tool.

###### Automation testing: 
- Define the tools : Selenium java
- Setup framework.: Page object model framework 
- Reporting : TestNG
- Decide build, version control and implement CI/CD

## **Tradeoffs**
- When a page is loaded by the browser the interacting elements may load at different time intervals.Leading in element not found excetion. To avoid the test to break had to use implicit and explicit waits and traded off on the test execution time. 

## **Test Scenarios**
Following are some testcases: 
- Test successful search results. Test different data for search. 
- Test all UI Components are loaded.
- Test incorrect Card information.
- For Payment verify the mandatory fields.
- Verify correct message is displayed for payment time expiry,
- Verify the user navigation after the time expiry


