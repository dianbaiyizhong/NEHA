package hhm.neha.area.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;

public class FileUtil {
	


	public void writeToTxt(String str, String path) {
		File file = new File(path); // 找到File类的实例

		try {
			// 创建文件
			file.createNewFile();
			// 声明字符输出流
			Writer out = null;
			// 通过子类实例化，表示可以追加
			out = new FileWriter(file, true);
			// 写入数据
			out.write(str);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getFromTxt2(String path) {
		String result = "";
		File file = new File(path);
		InputStream in = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(path);
		try {
			String encoding = "utf-8";

			InputStreamReader read = new InputStreamReader(new FileInputStream(
					file), encoding);// 考虑到编码格式
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = null;
			while ((lineTxt = bufferedReader.readLine()) != null) {
				result = result + lineTxt + "#";
			}
			read.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	public String getFromTxt(String path) {
		String result = "";
		InputStream in = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(path);
		try {
			String encoding = "utf-8";

			InputStreamReader read = new InputStreamReader(in, encoding);// 考虑到编码格式
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = null;
			while ((lineTxt = bufferedReader.readLine()) != null) {
				result = result + lineTxt;
			}
			read.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	
	
}
