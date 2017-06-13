package sgbr.cadastros.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import sgbr.cadastros.IntfDAOFuncionario;
import sgbr.entidades.Funcionario;
import sgbr.entidades.Pessoa;
import sgbr.entidades.TipoFuncionario;
import sgbr.util.DAO_MYSQL;
import sgbr.util.OTDFuncionario;

/**
 * 
 * TODO ajustar interface
 * 
 * @author Reinaldo
 *
 */
public class DAOFuncionario extends DAO_MYSQL implements IntfDAOFuncionario {

	private static DAOFuncionario aDAOFuncionario = new DAOFuncionario();

	/**
	 * - implementacao do singleton
	 *
	 * @return
	 */
	public static DAOFuncionario getInstancia() {
		if (DAOFuncionario.aDAOFuncionario == null) {
			DAOFuncionario.aDAOFuncionario = new DAOFuncionario();
		}

		return DAOFuncionario.aDAOFuncionario;
	}

	/**
	 * Cria um novo objeto DAOFuncionario.
	 */
	private DAOFuncionario() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sgbr.cadastros.IntfDAOFuncionario#incluir(sgbr.entidades.Funcionario)
	 */
	@Override
	public Funcionario incluir(Funcionario pFuncionario) throws SQLException {

		Connection conexao = null;
		PreparedStatement ppSt = null;

		conexao = this.getConection();

		pFuncionario.setDhIncusaoRegistro(new Timestamp(System.currentTimeMillis()));
		pFuncionario.setDhAlteracaoRegistro(new Timestamp(System.currentTimeMillis()));

		String sql = "INSERT INTO mydb.funcionario  ( " + Funcionario.NM_COLUNA_PESSOA_CD + ","
				+ Funcionario.NM_COLUNA_FUNCIONARIO_TP + "," + Funcionario.NM_COLUNA_FUNCIONARIO_BANCO_AGENCIA + ","
				+ Funcionario.NM_COLUNA_FUNCIONARIO_BANCO_CONTA + "," + Funcionario.NM_COLUNA_FUNCIONARIO_SALARIO + ","
				+ Funcionario.NM_COLUNA_FUNCIONARIO_DT_ADMISSAO + "," + Funcionario.NM_COLUNA_FUNCIONARIO_BANCO_NM + ","
				+ Funcionario.NM_COLUNA_DH_INCLUSAO_REGISTRO + "," + Funcionario.NM_COLUNA_DH_ALTERACAO_REGISTRO
				+ ") VALUES(?,?,?,?,?,?,?,?,?)";

		ppSt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		ppSt.setInt(1, pFuncionario.getCdPessoa());
		ppSt.setInt(2, pFuncionario.getTpFuncionario());
		ppSt.setString(3, pFuncionario.getNuBancoAgencia());
		ppSt.setString(4, pFuncionario.getNuBancoConta());
		ppSt.setDouble(5, pFuncionario.getVlSalario());
		ppSt.setDate(6, pFuncionario.getDtAdmissao());
		ppSt.setString(7, pFuncionario.getNmBanco());
		ppSt.setTimestamp(8, pFuncionario.getDhIncusaoRegistro());
		ppSt.setTimestamp(9, pFuncionario.getDhAlteracaoRegistro());

		ppSt.execute();

		// pega o ultimo sequencial gerado pelo banco na tabela
		ResultSet rs = ppSt.getGeneratedKeys();

		while (rs.next()) {
			// pega o valor do sequencial inserido
			pFuncionario.setCdFuncionario(rs.getInt(1));
		}

		ppSt.close();
		conexao.close();

		return pFuncionario;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sgbr.cadastros.IntfDAOFuncionario#alterar(sgbr.entidades.Funcionario)
	 */
	@Override
	public void alterar(Funcionario pFuncionario) throws SQLException {

		Connection conexao = null;

		PreparedStatement ppSt = null;
		conexao = this.getConection();

		String sql = "UPDATE MYDB.FUNCIONARIO SET " + "TIPO_FUNCIONARIO_CD = ?" + ",FUNCIONARIO_BANCO_AGENCIA = ?"
				+ ",FUNCIONARIO_BANCO_CONTA = ?" + ",FUNCIONARIO_SALARIO = ?" + ",FUNCIONARIO_DT_ADMISSAO  = ?"
				+ ",FUNCIONARIO_DT_DEMISSAO  = ?" + ",FUNCIONARIO_BANCO_NM  = ?" + ",DH_ALTERACAO  = current_timestamp "
				+ "WHERE FUNCIONARIO_CD = ? and PESSOA_CD = ?";

		ppSt = conexao.prepareStatement(sql);

		ppSt.setInt(1, pFuncionario.getTpFuncionario());
		ppSt.setString(2, pFuncionario.getNuBancoAgencia());
		ppSt.setString(3, pFuncionario.getNuBancoConta());
		ppSt.setDouble(4, pFuncionario.getVlSalario());
		ppSt.setDate(5, pFuncionario.getDtAdmissao());
		ppSt.setDate(6, pFuncionario.getDtDemissao());
		ppSt.setString(7, pFuncionario.getNmBanco());
		ppSt.setInt(8, pFuncionario.getCdFuncionario());
		ppSt.setInt(9, pFuncionario.getCdPessoa());

		ppSt.execute();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sgbr.cadastros.IntfDAOFuncionario#excluir(sgbr.entidades.Funcionario)
	 */
	@Override
	public void excluir(Funcionario pFuncionario) throws SQLException {

		Connection conexao = null;

		conexao = this.getConection();

		String sql = "DELETE FROM MYDB.FUNCIONARIO WHERE PESSOA_CD = " + pFuncionario.getCdPessoa()
				+ " AND FUNCIONARIO_CD = " + pFuncionario.getCdFuncionario();

		Statement stm = conexao.createStatement();

		stm.execute(sql);

	}

	public OTDFuncionario consultarDadosFuncionario(Integer pCdFuncionario, Integer pCdPessoa) throws SQLException {

		String sqlWhere = "";
		String sqlConector = "";
		Connection conexao = null;
		OTDFuncionario otdFuncionario = null;

		conexao = this.getConection();

		String sql = "SELECT * FROM MYDB.PESSOA INNER JOIN MYDB.FUNCIONARIO ON MYDB.FUNCIONARIO.PESSOA_CD = MYDB.PESSOA.PESSOA_CD ";

		if (pCdFuncionario != null) {
			sqlWhere = sqlWhere + sqlConector + "MYDB.FUNCIONARIO.FUNCIONARIO_CD  = " + pCdFuncionario;
			sqlConector = " \n AND ";
		}

		if (pCdPessoa != null) {
			sqlWhere = sqlWhere + sqlConector + "MYDB.FUNCIONARIO.PESSOA_CD = " + pCdPessoa;

			sqlConector = " \n AND ";
		}

		// Constroi SQL completo
		if (sqlWhere.length() != 0) {
			sql = sql + " \n WHERE " + sqlWhere;
		}

		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			otdFuncionario = new OTDFuncionario();
			otdFuncionario.setCdPessoa(rs.getInt(Funcionario.NM_COLUNA_PESSOA_CD));
			otdFuncionario.setNmFuncionario(rs.getString(Pessoa.NM_COLUNA_PESSOA_NM).toUpperCase());
			otdFuncionario.setCdFuncionario(rs.getInt(Funcionario.NM_COLUNA_FUNCIONARIO_CD));
			otdFuncionario.setTpFuncionario(rs.getInt(Funcionario.NM_COLUNA_FUNCIONARIO_TP));
			otdFuncionario.setDtAdmissao(this.getDateOpcional(rs, Funcionario.NM_COLUNA_FUNCIONARIO_DT_ADMISSAO));
			otdFuncionario.setDtDemissao(this.getDateOpcional(rs, Funcionario.NM_COLUNA_FUNCIONARIO_DT_DEMISSAO));
			otdFuncionario.setVlSalario(rs.getDouble(Funcionario.NM_COLUNA_FUNCIONARIO_SALARIO));

			otdFuncionario.setNmBanco(rs.getString(Funcionario.NM_COLUNA_FUNCIONARIO_BANCO_NM));
			otdFuncionario.setNuAgencia(rs.getString(Funcionario.NM_COLUNA_FUNCIONARIO_BANCO_AGENCIA));
			otdFuncionario.setNuCC(rs.getString(Funcionario.NM_COLUNA_FUNCIONARIO_BANCO_CONTA));

			otdFuncionario.setNmUF(rs.getString(Pessoa.NM_COLUNA_PESSOA_ENDERECO_UF));
			otdFuncionario.setNmCidade(rs.getString(Pessoa.NM_COLUNA_PESSOA_ENDERECO_CIDADE));
			otdFuncionario.setNmBairro(rs.getString(Pessoa.NM_COLUNA_PESSOA_ENDERECO_BAIRRO_NM));
			otdFuncionario.setNmLogradouro(rs.getString(Pessoa.NM_COLUNA_PESSOA_ENDERECO_LOGRADOURO_NM));
			otdFuncionario.setNuLogradouro(rs.getString(Pessoa.NM_COLUNA_PESSOA_ENDERECO_LOGRADOURO_NU));
			otdFuncionario.setNuCEP(rs.getString(Pessoa.NM_COLUNA_PESSOA_ENDERECO_CEP));
			otdFuncionario.setDtNascimento(this.getDateOpcional(rs, Pessoa.NM_COLUNA_PESSOA_DT_NASC));
			otdFuncionario.setEmail(rs.getString(Pessoa.NM_COLUNA_PESSOA_EE));

		}

		rs.close();
		stm.close();
		conexao.close();
		return otdFuncionario;

	}

	public ArrayList<OTDFuncionario> consultaTelaManterFuncionario(String pNome, String pTpDocumento,
			String pNuDocumento, String pTpFuncionario, boolean pInAtivos) throws SQLException {

		String sqlWhere = "";
		String sqlConector = "";
		Connection conexao = null;
		ArrayList<OTDFuncionario> arrayResposta = new ArrayList<>();
		OTDFuncionario otdFuncionario = null;

		conexao = this.getConection();

		String sql = "SELECT " + "MYDB.PESSOA.PESSOA_CD, " + "MYDB.PESSOA.PESSOA_NM, "
				+ "MYDB.FUNCIONARIO.FUNCIONARIO_CD, " + "MYDB.FUNCIONARIO.TIPO_FUNCIONARIO_CD, "
				+ " MYDB.FUNCIONARIO.FUNCIONARIO_DT_ADMISSAO, " + "MYDB.TIPO_FUNCIONARIO.TIPO_FUNCIONARIO_DS, "
				+ "MYDB.FUNCIONARIO.FUNCIONARIO_DT_DEMISSAO," + "MYDB.FUNCIONARIO.FUNCIONARIO_SALARIO "
				+ "FROM MYDB.PESSOA "
				+ "INNER JOIN MYDB.FUNCIONARIO ON MYDB.FUNCIONARIO.PESSOA_CD = MYDB.PESSOA.PESSOA_CD "
				+ "INNER JOIN MYDB.TIPO_FUNCIONARIO ON MYDB.FUNCIONARIO.TIPO_FUNCIONARIO_CD = MYDB.TIPO_FUNCIONARIO.TIPO_FUNCIONARIO_CD";

		if (!pNome.isEmpty()) {
			sqlWhere = sqlWhere + sqlConector + "MYDB.PESSOA.PESSOA_NM LIKE '%" + pNome.toUpperCase() + "%'";
			sqlConector = " \n AND ";
		}

		if (!pTpDocumento.isEmpty()) {
			sqlWhere = sqlWhere + sqlConector
					+ " EXISTS (SELECT 1 FROM MYDB.PESSOA_DOCUMENTO WHERE TIPO_DOCUMENTO_CD = " + pTpDocumento
					+ " AND MYDB.PESSOA_DOCUMENTO.PESSOA_DOCUMENTO_NU = '" + pNuDocumento
					+ "' AND MYDB.PESSOA.PESSOA_CD = MYDB.PESSOA_DOCUMENTO.PESSOA_CD)";
			sqlConector = " \n AND ";
		}

		if (!pTpFuncionario.isEmpty()) {
			sqlWhere = sqlWhere + sqlConector + "	MYDB.FUNCIONARIO.TIPO_FUNCIONARIO_CD = " + pTpFuncionario;
			sqlConector = " \n AND ";
		}

		if (pInAtivos) {
			sqlWhere = sqlWhere + sqlConector + "	MYDB.FUNCIONARIO.FUNCIONARIO_DT_DEMISSAO IS NULL";
			sqlConector = " \n AND ";
		}

		// Constroi SQL completo
		if (sqlWhere.length() != 0) {
			sql = sql + " \n WHERE " + sqlWhere;
		}

		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			otdFuncionario = new OTDFuncionario();
			otdFuncionario.setCdPessoa(rs.getInt(Funcionario.NM_COLUNA_PESSOA_CD));
			otdFuncionario.setNmFuncionario(rs.getString(Pessoa.NM_COLUNA_PESSOA_NM).toUpperCase());
			otdFuncionario.setCdFuncionario(rs.getInt(Funcionario.NM_COLUNA_FUNCIONARIO_CD));
			otdFuncionario.setTpFuncionario(rs.getInt(Funcionario.NM_COLUNA_FUNCIONARIO_TP));
			otdFuncionario.setDsFuncionario(rs.getString(TipoFuncionario.NM_COLUNA_TIPO_FUNCIONARIO_DS));
			otdFuncionario.setDtAdmissao(this.getDateOpcional(rs, Funcionario.NM_COLUNA_FUNCIONARIO_DT_ADMISSAO));
			otdFuncionario.setDtDemissao(this.getDateOpcional(rs, Funcionario.NM_COLUNA_FUNCIONARIO_DT_DEMISSAO));
			otdFuncionario.setVlSalario(rs.getDouble(Funcionario.NM_COLUNA_FUNCIONARIO_SALARIO));

			arrayResposta.add(otdFuncionario);
		}

		rs.close();
		stm.close();
		conexao.close();
		return arrayResposta;
	}

