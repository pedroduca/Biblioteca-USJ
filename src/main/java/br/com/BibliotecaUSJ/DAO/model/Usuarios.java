package br.com.BibliotecaUSJ.DAO.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Richard Vepo
 */
@SessionScoped
@ManagedBean
public class Usuarios {
    
    private String str_login, str_senha, str_nmUsuario, str_cpf, str_telefone;
   
private Integer  id_usuario;

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }


    
    


    public int getInt_idUsuario() {
        return int_idUsuario;
    }

    public void setInt_idUsuario(int int_idUsuario) {
        this.int_idUsuario = int_idUsuario;
    }
    private int int_idUsuario;

    public String getStr_login() {
        return str_login;
    }

    public void setStr_login(String str_login) {
        this.str_login = str_login;
    }

    public String getStr_senha() {
        return str_senha;
    }

    public void setStr_senha(String str_senha) {
        this.str_senha = str_senha;
    }

    public String getStr_nmUsuario() {
        return str_nmUsuario;
    }

    public void setStr_nmUsuario(String str_nmUsuario) {
        this.str_nmUsuario = str_nmUsuario;
    }

    public String getStr_cpf() {
        return str_cpf;
    }

    public void setStr_cpf(String str_cpf) {
        this.str_cpf = str_cpf;
    }

    public String getStr_telefone() {
        return str_telefone;
    }

    public void setStr_telefone(String str_telefone) {
        this.str_telefone = str_telefone;
    }

    
    
    
    
    
}
