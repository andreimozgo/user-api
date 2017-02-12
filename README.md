***Rest Api for Managing Users***

Used technologies:
* Java 8
* Spring Boot
* Gradle
* MySQL


**Preparing project**

After checkout or unzip project please check connection to DB.
 For it open 
user-api\src\main\resources\application.properties and check properties

    spring.datasource.username
    spring.datasource.password
    
Set them based on your environment.

**Running project**

for windows

    gradlew.bat bootRun
    
for unix
    
    ./gradlew bootRun