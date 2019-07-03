package br.com.BibliotecaUSJ.DAO;

import br.com.BibliotecaUSJ.DAO.model.Professor;
import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.BibliotecaUSJ.uteis.FabricaConexao;

public class ProfessorDAO {
    
    public void salvarProfessor(Professor professor){
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            
            {
                ps = conexao.prepareStatement("INSERT INTO `professor` (`nm_professor`) VALUES (?)");
            } 
            
          
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    public List<Professor> buscarProfessor(){
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM biblioteca.professor;");
            ResultSet resultSet = ps.executeQuery();
            List<Professor> professores = new ArrayList<>();
            while(resultSet.next()){
                Professor professor = new Professor();
                professor.setInt_idProf(resultSet.getInt("id_professor"));
                professor.setStr_nome(resultSet.getNString("nm_professor"));
                professores.add(professor);
            }
            return professores;
            
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void atualizarProfessor(Professor professor){
	Connection conexao = FabricaConexao.getConexao();
        
	
	PreparedStatement ps=null;
	try {
		String query="UPDATE `biblioteca`.`professor` set nm_professor=? where id_professor=?";
		ps=conexao.prepareStatement(query);
		ps.setString(1, professor.getStr_nome());
		System.out.println(ps);
		ps.executeUpdate();
	} catch (Exception e) {
		System.out.println(e);
	}
}
    
    public void deletarProfessor(Professor professor){
	Connection conexao = FabricaConexao.getConexao();
	
	PreparedStatement ps=null;
	try {
		String query="DELETE FROM `biblioteca`.`professor` where id_professor=?";
		ps=conexao.prepareStatement(query);
		ps.setInt(1, professor.getInt_idProf());
		System.out.println(ps);
		ps.executeUpdate();
	} catch (SQLException ex) {
		 Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
               
	}

}
}
