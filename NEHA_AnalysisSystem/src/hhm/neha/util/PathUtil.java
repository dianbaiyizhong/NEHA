package hhm.neha.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.struts2.ServletActionContext;

public class PathUtil {

	public static String PathConfig = "/path.properites";

	public String getRemoteAdd() {

		InputStream in = getClass().getResourceAsStream(PathConfig);
		Properties props = new Properties();
		try {
			props.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String path = props.getProperty("remoteServerAdd");
		return path;
	}

	public String getServerPath() {
		return ServletActionContext.getRequest().getRealPath("");

	}

}
