<%-- 
    Document   : listar
    Created on : 20/07/2020, 22:32:34
    Author     : Isis Carolina
--%>

<%@page import="classes.Funcionario"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="classes.Lider"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dados.LiderBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--INCLUI A VARIAVEL DE SESSAO-->
<%@include file="/sessao.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Lideres</title>
    </head>
    <body>
        
        <!--Inclui o Menu-->
        <jsp:include page="../menu.jsp"></jsp:include>
        
        <h3>Lista de Lideres</h3>
        
        <table border="1">
            <thead>
                <th>Nome</th>
                <th>Cpf</th>
                <th>Data Nascimento</th>
                <th>Cidade</th>
                <th>Estado</th>
                <th>Acao</th>
            </thead>
            <tbody>
                <%
                    //SimpleDateFormat formata campo data de Date para String
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    
                    //Retorna um array
                    ArrayList<Lider> lideres = LiderBD.listar();
                    
                    //Percorre o array
                    for(int i=0; i < lideres.size(); i++){
                        
                        String data = "";
                        
                        //Obj lider
                        Lider posicao = lideres.get(i);
                        
                        //Verifica de campo dtnascimento é vazio
                        if(posicao.getDtnascimento() != null){
                            
                            //Se não for, aplica a formatação da data 
                            data = formato.format(posicao.getDtnascimento());
                        }
                        
                        %>
                        <tr>
                            <td><%=posicao.getNome()%>   </td>
                            <td><%=posicao.getCpf()%>    </td>
                            <td><%=data%>                </td>
                            <td><%=posicao.getCidade()%> </td>
                            <td><%=posicao.getEstado()%> </td>
                            <td>
                                <a href="cadastrar.jsp?cpf=<%=posicao.getCpf()%>">Alterar</a>
                                <a href="excluir.jsp?cpf=<%=posicao.getCpf()%>" onclick="return confirm('Deseja excluir o Lider?')">Excluir</a>
                            </td>
                        </tr>
                        <%
                    }
                %>
                
                
            </tbody>
        </table>
    </body>
</html>
