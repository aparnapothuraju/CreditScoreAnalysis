package com.example.ReportGeneration;

import com.example.ReportGeneration.Controller.GenerateandDeliverReport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SmokeTest {

    @Autowired
    private GenerateandDeliverReport gc;

    @Test
    @DisplayName("Context Loads: Controller bean should be present in ApplicationContext")
    void controllerShouldNotBeNull() {
        assertThat(gc).isNotNull();
    }
}