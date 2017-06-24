package testes;

import org.junit.Assert;
import org.junit.Test;

import application.ConfereSenha;

public class ConfereSenhaTeste {
	
	
	@Test
	public void deveTerSenhaVazia(){
		ConfereSenha senhas = new ConfereSenha("","");
		Assert.assertTrue(senhas.isSenhaVazia());
	}
	
	@Test
	public void deveTerSenhaVazia2(){
		ConfereSenha senhas = new ConfereSenha("senha","");
		Assert.assertTrue(senhas.isSenhaVazia());
	}
	
	@Test
	public void naoDeveTerSenhaVazia(){
		ConfereSenha senhas = new ConfereSenha("senha","senha");
		Assert.assertFalse(senhas.isSenhaVazia());
	}
	
	@Test
	public void deveTerSenhaIgual(){
		ConfereSenha senhas = new ConfereSenha("senha","senha");
		Assert.assertTrue(senhas.isSenhaIgual());
	}
	
	@Test
	public void deveTerSenhaDiferente(){
		ConfereSenha senhas = new ConfereSenha("senha","senhaDiferente");
		Assert.assertFalse(senhas.isSenhaIgual());
	}
	
	@Test
	public void deveTerSenhaSemNada(){
		ConfereSenha senhas = new ConfereSenha();
		Assert.assertNotNull(senhas);
	}
}
