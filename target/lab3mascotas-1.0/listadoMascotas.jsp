<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Mascotas</title>
    </head>
    <body>
        <h1>Listado de Mascotas: </h1>
        <ul>
            <c:forEach items="${mascotas}" var="mascota">
                <li> ${mascota.tipo} ${mascota.nombre}</li>
            </c:forEach>
        </ul>
    </body>
</html>
