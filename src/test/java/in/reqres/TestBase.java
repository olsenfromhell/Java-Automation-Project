package in.reqres;

import in.reqres.config.Configuration;

public class TestBase {
    public static void setUp() {
        Configuration.setup(); // browser setup
    }
}
