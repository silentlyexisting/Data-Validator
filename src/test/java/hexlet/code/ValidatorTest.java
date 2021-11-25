package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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
        final int biggerMaxRange = 4;

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
        assertFalse(schemaNum.isValid(biggerMaxRange));
    }

    @Test
    void testMapScheme() {
        final Validator validator = new Validator();
        final MapSchema mapSchema = validator.map();

        assertTrue(mapSchema.isValid(null));

        mapSchema.required();

        assertFalse(mapSchema.isValid(null));
        assertTrue(mapSchema.isValid(new HashMap<>()));
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertTrue(mapSchema.isValid(data));

        mapSchema.sizeof(2);
        assertFalse(mapSchema.isValid(data));
        data.put("key2", "value2");
        assertTrue(mapSchema.isValid(data));
    }

    @Test
    void testShapeMapScheme() {
        final Validator validator = new Validator();
        final MapSchema mapSchema = validator.map();
        final int positiveValue = 100;
        final int negativeValue = -5;
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", validator.string().required());
        schemas.put("age", validator.number().positive());
        mapSchema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", positiveValue);
        assertTrue(mapSchema.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        assertTrue(mapSchema.isValid(human2));

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        assertFalse(mapSchema.isValid(human3));

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", negativeValue);
        assertFalse(mapSchema.isValid(human4));

    }
}
