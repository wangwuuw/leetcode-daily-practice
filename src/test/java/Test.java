import entity.KycLevel;
import entity.Student;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: wangwu
 * @Date: Created in 17:04 2020-07-14
 * @Description:
 */
public class Test {
	public static void main(String[] args) {
//		String bankAccount = "234";
//		if (StringUtils.isNotEmpty(bankAccount)&&bankAccount.length()>3) {
//			int length = bankAccount.length();
//			bankAccount = "**** **** "+bankAccount.substring(length - 4, length);
//		}
//		System.out.println(bankAccount);

//		for (int i = 0; i < 100; i++) {
//			new Thread(){
//				@Override
//				public void run() {
//					super.run();
//					callWhile();
//				}
//			}.start();
//		}
//		BigDecimal fee = new BigDecimal(0.0001);
//		fee = fee.setScale(2, RoundingMode.UP);
//		System.out.println(fee);
//		String s = "ID_CARD";
//		IdentificationType identificationType = IdentificationType.valueOf(s);
//		System.out.println(identificationType);
//		BigDecimal bigDecimal = new BigDecimal(1.0000);
//		BigDecimal bigDecimal1 = bigDecimal.setScale(8, RoundingMode.UP);
//		System.out.println(bigDecimal1);
//		callWhile();
//		String substring = "2020-01-01dsfasd".substring(0, 10);
//		System.out.println(true||false);
//		HashMap<String, Integer> map = new HashMap<>();
//		Integer value = map.put(null, 1);
//		System.out.println(value);
//		Integer value2 = map.put(null, 1);
//		System.out.println(value2);
//		String s = null;
//		if (s != null) {
//			KycLevel kycLevel = KycLevel.valueOf(s);
//		}else{
//
//		}
//		while (true){
//			String str = randIP();
//			System.out.println("ip:"+str);
//			String pattern = "^([1-9]|[1-9]\\d|1\\d\\d|2[0-4]\\d|2[0-5][0-5])(\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])){3}$";// ip的正则表达式
//			Pattern r = Pattern.compile(pattern);
//			Matcher m = r.matcher(str);
//			System.out.println("------------"+m.matches());
//			if (!m.matches()) {
//				break;
//			}
//		}
//		List<String> array = new ArrayList();
//		array.add("4");
//		array.add("3");
//		array.add("1");
//		array.add("8");
//		array.add("2");
//		array.add("7");
//		array = new ArrayList<>();
//		for (String str: array) {
//			System.out.println(str);
//
//		}
//		System.out.println("end");
//		callWhile();
//		System.out.println("ABCD".substring(0,3));
//		boolean a = false;
//		boolean b = true;
//		boolean c = false;
//		boolean d = a?true:b?true:c?true:false;
//		System.out.println("d:"+d);
		if (true && 1 == 1) {
			System.out.println("hello");
		}
	}

	static void callWhile(){
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1,"OPERATIONS_OFFICER");
		map.put(2,"OPERATIONS_MANAGER");
		System.out.println("group_name:"+map.get(1));


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
