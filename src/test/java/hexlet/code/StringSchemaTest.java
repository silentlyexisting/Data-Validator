package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;



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
        assertTrue(schema.minLength(LENGTH).isValid(null));
    }

    @Test
    void testMinLength4() {
        schema.required();
        assertTrue(schema.minLength(LENGTH).isValid(""));
    }

    @Test
    void testRequired1() {
//        assertEquals(schema.required().isValid(""), true);
        assertThat(schema.required().isValid("")).isEqualTo(true);
    }

    @Test
    void testRequired2() {
//        assertEquals(schema.required().isValid(null), true);
        assertThat(schema.required().isValid(null)).isEqualTo(true);
    }

    @Test
    void testContains1() {
        assertTrue(schema.contains("what").isValid("what does the fox say"));
    }

    @Test
    void testContains2() {
        assertTrue(schema.contains("whatthe").isValid("what does the fox say"));
    }

}
