package TrueSelf.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comentario implements Serializable {

	private static final long serialVersionUID = 7724694173425717880L;
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
	public String comentar(Usuario usuarioRecebe, Usuario usuarioEnvia, String comentario){
		this.usuarioRecebe = usuarioRecebe;
		this.usuarioEnvia = usuarioEnvia;
		return comentario;
	}
	
	@Override
	public String toString() {
		return comentario;
	}
	
}
