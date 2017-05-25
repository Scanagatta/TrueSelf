package TrueSelf.modelo;

import java.util.ArrayList;
import java.util.List;

import TrueSelf.dao.ManipuladorArquivo;

public class SimuladorDB {
	
	private static ManipuladorArquivo manipuladorArquivo;
	private static List<Usuario> usuarios;
	
	static{
		usuarios = new ArrayList<>();
		manipuladorArquivo = new ManipuladorArquivo();
		usuarios.addAll(manipuladorArquivo.recuperar("usuarios.ser"));
	}
	
	public static void atualizarUsuarios(){
		manipuladorArquivo.gravarArquivo(usuarios,"usuarios.ser");
	}
	
	
	public static void insert(Usuario usuario){
		usuarios.add(usuario);
		atualizarUsuarios();
	}
	

	
	public static List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	
	public static Usuario getLogin(String login) {
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
}