	public Collection<OTDFuncionario> consultaTodosRegistrosFuncionario(Boolean pIsFuncionarioSemUsuario)
			throws SQLException {

		String sqlWhere = "";
		String sqlConector = "";
		Connection conexao = null;
		OTDFuncionario otdFuncionario = null;
		Collection<OTDFuncionario> colecaoFuncionario = new ArrayList<OTDFuncionario>();

		conexao = this.getConection();

		String sql = "SELECT  MYDB.PESSOA.PESSOA_NM,  MYDB.FUNCIONARIO.FUNCIONARIO_CD FROM MYDB.PESSOA INNER JOIN MYDB.FUNCIONARIO ON MYDB.FUNCIONARIO.PESSOA_CD = MYDB.PESSOA.PESSOA_CD ";
		if (pIsFuncionarioSemUsuario) {
			sqlWhere = sqlWhere + sqlConector
					+ " NOT EXISTS (SELECT * FROM MYDB.USUARIO WHERE MYDB.USUARIO.FUNCIONARIO_CD = MYDB.FUNCIONARIO.FUNCIONARIO_CD) ";
			sqlConector = " \n AND ";
		}

		// Constroi SQL completo
		if (sqlWhere.length() != 0) {
			sql = sql + " \n WHERE " + sqlWhere;
		}

		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			otdFuncionario = new OTDFuncionario();
			otdFuncionario.setNmFuncionario(rs.getString(Pessoa.NM_COLUNA_PESSOA_NM).toUpperCase());
			otdFuncionario.setCdFuncionario(rs.getInt(Funcionario.NM_COLUNA_FUNCIONARIO_CD));

			colecaoFuncionario.add(otdFuncionario);
		}

		rs.close();
		stm.close();
		conexao.close();
		return colecaoFuncionario;

	}
}
