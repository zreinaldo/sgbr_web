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

import sgbr.cadastros.IntfDAOTipoDocumento;
import sgbr.entidades.TipoDocumento;
import sgbr.util.DAO_MYSQL;

/**
 * @author Reinaldo
 *
 */
public class DAOTipoDocumento extends DAO_MYSQL implements IntfDAOTipoDocumento {

	private static DAOTipoDocumento aDAOTipoDocumento = new DAOTipoDocumento();

	/**
	 * Cria um novo objeto DAOTipoDocumento.
	 */
	private DAOTipoDocumento() {
		super();
	}

	/**
	 * - implementacao do singleton
	 *
	 * @return
	 */
	public static DAOTipoDocumento getInstancia() {
		if (DAOTipoDocumento.aDAOTipoDocumento == null) {
			DAOTipoDocumento.aDAOTipoDocumento = new DAOTipoDocumento();
		}

		return DAOTipoDocumento.aDAOTipoDocumento;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sgbr.cadastros.IntfDAOTipoDocumento#incluir(sgbr.entidades.TipoDocumento)
	 */
	@Override
	public TipoDocumento incluir(TipoDocumento pTipoDocumento) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sgbr.cadastros.IntfDAOTipoDocumento#alterar(sgbr.entidades.TipoDocumento)
	 */
	@Override
	public void alterar(TipoDocumento pTipoDocumento) throws SQLException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sgbr.cadastros.IntfDAOTipoDocumento#excluir(sgbr.entidades.TipoDocumento)
	 */
	@Override
	public void excluir(TipoDocumento pTipoDocumento) throws SQLException {
		// TODO Auto-generated method stub

	}

	public Collection<TipoDocumento> consultaTodosRegistros(boolean pInRetornarApenasVigentes) throws SQLException {

		Connection conexao = null;
		PreparedStatement ppSt = null;
		TipoDocumento tpDocumento = null;
		Collection<TipoDocumento> colecaoTipoFuncionario = new ArrayList<TipoDocumento>();

		conexao = this.getConection();

		String sql = "SELECT * FROM mydb.tipo_documento ";

		if (pInRetornarApenasVigentes) {
			sql = sql + " where mydb.tipo_documento.dt_fim_vigencia is null";
		}

		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			tpDocumento = new TipoDocumento();
			tpDocumento.setTpDocumento(rs.getInt(TipoDocumento.NM_COLUNA_TIPO_DOCUMENTO_CD));
			tpDocumento.setDsDocumento(rs.getString(TipoDocumento.NM_COLUNA_TIPO_DOCUMENTO_DS));
			tpDocumento.setDhIncusaoRegistro(rs.getTimestamp(TipoDocumento.NM_COLUNA_DH_INCLUSAO_REGISTRO));
			tpDocumento.setDhAlteracaoRegistro(rs.getTimestamp(TipoDocumento.NM_COLUNA_DH_ALTERACAO_REGISTRO));
			tpDocumento.setDtFimVigencia(rs.getDate(TipoDocumento.NM_COLUNA_DT_FIM_VIGENCIA));
			colecaoTipoFuncionario.add(tpDocumento);
		}

		rs.close();
		stm.close();
		conexao.close();

		return colecaoTipoFuncionario;
	}
}
