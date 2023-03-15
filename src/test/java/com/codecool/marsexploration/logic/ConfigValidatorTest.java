package com.codecool.marsexploration.logic;
import com.codecool.marsexploration.data.MapConfig;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
class ConfigValidatorTest {

    @Test
    public void testValidate() {
        MapConfig mapConfig = new MapConfig("test", 5, List.of(1, 1, 1, 1), List.of(1, 1, 1, 1), 2, 2);
        ConfigValidator configValidator = new ConfigValidator(mapConfig);

        assertTrue(configValidator.validate(50));
        assertFalse(configValidator.validate(25));

    }
}