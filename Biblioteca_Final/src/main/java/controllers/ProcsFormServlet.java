package controllers;
import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import app.Leitor;

@WebServlet("/processa")
public class ProcsFormServlet extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String nome = req.getParameter("field_nome");
		String sobrenome = req.getParameter("field_sobrenome");
		//String dataStr = req.getParameter("field_data");
			
				
		try {
		
			Leitor leitor = new Leitor();
			
			leitor.setNome(nome);
			leitor.setSobrenme(sobrenome);
			//pessoa.setDataNasc(dataStr);
		
		} catch (Exception e) {
			
			req.setAttribute("erro", e.getMessage());
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("cadastro.jsp");
			dispatcher.forward(req, resp);
						
		}
		
	}

}
