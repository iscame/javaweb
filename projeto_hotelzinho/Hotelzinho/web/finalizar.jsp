<%-- 
    Document   : finalizar
    Created on : 21/07/2020, 11:16:32
    Author     : Isis Carolina
--%>

<%
    /*
        DESTRIUR A SESSÃO
    */

    session.invalidate();
    response.sendRedirect("/Hotelzinho/index.jsp");
%>
