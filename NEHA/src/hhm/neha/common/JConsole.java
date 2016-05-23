/**
 *
 */
package hhm.neha.common;

import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.SwingUtilities;
import javax.swing.text.JTextComponent;

/**

 * @comment 重定向java控制台输出 到swing组件中
 */
public class JConsole extends PrintStream {
	private JTextComponent text;
	private StringBuffer buffer = new StringBuffer();
	private Integer maxMsg = 2000;
	private Integer point = 0;

	/**
	 * @return the maxMsg
	 */
	public Integer getMaxMsg() {
		return maxMsg;
	}

	/**
	 * @param maxMsg the maxMsg to set
	 */
	public void setMaxMsg(Integer maxMsg) {
		this.maxMsg = maxMsg;
	}

	public JConsole(OutputStream out, JTextComponent text) {
		super(out);
		this.text = text;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.PrintStream#write(byte[], int, int)
	 */
	public void write(byte[] buf, int off, int len) {
		final String message = new String(buf, off, len);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				buffer.append(message);
				text.setText(buffer.toString());
				if(point > maxMsg){
					buffer = new StringBuffer();
					text.setText("");
					point = 0;
				}else{
					point++;
				}
			}
		});
	}
	/**
	 * 清理console信息
	 */
	public void clear(){
		if(buffer.length() > 0)
			buffer.delete(0, buffer.length());
	}

}
