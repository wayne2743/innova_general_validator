# Getting Started

## > Startup the RestFul service
1. Go to the home directory for "gneral-validator"
2. Run the below command : 
```pwershell
.\mvnw spring-boot:run
```
3. You should see the service run on `http://loacalhost:8080`

# Function Verification
## > Unit test & Integeration test
1. Go to the home directory for "gneral-validator"
2. Run the below command :
```powershell
.\mvnw surefire-report:report
```
3. After you see the "BUILD SUCCESS" in the comand line, you can try to open the html under 
<b>${general-validator home}/target/site/surefire-report.html</b>.
4. All test result should show in the page.

## > Load test
1. Before load testing startup, the spring-boot website should start up already. (Please refer to "Getting Started" section).
2. Run the below command :
```powershell
.\mvnw gatling:test
```
3. You can find the load testing report will generate at <b>${general-validator home}\target\gatling\passwordchecksimulation-xxxxxxxxxxxxxxxxx/index.html</b> location.
4. If you want to change the `rampUsers` and `during` in the load testing, you can modify the <b>${general-validator home}/src/test/java/loadtesting/PasswordCheckSimulation.java</b> in the project. 

``` java
    ScenarioBuilder users = scenario("Users").exec(passwordCheck);

    {
        setUp(
            users.injectOpen(rampUsers(10).during(30))
        ).protocols(httpProtocol);
    }
```
5. Then after modification, please run step 2-3 again to regenerate load testing report.