/**
 * 
 */
package sgbr.fachada;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import sgbr.controlador.ControladorCliente;
import sgbr.controlador.ControladorComanda;
import sgbr.controlador.ControladorFuncionario;
import sgbr.controlador.ControladorItemCardapio;
import sgbr.controlador.ControladorPromocao;
import sgbr.controlador.ControladorTipoDocumento;
import sgbr.controlador.ControladorTipoFuncionario;
import sgbr.controlador.ControladorTipoUsuario;
import sgbr.controlador.ControladorUsuario;
import sgbr.entidades.Comanda;
import sgbr.entidades.ItemCardapio;
import sgbr.entidades.Promocao;
import sgbr.entidades.TipoDocumento;
import sgbr.entidades.TipoFuncionario;
import sgbr.entidades.TipoUsuario;
import sgbr.entidades.Usuario;
import sgbr.util.OTDCliente;
import sgbr.util.OTDComanda;
import sgbr.util.OTDFuncionario;
import sgbr.util.OTDItemCardapio;
import sgbr.util.OTDPromocao;
import sgbr.util.OTDTipoFuncionario;
import sgbr.util.OTDUsuario;

/**
 * @author Reinaldo
 *
 */
public class FachadaSGBR {

	private static FachadaSGBR aFachadaSGBR = new FachadaSGBR();

	/**
	 * Cria um novo objeto FachadaSGBR.
	 */
	private FachadaSGBR() {

		super();
	}

	/**
	 * -
	 *
	 * @return
	 */
	public static FachadaSGBR getInstancia() {
		if (FachadaSGBR.aFachadaSGBR == null) {
			FachadaSGBR.aFachadaSGBR = new FachadaSGBR();
		}

		return FachadaSGBR.aFachadaSGBR;
	}

	/**
	 * inclui os dados do funcionario
	 * 
	 * @param pOTDFuncionario
	 */
	public void incluirFuncionario(OTDFuncionario pOTDFuncionario) {
		ControladorFuncionario.getInstancia().incluirFuncionario(pOTDFuncionario);
	}

	/**
	 * altera os dados do funcionario
	 * 
	 * @param pOTDFuncionario
	 */
	public void alterarFuncionario(OTDFuncionario pOTDFuncionario) {
		ControladorFuncionario.getInstancia().alterarFuncionario(pOTDFuncionario);
	}

	/**
	 * exclui os dados do funcionario
	 * 
	 * @param pOTDFuncionario
	 */
	public void excluirFuncionario(OTDFuncionario pOTDFuncionario) {
		ControladorFuncionario.getInstancia().excluirFuncionario(pOTDFuncionario);
	}
	
	public Collection<OTDFuncionario> consultaTodosRegistrosFuncionario(Boolean pIsFuncionarioSemUsuario) throws SQLException{
		return ControladorFuncionario.getInstancia().consultaTodosRegistrosFuncionario(pIsFuncionarioSemUsuario);
	}

	/**
	 * consulta todos os dados de um funcionario
	 * 
	 * @param pCdFuncionario
	 * @param pCdPessoa
	 * @return
	 * @throws SQLException
	 */
	public OTDFuncionario consultarDadosFuncionario(Integer pCdFuncionario, Integer pCdPessoa) throws SQLException {
		return ControladorFuncionario.getInstancia().consultarDadosFuncionario(pCdFuncionario, pCdPessoa);
	}

	public void incluirTipoFuncionario(TipoFuncionario pTipoFuncionario) throws SQLException {
		ControladorTipoFuncionario.getInstancia().incluir(pTipoFuncionario);
	}

	public void alterarTipoFuncionario(TipoFuncionario pTipoFuncionario) throws SQLException {
		ControladorTipoFuncionario.getInstancia().alterar(pTipoFuncionario);
	}

	public void excluirTipoFuncionario(TipoFuncionario pTipoFuncionario) throws SQLException {
		ControladorTipoFuncionario.getInstancia().excluir(pTipoFuncionario);
	}

	public ArrayList<OTDTipoFuncionario> consultaTelaManterTipoFuncionario(String pCdTipoFuncionario,
			String pDsTipoFuncionario) throws SQLException {
		return ControladorTipoFuncionario.getInstancia().consultaTelaManterTipoFuncionario(pCdTipoFuncionario,
				pDsTipoFuncionario);
	}

	public TipoFuncionario consultaTipoFuncionarioPorChavePrimaria(TipoFuncionario pTipoFuncionario)
			throws SQLException {
		return ControladorTipoFuncionario.getInstancia().consultaPorChavePrimaria(pTipoFuncionario);
	}

