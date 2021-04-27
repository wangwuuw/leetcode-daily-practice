package com.leetcode.stream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

/**
 * @Author: wangwu
 * @Date: Created in 16:46 2021/04/27
 * @Description:
 */
public class StreamTest {
	public static void main(String[] args) {
		try {
// 创建原始的数据源:
			InputStream fis = new FileInputStream("test.gz");
// 增加缓冲功能:
			InputStream bis = new BufferedInputStream(fis);
// 增加解压缩功能:
			InputStream gis = new GZIPInputStream(bis);
		}catch (Exception e){

		}
	}
}
