import org.apache.commons.lang.StringUtils;

import java.util.Arrays;

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
                Arrays.stream(words).forEach(s -> caseWord.append(StringUtils.lowerCase(s) + "-"));
                caseWord.deleteCharAt(caseWord.lastIndexOf("-"));
            case Constants.SNAKE_CASE:
                Arrays.stream(words).forEach(s -> caseWord.append(StringUtils.lowerCase(s) + "_"));
                caseWord.deleteCharAt(caseWord.lastIndexOf("_"));
            case Constants.DOT_CASE:
                Arrays.stream(words).forEach(s -> caseWord.append(StringUtils.lowerCase(s) + "."));
                caseWord.deleteCharAt(caseWord.lastIndexOf("."));
            default:
                caseWord.append(words);

        }
        return caseWord.toString();
    }
}
