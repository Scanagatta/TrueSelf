package TrueSelf.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
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
	
	@Override
	public String toString() {
		return nome;
	}



	public Usuario() {
		//inicializar as quantidades com zero, se n elas n aparecem
		setQtdAnjo(0);
		setQtdDemonio(0);
		setQtdNeutro(0);
	}
}
