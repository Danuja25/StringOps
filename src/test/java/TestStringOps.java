import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;


public class TestStringOps {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void testChangeCase() {
        String testPhrase = "new text-to.check_case";
        String camelWord = "newTextToCheckCase";
        String pascalWord = "NewTextToCheckCase";
        String upperWord = "NEWTEXTTOCHECKCASE";
        String lowerWord = "newtexttocheckcase";
        String kebabWord = "new-text-to-check-case";
        String snakeWord = "new_text_to_check_case";
        String dotWord = "new.text.to.check.case";

        String changedCamelWord = StringOps.changeCase(testPhrase, Constants.CAMEL_CASE);
        assertEquals(changedCamelWord,camelWord);

        String changedPascalWord = StringOps.changeCase(testPhrase, Constants.PASCAL_CASE);
        assertEquals(changedPascalWord,pascalWord);

        String changedUpperWord = StringOps.changeCase(testPhrase, Constants.UPPER_CASE);
        assertEquals(changedUpperWord,upperWord);

        String changedLowerWord = StringOps.changeCase(testPhrase, Constants.LOWER_CASE);
        assertEquals(changedLowerWord,lowerWord);

        String changedKebabWord = StringOps.changeCase(testPhrase, Constants.KEBAB_CASE);
        assertEquals(changedKebabWord,kebabWord);

        String changedSnakeWord = StringOps.changeCase(testPhrase, Constants.SNAKE_CASE);
        assertEquals(changedSnakeWord,snakeWord);

        String changedDotWord = StringOps.changeCase(testPhrase, Constants.DOT_CASE);
        assertEquals(changedDotWord,dotWord);
    }

    @Test
    public void testPrintObject()
    {
        record Person(int id,String name,int age,String gender,String profession){}

        Person john = new Person(1,"John Smith",25,"Male","Baker");

        StringOps.printObject(john);

        Assert.assertEquals("Person[id=1, name=John Smith, age=25, gender=Male, profession=Baker]", outputStreamCaptor.toString()
                .trim());
    }
}