	/**
	 * 
	 * @param pInRetornarApenasVigentes
	 * @return
	 * @throws SQLException
	 */
	public Collection<TipoFuncionario> consultaTodosRegistrosTipoFuncionario(boolean pInRetornarApenasVigentes)
			throws SQLException {
		return ControladorTipoFuncionario.getInstancia()
				.consultaTodosRegistrosTipoFuncionario(pInRetornarApenasVigentes);
	}

	/**
	 * @param pInRetornarApenasVigentes
	 * @return
	 * @throws SQLException
	 */
	public Collection<TipoDocumento> consultaTodosRegistrosTipoDocumento(boolean pInRetornarApenasVigentes)
			throws SQLException {
		return ControladorTipoDocumento.getInstancia().consultaTodosRegistrosTipoDocumento(pInRetornarApenasVigentes);
	}

	/**
	 * consulta utilizada na tela manter funcionario
	 * 
	 * @param pNome
	 * @param pTpDocumento
	 * @param pNuDocumento
	 * @param pTpFuncionario
	 * @param pInAtivos
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<OTDFuncionario> consultaTelaManterFuncionario(String pNome, String pTpDocumento,
			String pNuDocumento, String pTpFuncionario, boolean pInAtivos) throws SQLException {
		return ControladorFuncionario.getInstancia().consultaTelaManterFuncionario(pNome, pTpDocumento, pNuDocumento,
				pTpFuncionario, pInAtivos);
	}

	public ArrayList<OTDComanda> consultaTelaManterComanda(String pCodigo, String pSituacao) throws SQLException {
		return ControladorComanda.getInstancia().consultaTelaManterComanda(pCodigo, pSituacao);
	}

	public void incluirComanda(Integer pQtdComandas) throws SQLException {
		ControladorComanda.getInstancia().incluir(pQtdComandas);

	}

	public Comanda consultaComandaPorChavePrimaria(Comanda pComanda) throws SQLException {
		return ControladorComanda.getInstancia().consultaPorChavePrimaria(pComanda);

	}

	public void alterarComanda(Comanda pComanda) throws SQLException {
		ControladorComanda.getInstancia().alterar(pComanda);

	}

	public void excluirComanda(Comanda pComanda) throws SQLException {
		ControladorComanda.getInstancia().excluir(pComanda);

	}

	public void incluirItemCardapio(ItemCardapio pItemCardapio) throws SQLException {
		ControladorItemCardapio.getInstancia().incluir(pItemCardapio);
	}

	public void alterarItemCardapio(ItemCardapio pItemCardapio) throws SQLException {
		ControladorItemCardapio.getInstancia().alterar(pItemCardapio);
	}

	public void excluirItemCardapio(ItemCardapio pItemCardapio) throws SQLException {
		ControladorItemCardapio.getInstancia().excluir(pItemCardapio);
	}

	public ArrayList<OTDItemCardapio> consultaTelaManterItemCardapio(String pCdItemCardapio, String pNmItemCardapio,
			String pSiItemCardapio) throws SQLException {
		return ControladorItemCardapio.getInstancia().consultaTelaManterItemCardapio(pCdItemCardapio, pNmItemCardapio,
				pSiItemCardapio);
	}

	public ItemCardapio consultaItemCardapioPorChavePrimaria(ItemCardapio pItemCardapio) throws SQLException {
		return ControladorItemCardapio.getInstancia().consultaPorChavePrimaria(pItemCardapio);
	}

	/**
	 * 
	 * @param pInRetornarApenasVigentes
	 * @return
	 * @throws SQLException
	 */
	public Collection<ItemCardapio> consultaTodosRegistrosItemCardapio(boolean pInRetornarApenasVigentes)
			throws SQLException {
		return ControladorItemCardapio.getInstancia().consultaTodosRegistrosItemCardapio(pInRetornarApenasVigentes);
	}

	public void incluirCliente(OTDCliente pOtdCliente) {
		ControladorCliente.getInstancia().incluir(pOtdCliente);
	}

	public ArrayList<OTDCliente> consultaTelaManterCliente(String pNome, String pTpDocumento, String pNuDocumento)
			throws SQLException {
		return ControladorCliente.getInstancia().consultaTelaManterCliente(pNome, pTpDocumento, pNuDocumento);
	}
	
	public void alterarCliente(OTDCliente pOtdCliente) {
		ControladorCliente.getInstancia().alterar(pOtdCliente);
	}

