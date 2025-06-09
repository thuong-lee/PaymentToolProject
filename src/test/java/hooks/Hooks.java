package hooks;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass {
    @Before
    public void beforeScenario() {
        setUp();
    }

    @After
    public void afterScenario() {
        tearDown();
    }
}
