
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
public class Visita {
    
    private int int_alunos, int_idVisita;
    private Date dt_visita;

    public int getInt_idVisita() {
        return int_idVisita;
    }

    public void setInt_idVisita(int int_idVisita) {
        this.int_idVisita = int_idVisita;
    }

    
    public int getInt_alunos() {
        return int_alunos;
    }

    public void setInt_alunos(int int_alunos) {
        this.int_alunos = int_alunos;
    }

    public Date getDt_visita() {
        return dt_visita;
    }

    public void setDt_visita(Date dt_visita) {
        this.dt_visita = dt_visita;
    }
    
    
}
