package command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Noticia;
import service.NoticiaService;

public class AddNoticia implements Command{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Instanciando um PrintWriter para sa�da de dados;
				PrintWriter saida = response.getWriter();
				
		// Instanciando a classe Noticia;
				Noticia news = new Noticia();
				
		// Recebendo valores dos parametros do html;
				String titulo = request.getParameter("titulo");
				String desc = request.getParameter("desc");
				String noticia = request.getParameter("not");
				
				// Atribuindo os valores recebidos dos par�metros � classe Noticia;
				news.setTitulo(titulo);
				news.setDescricao(desc);
				news.setTextoNoticia(noticia);
				
				// Instanciando a classe service de Noticia;
				NoticiaService serv = new NoticiaService();
				
				// Enviando os atributos para o banco de dados;
				serv.cadastrarNoticia(news);
				
				saida.print("Notícia adicionada com sucesso!" + "<br>" 
						+ "<button   onclick=\"window.location.href = 'menu.html'\">Voltar</button>");
	}
}
