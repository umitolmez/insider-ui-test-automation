Insider IU Test Automation
---



This framework is based in **Page Object Model (POM)** and supports multi browsers(Chrome, Firefox).

The framework uses:

1. Java
2. Maven
3. Selenium
4. TestNG
5. ExtentReport

---

Prerequisites
---
1. Java: SDK 11 or higher
2. Maven: 3.9 or higher
---
Running Suite
---
1. Execute the test cases by maven command `mvn clean test`
2. To run specific browser for example Firefox `mvn clean test -Dbrowser=firefox`
---

Reporting
---
1. A html report - Which is generated using Extent Reports, under the folder `test-output`.

---

Improvements & Suggestions
---

1. Parallel Run: As the number of test cases increases, it will take time to run tests in a single browser.
2. Runner.xml: As the number of test cases increases, suites like Regression, Smoke should be created.
3. Reporting: If the management team does not like the reports generated, a different reporting tool can be tried.
4. Rerun: A file can be created to rerun failed test cases.
5. Branch Strategy: I did not pay attention to commit and branch issues because I was working alone on this project. Branch strategy would be better in terms of traceability.
