package com;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public class ErrorResponses {

	private static final String notFoundPage = "<html>"
			+ "<head><title>404 - Not Found</title></head>"
			+ "<body><h1>404 - Not Found</h1>The requested page has not been found.</body>"
			+ "</html>";
	
	public static void sendNotFound(HttpServletResponse response) throws IOException {
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		response.getWriter().write(notFoundPage);
	}
}
