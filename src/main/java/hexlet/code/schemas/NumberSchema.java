package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        Predicate<Object> integerPredicate = x -> x instanceof Integer;
        add(integerPredicate);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Object> integerPredicate = x -> x == null || x instanceof Integer && (Integer) x > 0;
        add(integerPredicate);
        return this;
    }

    public NumberSchema range(int minRange, int maxRange) {
        Predicate<Object> integerPredicate = x -> x == null || x instanceof Integer && (Integer) x >= minRange
                && (Integer) x <= maxRange;
        add(integerPredicate);
        return this;
    }
}
