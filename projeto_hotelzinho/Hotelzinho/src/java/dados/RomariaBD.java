/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import classes.Romaria;
import java.util.ArrayList;

/**
 *
 * @author Isis Carolina
 * Classe de Banco de Dados
 */
public class RomariaBD {
    
    /*
        Simular Banco de Dados com Vetor
    */
    private static ArrayList<Romaria> lista = new ArrayList<Romaria>();
    
    /*
        Métodos da Classe
    */
    public static void inserir(Romaria novoRomaria){
        lista.add(novoRomaria);
    }
    
    public static void alterar(Romaria updadeRomaria){
     
        //Exclui o antigo
        excluir(updadeRomaria.getCodigo());
        
        //Adiciona o novo
        inserir(updadeRomaria);
    }
    
    public static void excluir(int codigo){
        
        //Buscar pelo cpf
        for(int i=0; i < lista.size(); i++){
            
            //Pega cada lider
            Romaria romaria = lista.get(i);
            
            //Compara
            if(romaria.getCodigo() == codigo){
                
                //Se for igual, remove.
                lista.remove(i);
                break;
            };
        }
    }
    
    public static ArrayList<Romaria> listar(){
        return lista;
    }
}
