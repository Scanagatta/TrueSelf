package testes;

import org.junit.Assert;
import org.junit.Test;

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
	
}
