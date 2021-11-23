package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberSchemaTest {
    private Validator validator = new Validator();
    private NumberSchema schema = validator.number();
    private final int min = 5;
    private final int max = 10;
    private final int four = 4;
    private final int eleven = 11;
    private final int minten = -10;
    @Test
    void testRequired() {
        assertFalse(schema.required().isValid(null));
    }

    @Test
    void testPositive1() {
        schema.required();
        assertFalse(schema.positive().isValid(minten));
    }

    @Test
    void testPositive2() {
        schema.required();
        assertTrue(schema.positive().isValid(max));
    }

    @Test
    void testPositive3() {
        schema.required();
        assertFalse(schema.positive().isValid("5"));
    }

    @Test
    void testRange1() {
        schema.required();
        assertTrue(schema.range(min, max).isValid(min));
    }

    @Test
    void testRange2() {
        schema.required();
        assertTrue(schema.range(min, max).isValid(max));
    }

    @Test
    void testRange3() {
        schema.required();
        assertFalse(schema.range(min, max).isValid(four));
    }

    @Test
    void testRange4() {
        schema.required();
        assertFalse(schema.range(min, max).isValid(eleven));
    }
}
