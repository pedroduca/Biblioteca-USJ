


import ClassesBean.Usuarios;
import java.sql.Connection;
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
public class usuarioDAO {
    
    public void salvarUsuario(Usuarios usuario){
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            
            {
                ps = conexao.prepareStatement("INSERT INTO `usuario` (`ds_login`,`ds_senha`,`nm_usuario`,`ds_cpf`,'ds_telefone',fl_nivel) VALUES (?,?,?,?,?,?)");
            } 
            
            ps.setString(1, usuario.getStr_login());
            ps.setString(2, usuario.getStr_senha());
            ps.setString(3, usuario.getStr_nmUsuario());
            ps.setString(4, usuario.getStr_cpf());
            ps.setString(5, usuario.getStr_telefone());
            ps.setInt(6, usuario.getFl_nivel());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    public List<Usuarios> buscarUsuario(){
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from usuario");
            ResultSet resultSet = ps.executeQuery();
            List<Usuarios> usuarios = new ArrayList<>();
            while(resultSet.next()){
                Usuarios usuario = new Usuarios();
                usuario.setId_usuario(resultSet.getInt("id_usuario"));
                usuario.setStr_login(resultSet.getString("ds_login"));
                usuario.setStr_senha(resultSet.getString("ds_senha"));
                usuario.setStr_nmUsuario(resultSet.getString("nm_usuario"));
                usuario.setStr_cpf(resultSet.getString("ds_cpf"));
                 usuario.setStr_telefone(resultSet.getString("ds_telefone"));
                  usuario.setFl_nivel(resultSet.getInt("fl_nivel"));
                 
                usuarios.add(usuario);
            }
            return usuarios;
            
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void atualizarUsuario(Usuarios usuarios){
	Connection conexao = FabricaConexao.getConexao();
        
	
	PreparedStatement ps=null;
	try {
		String query="update usuario set ds_login=?,ds_senha=?,nm_usuario=?,ds_cpf=?,ds_telefone=?,fl_nivel where id_usuario=?";
		ps=conexao.prepareStatement(query);
		ps.setString(1, usuarios.getStr_login());
		ps.setString(2, usuarios.getStr_senha());
		ps.setString(3, usuarios.getStr_nmUsuario());
		ps.setString(4, usuarios.getStr_cpf());
                ps.setString(5, usuarios.getStr_telefone());
                ps.setInt(6, usuarios.getFl_nivel());
                ps.setInt(7, usuarios.getInt_idUsuario());
		System.out.println(ps);
		ps.executeUpdate();
	} catch (Exception e) {
		System.out.println(e);
	}
}
    
    public void deletarUsuario(Usuarios usuario){
	Connection conexao = FabricaConexao.getConexao();
	
	PreparedStatement ps=null;
	try {
		String query="delete from usuario where id_usuario=?";
		ps=conexao.prepareStatement(query);
		ps.setInt(1, usuario.getInt_idUsuario());
		System.out.println(ps);
		ps.executeUpdate();
	} catch (SQLException ex) {
		 Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
               
	}

}
}
