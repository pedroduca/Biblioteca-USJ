

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
    
    public void salvar(Usuarios usuario){
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
    
    public List<Usuarios> buscar(){
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
                  usuario.setFl_nivel(resultSet.getInt("ds_telefone"));
                 
                usuarios.add(usuario);
            }
            return usuarios;
            
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
