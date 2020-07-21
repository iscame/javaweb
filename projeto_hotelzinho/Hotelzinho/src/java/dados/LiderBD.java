/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import classes.Lider;
import java.io.File;
import java.util.ArrayList;
import java.io.FileWriter;

/*
    Necessario fazer Download da biblioteca XStream e importar no projeto:
    1- Extrai o zip na pasta do projeto;
    2- Em Bibliotecas, clica em "adicionar JAR\Pasta" e procura na pasta "xstream-1.4.12\lib" o arquivo "xstream-1.4.12.jar";
    3- Clica novamente em "adicionar JAR\Pasta" e procura "xstream-1.4.12\lib\xstream" e seleciona todo o conteudo;
*/
import com.thoughtworks.xstream.XStream;

/**
 *
 * @author Isis Carolina
 * Classe de Banco de Dados
 */
public class LiderBD {
    
    /*
        Simular Banco de Dados com Vetor
    */
    private static ArrayList<Lider> lista = new ArrayList<Lider>();
    
    /*
        Caminho onde salva arquivo Xml
    */
    private static String caminho = "C:\\Users\\Isis Carolina\\javaweb\\projeto_hotelzinho\\xml\\";
    
    /*
        Métodos da Classe
    */
    public static void inserir(Lider novoLider){
        lerXml();
        lista.add(novoLider);
        salvarXml();
    }
    
    public static void alterar(Lider updadeLider){
     
        //Exclui o antigo
        excluir(updadeLider.getCpf());
        
        //Adiciona o novo
        inserir(updadeLider);
    }
    
    public static void excluir(String cpf){
        
        lerXml();
        
        //Buscar pelo cpf
        for(int i=0; i < lista.size(); i++){
            
            //Pega cada lider
            Lider lider = lista.get(i);
            
            //Compara
            if(lider.getCpf().equals(cpf)){
                
                //Se for igual, remove.
                lista.remove(i);
                break;
            };
        }
        
        salvarXml();
    }
    
    public static ArrayList<Lider> listar(){
        lerXml();
        return lista;
    }
    
    
    public static Lider buscarCpf(String cpf){
        lerXml();
        
        //Buscar pelo cpf
        for(int i=0; i < lista.size(); i++){
            
            //Pega cada lider
            Lider lider = lista.get(i);
            
            //Compara
            if(lider.getCpf().equals(cpf)){
                
                //Se for igual, remove.
                return lider;
            };
        }
        
        return null;
    }
    
    /*
        Atribui dados do Xml ao Vetor<lista>
    */
    public static void lerXml(){
        
        //Cria um arquivo Xml
        File arquivo = new File(caminho + "lideres.xml");
        
        //Se o arquivo existir, ler os dados e salva no arquivo.
        if(arquivo.exists()){
            
            //Armazena Xml no Vetor
            XStream xstream = new XStream();
            
            //Apelido 
            xstream.alias("lider", Lider.class);
            
            //Converte Xml em Objeto da classe Lider
            lista = (ArrayList<Lider>) xstream.fromXML(arquivo);
            
        }else{
            
            //Se não existir, cria uma lista vazia.
            lista = new ArrayList<Lider>();
        }
    }
    
    /*
        Atribui dados do Vetor<lista> e atribui ao Xml
    */
    public static void salvarXml(){
        
        //Cria Obj da Classe XStream
        XStream xstream = new XStream();
        xstream.alias("lider", Lider.class);
        
        try{
            
            //Classe FileWriter "escreve" em arquivo
            FileWriter escreve = new FileWriter(caminho + "lideres.xml");
            
            //Escreve em Xml a lista de Obj 
            escreve.write(xstream.toXML(lista));
            
            //Fecha arquivo
            escreve.close();
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
