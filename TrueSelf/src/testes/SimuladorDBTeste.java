package testes;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import TrueSelf.dao.ManipuladorArquivo;
import TrueSelf.modelo.SimuladorDB;
import TrueSelf.modelo.Usuario;


public class SimuladorDBTeste {
	
	@Test
	public void adicionaUsuarioNaLista(){
		Usuario usuario = new Usuario();
		SimuladorDB.insert(usuario);
		usuario.setLogin("bolsonaro");
		Assert.assertEquals(usuario, SimuladorDB.getLogin("bolsonaro"));
	}
	
	@Test
	public void procuraUsuarioQueNaoExiste(){
		Assert.assertNull(SimuladorDB.getLogin("naoExiste"));
	}
	
	@Test
	public void colocaNovaLista(){
	  List<Usuario> usuarios = new ArrayList<>();
	  SimuladorDB.setUsuarios(usuarios);
	  Assert.assertEquals(usuarios, SimuladorDB.getUsuarios());
	}
	
	@Test
	public void colocaManipuladorDeArquivo(){
		ManipuladorArquivo manipuladorArquivo = new ManipuladorArquivo();
		SimuladorDB.setManipuladorArquivo(manipuladorArquivo);
		Assert.assertEquals(manipuladorArquivo, SimuladorDB.getManipuladorArquivo());
	}
}
