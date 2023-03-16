package com.codecool.marsexploration.logic;
import com.codecool.marsexploration.data.MapConfig;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
class ConfigValidatorTest {
    @ParameterizedTest
    @CsvSource ({
            "true, 50",
            "false, 25",
    })

    void testValidate(boolean expected, int maxOccupancyPercentage) {
        MapConfig mapConfig = new MapConfig("test", 5, List.of(1, 1, 1, 1), List.of(1, 1, 1, 1), 2, 2);
        ConfigValidator configValidator = new ConfigValidator(mapConfig);

        boolean result = configValidator.validate(maxOccupancyPercentage);

        assertEquals(expected, result);
    }
}