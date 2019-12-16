package util;

import model.Curso;

public class NoPilha {
    private Curso info;
    private NoPilha prox;

    public NoPilha(Curso info, NoPilha prox) {
        this.info = info;
        this.prox = prox;
    }

    public Curso getInfo() {
        return info;
    }

    public void setInfo(Curso info) {
        this.info = info;
    }

    public NoPilha getProx() {
        return prox;
    }

    public void setProx(NoPilha prox) {
        this.prox = prox;
    }
}
