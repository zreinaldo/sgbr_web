/**
 * 
 */
package sgbr.util.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import sgbr.cadastros.sql.DAODiaSemana;
import sgbr.cadastros.sql.DAOPromocao;
import sgbr.cadastros.sql.DAOPromocaoDiaSemana;
import sgbr.entidades.DiaSemana;
import sgbr.entidades.PromocaoDiaSemana;

/**
 * @author Reinaldo
 *
 */
public class CheckBoxDiaSemana {

	private static CheckBoxDiaSemana aCheckBoxDiaSemana = new CheckBoxDiaSemana();

	private CheckBoxDiaSemana() {
		super();
	}

	public static CheckBoxDiaSemana getInstancia() {
		if (CheckBoxDiaSemana.aCheckBoxDiaSemana == null) {
			CheckBoxDiaSemana.aCheckBoxDiaSemana = new CheckBoxDiaSemana();
		}

		return CheckBoxDiaSemana.aCheckBoxDiaSemana;
	}

	/**
	 * utilizado para o cadastro de promocoes
	 * 
	 * @param pRequest
	 * @param pNmCheckBox
	 * @param pIdSelect
	 * @param pCampoSelecionado
	 * @return
	 * @throws Exception
	 */
	public String getHTML(HttpServletRequest pRequest, String pNmCheckBox, String pIdSelect, Integer pCdPromocao)
			throws Exception {

		ArrayList<DiaSemana> aDiaSemana = DAODiaSemana.getInstancia().consultaTodosRegistros();
		StringBuffer bufferHtml = new StringBuffer();
		ArrayList<Integer> aPromocaoDiaSemana = DAOPromocaoDiaSemana.getInstancia()
				.consultaPromocaoDiasSemana(pCdPromocao);

		for (DiaSemana diaSemana : aDiaSemana) {

			this.valoresCheckBoxs(bufferHtml, pNmCheckBox, aPromocaoDiaSemana, diaSemana.getCdDiaSemana(),
					diaSemana.getDsDiaSemana());
		}

		return bufferHtml.toString();
	}

	/**
	 * monta o checkbox
	 * 
	 * @param bufferHtml
	 * @param pNmCheckBox
	 * @param pCampoSelecionado
	 * @param pValue
	 * @param pDescricao
	 */
	private void valoresCheckBoxs(StringBuffer bufferHtml, String pNmCheckBox, ArrayList<Integer> pCampoSelecionado,
			Integer pValue, String pDescricao) {
		bufferHtml.append("<input type=\"checkbox\" value=\"");
		bufferHtml.append(pValue);
		bufferHtml.append("\" ");
		if (pCampoSelecionado.contains(pValue)) {
			bufferHtml.append(" checked ");
		}
		bufferHtml.append("name=\"");
		bufferHtml.append(pNmCheckBox);
		bufferHtml.append("\" ");
		bufferHtml.append(">");
		bufferHtml.append(pDescricao);
		bufferHtml.append("<br>");
		bufferHtml.append("");
	}

}
