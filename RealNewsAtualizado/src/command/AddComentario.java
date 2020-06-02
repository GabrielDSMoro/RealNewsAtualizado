package command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Comentario;
import service.ComentarioService;

public class AddComentario implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter saida = response.getWriter();
		// Instanciando a classe Comentario;
		 Comentario msg = new Comentario();
		
		// Capturando as informações inseridas nos campos;
		int notId = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String texto = request.getParameter("comentario");
		
		
		// Imputando as informa��es na instancia de Comentario:
		msg.setNome(nome);
		msg.setComentario(texto);
		msg.setNoticiaId(notId);
		
		// Instanciando a classe service de comentario;
		ComentarioService serv = new ComentarioService();
		
		// Enviando as informações para o banco de dados;
		serv.cadastrarComentario(msg);
		
		// Redirecionando o usuário para a listagem de notícias:
		saida.println("<form action='Controller.do' method='post'>"
				+ "<p> Comentário adicionado com sucesso!</p>"
				+ "<input type='hidden' name='command' value='ListaNoticia'>"
				+ "<button type='submit'>OK</button>");
		
	}
}
