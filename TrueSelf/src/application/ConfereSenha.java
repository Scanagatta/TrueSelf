package application;

public class ConfereSenha {
	
	String senha;
	String confereSenha;
	
	
	public ConfereSenha() {
		super();
	}

	public ConfereSenha(String senha, String confereSenha) {
		super();
		this.senha = senha;
		this.confereSenha = confereSenha;
	}
	
	public boolean isSenhaVazia(){
		if(senha.isEmpty() || confereSenha.isEmpty()){
			return true;
		}
		return false;
	}
	
	public boolean isSenhaIgual(){
		if(senha.equals(confereSenha)){
			return true;
		}
		return false;
	}

}
