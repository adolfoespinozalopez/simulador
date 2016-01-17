<%--
    Document   : index
    Created on : 29/12/2015
    Author     : Adolfo
--%>
<%@page import="com.pss.simulador.web.controller.LoginController"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Simulador | BBVA Continental</title>
        <link rel="shortcut icon" href="${facesContext.externalContext.requestContextPath}/img/favicon.ico"/>
    </head>
    <c:if test="${not empty loginController and loginController.logueado}">
        <jsp:forward page="/home.jsf"/>
    </c:if>
    <c:if test="${empty loginController or (not loginController.logueado)}">
        <jsp:forward page="/seguridad/frmLogin.jsf"/>
    </c:if>
</html>
