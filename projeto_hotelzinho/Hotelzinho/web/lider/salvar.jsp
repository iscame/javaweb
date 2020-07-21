<%-- 
    Document   : salvar
    Created on : 20/07/2020, 22:19:12
    Author     : Isis Carolina
--%>

<%@page import="dados.LiderBD"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="classes.Lider"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Lideres</title>
    </head>
    <body>
        
        <%
            //Recebe dados do formulário
            String nome = request.getParameter("nome");
            String cpf = request.getParameter("cpf");
            String dtnascimento = request.getParameter("dtnascimento");
            String telefone = request.getParameter("telefone");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            
            String update = request.getParameter("tipoForm");
            
            //Converte de String para Date
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date data = formato.parse(dtnascimento);
            
            //Obj
            Lider lider;
            if(update != "null"){
                
                //Se vier dados preenchido, altera!
                lider = LiderBD.buscarCpf(update);
                
                lider.setNome(nome);
                lider.setCpf(cpf);
                lider.setDtnascimento(data);
                lider.setTelefone(telefone);
                lider.setCidade(cidade);
                lider.setEstado(estado);
                
                //Altera
                LiderBD.alterar(lider);
                out.println("Líder Alterado com Sucesso!");
                
            }else{
                //Se vier vazio, cria novo!
                lider = new Lider();
                
                lider.setNome(nome);
                lider.setCpf(cpf);
                lider.setDtnascimento(data);
                lider.setTelefone(telefone);
                lider.setCidade(cidade);
                lider.setEstado(estado);

                //Salvar
                LiderBD.inserir(lider);
                out.println("Líder Cadastrado com Sucesso!");
            }
            
        %>
        
        </br>
        <a href="listar.jsp">Listar</a>
        
    </body>
</html>
