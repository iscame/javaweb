<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        <!--TITULO-->
        <div style="font-size: 16pt">Projeto a nivel de Aprendizado: Hotelzinho</div>
        
        <!--MENSAGEM DE ERROR-->
        <div style="color: red">
            <%
                String error = request.getParameter("error");

                if(error != null){
                    if(error.equals("NAO_EXISTE")){
                        out.println("Usuario Nao Existe!");
                    }
                }
            %>
        </div>
        
        <!--FORMULARIO DE LOGIN-->
        <form name="formLogin" method="post" action="logar.jsp">
            
            <table>
                <tr>
                    <td>Login: </td>
                    <td><input type="text" name="login"/></td>
                </tr>
                <tr>
                    <td>Senha: </td>
                    <td><input type="text" name="senha"/></td>
                </tr>
                <tr>
                    <td><input type="submit" name="entrar" value="Entrar"/></td>
                </tr>
            </table>
            
        </form>
    </body>
</html>
