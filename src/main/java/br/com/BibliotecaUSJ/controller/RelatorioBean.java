package br.com.BibliotecaUSJ.controller;

import br.com.BibliotecaUSJ.DAO.ProfessorDAO;
import br.com.BibliotecaUSJ.DAO.RelatorioDAO;
import br.com.BibliotecaUSJ.DAO.model.Professor;
import br.com.BibliotecaUSJ.DAO.model.Relatorio;
import br.com.BibliotecaUSJ.DAO.model.Usuarios;
import br.com.BibliotecaUSJ.DAO.model.Visita;
import br.com.BibliotecaUSJ.DAO.usuarioDAO;
import br.com.BibliotecaUSJ.DAO.visitaDAO;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class RelatorioBean {
    
    private int livrosEmprestados;
    private int livrosDevolvidos;
    private int livrosEtiquetados;
    private int etiquetasArrumadas;
    private int tccCatalogados;
    private int negativasRetiradas;

private RelatorioDAO relatorioDAO = new RelatorioDAO();

    public int getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void setLivrosEmprestados(int livrosEmprestados) {
        this.livrosEmprestados = livrosEmprestados;
    }

    public int getLivrosDevolvidos() {
        return livrosDevolvidos;
    }

    public void setLivrosDevolvidos(int livrosDevolvidos) {
        this.livrosDevolvidos = livrosDevolvidos;
    }  

    public int getLivrosEtiquetados() {
        return livrosEtiquetados;
    }

    public void setLivrosEtiquetados(int livrosEtiquetados) {
        this.livrosEtiquetados = livrosEtiquetados;
    }

    public int getEtiquetasArrumadas() {
        return etiquetasArrumadas;
    }

    public void setEtiquetasArrumadas(int etiquetasArrumadas) {
        this.etiquetasArrumadas = etiquetasArrumadas;
    }

    public int getTccCatalogados() {
        return tccCatalogados;
    }

    public void setTccCatalogados(int tccCatalogados) {
        this.tccCatalogados = tccCatalogados;
    }

    public int getNegativasRetiradas() {
        return negativasRetiradas;
    }

    public void setNegativasRetiradas(int negativasRetiradas) {
        this.negativasRetiradas = negativasRetiradas;
    }
    
 public String salvarRelatorio(){
         Relatorio relatorio = new Relatorio();
         relatorio.setInt_etiquetasArrumadas(etiquetasArrumadas);
         relatorio.setInt_livrosDevolvidos(livrosDevolvidos);
         relatorio.setInt_livrosEmprestados(livrosEmprestados);
         relatorio.setInt_livrosEtiquetados(livrosEtiquetados);
         relatorio.setInt_negativasRetiradas(negativasRetiradas);
         relatorio.setInt_tccCatalogados(tccCatalogados);
         relatorio.setDt_relatorio(new Date(System.currentTimeMillis()));
         relatorioDAO.salvarRelatorio(relatorio);         
        return "";
   } 
}
