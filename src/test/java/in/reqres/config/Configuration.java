package in.reqres.config;

import io.restassured.RestAssured;

public class Configuration {
  public static void setup() {
    RestAssured.baseURI = "https://reqres.in/";

  }
}
