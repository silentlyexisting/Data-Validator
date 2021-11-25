package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {
    public final MapSchema required() {
        super.addPredicate(x -> x instanceof Map);
        return this;
    }

    public final MapSchema sizeof(int requiredSize) {
        super.addPredicate(x -> x instanceof Map && ((Map<?, ?>) x).size() == requiredSize);
        return this;
    }

    public final MapSchema shape(Map<String, BaseSchema> schemas) {
        super.addPredicate(x -> {
            for (Map.Entry<String, Object> entry : ((Map<String, Object>) x).entrySet()) {
                if (!schemas.get(entry.getKey()).isValid(entry.getValue())) {
                    return false;
                }
            }
            return true;
        });
        return this;
    }
}
