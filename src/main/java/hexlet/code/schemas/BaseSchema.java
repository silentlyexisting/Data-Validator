package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {
    private static List<Predicate<String>> list = new ArrayList<>();
    /**
     * @param predicate
     */
    public void add(Predicate<String> predicate) {
        list.add(predicate);
    }
    /**
     * @param o
     * @return instance of Boolean
     */
    public Boolean isValid(String o) {
        for (Predicate<String> s : list) {
            s.test(o);
        }
        return true;
    }
}
