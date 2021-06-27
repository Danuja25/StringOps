import org.apache.commons.lang.StringUtils;

import java.util.Arrays;

public class StringOps {

    public static String changeCase(String str, String newCase)
    {
        switch (newCase)
        {
            case Constants.CAMEL_CASE:
                return toCamelCase(str);
        }
        return str;
    }

    private static String toCamelCase(String str) {
        StringBuilder caseWord = new StringBuilder();
        String[] words = str.split("[\\W]|_");
        Arrays.stream(words).forEach(s -> caseWord.append(StringUtils.capitalize(s)));
        return caseWord.toString();
    }
}
