/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karaoke.model;

public class UltimoResultado {
    String apelidoCantor;
    Double nota;

    public UltimoResultado(String apelidoCantor, Double nota) {
        this.apelidoCantor = apelidoCantor;
        this.nota = nota;
    }

    public String getApelidoCantor() {
        return apelidoCantor;
    }

    public void setApelidoCantor(String apelidoCantor) {
        this.apelidoCantor = apelidoCantor;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
    
    
    
    
}
