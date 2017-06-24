package testes;

import org.junit.Assert;
import org.junit.Test;

import TrueSelf.modelo.Usuario;
import application.TelaPerfilVisitanteController;

public class VisitanteTest {
	
	TelaPerfilVisitanteController visitante = new TelaPerfilVisitanteController();
	
	@Test
	public void deveAtribuirVisitado(){
		Usuario usuario = new Usuario();
		TelaPerfilVisitanteController.setVisitado(usuario);
		Assert.assertEquals(usuario , TelaPerfilVisitanteController.getVisitado());
	}

}
