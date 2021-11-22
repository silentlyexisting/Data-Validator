package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {
    /**
     * @param num
     * @return minLength
     */
    public StringSchema minLength(int num) {
        Predicate<String> stringPredicate = x -> x instanceof String && x.length() >= num;
        this.add(stringPredicate);
        return this;
    }
    /**
     * @param str
     * @return contains
     */
    public StringSchema contains(String str) {
        Predicate<String> stringPredicate = x -> x instanceof String && x.contains(str);
        this.add(stringPredicate);
        return this;
    }
    /**
     *
     * @return required
     */
    public StringSchema required() {
        String empty = "";
        Predicate<String> stringPredicate = x -> x instanceof String && x.equals(empty);
        this.add(stringPredicate);
        return this;
    }
}
