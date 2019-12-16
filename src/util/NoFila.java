package util;

import model.Disciplina;

public class NoFila {
    private Disciplina info;
    private NoFila prox;

    public NoFila(Disciplina info, NoFila prox) {
        this.info = info;
        this.prox = prox;
    }

    public Disciplina getInfo() {
        return info;
    }

    public void setInfo(Disciplina info) {
        this.info = info;
    }

    public NoFila getProx() {
        return prox;
    }

    public void setProx(NoFila prox) {
        this.prox = prox;
    }
}
