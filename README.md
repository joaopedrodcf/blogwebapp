# blogwebapp
Rest Api with enpoints to CRUD and filter Posts of Blog

## Getting Started

First just

```
git clone https://github.com/joaopedrodcf/blogwebapp.git
```

### Mysql
Download xampp and start a mysql database

Then update file application.properties

spring.datasource.username=****
spring.datasource.password=****

With your credentials

### Lombok
This project uses lombok and because of that you need to install lombok in your eclipse, the way I have done it was just maven install this project.
After that went into - C:\Users\<YOUR USER>\.m2\repository\org\projectlombok\lombok\1.16.20
Just double click the lombok jar and click install in your eclipse.

### Prerequisites

You need a mysql DB (Used XAMPP for faster creation)

## Built With

* [spring-boot](https://github.com/spring-projects/spring-boot) - Spring Boot
* [lombok](https://github.com/rzwitserloot/lombok) - Very spicy additions to the Java programming language.