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

import sgbr.cadastros.IntfDAOCliente;
import sgbr.entidades.Cliente;
import sgbr.entidades.Pessoa;
import sgbr.entidades.PessoaDocumento;
import sgbr.entidades.PessoaTelefone;
import sgbr.util.DAO_MYSQL;
import sgbr.util.OTDCliente;

/**
 * @author Reinaldo
 *
 */
public class DAOCliente extends DAO_MYSQL implements IntfDAOCliente {

	private static DAOCliente aDAOCliente = new DAOCliente();

	/**
	 * Cria um novo objeto DAOCliente.
	 */
	private DAOCliente() {
		super();
	}

	/**
	 * - implementacao do singleton
	 *
	 * @return
	 */
	public static DAOCliente getInstancia() {
		if (DAOCliente.aDAOCliente == null) {
			DAOCliente.aDAOCliente = new DAOCliente();
		}

		return DAOCliente.aDAOCliente;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.cadastros.IntfDAOCliente#incluir(sgbr.entidades.Cliente)
	 */
	@Override
	public Cliente incluir(Cliente pCliente) throws SQLException {

		Connection conexao = null;
		PreparedStatement ppSt = null;

		conexao = this.getConection();

		pCliente.setDhIncusaoRegistro(new Timestamp(System.currentTimeMillis()));

		String sql = "INSERT into mydb.cliente (PESSOA_CD,DH_INCLUSAO) values (?,?);";

		ppSt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		ppSt.setInt(1, pCliente.getCdPessoa());
		ppSt.setTimestamp(2, pCliente.getDhIncusaoRegistro());

		ppSt.execute();

		ResultSet rs = ppSt.getGeneratedKeys();

		while (rs.next()) {
			// pega o valor do sequencial inserido
			pCliente.setCdCliente(rs.getInt(1));
		}

		ppSt.close();
		conexao.close();

		return pCliente;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.cadastros.IntfDAOCliente#alterar(sgbr.entidades.Cliente)
	 */
	@Override
	public void alterar(Cliente pCliente) throws SQLException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sgbr.cadastros.IntfDAOCliente#excluir(sgbr.entidades.Cliente)
	 */
	@Override
	public void excluir(Cliente pCliente) throws SQLException {

		String sqlConector = "";
		Connection conexao = null;

		conexao = this.getConection();

		String sql = "delete from mydb.cliente  WHERE PESSOA_CD = " + pCliente.getCdPessoa() + " and CLIENTE_CD = " + pCliente.getCdCliente();

		Statement stm = conexao.createStatement();

		stm.execute(sql);


	}

	
	public ArrayList<OTDCliente> consultaTelaManterCliente(String pNome, String pTpDocumento,
			String pNuDocumento) throws SQLException {

		String sqlWhere = "";
		String sqlConector = "";
		Connection conexao = null;
		ArrayList<OTDCliente> arrayResposta = new ArrayList<>();
		OTDCliente otdCliente = null;

		conexao = this.getConection();

		String sql = "SELECT mydb.cliente.pessoa_cd"
				+ ",mydb.cliente.cliente_cd"
				+ ", mydb.pessoa.PESSOA_NM"
				+ ", mydb.pessoa.PESSOA_EE" +
				", mydb.pessoa_telefone.PESSOA_TELEFONE_DDD " +
				", mydb.pessoa_telefone.PESSOA_TELEFONE_NU_TEL " 
				+ ",mydb.pessoa.PESSOA_DT_NASC"
				+ " FROM mydb.cliente inner join mydb.pessoa on mydb.pessoa.PESSOA_CD = mydb.cliente.PESSOA_CD "
				+ " inner join mydb.pessoa_documento on mydb.pessoa_documento.PESSOA_CD = mydb.pessoa.PESSOA_CD"
				
				+ " left join  mydb.pessoa_telefone on mydb.pessoa.PESSOA_CD = mydb.pessoa_telefone.PESSOA_CD aND MYDB.pessoa_telefone.TIPO_TELEFONE_CD = 2 ";

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


		// Constroi SQL completo
		if (sqlWhere.length() != 0) {
			sql = sql + " \n WHERE " + sqlWhere;
		}

		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			otdCliente = new OTDCliente();
			otdCliente.setCdPessoa(rs.getInt(Cliente.NM_COLUNA_PESSOA_CD));
			otdCliente.setCdCliente(rs.getInt(Cliente.NM_COLUNA_CLIENTE_CD));
			otdCliente.setNmCliente(rs.getString(Pessoa.NM_COLUNA_PESSOA_NM).toUpperCase());
			otdCliente.setDtNascimento(rs.getDate(Pessoa.NM_COLUNA_PESSOA_DT_NASC));
			otdCliente.setEmail(rs.getString(Pessoa.NM_COLUNA_PESSOA_EE));
			otdCliente.setDddTelefone(rs.getString(PessoaTelefone.NM_COLUNA_PESSOA_TELEFONE_DDD) == null ? "" : rs.getString(PessoaTelefone.NM_COLUNA_PESSOA_TELEFONE_DDD) );
			otdCliente.setNuTelefone(rs.getString(PessoaTelefone.NM_COLUNA_PESSOA_TELEFONE_NU_TEL) == null ? "" : rs.getString(PessoaTelefone.NM_COLUNA_PESSOA_TELEFONE_NU_TEL) );
			
			
			arrayResposta.add(otdCliente);
		}

		rs.close();
		stm.close();
		conexao.close();
		return arrayResposta;
	}
	
	
	
	
	public OTDCliente consultarDadosCliente(Integer pCdCliente, Integer pCdPessoa) throws SQLException {

		String sqlWhere = "";
		String sqlConector = "";
		Connection conexao = null;
		OTDCliente otdCliente = null;

		conexao = this.getConection();
		String sql  ="SELECT " +
		"mydb.cliente.PESSOA_CD, " +
		"mydb.cliente.CLIENTE_CD, " +
		"mydb.pessoa.PESSOA_NM, " +
		"mydb.pessoa.PESSOA_EE, " +
		"mydb.pessoa.PESSOA_DT_NASC, " +
		" mydb.pessoa_telefone.PESSOA_TELEFONE_DDD " +
		", mydb.pessoa_telefone.PESSOA_TELEFONE_NU_TEL, " +
		"mydb.pessoa_documento.PESSOA_DOCUMENTO_NU, " +
		"mydb.cliente.DH_INCLUSAO " +
		"FROM mydb.cliente " +
		"inner join mydb.pessoa on mydb.pessoa.PESSOA_CD = mydb.cliente.PESSOA_CD " +
		"inner join mydb.pessoa_documento on mydb.pessoa_documento.PESSOA_CD = mydb.pessoa.PESSOA_CD "
		+ " left join  mydb.pessoa_telefone on mydb.pessoa.PESSOA_CD = mydb.pessoa_telefone.PESSOA_CD aND MYDB.pessoa_telefone.TIPO_TELEFONE_CD = 2 ";

		if (pCdCliente != null) {
			sqlWhere = sqlWhere + sqlConector + " mydb.cliente.CLIENTE_CD  = " + pCdCliente;
			sqlConector = " \n AND ";
		}

		if (pCdPessoa != null) {
			sqlWhere = sqlWhere + sqlConector + "MYDB.cliente.PESSOA_CD = " + pCdPessoa;

			sqlConector = " \n AND ";
		}

		// Constroi SQL completo
		if (sqlWhere.length() != 0) {
			sql = sql + " \n WHERE " + sqlWhere;
		}

		Statement stm = conexao.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			otdCliente = new OTDCliente();
			otdCliente.setCdPessoa(rs.getInt(Cliente.NM_COLUNA_PESSOA_CD));
			otdCliente.setCdCliente(rs.getInt(Cliente.NM_COLUNA_CLIENTE_CD));
			otdCliente.setNmCliente(rs.getString(Pessoa.NM_COLUNA_PESSOA_NM).toUpperCase());
			otdCliente.setDtNascimento(rs.getDate(Pessoa.NM_COLUNA_PESSOA_DT_NASC));
			otdCliente.setEmail(rs.getString(Pessoa.NM_COLUNA_PESSOA_EE));
			otdCliente.setNuCPF(rs.getString(PessoaDocumento.NM_COLUNA_PESSOA_DOCUMENTO_NU));
			otdCliente.setDhInclusao(rs.getTimestamp(Cliente.NM_COLUNA_DH_INCLUSAO_REGISTRO));
			otdCliente.setDddTelefone(rs.getString(PessoaTelefone.NM_COLUNA_PESSOA_TELEFONE_DDD) == null ? "" : rs.getString(PessoaTelefone.NM_COLUNA_PESSOA_TELEFONE_DDD) );
			otdCliente.setNuTelefone(rs.getString(PessoaTelefone.NM_COLUNA_PESSOA_TELEFONE_NU_TEL) == null ? "" : rs.getString(PessoaTelefone.NM_COLUNA_PESSOA_TELEFONE_NU_TEL) );
		

		}

		rs.close();
		stm.close();
		conexao.close();
		return otdCliente;

	}

}
