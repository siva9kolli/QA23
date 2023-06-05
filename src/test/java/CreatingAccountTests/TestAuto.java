package CreatingAccountTests;

import org.testng.annotations.Test;

import java.text.MessageFormat;
import java.util.Formatter;


public class TestAuto {

    @Test
    public void testA(){
    Formatter formatter = new Formatter();

    formatter.format("%s package of %d", "Joe", 400);
        System.out.println(formatter.out());
        formatter.close();

    }
}
