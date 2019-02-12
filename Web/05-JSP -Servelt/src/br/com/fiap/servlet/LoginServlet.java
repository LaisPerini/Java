package br.com.fiap.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logar")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Recuperar informa��es da p�gina JSP
		String usuario = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		
		//Validar os campos
		if(usuario.equals("fiap") && senha.equals("1234")){
			
			req.setAttribute("olalogin",usuario );
			//req.setAttribute("olasenha", senha);
			
			//Redireciona para a p�gina home.jsp
			req.getRequestDispatcher("home.jsp").forward(req, resp);
			
		}else{
			//Passar informa��es para a p�gina
			req.setAttribute("qualquer", "Usu�rio e/ou Senha inv�lido");
			//voc� passa dois parametros, um 1� � a chave, que vc utiliza
			//para recuperar o que esta dentro da mensagem, que seria o 2� par�metro
			
			//Redirecionar o usu�rio para a p�gina de login
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			//No m�todo format, sempre ser� request e response, o que muda � o
			//endere�o da p�gina
		}
		
	
	}

}
