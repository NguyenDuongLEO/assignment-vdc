#assignment-vdc
(QA Development Technical Assignment)

The Application Under Test
- https://openweathermap.org/
- Test case, Testing Approach, API collection: please refer to the **Testing Document** directory

##Resource need to be installed
- Maven
- Java 8
- IntelliJ IDEA
- Cucumber
- API Rest Assured
- Selenium
- Google Chrome web browsers

How to execute the test scripts?
1. Clone the repository (https://github.com/NguyenDuongLEO/assignment-vdc).
2. Right click on the "pom.xml" and select "Maven > Reimport".
3. Wait until all dependencies are imported.
4. Run API test: 
	- Run file **src\test\java\testscripts\api\TestApiRunner.java**
	- View the report by opening file **target\cucumber-reports.html** using Web Browser
5. Run UI test:
	- Run file **src\test\java\testscripts\api\TestRunner.java**
	- View the report by opening file **target\cucumber-reports.html** using Web Browser