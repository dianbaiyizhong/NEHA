package hhm.neha.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileUtil {

	private static final Log LOG = LogFactory.getLog(FileUtil.class);

	/**
	 * @param path
	 *            文件的路径
	 * @param obj
	 *            如果不能正确读到文件对象，则返回该值
	 * @return 文件中的对象或者是传入的默认值
	 */
	public static Object getObjectFromFile(String path, Object obj) {
		File idFile = new File(path);
		if (!idFile.exists())
			return obj;
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(
					idFile.getAbsoluteFile()));
			return ois.readObject();
		} catch (FileNotFoundException e) {
			LOG.error(path + " 文件找不到!" + e.getMessage());
			if (LOG.isInfoEnabled())
				e.printStackTrace();
		} catch (IOException e) {
			LOG.error("读取 " + path + " 文件出错" + e.getMessage());
			if (LOG.isInfoEnabled())
				e.printStackTrace();
		} catch (ClassNotFoundException e) {
			LOG.error("找不到class文件！" + e.getMessage());
			if (LOG.isInfoEnabled())
				e.printStackTrace();
		} finally {
			try {
				if (ois != null)
					ois.close();
			} catch (IOException e) {
				LOG.error("关闭 " + path + " 文件出错" + e.getMessage());
				if (LOG.isInfoEnabled())
					e.printStackTrace();
			}
		}
		return obj;
	}

	/**
	 * @param path
	 *            文件的路径
	 * @param value
	 *            需要保存在文件中的对象
	 */
	public static void setObjectToFile(String path, Object value) {
		File idFile = new File(path);
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(
					idFile.getCanonicalFile()));
			oos.writeObject(value);
		} catch (FileNotFoundException e) {
			LOG.error(path + " 文件找不到!" + e.getMessage());
			if (LOG.isInfoEnabled())
				e.printStackTrace();
		} catch (IOException e) {
			LOG.error("读取 " + path + " 文件出错" + e.getMessage());
			if (LOG.isInfoEnabled())
				e.printStackTrace();
		} finally {
			try {
				if (oos != null)
					oos.close();
			} catch (IOException e) {
				LOG.error("关闭 " + path + " 文件出错" + e.getMessage());
				if (LOG.isErrorEnabled())
					e.printStackTrace();
			}
		}
	}

	/**
	 * 删除文件或目录，如果该目录下存在子目录或子文件，则一起删除
	 * 
	 * @param path
	 *            文件或目录位置
	 */
	public static void delDir(String path) {
		try {
			File delFile = new File(path);
			delDir(delFile);
		} catch (Exception e) {

		}

	}

	/**
	 * 删除文件或目录，如果该目录下存在子目录或子文件，则一起删除
	 * 
	 * @param file
	 */
	public static void delDir(File file) {
		if (file.exists()) {
			File[] files = file.listFiles();
			if (files == null || files.length == 0) {
				return;
			}
			for (File f : files) {
				if (f.isDirectory()) {
					delDir(f);
				} else {
					f.delete();
				}
			}
			file.delete();
		}
	}

	/**
	 * 将Map中的内容写入文件
	 * 
	 * @param writePath
	 *            文件路径
	 * @param values
	 *            map内容
	 * @param charsetName
	 *            编码格式名字，默认为UTF-8
	 * @param sz
	 *            输出缓冲区的大小，默认为1024
	 */
	public static void writeFileByMap(String writePath,
			Map<String, String> values, String charsetName, Integer sz) {
		BufferedWriter bw = null;
		try {
			if (charsetName == null || charsetName.trim().equals("")) {
				charsetName = "UTF-8";
			}
			if (sz == null || sz <= 0) {
				sz = 1024;
			}
			bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(writePath, true), charsetName), sz);
			for (Iterator<Map.Entry<String, String>> it = values.entrySet()
					.iterator(); it.hasNext();) {
				Map.Entry<String, String> urlMap = it.next();
				bw.write(urlMap.getKey() + "<=>" + urlMap.getValue());
				bw.newLine();
			}
		} catch (IOException ioe) {
			LOG.error("写文件出现错误!" + writePath + ioe.getMessage());
			if (LOG.isErrorEnabled())
				ioe.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				LOG.error("关闭文件异常!" + e.getMessage());
				if (LOG.isErrorEnabled())
					e.printStackTrace();
			}
		}
	}

	/**
	 * 将集合中的内容写入文件
	 * 
	 * @param file
	 *            文件路径
	 * @param col
	 *            内容
	 * @param charsetName
	 *            编码格式名字，默认为UTF-8
	 * @param sz
	 *            输出缓冲区的大小，默认为1024
	 * @param append
	 *            如果为 true，则将字节写入文件末尾处(追加)，而不是写入文件开始处 （重写）
	 */
	public static void writeFileByCol(File file, Collection<Object> col,
			String charsetName, Integer sz, boolean append) {
		BufferedWriter bw = null;
		if (charsetName == null || charsetName.trim().equals("")) {
			charsetName = "UTF-8";
		}
		if (sz == null || sz <= 0) {
			sz = 1024;
		}
		try {
			bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file, append), charsetName), sz);
			for (Iterator<Object> it = col.iterator(); it.hasNext();) {
				Object obj = it.next();
				bw.write(obj.toString());
				bw.newLine();
			}
		} catch (IOException ioe) {
			LOG.error("写文件出现错误!" + file + ioe.getMessage());
			if (LOG.isErrorEnabled())
				ioe.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				LOG.error("关闭文件异常!" + e.getMessage());
				if (LOG.isErrorEnabled())
					e.printStackTrace();
			}
		}
	}

	/**
	 * @param readPath
	 * @param result
	 */
	public static void readFileForMap(String readPath,
			Map<String, String> result) {
		String line = "";
		BufferedReader br = null;
		File readFile = new File(readPath);
		if (!readFile.exists())
			return;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					readFile), "UTF-8"), 1024);
			do {
				line = br.readLine();
				if (line != null) {
					line = line.trim();
					String kv[] = line.split("<=>");
					if (kv.length == 2)
						result.put(kv[0], kv[1]);
				}
			} while (line != null);
		} catch (IOException ioe) {
			LOG.error("读文件出现错误!" + ioe.getMessage());
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				readFile.delete();
			} catch (IOException e) {
				LOG.error("关闭文件异常!" + e.getMessage());
			}
		}
	}

	/**
	 * 将文件中的内容按行读取存放到集合中
	 * 
	 * @param readFile
	 *            读取的目标文件
	 * @param result
	 *            存放的目标集合
	 * @param charsetName
	 *            文件编码
	 * @param trim
	 *            是否跳过带空格及空行，true为跳过反之则保留
	 */
	public static void readFileForCol(File readFile, Collection<String> result,
			String charsetName, boolean trim) {
		String line = "";
		BufferedReader br = null;
		// File readFile=new File(readPath);
		if (!readFile.exists())
			return;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					readFile), charsetName), 1024);
			do {
				line = br.readLine();
				if (line != null) {
					line = line.trim();
					if (trim && line.equals("")) {
						continue;
					}
					result.add(line);
				}
			} while (line != null);
		} catch (IOException ioe) {
			LOG.error("Read file(" + readFile.getAbsolutePath() + ") fail: "
					+ ioe.getMessage());
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				LOG.error("关闭文件异常!" + e.getMessage());
			}
		}
	}

	/**
	 * 从文件获得二进制数据数组
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static byte[] getBytesFromFile(File file) throws IOException {
		InputStream is = new FileInputStream(file);
		long length = file.length();

		if (length > Integer.MAX_VALUE) {
		}

		byte[] bytes = new byte[(int) length];

		is.read(bytes, 0, bytes.length);
		is.close();
		return bytes;
	}

	/**
	 * 把二进制数据数组写入文件
	 * 
	 * @param file
	 * @param b
	 * @throws IOException
	 */
	public static void putBytesToFile(File file, byte[] b) throws IOException {
		OutputStream outPut = new FileOutputStream(file);
		outPut.write(b);
		outPut.close();
	}

	/**
	 * 获取指定路径下的文件（不包含目录），指定路径不存在时返回size为0的List
	 * 
	 * @param path
	 *            指定路径
	 * @param listSubPath
	 *            是否包含子目录中的文件，包含（true），不包含（false）
	 * @param extensionFileName
	 *            文件的扩展名，extensionFileName为null则为所有文件，extensionFileName为String(
	 *            "")时则为无扩展名的文件，不区分大小写
	 * @return
	 */
	public static List<File> listFiles(File path, boolean listSubPath,
			String extensionFileName) {
		List<File> list = new ArrayList<File>();
		if (path.isDirectory()) {
			File[] files = path.listFiles();
			if (files.length > 0) {
				for (int i = 0; i < files.length; i++) {
					if (files[i].isDirectory()) {
						if (listSubPath) {
							list.addAll(listFiles(files[i], listSubPath,
									extensionFileName));
						}
					}
					if (files[i].isFile()) {
						if (extensionFileName == null) {
							list.add(files[i]);
						} else {
							String fileName = files[i].getName();
							if (extensionFileName.trim().equals("")) {
								if (fileName.indexOf(".") == -1) {
									list.add(files[i]);
								}
							} else {
								if (fileName.indexOf(".") != -1) {
									String extensName = fileName
											.substring(fileName
													.lastIndexOf(".") + 1);
									if (extensName
											.equalsIgnoreCase(extensionFileName)) {
										list.add(files[i]);
									}
								}
							}
						}
					}
				}
			}
		}
		return list;
	}

	/**
	 * 将字符串写入到文件中(重写文件 )
	 * 
	 * @param str
	 *            需要写入的字符串
	 * @param file
	 *            文件
	 * @param charsetName
	 *            编码类型，如果没有指定则使用UTF-8
	 * @param sz
	 *            缓冲区大小
	 * @throws IOException
	 */
	public static void write(String str, File file, String charsetName,
			Integer sz) throws IOException {
		if (!file.exists()) {
			file.createNewFile();
		}
		if (!file.isFile()) {
			throw new IOException("File(" + file.getAbsolutePath()
					+ ") is not file!");
		} else {
			if (charsetName == null || charsetName.trim().equals("")) {
				charsetName = "UTF-8";
			}
			BufferedWriter bw = null;
			bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file, false), charsetName), sz);
			if (str == null) {
				LOG.error("Write context to file fail: contenxt is null!");
				return;
			}
			bw.write(str);
			bw.flush();
			bw.close();
		}
	}

	/**
	 * @param arg
	 * @throws IOException
	 */
	public static void main(String[] arg) throws IOException {
		// write("123\n"+"321\n"+"yuo\n", new File("c:/222.txt"),null,1024);
		Collection<String> col = new ArrayList<String>();
		readFileForCol(new File("c:/222.txt"), col, "utf-8", false);
		System.out.println(col.size());
	}
}
