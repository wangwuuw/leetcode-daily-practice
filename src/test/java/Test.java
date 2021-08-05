

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @Author: wangwu
 * @Date: Created in 17:04 2020-07-14
 * @Description:
 */
public class Test {

	public static void main(String[] args) {
		HashMap<Object, Object> hashmap = new HashMap<>();
		hashmap.put(null,1);
		hashmap.put(null,2);
		Object o = hashmap.get(null);
		System.out.println(o);
		ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
		map.put("abc","123");
		map.containsKey("abc");
		String s = map.get("abc");
		map.remove("abc");
		System.out.println(800%1200);

	}
}
