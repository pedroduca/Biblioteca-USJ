package br.com.BibliotecaUSJ.DAO.model;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Richard Vepo
 */
@SessionScoped
@ManagedBean
public class Professor {
    
    private String str_nome;
    private boolean bool_ativo;
    private int int_idProf;

    public String getStr_nome() {
        return str_nome;
    }

    public void setStr_nome(String str_nome) {
        this.str_nome = str_nome;
    }

    public boolean isBool_ativo() {
        return bool_ativo;
    }

    public void setBool_ativo(boolean bool_ativo) {
        this.bool_ativo = bool_ativo;
    }

    public int getInt_idProf() {
        return int_idProf;
    }

    public void setInt_idProf(int int_idProf) {
        this.int_idProf = int_idProf;
    }
    
    
}
