<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quan Ly Nhap Xuat</title>
</head>
<body>
<div style="margin-left: 200px">
			<h1>QUAN LY PHIEU</h1>
        <h2>
        	<a href="new">Them moi</a>   	
        </h2>
        <form action="search">
        	<table>
        		<tr>
        			<td colspan="2">
        				<label>Tim Kiem</label>
        			</td>
        		</tr>
        		<tr>
        			<td>
        				<input type="text" placeholder="Search..." name="src"/>
        			</td>
        			<td>
        				<input type="submit" value="search"/>
        			</td>
        		</tr>
        	</table>
        </form>
        
	</div>
	<table>
		<tr>
		<th> ID</th>
		<th> ID Phieu</th>
		<th> Ten</th>
		<th> Loai SP</th>
		<th> Trang Thai </th>
		<th> ID Kho </th>
		<th> ID Cua Hang </th>
		<th> So Luong</th>
		<th> Ngay Thang</th>
		</tr>
		<c:forEach var="phieu" items="${listPhieu}">
			<tr>
			<td> <c:out value="${phieu.id }"></c:out> </td>
			<td> <c:out value="${phieu.tenSP }"></c:out> </td>
			<td> <c:out value="${phieu.loaiSP }"></c:out> </td>
			<td> <c:out value="${phieu.trangThai }"></c:out> </td>
			<td> <c:out value="${phieu.idKho }"></c:out> </td>
			<td> <c:out value="${phieu.idcuaHang }"></c:out> </td>
			<td> <c:out value="${phieu.soLuong }"></c:out> </td>
			<td> <c:out value="${phieu.ngayThang }"></c:out> </td>
			<td>
				<a href="edit?id=<c:out value="${phieu.id }"/>">Edit</a>
				<a href="delete?id=<c:out value="${phieu.id }"/>">Delete</a>
			</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>