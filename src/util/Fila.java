package util;

import model.Disciplina;

public class Fila {
    private NoFila inicio;
    private NoFila fim;

    public Fila() {
        this.inicio = null;
        this.fim = null;
    }
    
    public boolean vazia() {
        return inicio == null;
    }
    
    public void enfileirar(Disciplina disc) {
        NoFila no = new NoFila(disc, null);
        
        if(vazia()) {
            inicio = fim = no;
        }
        else {
            fim.setProx(no);
            fim = no;
        }
    }
    
    public Disciplina desinfileirar() {
        if(vazia()) {
            return null;
        }
        
        Disciplina disc = inicio.getInfo();
        NoFila aux = inicio;
        inicio = inicio.getProx();
        
        if(inicio == null) {
            return null;
        }
        
        aux.setProx(null);
        return disc;
    }

    public NoFila getInicio() {
        if(vazia()) {
            return null;
        }
        return inicio;
    }
}
