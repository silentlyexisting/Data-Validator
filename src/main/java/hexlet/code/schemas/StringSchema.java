package hexlet.code.schemas;


public class StringSchema extends BaseSchema {
    public final StringSchema required() {
        super.addPredicate(x -> x instanceof String && !((String) x).isEmpty());
        return this;
    }

    public final StringSchema minLength(int minLength) {
        super.addPredicate(x -> x instanceof String && x.toString().length() >= minLength);
        return this;
    }

    public final StringSchema contains(String content) {
        super.addPredicate(x -> x instanceof String && x.toString().contains(content));
        return this;
    }
}
