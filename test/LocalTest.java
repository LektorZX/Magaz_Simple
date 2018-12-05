import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalTest {
    @Test
    public void testLocal(){

        Locale locale = new Locale("ru", "RU");
        //Locale.setDefault(new Locale("en","US"));
       // System.out.println(Locale.getDefault()); посмотреть локаль
        ResourceBundle bundle = ResourceBundle.getBundle("local");
        System.out.println(bundle.getString("some.text"));


    }

}
