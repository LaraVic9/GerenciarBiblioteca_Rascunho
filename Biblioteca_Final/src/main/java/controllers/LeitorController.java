package controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.Leitor;
import repository.UsuarioRepository;

@SuppressWarnings("unused")
@WebServlet(name = "Leitores", urlPatterns = {"/LeitorController"})
public class LeitorController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/Leitor.jsp";
	private static String LIST_USER = "/listLeitor.jsp";
	private UsuarioRepository user;
	
	public LeitorController() {
		super();
		user = new UsuarioRepository();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String forward="";
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("delete")) {
			int leitorId = Integer.parseInt(request.getParameter("leitorId"));
			user.deleteLeitor(leitorId);
			forward = LIST_USER;
			request.setAttribute("leitor", user.getAllLeitor());
					
		} else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int leitorId = Integer.parseInt(request.getParameter("leitorId"));
            Leitor leitor = user.getLeitorById(leitorId);
            request.setAttribute("leitor", leitor);
        } else if (action.equalsIgnoreCase("listLeitor")){
            forward = LIST_USER;
            request.setAttribute("Leitores", user.getAllLeitor());
        } else {
            forward = INSERT_OR_EDIT;
        }

		
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Leitor leitor = new Leitor();
        leitor.setNome(request.getParameter("nome"));
        leitor.setSobrenme(request.getParameter("sobrenome"));
        
        String leitorid = request.getParameter("leitorid");
        
        if(leitorid == null || leitorid.isEmpty())
        {
            user.insertLeitor(leitor);
        }
        else
        {
            leitor.setId(Integer.parseInt(leitorid));
            user.updateLeitor(leitor);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("leitores", user.getAllLeitor());
        view.forward(request, response);
    }
}