package TrueSelf.modelo;

import java.util.ArrayList;
import java.util.List;

import TrueSelf.dao.ManipuladorArquivo;

public class SimuladorDB {
	
	private static ManipuladorArquivo manipuladorArquivo;
	private static List<Usuario> usuarios;
	private static List<Comentario> comentarios;
	
	static{
		usuarios = new ArrayList<>();
		manipuladorArquivo = new ManipuladorArquivo();
		comentarios = new ArrayList<>();
		//recuperar os dados do arquivo
		usuarios.addAll(manipuladorArquivo.recuperar("usuarios.ser"));
		comentarios.addAll(manipuladorArquivo.recuperar("comentarios.ser"));
	}
	
	public static void atualizarUsuarios(){
		manipuladorArquivo.gravarArquivo(usuarios,"usuarios.ser");
	}
	
	
	public static void insert(Usuario usuario){
		//colocar novo usuario na lista
		usuarios.add(usuario);
		atualizarUsuarios();
	}
		
	public static List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public static void atualizarComentarios(){
		manipuladorArquivo.gravarArquivo(comentarios, "comentarios.ser");
	}
	
	public static void insert(Comentario comentario){
		//colocar novo usuario na lista
		comentarios.add(comentario);
		atualizarComentarios();
	}
	
	public static Usuario getLogin(String login) {
		//metodo para pegar o login do usuario
		for (Usuario usuario : usuarios) {
			if (login.equals(usuario.getLogin())) {
				return usuario;
			}
		}
		return null;
	}

	public static void setUsuarios(List<Usuario> usuarios) {
		SimuladorDB.usuarios = usuarios;
	}

	public static ManipuladorArquivo getManipuladorArquivo() {
		return manipuladorArquivo;
	}

	public static void setManipuladorArquivo(ManipuladorArquivo manipuladorArquivo) {
		SimuladorDB.manipuladorArquivo = manipuladorArquivo;
	}


	
	public static List<Comentario> getComentarios() {
		return comentarios;
	}


	public static void setComentarios(List<Comentario> comentarios) {
		SimuladorDB.comentarios = comentarios;
	}
}
