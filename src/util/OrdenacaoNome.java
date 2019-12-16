package util;

import model.Pessoa;

public class OrdenacaoNome extends Ordenacao {
    OrdenacaoTerceirizada ot;
    public OrdenacaoNome() {
        ot = new OrdenacaoTerceirizada();
    }
    // Classe alem de conter o padrão theplate é adpter do metodo de cmparação terceirizado
    @Override
    public boolean compare(Pessoa pes01, Pessoa pes02) {
        return ot.compare(pes01, pes02, false);
    }
    
}
