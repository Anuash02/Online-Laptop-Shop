<%@ page language="java" contentType="text/html"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="index.jsp"%>

<form:form action="InsertSupplier" modelAttribute="supplier">
<table align="center">
                      <tr>
                           <td colspan="2"><center>Supplier Details</center></td>
                     </tr>
                      
                      <tr>
                          <td>Supplier ID</td>
                          <td><form:input path="supid" /></td>
                      </tr>
                      
                      <tr>
                           <td>Supplier Name</td>
                           <td><form:input path="supname" /></td>
                           
                      </tr>
                      
                      <tr>
                     <td>Supplier Address</td>
                           <td><form:input path="address" /></td>
                     </tr>
                     
</table>
</form:form>