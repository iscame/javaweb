<%-- 
    Document   : excluir
    Created on : 20/07/2020, 22:55:43
    Author     : Isis Carolina
--%>

<%@page import="dados.LiderBD"%>

<%
    //Pega o valor passado na url
    String cpf = request.getParameter("cpf");
    
    //Excluir
    LiderBD.excluir(cpf);
    
    //Retorna para lista
    response.sendRedirect("listar.jsp");
%>
