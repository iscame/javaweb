/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import classes.Funcionario;
import dados.FuncionarioBD;

/**
 *
 * @author Isis Carolina
 */
public class TesteLogin {
    
    /*
        TESTE PARA CADASTRAR FUNCIONARIO
    */
    public static void main(String[] args) {
        
        Funcionario funcionario = new Funcionario();
        funcionario.setLogin("isis");
        funcionario.setSenha("123");
        funcionario.setCodigo(1);
        FuncionarioBD.inserir(funcionario);
    }
}
