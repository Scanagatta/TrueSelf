package testes;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import TrueSelf.modelo.Comentario;
import TrueSelf.modelo.Usuario;

public class UsuarioTeste {
	
	
	@Test
	public void DeveIniciarUsuarioComCountZeroeListaVazia() throws Exception {
		Usuario usuario = new Usuario();
		Assert.assertEquals(new Integer (0), usuario.getQtdAnjo());
		Assert.assertEquals(new Integer (0), usuario.getQtdDemonio());
		Assert.assertEquals(new Integer (0), usuario.getQtdNeutro());
		Assert.assertNotNull(usuario.getComentarios());
	}
	
	
	@Test
	public void DeveRetornarToString(){
		Usuario usuario = new Usuario();
		usuario.setNome("Bolsonaro");
		Assert.assertEquals(new String ("Bolsonaro"), usuario.toString());
	}
	
	@Test
	public void DeveAdicionarComentarioNaLista() throws Exception {
		Usuario usuario = new Usuario();
		Comentario comentario = new Comentario();
		List<Comentario> comentarios = new ArrayList<Comentario>();
		comentarios.add(comentario);
		usuario.adicionarComentario(comentario);
		Assert.assertEquals(comentarios, usuario.getComentarios());
	}
	
}
