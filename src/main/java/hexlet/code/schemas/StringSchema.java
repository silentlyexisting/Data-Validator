package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {
    /**
     * @param num
     * @return minLength
     */
    public StringSchema minLength(int num) {
        Predicate<Object> stringPredicate = x -> x == null || x instanceof String && ((String) x).length() >= num;
        add(stringPredicate);
        return this;
    }
    /**
     * @param str
     * @return contains
     */
    public StringSchema contains(String str) {
        Predicate<Object> stringPredicate = x -> x == null || x instanceof String && ((String) x).contains(str);
        add(stringPredicate);
        return this;
    }
    /**
     *
     * @return required
     */
    public StringSchema required() {

        Predicate<Object> stringPredicate = x -> x instanceof String && !((String) x).isEmpty();
        add(stringPredicate);
        return this;
    }
}
