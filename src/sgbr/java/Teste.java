/**
 * 
 */
package sgbr.java;

import java.sql.Date;

import sgbr.cadastros.sql.DAOPessoa;
import sgbr.entidades.Pessoa;
import sgbr.util.Util;

/**
 * @author Reinaldo
 *
 */
public class Teste {
	
	public static void main(String[] args) throws Exception {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNmPessoa("josajoajdosa sem nome");
		pessoa.setEePessoa("joasso@gmail.com");
		
	
			Date dtNasc = Util.formataData("10/06/1982");
			pessoa.setDtNascPessoa(dtNasc);

		DAOPessoa.getInstancia().incluir(pessoa);
		
		DAOPessoa.getInstancia().incluir(pessoa);
	}

}
