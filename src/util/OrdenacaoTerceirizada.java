package util;

import model.Pessoa;

public class OrdenacaoTerceirizada {

    public OrdenacaoTerceirizada() {
    }
    
    public boolean compare(Pessoa pes01, Pessoa pes02, boolean ordenacaoReversa) {
        if(ordenacaoReversa) {
            return pes01.getPes_nome().compareToIgnoreCase(pes02.getPes_nome()) < 0;
        }
        return pes01.getPes_nome().compareToIgnoreCase(pes02.getPes_nome()) > 0;
    }
}
