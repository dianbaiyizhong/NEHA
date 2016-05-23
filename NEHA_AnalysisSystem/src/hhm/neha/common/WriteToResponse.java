package hhm.neha.common;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class WriteToResponse {
	 public static void response(Object message) {
		 try {
		 HttpServletResponse response =ServletActionContext.getResponse();
		 response.setCharacterEncoding("UTF-8");
		 response.setContentType("text/plain");
		 PrintWriter out = response.getWriter();
		 out.print(message);
		 out.close();
		   } catch (Exception e) {
		 throw new RuntimeException(e);
		 }
		 }
}
