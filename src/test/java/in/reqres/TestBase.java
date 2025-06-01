package in.reqres;

import in.reqres.config.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

  final String headerKey = "x-api-key";
  final String headerValue = "reqres-free-v1";

  @BeforeAll
  public static void browserSetup() {
    Configuration.setup();
  }
}
