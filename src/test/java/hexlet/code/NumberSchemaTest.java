package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberSchemaTest {
    private Validator validator = new Validator();
    private NumberSchema schema = validator.number();
    private static final int MIN = 5;
    private static final int MAX = 10;
    private static final int FOUR = 4;
    private static final int ELEVEN = 11;
    @Test
    void testRequired() {
        assertFalse(schema.required().isValid(null));
    }

    @Test
    void testPositive1() {
        schema.required();
        assertFalse(schema.positive().isValid(null));
    }

    @Test
    void testPositive2() {
        schema.required();
        assertTrue(schema.positive().isValid(MAX));
    }

    @Test
    void testPositive3() {
        schema.required();
        assertFalse(schema.positive().isValid("5"));
    }

    @Test
    void testRange1() {
        schema.required();
        assertTrue(schema.range(MIN, MAX).isValid(MIN));
    }

    @Test
    void testRange2() {
        schema.required();
        assertTrue(schema.range(MIN, MAX).isValid(MAX));
    }

    @Test
    void testRange3() {
        schema.required();
        assertFalse(schema.range(MIN, MAX).isValid(FOUR));
    }

    @Test
    void testRange4() {
        schema.required();
        assertFalse(schema.range(MIN, MAX).isValid(ELEVEN));
    }
}
