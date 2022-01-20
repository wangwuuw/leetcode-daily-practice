/**
 * @Author: wangwu
 * @Date: Created in 17:04 2020-07-14
 * @Description:
 */
public class Test {

	public static void main(String[] args) {
		String join = String.join("-", String.valueOf(123), null, String.valueOf(11), null);
		System.out.println(join);

	}

}
