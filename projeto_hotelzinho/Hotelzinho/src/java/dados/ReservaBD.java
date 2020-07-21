/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import classes.Reserva;
import java.util.ArrayList;

/**
 *
 * @author Isis Carolina
 * Classe de Banco de Dados
 */
public class ReservaBD {
    
    /*
        Simular Banco de Dados com Vetor
    */
    private static ArrayList<Reserva> lista = new ArrayList<Reserva>();
    
    /*
        Métodos da Classe
    */
    public static void inserir(Reserva novoReserva){
        lista.add(novoReserva);
    }
    
    public static void alterar(Reserva updadeReserva){
     
        //Exclui o antigo
        excluir(updadeReserva.getCodigo());
        
        //Adiciona o novo
        inserir(updadeReserva);
    }
    
    public static void excluir(int codigo){
        
        //Buscar pelo cpf
        for(int i=0; i < lista.size(); i++){
            
            //Pega cada lider
            Reserva reserva = lista.get(i);
            
            //Compara
            if(reserva.getCodigo() == codigo){
                
                //Se for igual, remove.
                lista.remove(i);
                break;
            };
        }
    }
    
    public static ArrayList<Reserva> listar(){
        return lista;
    }
}
