package app;

import java.util.List;

import dao.DAO;
import dao.UsuarioDAO;
import model.Usuario;

public class Aplicacao {
	
	public static void main(String[] args) throws Exception {
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		System.out.println("\n\n==== Inserir usu�rio === ");
		Usuario usuario = new Usuario(11, "pablo", "pablo",'M');
		if(usuarioDAO.insert(usuario) == true) {
			System.out.println("Inser��o com sucesso -> " + usuario.toString());
		}
		
		System.out.println("\n\n==== Testando autentica��o ===");
		System.out.println("Usu�rio (" + usuario.getLogin() + "): " + usuarioDAO.autenticar("pablo", "pablo"));
			
		System.out.println("\n\n==== Mostrar usu�rios do sexo masculino === ");
		List<Usuario> usuarios = usuarioDAO.getSexoMasculino();
		for (Usuario u: usuarios) {
			System.out.println(u.toString());
		}

		System.out.println("\n\n==== Atualizar senha (c�digo (" + usuario.getCodigo() + ") === ");
		usuario.setSenha(DAO.toMD5("pablo"));
		usuarioDAO.update(usuario);
		
		System.out.println("\n\n==== Testando autentica��o ===");
		System.out.println("Usu�rio (" + usuario.getLogin() + "): " + usuarioDAO.autenticar("pablo", DAO.toMD5("pablo")));		
		
		System.out.println("\n\n==== Invadir usando SQL Injection ===");
		System.out.println("Usu�rio (" + usuario.getLogin() + "): " + usuarioDAO.autenticar("pablo", "x' OR 'x' LIKE 'x"));

		System.out.println("\n\n==== Mostrar usu�rios ordenados por c�digo === ");
		usuarios = usuarioDAO.getOrderByCodigo();
		for (Usuario u: usuarios) {
			System.out.println(u.toString());
		}
		
		System.out.println("\n\n==== Excluir usu�rio (c�digo " + usuario.getCodigo() + ") === ");
		usuarioDAO.delete(usuario.getCodigo());
		
		System.out.println("\n\n==== Mostrar usu�rios ordenados por login === ");
		usuarios = usuarioDAO.getOrderByLogin();
		for (Usuario u: usuarios) {
			System.out.println(u.toString());
		}
	}
}