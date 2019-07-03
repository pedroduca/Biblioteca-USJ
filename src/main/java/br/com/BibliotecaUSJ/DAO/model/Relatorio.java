package br.com.BibliotecaUSJ.DAO.model;


import java.util.Date;
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
public class Relatorio {
    
    private int int_livrosEmprestados, int_livrosDevolvidos,int_livrosEtiquetados,int_etiquetasArrumadas,
            int_tccCatalogados, int_negativasRetiradas, int_idRelatorio;
    
    private Date dt_relatorio;
    

    public Date getDt_relatorio() {
        return dt_relatorio;
    }

    public void setDt_relatorio(Date dt_relatorio) {
        this.dt_relatorio = dt_relatorio;
    }

    
    
    public int getInt_livrosEmprestados() {
        return int_livrosEmprestados;
    }

    public void setInt_livrosEmprestados(int int_livrosEmprestados) {
        this.int_livrosEmprestados = int_livrosEmprestados;
    }

    public int getInt_livrosDevolvidos() {
        return int_livrosDevolvidos;
    }

    public void setInt_livrosDevolvidos(int int_livrosDevolvidos) {
        this.int_livrosDevolvidos = int_livrosDevolvidos;
    }
    
    public int getInt_livrosEtiquetados() {
        return int_livrosEtiquetados;
    }

    public void setInt_livrosEtiquetados(int int_livrosEtiquetados) {
        this.int_livrosEtiquetados = int_livrosEtiquetados;
    }

    public int getInt_etiquetasArrumadas() {
        return int_etiquetasArrumadas;
    }

    public void setInt_etiquetasArrumadas(int int_etiquetasArrumadas) {
        this.int_etiquetasArrumadas = int_etiquetasArrumadas;
    }

    public int getInt_tccCatalogados() {
        return int_tccCatalogados;
    }

    public void setInt_tccCatalogados(int int_tccCatalogados) {
        this.int_tccCatalogados = int_tccCatalogados;
    }

    public int getInt_negativasRetiradas() {
        return int_negativasRetiradas;
    }

    public void setInt_negativasRetiradas(int int_negativasRetiradas) {
        this.int_negativasRetiradas = int_negativasRetiradas;
    }

    public int getInt_idRelatorio() {
        return int_idRelatorio;
    }

    public void setInt_idRelatorio(int int_idRelatorio) {
        this.int_idRelatorio = int_idRelatorio;
    }


 
    
    
    
}
