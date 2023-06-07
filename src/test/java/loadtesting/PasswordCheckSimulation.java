package loadtesting;

import static io.gatling.javaapi.core.CoreDsl.bodyString;
import static io.gatling.javaapi.core.CoreDsl.csv;
import static io.gatling.javaapi.core.CoreDsl.feed;
import static io.gatling.javaapi.core.CoreDsl.rampUsers;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.FeederBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

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
                    .get("/validate/password/check?input=#{validInput}")
                    .check(
                       bodyString().is("{\"httpStatus\":200,\"result\":\"Success\",\"errorCode\":0,\"errorMsg\":\"Sucess\"}"),
                       status().is(200)
                    )
            )
            .pause(1)
            .exec(
                http("Password Check: Invalid Input")
                    .get("/validate/password/check?input=#{invalidInput}")
                    .check(
                       status().is(500)
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
