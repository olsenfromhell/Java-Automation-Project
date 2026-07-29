package in.reqres;

import in.reqres.config.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

  final String headerKey = "x-api-key";
  final String headerValue = "reqres_4550ced39eb945638b5463b02a51cff9";

  @BeforeAll
  public static void browserSetup() {
    Configuration.setup();
  }
}
