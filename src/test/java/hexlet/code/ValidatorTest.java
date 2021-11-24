package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidatorTest {
    @Test
    void testStringSchema() {
        final Validator validator = new Validator();
        final StringSchema schemaStr = validator.string();
        final int minLength = 5;
        final String content = "what does the fox say";

        assertTrue(schemaStr.isValid(""));
        assertTrue(schemaStr.isValid(null));

        schemaStr.required();

        schemaStr.minLength(minLength);
        assertFalse(schemaStr.isValid("1234"));
        assertTrue(schemaStr.isValid(content));
        assertFalse(schemaStr.isValid(null));
        assertFalse(schemaStr.isValid(""));

        schemaStr.contains("what");
        assertTrue(schemaStr.isValid(content));

        schemaStr.contains("whatthe");
        assertFalse(schemaStr.isValid(content));
    }

    @Test
    void testNumberSchema() {
        final Validator validator = new Validator();
        final NumberSchema schemaNum = validator.number();

        final int minRange = 10;
        final int maxRange = 10;
        final int negativeNum = -10;
        final int lessMinRange = 4;
        final int greaterMaxRange = 4;

        assertTrue(schemaNum.isValid(null));

        schemaNum.required();

        assertFalse(schemaNum.isValid(null));
        assertTrue(schemaNum.isValid(maxRange));
        assertFalse(schemaNum.isValid("5"));

        schemaNum.positive();
        assertTrue(schemaNum.isValid(maxRange));
        assertFalse(schemaNum.isValid(negativeNum));

        schemaNum.range(minRange, maxRange);
        assertTrue(schemaNum.isValid(minRange));
        assertTrue(schemaNum.isValid(maxRange));
        assertFalse(schemaNum.isValid(lessMinRange));
        assertFalse(schemaNum.isValid(greaterMaxRange));
    }
}
