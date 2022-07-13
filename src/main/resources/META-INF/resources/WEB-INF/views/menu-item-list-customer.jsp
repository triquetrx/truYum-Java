<%@include file="commons/head.jspf"%>
<%@include file="commons/navbar.jspf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container py-2">
	<h2 class="my-3">Menu Items</h2>
	<div class="d-flex justify-content-center">
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Free Delivery</th>
					<th>Price</th>
					<th>Category</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${menuCustomer}" var="menu">
			<c:if test="${menu.getIsActive()}">			
				<tr>
					<td>${menu.getName()}</td>
					<td>
						<c:if test="${menu.getIsFreeDelivery()}">Yes</c:if>
						<c:if test="${not menu.getIsFreeDelivery()}">No</c:if>						
					</td>
					<td>${menu.getPrice()}</td>
					<td>${menu.getCategory()}</td>
					<td><a href="/add-to-cart?id=${menu.getItemId()}">Add To Cart</a></td>
				</tr>
			</c:if>
			</c:forEach>
		</tbody>	
		</table>
	</div>
</div>
<%@include file="commons/footer.jspf"%>
<%@include file="commons/end.jspf"%>