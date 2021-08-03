import java.util.HashMap;

public class Rule
{
    private Rules.ValidationRule type;
    private HashMap<Rules.Condition,Integer> conditions;

    public Rules.ValidationRule getType() {
        return type;
    }

    public void setType(Rules.ValidationRule type) {
        this.type = type;
    }

    public HashMap<Rules.Condition, Integer> getConditions() {
        return conditions;
    }

    public void setConditions(HashMap<Rules.Condition, Integer> conditions) {
        this.conditions = conditions;
    }
}
