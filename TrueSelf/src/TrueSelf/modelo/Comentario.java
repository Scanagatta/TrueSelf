package TrueSelf.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comentario  implements Serializable{



	private static final long serialVersionUID = 673564205224778456L;

	public Comentario(String comentario, Usuario usuarioEnvia, Usuario usuarioRecebe, LocalDate data) {
		super();
		this.comentario = comentario;
		this.usuarioEnvia = usuarioEnvia;
		this.usuarioRecebe = usuarioRecebe;
		this.data = data;
	}
	
	public Comentario(){}

	private String comentario;
	// usuario que envia a mensagem
	private Usuario usuarioEnvia;
	// usuario que recebe a mensagem
	private Usuario usuarioRecebe;
	
	private LocalDate data;
	
	/**
	 * metodo para fazer salvar os comentarios e quem os fez e recebeu
	 * 
	 * @param usuarioRecebe
	 * @param usuarioEnvia
	 * @param comentario
	 * @return
	 */
	
	public void adicionarCountAnjo(){
		usuarioEnvia.setQtdAnjo(usuarioEnvia.getQtdAnjo() + 1);
	}
	
	public void adicionarCountDemonio(){
		usuarioEnvia.setQtdDemonio(usuarioEnvia.getQtdDemonio() + 1);
	}
	
	public void adicionarCountNeutro(){
		usuarioEnvia.setQtdNeutro(usuarioEnvia.getQtdNeutro() + 1);
	}
	
	@Override
	public String toString() {
		return comentario;
	}
	
	
	
}
