# registration-simple-spring-boot-app

This is a simple web app with registration form, it does not include authentication. It was written in Java using Spring Boot and Maven. 
I recommend to run it from IDE using a Spring boot configuration. For example Intellij or Eclipse would do. You can also run it from the command line using the following command.

mvnw spring-boot:run
 
Although if using the latter option, make sure that your JAVA_HOME env variable points to a Java 11 JDK. This command has to be run from the project directory. 

The application uses H2 embedded database. It uses default configuration so after every restart database is being cleared. Application uses 8080 port by default. 
H2 console is available under the following URL.
http://localhost:8080/h2-console

There are only two possible URLS served by this application.
http://localhost:8080/register
http://localhost:8080/greeting
