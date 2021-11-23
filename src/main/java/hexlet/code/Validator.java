package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

public class Validator {
    /**
     *
     * @return instance of StringSchema
     */
    public StringSchema string() {
        return new StringSchema();
    }
    /**
     *
     * @return instance of NumberSchema
     */
    public NumberSchema number() {
        return new NumberSchema();
    }
}
