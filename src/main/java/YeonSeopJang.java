import java.text.SimpleDateFormat;
import java.util.Calendar;

public class YeonSeopJang {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(formatter.format(calendar.getTime()).toString());
	}

}
