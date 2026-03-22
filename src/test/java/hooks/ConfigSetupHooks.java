package hooks;

import config.BaseTest;
import io.cucumber.java.Before;

public class ConfigSetupHooks {

    @Before
    public void setup() {
        BaseTest.setup();
    }
}