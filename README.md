#QA Development Technical Assignment

##The Application Under Test - [AUT](https://openweathermap.org/)
- Feature: Search weather in your city
- [Test case](https://github.com/NguyenDuongLEO/assignment-vdc/blob/master/Testing%20Document/Assignment_TestCases.xlsx)
- [Testing Approach](https://github.com/NguyenDuongLEO/assignment-vdc/blob/master/Testing%20Document/Testing%20Approach.docx)
- [API collection](https://github.com/NguyenDuongLEO/assignment-vdc/blob/master/Testing%20Document/Openweathermap%20-%20API%20Search%20Weather%20in%20your%20city.postman_collection.json)

##Resource need to be installed
- Maven
- Java 8
- IntelliJ IDEA
- Cucumber
- API Rest Assured
- Selenium
- Git
- Google Chrome web browsers

##Installation
Use the git command to clone the repository **assignment-vdc**
```bash
git clone https://github.com/NguyenDuongLEO/assignment-vdc
```

##How to execute the test scripts?
1. Open the IntelliJ IDEA app and open the project **assignment-vdc**
2. Right click on the file **pom.xml** and select **Maven** and then **Reimport**.
3. Wait until all dependencies are imported.
4. Run API test: 
	- Right click on the file **src\test\java\scripts\api\TestApiRunner.java** and select **Run 'TestApiRunner'**
	- To view the report, right click on the file **target\cucumber-api-reports.html** and select **Open in browser** and then **Chrome**
5. Run UI test:
	- Right click on the file **src\test\java\scripts\api\TestRunner.java** and select **Run 'TestRunner'**
	- To view the report, right click on the file **target\cucumber-reports.html** and select **Open in browser** and then **Chrome**