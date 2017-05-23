/**
 * 
 */
package sgbr.cadastros.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import sgbr.cadastros.IntfDAOTipoFuncionario;
import sgbr.entidades.TipoFuncionario;
import sgbr.util.DAO_MYSQL;

/**
 * @author Reinaldo
 *
 */
public class DAOTipoFuncionario extends DAO_MYSQL implements IntfDAOTipoFuncionario {
	
	private static DAOTipoFuncionario aDAOTipoFuncionario = new DAOTipoFuncionario();

	/**
	 * Cria um novo objeto DAOTipoFuncionario.
	 */
	private DAOTipoFuncionario() {
		super();
	}

	/**
	 * - implementacao do singleton
	 *
	 * @return
	 */
	public static DAOTipoFuncionario getInstancia() {
		if (DAOTipoFuncionario.aDAOTipoFuncionario == null) {
			DAOTipoFuncionario.aDAOTipoFuncionario = new DAOTipoFuncionario();
		}

		return DAOTipoFuncionario.aDAOTipoFuncionario;
	}
	

	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOTipoFuncionario#incluir(sgbr.entidades.TipoFuncionario)
	 */
	@Override
	public TipoFuncionario incluir(TipoFuncionario pTipoFuncionario) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOTipoFuncionario#alterar(sgbr.entidades.TipoFuncionario)
	 */
	@Override
	public void alterar(TipoFuncionario pTipoFuncionario) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see sgbr.cadastros.IntfDAOTipoFuncionario#excluir(sgbr.entidades.TipoFuncionario)
	 */
	@Override
	public void excluir(TipoFuncionario pTipoFuncionario) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	public Collection<TipoFuncionario> consultaTodosRegistros( boolean pInRetornarApenasVigentes) throws SQLException {
		
		Connection conexao = null;
		PreparedStatement ppSt = null;
		TipoFuncionario tpFuncionario = null;
		Collection<TipoFuncionario> colecaoTipoFuncionario = new ArrayList<TipoFuncionario>();

		conexao = this.getConection();
		
		String sql = "SELECT * FROM mydb.tipo_funcionario ";
		
		if (pInRetornarApenasVigentes){
			sql = sql + " where mydb.tipo_funcionario.dt_fim_vigencia is null";
		}

		Statement stm = conexao.createStatement();
				
		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			tpFuncionario = new TipoFuncionario();
			tpFuncionario.setTpFuncionario(rs.getInt(TipoFuncionario.NM_COLUNA_TIPO_FUNCIONARIO_CD));
			tpFuncionario.setDsFuncionario(rs.getString(TipoFuncionario.NM_COLUNA_TIPO_FUNCIONARIO_DS));
			tpFuncionario.setDhIncusaoRegistro(rs.getTimestamp(TipoFuncionario.NM_COLUNA_DH_INCLUSAO_REGISTRO));
			tpFuncionario.setDhAlteracaoRegistro(rs.getTimestamp(TipoFuncionario.NM_COLUNA_DH_ALTERACAO_REGISTRO));
			tpFuncionario.setDtFimVigencia(rs.getDate(TipoFuncionario.NM_COLUNA_DT_FIM_VIGENCIA));
			colecaoTipoFuncionario.add(tpFuncionario);
		}

		rs.close();
		stm.close();
		conexao.close();
		
		return colecaoTipoFuncionario;
	}

}
