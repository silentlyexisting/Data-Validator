package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {
    public final NumberSchema required() {
        super.addPredicate(x -> x instanceof Integer);
        return this;
    }

    public final NumberSchema positive() {
        super.addPredicate(x -> x == null || x instanceof Integer && (Integer) x > 0);
        return this;
    }

    public final NumberSchema range(int minRange, int maxRange) {
        super.addPredicate(x -> x instanceof Integer && (Integer) x >= minRange
                && (Integer) x <= maxRange);
        return this;
    }
}
