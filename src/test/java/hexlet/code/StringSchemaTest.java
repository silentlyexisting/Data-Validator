package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;



class StringSchemaTest {
    private Validator validate = new Validator();
    private StringSchema schema = validate.string();
    private static final int LENGTH = 5;

    @Test
    void testMinLength1() {
        schema.required();
        assertTrue(schema.minLength(LENGTH).isValid("what does the fox say"));
    }

    @Test
    void testMinLength2() {
        schema.required();
        assertTrue(schema.minLength(LENGTH).isValid("hexlet"));
    }

    @Test
    void testMinLength3() {
        schema.required();
        assertFalse(schema.minLength(LENGTH).isValid(null));
    }

    @Test
    void testMinLength4() {
        schema.required();
        assertFalse(schema.minLength(LENGTH).isValid(""));
    }

    @Test
    void testRequired1() {
        assertFalse(schema.required().isValid(""));
    }

    @Test
    void testRequired2() {
        assertFalse(schema.required().isValid(null));
    }

    @Test
    void testContains1() {
        assertTrue(schema.contains("what").isValid("what does the fox say"));
    }

    @Test
    void testContains2() {
        assertFalse(schema.contains("whatthe").isValid("what does the fox say"));
    }

}
