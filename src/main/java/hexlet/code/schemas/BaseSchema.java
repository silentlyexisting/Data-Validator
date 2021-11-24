package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {
    private List<Predicate<Object>> predicates = new ArrayList<>();
    /**
     * @param predicate
     * adds predicates to list
     */
    public void addPredicate(Predicate<Object> predicate) {
        this.predicates.add(predicate);
    }
    /**
     * @param o
     * @return instance of Boolean
     */
    public Boolean isValid(Object o) {
        for (Predicate<Object> p : predicates) {
            if (!p.test(o)) {
                return false;
            }
        }
        return true;
    }
}
