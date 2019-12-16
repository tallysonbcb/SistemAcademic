/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import model.Pessoa;

/**
 *
 * @author JON
 */
public class OrdenacaoBolha {
    
 public void bolha(ArrayList<Pessoa> vet) {
        int i, j;
        Pessoa aux;
        boolean troca = false;
        for (i = vet.size()- 1; i > 0; i--) {
            troca = false;
            for (j = 0; j < i; j++) {
                if (vet.get(j).getPes_nome().compareToIgnoreCase(vet.get(j + 1).getPes_nome()) > 0) {
                    aux = vet.get(j);
                    vet.add(j, vet.get(j+1));
                    vet.remove(j+1);
                    vet.add(j+1, aux);
                    vet.remove(j+2);
                    troca = true;
                }
            }
            if (!troca) {
                return;
            }
        }
    }

}

