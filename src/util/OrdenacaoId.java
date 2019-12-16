package util;

import model.Pessoa;

public class OrdenacaoId extends Ordenacao {

    public OrdenacaoId() {
    }

    @Override
    public boolean compare(Pessoa pes01, Pessoa pes02) {
        return pes01.getPes_iden().compareToIgnoreCase(pes02.getPes_iden()) > 0;
    }
    
}
