package testes;

import org.junit.Assert;
import org.junit.Test;

import TrueSelf.modelo.Usuario;
import application.TelaLoginController;

public class LoginControllerTest {

	@Test
	public void deveAtribuirDonoCorretamente() throws Exception {
		TelaLoginController tela = new TelaLoginController();
		tela.setDono("jao");
		Assert.assertEquals("jao", TelaLoginController.getDono());
	}
	
	@Test
	public void deveAtribuirLogadoCorretamente() throws Exception {
		Usuario usuario = new Usuario();
		TelaLoginController.setLogado(usuario);
		Assert.assertEquals(usuario, TelaLoginController.getLogado());
	}
}
