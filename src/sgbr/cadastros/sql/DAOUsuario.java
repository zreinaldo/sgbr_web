/**
 * 
 */
package sgbr.cadastros.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import sgbr.cadastros.IntfDAOUsuario;
import sgbr.entidades.Pessoa;
import sgbr.entidades.TipoUsuario;
import sgbr.entidades.Usuario;
import sgbr.util.Constantes;
import sgbr.util.DAO_MYSQL;
import sgbr.util.OTDUsuario;

/**
 * @author Reinaldo
 *
 */
public class DAOUsuario extends DAO_MYSQL implements IntfDAOUsuario {

	private static DAOUsuario aDAOUsuario = new DAOUsuario();

	/**
	 * Cria um novo objeto DAOUsuario.
	 */
	private DAOUsuario() {
		super();
	}

	/**
	 * - implementacao do singleton
	 *
	 * @return
	 */
	public static DAOUsuario getInstancia() {
		if (DAOUsuario.aDAOUsuario == null) {
			DAOUsuario.aDAOUsuario = new DAOUsuario();
		}

		return DAOUsuario.aDAOUsuario;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.cadastros.IntfDAOUsuario#incluir(sgbr.entidades.Usuario)
	 */
	@Override
	public Usuario incluir(Usuario pUsuario) throws SQLException {
		Connection conexao = null;
		PreparedStatement ppSt = null;

		conexao = this.getConection();

		pUsuario.setDhIncusaoRegistro(new Timestamp(System.currentTimeMillis()));
		pUsuario.setDhAlteracaoRegistro(new Timestamp(System.currentTimeMillis()));

		String sql = "INSERT INTO mydb.USUARIO (" + Usuario.NM_COLUNA_USUARIO_LOGIN + ","
				+ Usuario.NM_COLUNA_USUARIO_SENHA + "," + Usuario.NM_COLUNA_USUARIO_IN_BLOQUEIO + ","
				+ Usuario.NM_COLUNA_TIPO_USUARIO_CD + "," + Usuario.NM_COLUNA_FUNCIONARIO_CD + ","
				+ Usuario.NM_COLUNA_DH_INCLUSAO_REGISTRO + "," + Usuario.NM_COLUNA_DH_ALTERACAO_REGISTRO
				+ ") VALUES(?,?,?,?,?,?,?)";

		ppSt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		ppSt.setString(1, pUsuario.getLoginUsuario());
		ppSt.setString(2, pUsuario.getSenhaUsuario());
		ppSt.setString(3, pUsuario.getInBloqueioUsuario().toUpperCase());
		ppSt.setInt(4, pUsuario.getCdTpUsuario());
		ppSt.setInt(5, pUsuario.getCdFuncionario());
		ppSt.setTimestamp(6, pUsuario.getDhIncusaoRegistro());
		ppSt.setTimestamp(7, pUsuario.getDhAlteracaoRegistro());

		ppSt.execute();

		ResultSet rs = ppSt.getGeneratedKeys();

		while (rs.next()) {
			// pega o valor do sequencial inserido
			pUsuario.setCdUsuario(rs.getInt(1));
		}

		ppSt.close();
		conexao.close();

		return pUsuario;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.cadastros.IntfDAOUsuario#alterar(sgbr.entidades.Usuario)
	 */
	@Override
	public void alterar(Usuario pUsuario) throws SQLException {
		Connection conexao = null;
		String sqlSeparador = "";
		int i = 1;
		conexao = this.getConection();

		String sql = "UPDATE mydb.USUARIO SET  " + Usuario.NM_COLUNA_DH_ALTERACAO_REGISTRO + " = CURRENT_TIMESTAMP ,";

		if (pUsuario.getLoginUsuario() != null && !pUsuario.getLoginUsuario().isEmpty()) {
			sql = sql + sqlSeparador + Usuario.NM_COLUNA_USUARIO_LOGIN + " = ? ";
			sqlSeparador = ", ";
		}

		if (pUsuario.getInBloqueioUsuario() != null && !pUsuario.getInBloqueioUsuario().isEmpty()) {
			sql = sql + sqlSeparador + Usuario.NM_COLUNA_USUARIO_IN_BLOQUEIO + " = ? ";
			sqlSeparador = ", ";
		}

		if (pUsuario.getSenhaUsuario() != null && !pUsuario.getSenhaUsuario().isEmpty()) {
			sql = sql + sqlSeparador + Usuario.NM_COLUNA_USUARIO_SENHA + " = ?";
			sqlSeparador = ", ";
		}

		if (pUsuario.getCdTpUsuario() != null) {
			sql = sql + sqlSeparador + Usuario.NM_COLUNA_TIPO_USUARIO_CD + " = ? ";
			sqlSeparador = ", ";
		}

		// WHERE
		if (pUsuario.getCdUsuario() != null) {
			sql = sql + " WHERE " + Usuario.NM_COLUNA_USUARIO_CD + " = ? ";
		}

		PreparedStatement ppSt = conexao.prepareStatement(sql);

		if (pUsuario.getLoginUsuario() != null && !pUsuario.getLoginUsuario().isEmpty()) {
			ppSt.setString(i, pUsuario.getLoginUsuario());
			i++;
		}

		if (pUsuario.getInBloqueioUsuario() != null && !pUsuario.getInBloqueioUsuario().isEmpty()) {
			ppSt.setString(i, pUsuario.getInBloqueioUsuario());
			i++;
		}
		if (pUsuario.getSenhaUsuario() != null && !pUsuario.getSenhaUsuario().isEmpty()) {
			ppSt.setString(i, pUsuario.getSenhaUsuario());
			i++;
		}
		if (pUsuario.getCdTpUsuario() != null) {
			ppSt.setInt(i, pUsuario.getCdTpUsuario());
			i++;
		}
		if (pUsuario.getCdUsuario() != null) {
			ppSt.setInt(i, pUsuario.getCdUsuario());
			i++;
			// SÓ ALTERA SE TIVER O CÓDIGO DO USUÁRIO
			ppSt.execute();
		}

		ppSt.close();
		conexao.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.cadastros.IntfDAOUsuario#excluir(sgbr.entidades.Usuario)
	 */
	public void excluir(Usuario pUsuario) throws SQLException {
		Connection conexao = null;

		conexao = this.getConection();

		String sql = "delete from mydb.USUARIO WHERE " + Usuario.NM_COLUNA_USUARIO_CD + " = ?";

		PreparedStatement ppSt = conexao.prepareStatement(sql);

		ppSt.setInt(1, pUsuario.getCdUsuario());

		ppSt.execute();

		ppSt.close();
		conexao.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.cadastros.IntfDAOUsuario#consultaTodosRegistros(boolean)
	 */
	public Collection<Usuario> consultaTodosRegistros(boolean pInRetornarApenasVigentes) throws SQLException {

		Connection conexao = null;
		PreparedStatement ppSt = null;
		Usuario usuario = null;
		Collection<Usuario> colecaoUsuario = new ArrayList<Usuario>();

		conexao = this.getConection();

		String sql = "SELECT * FROM mydb.USUARIO ";

		if (pInRetornarApenasVigentes) {
			sql = sql + " where mydb.USUARIO_IN_BLOQUEIO = '" + Constantes.CD_NAO + "'";
		}

		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			usuario = new Usuario();
			usuario.setCdUsuario(rs.getInt(Usuario.NM_COLUNA_USUARIO_CD));
			usuario.setCdFuncionario(rs.getInt(Usuario.NM_COLUNA_FUNCIONARIO_CD));
			usuario.setDhIncusaoRegistro(rs.getTimestamp(Usuario.NM_COLUNA_DH_INCLUSAO_REGISTRO));
			usuario.setDhAlteracaoRegistro(rs.getTimestamp(Usuario.NM_COLUNA_DH_ALTERACAO_REGISTRO));
			usuario.setCdTpUsuario(rs.getInt(Usuario.NM_COLUNA_TIPO_USUARIO_CD));
			usuario.setInBloqueioUsuario(rs.getString(Usuario.NM_COLUNA_USUARIO_IN_BLOQUEIO));
			usuario.setLoginUsuario(rs.getString(Usuario.NM_COLUNA_USUARIO_LOGIN));
			usuario.setSenhaUsuario(rs.getString(Usuario.NM_COLUNA_USUARIO_SENHA));
			colecaoUsuario.add(usuario);
		}

		rs.close();
		stm.close();
		conexao.close();

		return colecaoUsuario;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sgbr.cadastros.IntfDAOUsuario#consultaTelaManterUsuario(java.lang.String,
	 * java.lang.String)
	 */
	public ArrayList<OTDUsuario> consultaTelaManterUsuario(String pLoginUsuario, String pTpUsuario,
			String pCdFuncionario, String pInBloqueioUsuario) throws SQLException {

		String sqlWhere = "";
		String sqlConector = "";
		Connection conexao = null;
		ArrayList<OTDUsuario> arrayResposta = new ArrayList<>();
		OTDUsuario otdUsuario = null;

		conexao = this.getConection();
		String sql = "SELECT MYDB.USUARIO.USUARIO_CD," + " MYDB.USUARIO.USUARIO_LOGIN, "
				+ " MYDB.USUARIO.TIPO_USUARIO_CD, " + " MYDB.TIPO_USUARIO.TIPO_USUARIO_NM, " + "MYDB.PESSOA.PESSOA_NM," + "MYDB.USUARIO.USUARIO_IN_BLOQUEIO "
				+ "FROM MYDB.USUARIO " + "INNER JOIN MYDB.FUNCIONARIO "
				+ "ON MYDB.USUARIO.FUNCIONARIO_CD = MYDB.FUNCIONARIO.FUNCIONARIO_CD " + "INNER JOIN MYDB.PESSOA "
				+ "ON MYDB.FUNCIONARIO.PESSOA_CD = MYDB.PESSOA.PESSOA_CD "
				+ "INNER JOIN MYDB.TIPO_USUARIO " 
				+ "ON MYDB.TIPO_USUARIO.TIPO_USUARIO_CD = MYDB.USUARIO.TIPO_USUARIO_CD_ ";

		if (!pLoginUsuario.isEmpty()) {
			sqlWhere = sqlWhere + sqlConector + " MYDB.USUARIO.USUARIO_LOGIN LIKE '%" + pLoginUsuario + "%' ";
			sqlConector = " \n AND ";
		}

		if (!pTpUsuario.isEmpty()) {
			sqlWhere = sqlWhere + sqlConector + "MYDB.USUARIO.TIPO_USUARIO_CD = " + pTpUsuario;
			sqlConector = " \n AND ";
		}

		if (!pCdFuncionario.isEmpty()) {
			sqlWhere = sqlWhere + sqlConector + "	MYDB.FUNCIONARIO.FUNCIONARIO_CD =" + pCdFuncionario;
			sqlConector = " \n AND ";
		}

		if (!pInBloqueioUsuario.isEmpty()) {
			sqlWhere = sqlWhere + sqlConector + "	MYDB.USUARIO.USUARIO_IN_BLOQUEIO = '" + pInBloqueioUsuario + "'";
			sqlConector = " \n AND ";
		}

		// Constroi SQL completo
		if (sqlWhere.length() != 0) {
			sql = sql + " \n WHERE " + sqlWhere;
		}

		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			otdUsuario = new OTDUsuario();
			otdUsuario.setCdUsuario(rs.getInt(Usuario.NM_COLUNA_USUARIO_CD));
			otdUsuario.setLoginUsuario(rs.getString(Usuario.NM_COLUNA_USUARIO_LOGIN));
			otdUsuario.setCdTpUsuario(rs.getInt(Usuario.NM_COLUNA_TIPO_USUARIO_CD));
			otdUsuario.setNmFuncionario(rs.getString(Pessoa.NM_COLUNA_PESSOA_NM));
			otdUsuario.setInBloqueioUsuario(rs.getString(Usuario.NM_COLUNA_USUARIO_IN_BLOQUEIO));
			otdUsuario.setNmTpUsuario(rs.getString(TipoUsuario.NM_COLUNA_TIPO_USUARIO_NM));
			
			arrayResposta.add(otdUsuario);
		}

		rs.close();
		stm.close();
		conexao.close();
		return arrayResposta;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sgbr.cadastros.IntfDAOUsuario#consultaPorChavePrimaria(sgbr.entidades.
	 * Usuario)
	 */
	public Usuario consultaPorChavePrimaria(Usuario pUsuario) throws SQLException {

		String sqlWhere = "";
		String sqlConector = "";
		Connection conexao = null;
		ArrayList<OTDUsuario> arrayResposta = new ArrayList<>();
		Usuario usuario = null;

		conexao = this.getConection();

		String sql = "select * from mydb.USUARIO";

		if (pUsuario.getCdUsuario() != null) {
			sqlWhere = sqlWhere + sqlConector + "mydb.USUARIO.USUARIO_CD = " + pUsuario.getCdUsuario();
			sqlConector = " \n AND ";
		}

		// Constroi SQL completo
		if (sqlWhere.length() != 0) {
			sql = sql + " \n WHERE " + sqlWhere;
		}

		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			usuario = new Usuario();
			usuario.setCdUsuario(rs.getInt(Usuario.NM_COLUNA_USUARIO_CD));
			usuario.setCdTpUsuario(rs.getInt(Usuario.NM_COLUNA_TIPO_USUARIO_CD));
			usuario.setCdFuncionario(rs.getInt(Usuario.NM_COLUNA_FUNCIONARIO_CD));
			usuario.setInBloqueioUsuario(rs.getString(Usuario.NM_COLUNA_USUARIO_IN_BLOQUEIO));
			usuario.setSenhaUsuario(rs.getString(Usuario.NM_COLUNA_USUARIO_SENHA));
			usuario.setLoginUsuario(rs.getString(Usuario.NM_COLUNA_USUARIO_LOGIN));
			usuario.setDhIncusaoRegistro(rs.getTimestamp(Usuario.NM_COLUNA_DH_INCLUSAO_REGISTRO));
			usuario.setDhAlteracaoRegistro(rs.getTimestamp(Usuario.NM_COLUNA_DH_ALTERACAO_REGISTRO));

		}

		rs.close();
		stm.close();
		conexao.close();
		return usuario;
	}

	public OTDUsuario consultaDadosUsuario(Integer pCdUsuario) throws SQLException {
		String sqlWhere = "";
		String sqlConector = "";
		Connection conexao = null;
		OTDUsuario otdUsuario = null;

		conexao = this.getConection();

		String sql = "SELECT " + "MYDB.USUARIO.*,MYDB.PESSOA.PESSOA_NM, MYDB.TIPO_USUARIO.TIPO_USUARIO_NM "
				+ "FROM MYDB.USUARIO "
				+ "INNER JOIN MYDB.FUNCIONARIO ON MYDB.USUARIO.FUNCIONARIO_CD = MYDB.FUNCIONARIO.FUNCIONARIO_CD "
				+ "INNER JOIN MYDB.PESSOA ON MYDB.FUNCIONARIO.PESSOA_CD = MYDB.PESSOA.PESSOA_CD "
				+ "INNER JOIN MYDB.TIPO_USUARIO ON MYDB.USUARIO.TIPO_USUARIO_CD = MYDB.TIPO_USUARIO.TIPO_USUARIO_CD ";

		if (pCdUsuario != null) {
			sqlWhere = sqlWhere + sqlConector + "mydb.USUARIO.USUARIO_CD = " + pCdUsuario;
			sqlConector = " \n AND ";
		}

		// Constroi SQL completo
		if (sqlWhere.length() != 0) {
			sql = sql + " \n WHERE " + sqlWhere;
		}

		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			otdUsuario = new OTDUsuario();
			otdUsuario.setCdUsuario(rs.getInt(Usuario.NM_COLUNA_USUARIO_CD));
			otdUsuario.setCdTpUsuario(rs.getInt(Usuario.NM_COLUNA_TIPO_USUARIO_CD));
			otdUsuario.setCdFuncionario(rs.getInt(Usuario.NM_COLUNA_FUNCIONARIO_CD));
			otdUsuario.setInBloqueioUsuario(rs.getString(Usuario.NM_COLUNA_USUARIO_IN_BLOQUEIO));
			otdUsuario.setSenhaUsuario(rs.getString(Usuario.NM_COLUNA_USUARIO_SENHA));
			otdUsuario.setLoginUsuario(rs.getString(Usuario.NM_COLUNA_USUARIO_LOGIN));
			otdUsuario.setNmFuncionario(rs.getString(Pessoa.NM_COLUNA_PESSOA_NM));
			otdUsuario.setNmTpUsuario(rs.getString(TipoUsuario.NM_COLUNA_TIPO_USUARIO_NM));
			otdUsuario.setDhAlteracao(rs.getTimestamp(Usuario.NM_COLUNA_DH_ALTERACAO_REGISTRO));
			otdUsuario.setDhInclusao(rs.getTimestamp(Usuario.NM_COLUNA_DH_INCLUSAO_REGISTRO));

		}

		rs.close();
		stm.close();
		conexao.close();
		return otdUsuario;
	}
	
	
	public OTDUsuario consultaUsuarioSenha(String pLoginUsuario, String pSenhaUsuario) throws SQLException {
		String sqlWhere = "";
		String sqlConector = "";
		Connection conexao = null;
		OTDUsuario otdUsuario = null;

		conexao = this.getConection();

		String sql = "SELECT MYDB.USUARIO.*, " +
				"MYDB.PESSOA.PESSOA_NM " +
				"FROM MYDB.USUARIO " +
				"INNER JOIN MYDB.FUNCIONARIO " +
				"ON MYDB.FUNCIONARIO.FUNCIONARIO_CD = MYDB.USUARIO.FUNCIONARIO_CD " +
				"AND MYDB.USUARIO.USUARIO_IN_BLOQUEIO = 'N'"+
				"INNER JOIN MYDB.PESSOA " +
				"ON MYDB.FUNCIONARIO.PESSOA_CD = MYDB.PESSOA.PESSOA_CD ";
		
		if (pLoginUsuario != null && !pLoginUsuario.isEmpty()) {
			sqlWhere = sqlWhere + sqlConector + "mydb.USUARIO.USUARIO_LOGIN = '" + pLoginUsuario + "'";
			sqlConector = " \n AND ";
		}
		
		if (pSenhaUsuario != null && !pSenhaUsuario.isEmpty()) {
			sqlWhere = sqlWhere + sqlConector + "mydb.USUARIO.USUARIO_SENHA = '" + pSenhaUsuario + "'";
			sqlConector = " \n AND ";
		}

		// Constroi SQL completo
		if (sqlWhere.length() != 0) {
			sql = sql + " \n WHERE " + sqlWhere  ;
		}
		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			otdUsuario = new OTDUsuario();
			otdUsuario.setCdUsuario(rs.getInt(Usuario.NM_COLUNA_USUARIO_CD));
			otdUsuario.setCdTpUsuario(rs.getInt(Usuario.NM_COLUNA_TIPO_USUARIO_CD));
			otdUsuario.setCdFuncionario(rs.getInt(Usuario.NM_COLUNA_FUNCIONARIO_CD));
			otdUsuario.setInBloqueioUsuario(rs.getString(Usuario.NM_COLUNA_USUARIO_IN_BLOQUEIO));
			otdUsuario.setSenhaUsuario(rs.getString(Usuario.NM_COLUNA_USUARIO_SENHA));
			otdUsuario.setLoginUsuario(rs.getString(Usuario.NM_COLUNA_USUARIO_LOGIN));
			otdUsuario.setNmFuncionario(rs.getString(Pessoa.NM_COLUNA_PESSOA_NM));
			otdUsuario.setDhAlteracao(rs.getTimestamp(Usuario.NM_COLUNA_DH_ALTERACAO_REGISTRO));
			otdUsuario.setDhInclusao(rs.getTimestamp(Usuario.NM_COLUNA_DH_INCLUSAO_REGISTRO));

		}

		rs.close();
		stm.close();
		conexao.close();
		return otdUsuario;
	}
	
	
	
	
	
	
}
