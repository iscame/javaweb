<%-- 
    Document   : logar
    Created on : 21/07/2020, 10:21:50
    Author     : Isis Carolina
--%>

<%@page import="classes.Funcionario"%>
<%@page import="dados.FuncionarioBD"%>

<%
    String login = request.getParameter("login");
    String senha = request.getParameter("senha");
    
    //Chama m�todo da classe
    Funcionario logado = FuncionarioBD.buscarLogin(login, senha);
    
    if(logado != null){
        
        //Cria V�riavel de Sess�o, grava obj na variavel.
        session.setAttribute("funcionario", logado);
        
        //Redireciona para listagem
        response.sendRedirect("lider/listar.jsp");
    }else{
        
        //Se n�o existir, retorna pra login
        response.sendRedirect("index.jsp?error=NAO_EXISTE");
    }
%>
