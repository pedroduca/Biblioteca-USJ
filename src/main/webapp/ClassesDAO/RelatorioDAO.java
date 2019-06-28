

import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.FabricaConexao;

/**
 *
 * @author Danilo Souza Almeida
 */
public class RelatorioDAO {
    
    public void salvarRelatorio(Relatorio relatorio){
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            
            {
                ps = conexao.prepareStatement("INSERT INTO `relatorioexternos` (`int_emprestados`,`int_devolvidos`,`int_etiquetados`,`int_etiquetasArrumadas`,`int_tccCatalogados`,`int_negativasRetiradas`,`dt_relatorio`) VALUES (?,?,?,?,?,?,?)");
            } 
            
            ps.setInt(1, relatorio.getInt_livrosEmprestados());
            ps.setInt(2, relatorio.getInt_livrosDevolvidos());
            ps.setInt(3, relatorio.getInt_livrosEtiquetados());
            ps.setInt(4, relatorio.getInt_etiquetasArrumadas());
            ps.setInt(5, relatorio.getInt_tccCatalogados());
            ps.setInt(6, relatorio.getInt_negativasRetiradas());
            ps.setDate(7, (Date) relatorio.getDt_relatorio());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    public List<Relatorio> buscarVisita(){
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from relatorioexternos");
            ResultSet resultSet = ps.executeQuery();
            List<Relatorio> relatorios = new ArrayList<>();
            while(resultSet.next()){
                Relatorio relatorio = new Relatorio();
                relatorio.setInt_idRelatorio(resultSet.getInt("id_relatorio"));
                relatorio.setInt_livrosEmprestados(resultSet.getInt("int_emprestados"));
                relatorio.setInt_livrosDevolvidos(resultSet.getInt("int_devolvidos"));
                relatorio.setInt_livrosEtiquetados(resultSet.getInt("int_etiquetados"));
                relatorio.setInt_etiquetasArrumadas(resultSet.getInt("int_etiquetasArrumadas"));
                 relatorio.setInt_tccCatalogados(resultSet.getInt("int_tccCatalogados"));
                 relatorio.setInt_negativasRetiradas(resultSet.getInt("int_negativasRetiradas"));
                 relatorio.setDt_relatorio(resultSet.getDate("dt_relatorio"));
                 
                relatorios.add(relatorio);
            }
            return relatorios;
            
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void atualizarUsuario(Relatorio relatorio){
	Connection conexao = FabricaConexao.getConexao();
        
	
	PreparedStatement ps=null;
	try {
		String query="update relatorioexternos set int_emprestados=?, int_devolvidos=?, int_etiquetados=?, int_etiquetasArrumadas=?, int_tccCatalogados=?, int_negativasRetiradas=?, dt_relatorio=? where id_visita=?";
		ps=conexao.prepareStatement(query);
		ps.setInt(1, relatorio.getInt_livrosEmprestados());
		ps.setInt(2, relatorio.getInt_livrosDevolvidos());
		ps.setInt(3, relatorio.getInt_livrosEtiquetados());
                ps.setInt(4, relatorio.getInt_etiquetasArrumadas());
                ps.setInt(5, relatorio.getInt_tccCatalogados());
                ps.setInt(6, relatorio.getInt_negativasRetiradas());
                ps.setDate(7, (Date) relatorio.getDt_relatorio());
                
		System.out.println(ps);
		ps.executeUpdate();
	} catch (Exception e) {
		System.out.println(e);
	}
}
    
    public void deletarUsuario(Relatorio relatorio){
	Connection conexao = FabricaConexao.getConexao();
	
	PreparedStatement ps=null;
	try {
		String query="delete from relatorioexternos where id_relatorio=?";
		ps=conexao.prepareStatement(query);
		ps.setInt(1, relatorio.getInt_idRelatorio());
		System.out.println(ps);
		ps.executeUpdate();
	} catch (SQLException ex) {
		 Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
               
	}

}
}
