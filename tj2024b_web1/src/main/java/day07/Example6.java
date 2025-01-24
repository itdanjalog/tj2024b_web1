package day07;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;

import day05.BoardDao;
import day05.BoardDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day07/example6")
public class Example6 extends HttpServlet {
        
    private Set<Integer> set = new HashSet<>();
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("/day07/example6 POST OK ");
        ObjectMapper mapper = new ObjectMapper();
        set = mapper.readValue( req.getReader(), HashSet.class );
        resp.setContentType("application/json");
        resp.getWriter().print( true );
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("/day07/example6 GET OK ");

        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writeValueAsString( set ); // List Map 를 JSON 문자열 변환 
        resp.setContentType("application/json");
        resp.getWriter().print( jsonResult );
    }
    
} // c end



















