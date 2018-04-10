# blogwebapp
Rest Api with enpoints to CRUD and filter Posts of Blog

## Getting Started

First just

```
git clone https://github.com/joaopedrodcf/blogwebapp.git
```

### Mysql
Download xampp and start a mysql database

Then before running the project in eclipse for example set custom enviroment variables

Run configurations -> Enviroment

Set these

SPRING_DATASOURCE_URL = ****
SPRING_DATASOURCE_USERNAME = ****
SPRING_DATASOURCE_PASSWORD = ****


### Lombok
This project uses lombok and because of that you need to install lombok in your eclipse, the way I have done it was just maven install this project.
After that went into - C:\Users\<YOUR USER>\.m2\repository\org\projectlombok\lombok\1.16.20
Just double click the lombok jar and click install in your eclipse.

### Gmail
To send emails and if you use two step authenticator you need to create an app password.
https://security.google.com/settings/security/apppasswords

Then you just have to create more enviroment variables

EMAIL_GMAIL = ****
PASSWORD_GMAIL = ****

### Prerequisites

You need a mysql DB (Used XAMPP for faster creation)

## Built With

* [spring-boot](https://github.com/spring-projects/spring-boot) - Spring Boot
* [spring-data-jpa](https://github.com/spring-projects/spring-data-jpa) - Simplifies the development of creating a JPA-based data access layer.
* [javamail](https://javaee.github.io/javamail/) - The JavaMail API provides a platform-independent and protocol-independent framework to build mail and messaging applications.
* [lombok](https://github.com/rzwitserloot/lombok) - Very spicy additions to the Java programming language.