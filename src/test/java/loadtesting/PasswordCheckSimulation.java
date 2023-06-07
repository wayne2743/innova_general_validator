package loadtesting;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import java.util.concurrent.ThreadLocalRandom;

/**
 * This sample is based on our official tutorials:
 * <ul>
 *   <li><a href="https://gatling.io/docs/gatling/tutorials/quickstart">Gatling quickstart tutorial</a>
 *   <li><a href="https://gatling.io/docs/gatling/tutorials/advanced">Gatling advanced tutorial</a>
 * </ul>
 */
public class PasswordCheckSimulation extends Simulation {

    FeederBuilder<String> feeder = csv("search.csv").random();

    ChainBuilder passwordCheck =
            feed(feeder)
            .exec(
                http("Password Check: Valid Input")
                    .get("/validate/password/check?input=#{searchCriterion}")
                    .check(
                       bodyString().is("true"),
                       status().is(200)
                    )
            )
            .pause(1)
            .exec(
                http("Password Check: Invalid Input")
                    .get("/validate/password/check?input=#{searchComputerName}")
                    .check(
                       bodyString().is("false"),
                       status().is(200)
                    )
            )
            ;



    HttpProtocolBuilder httpProtocol =
        http.baseUrl("http://localhost:8080")
            .acceptHeader("application/json")
            .contentTypeHeader("application/json");

    ScenarioBuilder users = scenario("Users").exec(passwordCheck);

    {
        setUp(
            users.injectOpen(rampUsers(10).during(30))
        ).protocols(httpProtocol);
    }
}
