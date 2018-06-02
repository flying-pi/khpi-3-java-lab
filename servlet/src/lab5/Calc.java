package lab5;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Calc extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        int a = Integer.parseInt(request.getParameter("a"));
        int b = Integer.parseInt(request.getParameter("b"));
        String operation = request.getParameter("operation");
        String result = "";
        switch (operation){
            case "plus":{
                result = String.valueOf(a+b);
                break;
            }
            case "minus":{
                result = String.valueOf(a-b);
                break;
            }
            case "mull":{
                result = String.valueOf(a*b);
                break;
            }
            case "div":{
                result = String.valueOf(a/b);
                break;
            }

        }
        request.setAttribute("result", result);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException { request.setAttribute("name", "flying pi");
        request.getRequestDispatcher("calc.jsp").forward(request, response);
    }
}
