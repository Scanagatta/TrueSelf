package testes;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import TrueSelf.modelo.Comentario;
import TrueSelf.modelo.Usuario;

public class ComentarioTeste {
	
	@Test
	public void DeveCriarNovoComentario(){
		Usuario usuarioEnvia = new Usuario();
		Usuario usuarioRecebe = new Usuario();
		Comentario comentario = new Comentario("blablabla",usuarioEnvia, usuarioRecebe,LocalDate.parse("2017-06-10"));
		Assert.assertEquals("blablabla", comentario.getComentario());
		Assert.assertEquals(usuarioEnvia, comentario.getUsuarioEnvia());
		Assert.assertEquals(usuarioRecebe, comentario.getUsuarioRecebe());
		Assert.assertEquals(LocalDate.parse("2017-06-10"), comentario.getData());
	}
	
	@Test
	public void DeveRetornarToString(){
		Comentario comentario = new Comentario();
		comentario.setComentario("blablabla");
		Assert.assertEquals("blablabla", comentario.toString());
	}
	
	@Test 
	public void DeveRetornarImageNull(){
		Comentario comentario = new Comentario();
		Assert.assertNull(comentario.getImagemClassificacao());
	}
	
}
