package util;

import model.Pessoa;

public class NoLista {
    private Pessoa pessoaInfo;
    private NoLista prox;

    public NoLista(Pessoa pessoa, NoLista no) {
        this.pessoaInfo = pessoa;
        this.prox = no;
    }

    public Pessoa getPessoaInfo() {
        return pessoaInfo;
    }

    public void setPessoaInfo(Pessoa pessoaInfo) {
        this.pessoaInfo = pessoaInfo;
    }

    public NoLista getProx() {
        return prox;
    }

    public void setProx(NoLista prox) {
        this.prox = prox;
    }
}
