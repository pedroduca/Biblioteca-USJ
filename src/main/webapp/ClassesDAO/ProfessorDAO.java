

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
public class ProfessorDAO {
    
    public void salvarUsuario(Professor professor){
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            
            {
                ps = conexao.prepareStatement("INSERT INTO `professor` (`id_professor`,`nm`,`ds_observacao`) VALUES (?,?,?)");
            } 
            
            //ps.setInt(1, professor.getInt_alunos());
            //ps.setDate(2, (Date) visita.getDt_visita());
           // ps.setString(3, visita.getStr_observacao());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    public List<Visita> buscarVisita(){
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from visita");
            ResultSet resultSet = ps.executeQuery();
            List<Visita> visitas = new ArrayList<>();
            while(resultSet.next()){
                Visita visita = new Visita();
                visita.setInt_idVisita(resultSet.getInt("id_visita"));
                visita.setInt_alunos(resultSet.getInt("int_alunos"));
                visita.setStr_observacao(resultSet.getString("ds_observacao"));
                visita.setDt_visita(resultSet.getDate("dt_visita"));
                
                visitas.add(visita);
            }
            return visitas;
            
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void atualizarUsuario(Visita visita){
	Connection conexao = FabricaConexao.getConexao();
        
	
	PreparedStatement ps=null;
	try {
		String query="update visita set int_alunos=?,dt_visita=?,ds_observacao=? where id_visita=?";
		ps=conexao.prepareStatement(query);
		ps.setInt(1, visita.getInt_alunos());
		ps.setDate(2, (Date) visita.getDt_visita());
		ps.setString(3, visita.getStr_observacao());
		System.out.println(ps);
		ps.executeUpdate();
	} catch (Exception e) {
		System.out.println(e);
	}
}
    
    public void deletarUsuario(Visita visita){
	Connection conexao = FabricaConexao.getConexao();
	
	PreparedStatement ps=null;
	try {
		String query="delete from usuario where id_visita=?";
		ps=conexao.prepareStatement(query);
		ps.setInt(1, visita.getInt_idVisita());
		System.out.println(ps);
		ps.executeUpdate();
	} catch (SQLException ex) {
		 Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
               
	}

}
}
