
package br.com.BibliotecaUSJ.controller;

import br.com.BibliotecaUSJ.DAO.model.Usuarios;
import br.com.BibliotecaUSJ.DAO.usuarioDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class UsuarioBean {
    
    private String login;
    private String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    private usuarioDAO usuarioDAO = new usuarioDAO();
    
    public String ValidarUsuario(){
        List<Usuarios> listaUsuarios = usuarioDAO.buscarUsuario(login, senha);
        if(listaUsuarios != null && listaUsuarios.size() > 0){
            return "index?faces-redirect=true";
        }
        return "";
    }    
    
}
