import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

/**
 * @Author: wangwu
 * @Date: Created in 17:04 2020-07-14
 * @Description:
 */
public class Test {
	public static void main(String[] args) {
		System.out.println(0x0080);


	}

	static void callWhile(){


	}
	//	private static void setValue(Student student){
////		student.setName("name");
////		student.setId(111L);
////	}
	private static void setValue(Enum student){
		student.name();
	}



	public static String randIP() {
		Random random = new Random(System.currentTimeMillis());
		return (random.nextInt(255) + 1) + "." + (random.nextInt(255) + 1) + "." + (random.nextInt(255) + 1) + "."
				+ (random.nextInt(255) + 1);
	}

}
