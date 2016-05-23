/**
 * 
 */
package hhm.neha.util;

import java.io.File;

/**
 * 
 * File路径扩展类
 */
public class PathUtil {
	/**
	 * 返回抽象目录名的绝对路径名字符串，如果该路径不存在则创建该目录
	 * 
	 * @param path
	 * @return
	 */
	public static String getAbsolutePath(String path) {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}
		return file.getAbsolutePath();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getAbsolutePath("bin"));
	}
}
