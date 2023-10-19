package com.adventurer.webapp;

import com.adventurer.webapp.steps.BaseTests;
import org.testng.annotations.Test;

public class TestApi extends BaseTests {
    @Test(description = "Проверка апи получения юзера")
    public void  testGetUser() {
        apiSteps.getUserById(2L);
    }
}