	public OTDCliente consultarDadosCliente(Integer pCdCliente, Integer pCdPessoa) throws SQLException {
		return ControladorCliente.getInstancia().consultarDadosCliente(pCdCliente, pCdPessoa);
	}
	
	public void excluirCliente(OTDCliente pOtdCliente) {
		ControladorCliente.getInstancia().excluir(pOtdCliente);
	}
	
	public void incluirPromocao(OTDPromocao pOtdPromocao) throws Exception {
		ControladorPromocao.getInstancia().incluir(pOtdPromocao);
	}

	public void alterarPromocao(Promocao pPromocao) throws SQLException {
		ControladorPromocao.getInstancia().alterar(pPromocao);
	}

	public void excluirPromocao(Integer pCdPromocao) throws Exception {
		ControladorPromocao.getInstancia().excluir(pCdPromocao);
	}
	public ArrayList<OTDPromocao> consultaTelaManterPromocao(String pCdItemCardapio,
			String pInRetornarApenasVigentes,  String pDiaSemanaPromocao) throws SQLException {
		return ControladorPromocao.getInstancia().consultaTelaManterPromocao(pCdItemCardapio, pInRetornarApenasVigentes, pDiaSemanaPromocao);
	}

	public Promocao consultaPromocaoPorChavePrimaria(Promocao pPromocao) throws SQLException {
		return ControladorPromocao.getInstancia().consultaPorChavePrimaria(pPromocao);
	}

	public OTDPromocao consultaDadosPromocao(Integer pCdPromocao) throws SQLException {
		return ControladorPromocao.getInstancia().consultaDadosPromocao(pCdPromocao);
		
	}
	public Collection<Promocao> consultaTodosRegistrosPromocao(String pInRetornarApenasVigentes)
			throws SQLException {
		return ControladorPromocao.getInstancia().consultaTodosRegistrosPromocao(pInRetornarApenasVigentes);
	}
	
	public void incluirUsuario(Usuario pUsuario) throws SQLException {
		ControladorUsuario.getInstancia().incluir(pUsuario);
	}

	public void alterarUsuario(Usuario pUsuario) throws SQLException {
		ControladorUsuario.getInstancia().alterar(pUsuario);
	}

	public void excluirUsuario(Usuario pUsuario) throws SQLException {
		ControladorUsuario.getInstancia().excluir(pUsuario);
	}

	public ArrayList<OTDUsuario> consultaTelaManterUsuario(String pLoginUsuario, String pTpUsuario,
			String pCdFuncionario, String pInBloqueioUsuario) throws SQLException {
		return ControladorUsuario.getInstancia().consultaTelaManterUsuario(pLoginUsuario, pTpUsuario,
				pCdFuncionario, pInBloqueioUsuario);
	}

	public Usuario consultaUsuarioPorChavePrimaria(Usuario pUsuario) throws SQLException {
		return ControladorUsuario.getInstancia().consultaPorChavePrimaria(pUsuario);
	}
	
	public OTDUsuario consultaDadosUsuario(Integer pCdUsuario) throws SQLException {
		return ControladorUsuario.getInstancia().consultaDadosUsuario(pCdUsuario);
	}

	/**
	 * 
	 * @param pInRetornarApenasVigentes
	 * @return
	 * @throws SQLException
	 */
	public Collection<Usuario> consultaTodosRegistrosUsuario(boolean pInRetornarApenasVigentes)
			throws SQLException {
		return ControladorUsuario.getInstancia().consultaTodosRegistrosUsuario(pInRetornarApenasVigentes);
	}
	
	//TODO - FALTA FAZER A TELA DE LOGIN
	public OTDUsuario consultaUsuarioSenha(String pLoginUsuario, String pSenhaUsuario) throws SQLException{
		return ControladorUsuario.getInstancia().consultaUsuarioSenha(pLoginUsuario, pSenhaUsuario);
	}
	
	
	public TipoUsuario consultaTipoUsuarioPorChavePrimaria(TipoUsuario pTipoUsuario) throws SQLException {
		return ControladorTipoUsuario.getInstancia().consultaPorChavePrimaria(pTipoUsuario);
	}

	/**
	 * 
	 * @param pInRetornarApenasVigentes
	 * @return
	 * @throws SQLException
	 */
	public Collection<TipoUsuario> consultaTodosRegistrosTipoUsuario(boolean pInRetornarApenasVigentes)
			throws SQLException {
		return ControladorTipoUsuario.getInstancia().consultaTodosRegistrosTipoUsuario(pInRetornarApenasVigentes);
	}
	
}
