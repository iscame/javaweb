<%-- 
    Document   : sessao
    Created on : 21/07/2020, 11:11:58
    Author     : Isis Carolina
--%>
<%@page import="classes.Funcionario"%>

<%
    /*
        TESTA SESSÃO, SE EXISTE OU NÃO USUARIO LOGADO NO SISTEMA
    */
    
    Funcionario logado = null;
    
    //Pega o valor da variavel de sessão criada em logar
    if(session.getAttribute("funcionario") != null){
        
        //Converte valor da session em obj
        logado = (Funcionario) session.getAttribute("funcionario");
    }else{
        response.sendRedirect("../index.jsp");
    }
%>