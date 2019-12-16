package util;

import model.Pessoa;

public class Lista {
    
    private NoLista inicio;
    private NoLista fim;

    public Lista() {
        inicio = null;
        fim = null;
    }
    
    public boolean vazia() {
        return inicio == null;
    }
    
    public NoLista getInicio() {
        if(vazia()) {
            return null;
        }
        return inicio;
    }
    
    public void insereInicio(Pessoa info) {
        NoLista no = new NoLista(info, null);
        
        if(vazia()) {
            inicio = fim = no;
        }
        else {
            no.setProx(inicio);
            inicio = no;
        }
    }
    
    public void insereFim(Pessoa info) {
        NoLista no = new NoLista(info, null);
        
        if(vazia()) {
            inicio = fim = no;
        }
        else {
            fim.setProx(no);
            fim = no;
        }
    }
    
    public void insereOrdenado(Pessoa info) {
        NoLista no = new NoLista(info, null);
        NoLista anterior = null;
        NoLista atual = inicio;
        
        while(atual != null && no.getPessoaInfo().getPes_nome().compareToIgnoreCase(atual.getPessoaInfo().getPes_nome()) > 0) {
            anterior = atual;
            atual = atual.getProx();
        }
        
        if(atual == null) {
            insereFim(info);
        }
        else {
            if(anterior == null) {
                insereInicio(info);
            }
            else {
                anterior.setProx(no);
                no.setProx(atual);
            }
        }
    }
}
