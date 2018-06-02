package lab5;

import javafx.util.Pair;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class RegistrationFormsC extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Pair<String,String>> params = new ArrayList<>();
        ArrayList<Pair<String,String>> headers = new ArrayList<>();
        params.add(new Pair<>(
                "body",
                request.getReader().lines().collect(Collectors.joining(System.lineSeparator()))
        ));
        Collections.list(request.getHeaderNames()).forEach(s -> headers.add(new Pair<>(s,request.getHeader(s))));

        request.setAttribute("params", params);
        request.setAttribute("headers", headers);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
