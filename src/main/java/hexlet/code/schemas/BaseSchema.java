package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {
    private static List<Predicate<Object>> list = new ArrayList<>();
    /**
     * @param predicate
     */
    public void add(Predicate<Object> predicate) {
        list.add(predicate);
    }
    /**
     * @param o
     * @return instance of Boolean
     */
    public Boolean isValid(Object o) {
        for (Predicate<Object> s : list) {
            if (!s.test(o)) {
                return false;
            }
        }
        return true;
    }
}
