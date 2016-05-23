/**
 *
 */
package hhm.neha.framework.struts2;

import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.dispatcher.StreamResult;

import com.opensymphony.xwork2.ActionInvocation;


public class StreamXResult extends StreamResult {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8124892320205026487L;
	private static final Log log = LogFactory.getLog(StreamXResult.class);
	
	protected void doExecute(String finalLocation, ActionInvocation invocation) throws Exception {
		resolveParamsFromStack(invocation.getStack(), invocation);

		OutputStream oOutput = null;
		try {
			if (this.inputStream == null) {
				this.inputStream = (InputStream) invocation.getStack().findValue(conditionalParse(this.inputName, invocation));
			}

			if (this.inputStream == null) {
				String msg = "StreamResultX : Can not find a java.io.InputStream with the name [" + this.inputName + "] in the invocation stack. " + "Check the <param name=\"inputName\"> tag specified for this action.";
				log.error(msg);
				throw new IllegalArgumentException(msg);
			}

			HttpServletResponse oResponse = (HttpServletResponse) invocation.getInvocationContext().get("com.opensymphony.xwork2.dispatcher.HttpServletResponse");

			if ((this.contentCharSet != null) && (!this.contentCharSet.equals("")))
				oResponse.setContentType(conditionalParse(this.contentType, invocation) + ";charset=" + this.contentCharSet);
			else {
				oResponse.setContentType(conditionalParse(this.contentType, invocation));
			}

			if (this.contentLength != null) {
				String _contentLength = conditionalParse(this.contentLength, invocation);
				int _contentLengthAsInt = -1;
				try {
					_contentLengthAsInt = Integer.parseInt(_contentLength);
					if (_contentLengthAsInt >= 0)
						oResponse.setContentLength(_contentLengthAsInt);
				} catch (NumberFormatException e) {
					log.warn("StreamResultX warn : failed to recongnize " + _contentLength + " as a number, contentLength header will not be set");
				}

			}

			if (this.contentDisposition != null) {
				oResponse.addHeader("Content-Disposition", conditionalParse(this.contentDisposition, invocation));
			}

			if (!this.allowCaching) {
				oResponse.addHeader("Pragma", "no-cache");
				oResponse.addHeader("Cache-Control", "no-cache");
			}

			oOutput = oResponse.getOutputStream();

			if (log.isDebugEnabled()) {
				log.debug("StreamXResult : Streaming result [" + this.inputName + "] type=[" + this.contentType + "] length=[" + this.contentLength + "] content-disposition=[" + this.contentDisposition + "] charset=[" + this.contentCharSet + "]");
			}

			byte[] oBuff = new byte[this.bufferSize];
			try {
				log.debug("StreamXResult : Streaming to output buffer +++ START +++");
				int iSize;
				while (-1 != (iSize = this.inputStream.read(oBuff))) {
					oOutput.write(oBuff, 0, iSize);
				}
				log.debug("StreamXResult : Streaming to output buffer +++ END +++");

				oOutput.flush();
			} catch (Exception e) {
				log.warn("StreamXResult Warn : socket write error");
				if (oOutput != null)
					try {
						oOutput.close();
					} catch (Exception e1) {
						oOutput = null;
					}
			} finally {
				if (this.inputStream != null)
					this.inputStream.close();
				if (oOutput != null)
					oOutput.close();
			}
		} finally {
			if (this.inputStream != null)
				this.inputStream.close();
			if (oOutput != null)
				oOutput.close();
		}
	}
}
