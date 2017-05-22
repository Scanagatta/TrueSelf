package TrueSelf.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1800819952165704057L;
	private String nome;
	private String senha;
	private String login;
	private String telefone;
	private LocalDate dataNascimento;
	private String estadoCivil;
	private Integer qtdNeutro;
	private Integer qtdDemonio;
	private Integer qtdAnjo;
	private String comentario;
	private Integer idade;
	
	
	@Override
	public String toString() {
		return nome;
	}
}
