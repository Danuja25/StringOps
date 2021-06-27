import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TestStringOps {

    @Test
    public void testChangeCase() {
        String testPhrase = "new text-to.check_case";
        String expectedWord = "NewTextToCheckCase";

        String changedWord = StringOps.changeCase(testPhrase, Constants.CAMEL_CASE);
        assertEquals(changedWord,expectedWord);
    }
}