package br.com.fiap.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//Recupera o valor do campo do formul�rio --> m�todo getParameter("nomeDoMetodo")
		String nome = req.getParameter("nome");
		
		//Imprimir o nome recuperado do campo do formul�rio
		System.out.println(nome);
	}

}
