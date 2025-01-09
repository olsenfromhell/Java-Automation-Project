package in.reqres;

import in.reqres.config.Configuration;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    @BeforeEach
    public void setUp() {
        Configuration.setup(); // browser setup
    }
}
