package util;

import model.Pessoa;

public interface ServicoOrdenacao {
    boolean compare(Pessoa pes01, Pessoa pes02);
}
