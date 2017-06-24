package testes;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Test;

import application.CadastroController;
import javafx.event.ActionEvent;

public class CadastroTest {
	CadastroController cadastro = new CadastroController();
	
	@Test
	public void deveCriarUsuario(){
		Assert.assertNull(cadastro.getUsuario());
		cadastro.novo();
		Assert.assertNotNull(cadastro.getUsuario());
	}
	
	@Test 
	public void deveNaoSerHomem() throws Exception{
		Assert.assertFalse(cadastro.isHomem());
		Method method = CadastroController.class.getDeclaredMethod("onMasculino", ActionEvent.class);
		method.setAccessible(true);
		method.invoke(cadastro, new ActionEvent());
		Assert.assertTrue(cadastro.isHomem());
	}
	
	@Test
	public void deveNaoSerMulher() throws Exception{
		Assert.assertFalse(cadastro.isMulher()); 
		Method method = CadastroController.class.getDeclaredMethod("onFeminino", ActionEvent.class);
		method.setAccessible(true);
		method.invoke(cadastro, new ActionEvent());
		Assert.assertTrue(cadastro.isMulher());
	}
}
