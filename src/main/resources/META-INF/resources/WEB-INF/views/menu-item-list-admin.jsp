<%@include file="commons/head.jspf"%>
<%@include file="commons/navbar-admin.jspf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container py-2">
	<h2 class="my-3">Menu Items</h2>
	<table class="table">
		<thead>
			<tr>
				<th>Name</th>
				<th>Price</th>
				<th>Active</th>
				<th>Date of Launch</th>
				<th>Category</th>
				<th>Free Delivery</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${menuList}" var="menu">
				<tr>
					<td>${menu.getName()}</td>
					<td>${menu.getPrice()}</td>
					<td>
						<c:if test="${menu.isActive()}">Yes</c:if>
						<c:if test="${not menu.isActive()}">No</c:if>						
					</td>
					<td>${menu.getDateOfLaunch()}</td>
					<td>${menu.getCategory()}</td>
					<td>
						<c:if test="${menu.isFreeDelivery()}">Yes</c:if>
						<c:if test="${not menu.isFreeDelivery()}">No</c:if>						
					</td>
					<td><a href="/edit-admin?id=${menu.getItemId()}">Edit</a></td>
				</tr>
			</c:forEach>
		</tbody>	
	</table>
</div>
<%@include file="commons/footer.jspf"%>
<%@include file="commons/end-admin.jspf"%>