<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New book</title>
</head>
<body>
	<center>
		<h1>Phieu Management</h1>
        <h2>
        	<a href="new">Add New</a>
        </h2>
        	</br>
        <h2>
        	<a href="list">List All Phieu</a>
        </h2>
	</center>
	<div>
		<c:if test="${phieu != null }">
			<form action="update" method="post">
		</c:if>
		
		<c:if test="${phieu == null }">
			<form action="insert" method="post">
		</c:if>
		
		<table>
					<caption>
				<b>
					<c:if test="${phieu != null}">Update</c:if>
					<c:if test="${phieu == null}">Insert</c:if>
				</b>
				</caption>
				<c:if test="${phieu != null}">
        			<input type="hidden" name="id" value="<c:out value="${phieu.id}" />" />
        		</c:if> 
        		
        		<tr>
        			<td>Ten SP:</td>
        			<td>
        				<input type="text" name="tenSP" size="45" value="<c:out value="${phieu.tenSP }"/> "/>
        			</td>
        		</tr>
        		<tr>
        			<td>Loai SP:</td>
        			<td>
        				<input type="text" name="loaiSP" size="45" value="<c:out value="${phieu.loaiSP}"/> "/>
        			</td>
        		</tr>
        		<tr>
        			<td>Trang Thai:</td>
        			<td>
        				<input type="text" name="trangThai" size="45" value="<c:out value="${phieu.trangThai}"/> "/>
        			</td>
        		</tr>
        		<tr>
        			<td>ID Kho:</td>
        			<td>
        				<input type="text" name="idKho" size="45" value="<c:out value="${phieu.idKho}"/> "/>
        			</td>
        		</tr>
        		<tr>
        			<td>ID Cua Hang:</td>
        			<td>
        				<input type="text" name="idcuaHang" size="45" value="<c:out value="${phieu.idcuaHang}"/> "/>
        			</td>
        		</tr>
        		<tr>
        			<td>So Luong:</td>
        			<td>
        				<input type="number" name="soLuong" size="45" value="<c:out value="${phieu.soLuong}"/> "/>
        			</td>
        		</tr>
        		<tr>
        			<td>Ngay thang:</td>
        			<td>
        				<input type="text" name="ngayThang" size="45" value="<c:out value="${phieu.ngayThang}"/> "/>
        			</td>
        		</tr>
        		<tr>
        			<td colspan="2">
        				<input type="submit" value="Save" />
        			</td>
        		</tr>
			
		</table>
		</form>
	</div>
</body>
</html>