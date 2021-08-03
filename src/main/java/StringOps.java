import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringOps {

    public static String changeCase(String str, String newCase)
    {
        String[] words = str.split("[\\W]|_");
        StringBuilder caseWord = new StringBuilder();
        Arrays.stream(words).forEach(s -> caseWord.append(StringUtils.capitalize(s)));
        switch (newCase)
        {
            case Constants.CAMEL_CASE:
                Arrays.stream(words).forEach(s -> caseWord.append(StringUtils.capitalize(s)));
                caseWord.setCharAt(0,words[0].toLowerCase().charAt(0));
            case Constants.PASCAL_CASE:
                Arrays.stream(words).forEach(s -> caseWord.append(StringUtils.capitalize(s)));
            case Constants.UPPER_CASE:
                Arrays.stream(words).forEach(s -> caseWord.append(StringUtils.upperCase(s)));
            case Constants.LOWER_CASE:
                Arrays.stream(words).forEach(s -> caseWord.append(StringUtils.lowerCase(s)));
            case Constants.KEBAB_CASE:
                Arrays.stream(words).forEach(s -> caseWord.append(StringUtils.lowerCase(s)).append("-"));
                caseWord.deleteCharAt(caseWord.lastIndexOf("-"));
            case Constants.SNAKE_CASE:
                Arrays.stream(words).forEach(s -> caseWord.append(StringUtils.lowerCase(s)).append("_"));
                caseWord.deleteCharAt(caseWord.lastIndexOf("_"));
            case Constants.DOT_CASE:
                Arrays.stream(words).forEach(s -> caseWord.append(StringUtils.lowerCase(s)).append("."));
                caseWord.deleteCharAt(caseWord.lastIndexOf("."));
            default:
                caseWord.append(Arrays.toString(words));

        }
        return caseWord.toString();
    }

    public static void printObject(Object o)
    {
        Class<?> aClass = o.getClass();
        Field[] fields = aClass.getFields();
        StringBuilder objectValues= new StringBuilder();

        Arrays.stream(fields).forEach(field -> {
            field.setAccessible(true);
            try {
                objectValues.append(field.getName() + " = " + field.get(o));
            } catch (final IllegalAccessException e) {
                objectValues.append(field.getName() + " = " + "Inaccessible");
            }
        });

        System.out.println(objectValues.toString());
    }

    public static boolean checkPattern(String str, String pattern)
    {
        return Pattern.matches(pattern,str);
    }

    public static boolean validatePassword(String password, List<Rule> rules)
    {
        return Rules.validate(password, rules);
    }
}
