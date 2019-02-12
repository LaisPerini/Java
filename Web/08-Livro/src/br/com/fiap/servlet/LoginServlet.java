package br.com.fiap.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.bean.Usuario;
import br.com.fiap.bo.UsuarioBO;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// RECUPERA AS INFORMA��ES DO JSP
		String user = req.getParameter("usuario");
		String senha = req.getParameter("senha");
		
		// INSTANCIA O BO
		UsuarioBO bo = new UsuarioBO();
		
		// CHAMA O M�TODO LOGAR DA BO
		Usuario usuario = bo.logar(user, senha);
		
		// VALIDAR SE ENCONTROU O USU�RIO
		if(usuario == null){
			req.setAttribute("erro", "Usu�rio e/ou senha inv�lidos !");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}else{
			
			// RECUPERAR A SESS�O DO USU�RIO
			HttpSession session =  req.getSession();
			session.setAttribute("usuario", usuario.getNome());
			req.getRequestDispatcher("home.jsp").forward(req, resp);
					   
			//req.setAttribute("usuario", usuario.getNome());
			//req.getRequestDispatcher("home.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// LINK SEMPRE � GET !!!!!!!!!!!!
		
		// RECUPERAR A SESS�O DO USU�RIO
		HttpSession session = req.getSession();
		
		// INVALIDAR A SESS�O 
		session.invalidate();
		
		// REDIRECIONA PARA LOGIN.JSP
		//req.getRequestDispatcher("login.jsp").forward(req, resp);
		resp.sendRedirect("login.jsp");
	}
	
}
