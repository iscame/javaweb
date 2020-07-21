<%-- 
    Document   : cadastrar
    Created on : 20/07/2020, 22:08:11
    Author     : Isis Carolina
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="dados.LiderBD"%>
<%@page import="classes.Lider"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--INCLUI A VARIAVEL DE SESSAO-->
<%@include file="/sessao.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Lideres</title>
    </head>
    <body>
        
        <!--Inclui o Menu-->
        <jsp:include page="../menu.jsp"></jsp:include>
        
        <h3>Cadastro de Lideres</h3>
        
        <%
            //Busca e Atribui os dados, caso seja para "alterar".
            Lider lider = null;
            
            String cpf = request.getParameter("cpf");
            
            //Se vier cpf como parametro via url
            if(cpf != null){
                lider = LiderBD.buscarCpf(cpf);
            }else{
                lider = new Lider();
            }
            
            //Tratamento formato campo data
            String data = "";
            if(lider.getDtnascimento() != null){
                SimpleDateFormat formato  = new SimpleDateFormat("dd/MM/yyyy");
                data = formato.format(lider.getDtnascimento());
            }
            
            //Trata campo estado caso seja nulo
            String estado = "PE";
            if(lider.getEstado() != null){
                estado = lider.getEstado();
            }
        %>
        
        <form name="formCadastro" method="post" action="salvar.jsp">
            <table>
                <tr>
                    <td>Nome: </td>
                    <td>
                        <input type="text" name="nome" value="<%=lider.getNome()%>">
                    </td>
                </tr>
                <tr>
                    <td>CPF: </td>
                    <td>
                        <input type="text" name="cpf" value="<%=lider.getCpf()%>">
                    </td>
                </tr>
                <tr>
                    <td>Data Nascimento: </td>
                    <td>
                        <input type="text" name="dtnascimento" value="<%=data%>">
                    </td>
                </tr>
                <tr>
                    <td>Telefone: </td>
                    <td>
                        <input type="text" name="telefone" value="<%=lider.getTelefone()%>">
                    </td>
                </tr>
                <tr>
                    <td>Cidade: </td>
                    <td>
                        <input type="text" name="cidade" value="<%=lider.getCidade()%>">
                    </td>
                </tr>
                <tr>
                    <td>Estado: </td>
                    <td>
                        <select name="estado">
                            <option value="PE" <% if(estado.equals("PE")) out.println("selected");%>>Pernambuco</option>
                            <option value="SP" <% if(estado.equals("SP")) out.println("selected");%>>Sao Paulo</option>
                            <option value="MG" <% if(estado.equals("MG")) out.println("selected");%>>Minas Gerais</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" name="salvar" value="Salvar">
                    </td>
                    <td>
                        <input type="hidden" name="tipoForm" value="<%=cpf%>">
                    </td>
                </tr>
            </table>
        </form>
        
    </body>
</html>
