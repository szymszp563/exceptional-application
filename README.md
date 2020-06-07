# exceptional-application
Application which presents some methods of exception handling. 
Program uses spring framework and swagger libraries. 
Spring boot starts application on embedded tomcat server allowing to use application on browser.
Usage of swagger gives graphical documentation and UI for testing endpoints. 
Each endpoint is responsible for presenting different method of exception handling. 
Project consists of two controllers first - StandardExceptionController presents various exception handling methods
in pure java, second - RestExceptionController presents various exception with usage of spring framework. 
Every method is describe at swagger.

To run program:
1. download run-exceptional-application.jar
2. open command prompt at destination of that file
3. run command "java -jar run-exceptional-application.jar" (java 8 or higher is needed)
4. open browser of your choice(google chrome recommended)
5. in browser bar type http://localhost:8010/swagger-ui.html#/
6. Now you'll be able to use user interface - there are two expanding tabs - representing each controller
7. Clicking on each contoller shows available methods (each for different method of exception handling)
8. Now you can click on chosen method to expand it and then click "Try it out"
9. Then you can choose required parameters and click "execute"
10. Response of application will be visible as response body 
  - code 500 and appropriate message will be displayed when exception is handled
  - code 200 and appropriate message when exception is not thrown
