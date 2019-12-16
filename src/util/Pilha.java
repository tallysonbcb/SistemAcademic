package util;

import model.Curso;

public class Pilha {
    private NoPilha ultimo;

    public Pilha() {
        ultimo = null;
    }
    
    public boolean vazia() {
        return ultimo == null;
    }
    
    public void empilhar(Curso curso) {
        NoPilha no = new NoPilha(curso, null);
        if(vazia()) {
            ultimo = no;
        }
        else {
            no.setProx(ultimo);
            ultimo = no;
        }
    }
    
    public Curso desempilhar() {
        if(vazia()) {
            return null;
        }
        Curso curso = ultimo.getInfo();
        ultimo = ultimo.getProx();
        return curso;
    }
    
    public Curso getUltimo() {
        if(vazia()) {
            return null;
        }
        return ultimo.getInfo();
    }
}
