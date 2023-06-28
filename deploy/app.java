//写一个hello world
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class app {

    public static boolean IsValidDate(String str) {
        Date date;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = dateFormat.parse(str);

        } catch (ParseException e) {

            date = null;
        }
        System.out.println(str);
        System.out.println(date);

        return date!=null?true:false;
    }
    public static void main(String[] args) {

        boolean a=IsValidDate("Mon Jun 05 00:00:00 CST 2023");
        System.out.println(a);
    }
}