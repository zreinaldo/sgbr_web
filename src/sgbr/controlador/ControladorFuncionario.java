package sgbr.controlador;

import sgbr.entidades.Funcionario;
import sgbr.regras.funcionario.RNIncluirFuncionario;
import sgbr.util.OTDFuncionario;

public class ControladorFuncionario {

	private static ControladorFuncionario aControladorFuncionario = new ControladorFuncionario();

	/**
	 * Cria um novo objeto ControladorFuncionario.
	 */
	private ControladorFuncionario() {
		super();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static ControladorFuncionario getInstancia() {
		if (ControladorFuncionario.aControladorFuncionario == null) {
			ControladorFuncionario.aControladorFuncionario = new ControladorFuncionario();
		}

		return ControladorFuncionario.aControladorFuncionario;
	}
	
	
	public void incluirFuncionario(OTDFuncionario pOTDFuncionario) {

		RNIncluirFuncionario.getInstancia().processar(pOTDFuncionario);

	}

	public void alterarFuncionario(OTDFuncionario pOTDFuncionario) {

	}

	public void excluirFuncionario(OTDFuncionario pOTDFuncionario) {

	}

	public void consultarFuncionarioPorChavePrimaria(Funcionario pOTDFuncionario) {

	}

}
