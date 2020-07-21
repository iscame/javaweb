/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import classes.Funcionario;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author Isis Carolina
 */
public class FuncionarioBD {
    
    /*
        Simular Banco de Dados com Vetor
    */
    private static ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
    
    /*
        Caminho onde salva arquivo Xml
    */
    private static String caminho = "C:\\Users\\Isis Carolina\\javaweb\\projeto_hotelzinho\\xml\\";
    
    /*
        Métodos da Classe
    */
    public static void inserir(Funcionario novoFuncionario){
        lerXml();
        lista.add(novoFuncionario);
        salvarXml();
    }
    
    public static void alterar(Funcionario updadeFuncionario){
     
        //Exclui o antigo
        excluir(updadeFuncionario.getCodigo());
        
        //Adiciona o novo
        inserir(updadeFuncionario);
    }
    
    public static void excluir(int codigo){
        
        lerXml();
        
        //Buscar pelo codigo
        for(int i=0; i < lista.size(); i++){
            
            //Pega cada funcionario
            Funcionario funcionario = lista.get(i);
            
            //Compara
            if(funcionario.getCodigo() == codigo){
                
                //Se for igual, remove.
                lista.remove(i);
                break;
            };
        }
        
        salvarXml();
    }
    
    /*
        Metodo Listar todos
    */
    public static ArrayList<Funcionario> listar(){
        lerXml();
        return lista;
    }
    
    /*
        Metodo busca usando parametro como chave
    */
    public static Funcionario buscarCodigo(int codigo){
        lerXml();
        
        //Buscar pelo codigo
        for(int i=0; i < lista.size(); i++){
            
            //Pega cada funcionario
            Funcionario funcionario = lista.get(i);
            
            //Compara
            if(funcionario.getCodigo() == codigo){
                
                //Se for igual, remove.
                return funcionario;
            };
        }
        
        return null;
    }
    
    /*
        Atribui dados do Xml ao Vetor<lista>
    */
    public static void lerXml(){
        
        //Cria um arquivo Xml
        File arquivo = new File(caminho + "funcionarios.xml");
        
        //Se o arquivo existir, ler os dados e salva no arquivo.
        if(arquivo.exists()){
            
            //Armazena Xml no Vetor
            XStream xstream = new XStream();
            
            //Apelido 
            xstream.alias("funcionario", Funcionario.class);
            
            //Converte Xml em Objeto da classe Lider
            lista = (ArrayList<Funcionario>) xstream.fromXML(arquivo);
            
        }else{
            
            //Se não existir, cria uma lista vazia.
            lista = new ArrayList<Funcionario>();
        }
    }
    
    /*
        Atribui dados do Vetor<lista> e atribui ao Xml
    */
    public static void salvarXml(){
        
        //Cria Obj da Classe XStream
        XStream xstream = new XStream();
        xstream.alias("funcionario", Funcionario.class);
        
        try{
            
            //Classe FileWriter "escreve" em arquivo
            FileWriter escreve = new FileWriter(caminho + "funcionarios.xml");
            
            //Escreve em Xml a lista de Obj 
            escreve.write(xstream.toXML(lista));
            
            //Fecha arquivo
            escreve.close();
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    /*
        Metodo busca usando parametros como chaves
    */
    public static Funcionario buscarLogin(String login, String senha){
        
        lerXml();
        
        Funcionario logado = null;
        
        //Buscar pelo codigo
        for(int i=0; i < lista.size(); i++){
            
            //Pega cada funcionario
            Funcionario funcionario = lista.get(i);
            
            //Compara: obs. para comparar strings usa-se .equals()
            if(funcionario.getLogin().equals(login) && funcionario.getSenha().equals(senha)){
                
                logado = funcionario;
                break;
            }
        }
        
        return logado;
    }
    
}
