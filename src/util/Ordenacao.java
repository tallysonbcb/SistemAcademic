package util;

import java.util.ArrayList;
import java.util.Iterator;
import model.Pessoa;

public abstract class Ordenacao implements ServicoOrdenacao{

    public Ordenacao() {
    }
    
    @Override
    public abstract boolean compare(Pessoa pes01, Pessoa pes02);
    
    public Iterator<Pessoa> ordenar(ArrayList<Pessoa> listaPessoa) {
        for(int i = 0; i < listaPessoa.size(); i++) {
            for(int j = i + 1; j < listaPessoa.size(); j++) {
                if(compare(listaPessoa.get(i), listaPessoa.get(j))) {
                    Pessoa aux = listaPessoa.get(i);
                    listaPessoa.set(i, listaPessoa.get(j));
                    listaPessoa.set(j, aux);
                }
            }
        }
        return listaPessoa.iterator();
    }
}
