package com.mapsa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by MRK on 3/1/2020.
 */
public class HelloServlet extends HttpServlet {

    private static final long serialVersionUID = -4751096228274971485L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        {

            // set response headers
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");

            // create HTML form
            PrintWriter writer = response.getWriter();
            writer.append("<!DOCTYPE html>\r\n")
                    .append("<html>\r\n")
                    .append("		<head>\r\n")
                    .append("			<title>Form input</title>\r\n")
                    .append("		</head>\r\n")
                    .append("		<body>\r\n")
                    .append("			<form action=\"hello\" method=\"POST\">\r\n")
                    .append("				Enter your name: \r\n")
                    .append("				<input type=\"text\" name=\"user\" />\r\n")
                    .append("				<input type=\"submit\" value=\"Submit\" />\r\n")
                    .append("			</form>\r\n")
                    .append("		</body>\r\n")
                    .append("</html>\r\n");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // create HTML response
        PrintWriter writer = response.getWriter();
        writer.append("<!DOCTYPE html>\r\n")
                .append("<html>\r\n")
                .append("		<head>\r\n")
                .append("			<title>Welcome message</title>\r\n")
                .append("		</head>\r\n")
                .append("		<body>\r\n");
        if (user != null && !user.trim().isEmpty()) {
            writer.append("	Welcome " + user + ".\r\n");
            writer.append("	You successfully completed the process! \r\n");
        } else {
            writer.append("	You did not entered a name!\r\n");
        }
        writer.append("		</body>\r\n")
                .append("</html>\r\n");
    }


    @Override
    public void init() throws ServletException {
        System.out.println("Servlet " + this.getServletName() + " has started");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getServletName() + " has stopped");

    }
}
