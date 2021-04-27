package com.leetcode.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author: wangwu
 * @Date: Created in 15:23 2021/04/12
 * @Description:
 */
@RestController
public class TestController {
	@GetMapping("/getTest")
	public Object getTest(){
		HashMap<String, String> map = new HashMap<>();
		map.put("status","success");
		map.put("code","200");
		return map;
	}
}
