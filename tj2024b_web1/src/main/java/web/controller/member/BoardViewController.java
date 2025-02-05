package web.controller.member;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web.model.dao.BoardDao;

@WebServlet("/board/view")
public class BoardViewController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int bno = Integer.parseInt( req.getParameter("bno") ) ;
        
		Object result = BoardDao.getInstance().findById( bno );
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString( result );
		
		resp.setContentType("application/json");
		resp.getWriter().print( jsonResult );
		
	}
}
