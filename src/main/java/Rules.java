import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Rules
{
    enum ValidationRule {
        UPPERCASE_CHARACTER,
        LOWERCASE_CHARACTER,
        SPECIAL_CHARACTER,
        NUMBER,
        LENGTH
    }

    enum Condition {
        AT_LEAST,
        AT_MOST
    }

    public static boolean validate(String str, List<Rule> rules)
    {
        AtomicBoolean validated = new AtomicBoolean(false);
        rules.forEach(rule -> validated.set(validated.get() && validateRule(str, rule)) );
        return validated.get();
    }

    private static boolean validateRule(String str, Rule rule)
    {
        long value;
        AtomicBoolean validation = new AtomicBoolean(false);
        value = switch (rule.getType()) {
            case UPPERCASE_CHARACTER -> str.chars().filter(Character::isUpperCase).count();
            case LOWERCASE_CHARACTER -> str.chars().filter(Character::isLowerCase).count();
            case SPECIAL_CHARACTER -> str.chars().filter(c -> !Character.isLetterOrDigit(c)).count();
            case NUMBER -> str.chars().filter(Character::isDigit).count();
            case LENGTH -> str.length();
        };
        if(value > 0)
        {
            rule.getConditions().forEach((s, expected) -> validation.set(validation.get() && validateCondition(s, expected, value)) );
        }
        return validation.get();
    }

    private static boolean validateCondition(Condition condition, long expected, long actual)
    {
        return switch (condition) {
            case AT_LEAST -> expected <= actual;
            case AT_MOST -> expected >= actual;
        };
    }
}
