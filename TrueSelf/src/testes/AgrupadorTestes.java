package testes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({UsuarioTeste.class, ComentarioTeste.class, LoginControllerTest.class, CadastroTest.class, VisitanteTest.class,
	SimuladorDBTeste.class, ConfereSenhaTeste.class})
public class AgrupadorTestes {

}
