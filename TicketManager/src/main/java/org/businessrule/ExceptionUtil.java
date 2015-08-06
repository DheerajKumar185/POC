package org.businessrule;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtil {

	public String getStackTrace(Exception e) {
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		e.printStackTrace(printWriter);
		return stringWriter.toString();
	}
}
