/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import classes.Lider;
import dados.LiderBD;

/**
 *
 * @author Isis Carolina
 */
public class TesteSalvar {
    
    /*
        Atalho para criar metodo main "psvm + TAB"
    */
    public static void main(String[] args) {
        
        Lider lider = new Lider();
        lider.setNome("Isis Melo");
        lider.setCpf("075");
        
        LiderBD.inserir(lider);
        
        System.out.println("Cadastrado com Sucesso!");
    }
}
