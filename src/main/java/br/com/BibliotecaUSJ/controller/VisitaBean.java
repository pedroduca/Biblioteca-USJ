
package br.com.BibliotecaUSJ.controller;

import br.com.BibliotecaUSJ.DAO.ProfessorDAO;
import br.com.BibliotecaUSJ.DAO.model.Professor;
import br.com.BibliotecaUSJ.DAO.model.Usuarios;
import br.com.BibliotecaUSJ.DAO.model.Visita;
import br.com.BibliotecaUSJ.DAO.usuarioDAO;
import br.com.BibliotecaUSJ.DAO.visitaDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class VisitaBean {
    
    private String nomeProfessor;
    
    private ProfessorDAO professorDAO = new ProfessorDAO();
    
    private int qtdAlunos;    
    
    private String observacoes; 

    private visitaDAO visitaDAO = new visitaDAO();  

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public int getQtdAlunos() {
        return qtdAlunos;
    }

    public void setQtdAlunos(int qtdAlunos) {
        this.qtdAlunos = qtdAlunos;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    public Professor buscarProfessor()
    {
           List<Professor> listaProfessor = professorDAO.buscarProfessor();
        if(listaProfessor != null && listaProfessor.size() > 0){
           for(Professor professor: listaProfessor)
           {
            
               if(professor.getStr_nome().toUpperCase().equals(nomeProfessor.toUpperCase()))
               {
               return professor;
               }
           }
            return null;
        }
        return null;        
  
    }
    
     public String salvarVisita(){
         Visita visita = new Visita();
         visita.setInt_alunos(qtdAlunos);
         visita.setStr_observacao(observacoes);
         Professor professor = buscarProfessor();
         if(professor != null){
             visita.setProfessor(professor);
             visitaDAO.salvarUsuario(visita);
         }
         
        return "";
    }  
    
}
