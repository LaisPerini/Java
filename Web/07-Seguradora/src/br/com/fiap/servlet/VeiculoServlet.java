package br.com.fiap.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bean.Veiculo;
import br.com.fiap.bo.VeiculoBO;

@WebServlet("/veiculo")

public class VeiculoServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// RECUPERAR INFORMA��ES DO FORMUL�RIO HTML

		String model = req.getParameter("modelo");

		double preco = Double.parseDouble(req.getParameter("valor"));

		int ano = Integer.parseInt(req.getParameter("ano"));

		String monta = req.getParameter("montadora");

		// Cadastrar o ve�culo no Banco de Dados
		Veiculo veiculo = new Veiculo(0, model, preco, monta, ano);
		VeiculoBO bo = new VeiculoBO();
		bo.cadastrar(veiculo);

		// RETORNA PARA A P�GINA DE CADASTRO COM UMA MENSAGEM DE SUCESSO

		// MENSAGEM QUE SER� EXIBIDA COM SUCESSO
		req.setAttribute("mensagem", "Cadastrado com Sucesso");

		// REDIRECIONAR PARA A P�GINA DE CADASTRO
		
		req.getRequestDispatcher("veiculo.jsp").forward(req, resp);
		

	}

	
	
	// M�TODO GET PARA ENVIAR A RESPOSTA QUANDO A SERVLET FOR ACIONADA NA EXECU��O DA P�GINA
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// LISTA DE VE�CULOS
		
		//BUSCAR OS VE�CULOS CADASTRADOS NO BANCO DE DADOS	
		
		VeiculoBO bo = new VeiculoBO();
		
		List<Veiculo> lista = bo.listar();
		
		// PASSAR A LISTA PARA A JSP
		req.setAttribute("modeloChave", lista);
		// REDIRECIONAR PARA A P�GINA JSP
		req.getRequestDispatcher("lista-veiculo.jsp").forward(req, resp);
		
		
	}
}
