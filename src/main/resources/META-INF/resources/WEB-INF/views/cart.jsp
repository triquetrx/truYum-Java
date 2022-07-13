<%@include file="commons/head.jspf"%>
<%@include file="commons/navbar.jspf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container py-2">
	<h2 class="my-3">Cart Items</h2>
	<table class="table">
		<thead>
			<tr>
				<th>Name</th>
				<th>Free Delivery</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cartProduct}" var="item">
				<tr>
					<td>${item.getMenu().getName()}</td>
					<td>
						<c:if test="${item.getMenu().getIsFreeDelivery()}">Yes</c:if>
						<c:if test="${not item.getMenu().getIsFreeDelivery()}">No</c:if>	
					</td>
					<td>${item.getMenu().getPrice()}</td>
					<td>
						<a href="/delete_cart_item?cartid=${item.getCart_id()}">Delete</a>
					</td>
					<td>
						<a href="/order?cart_item_id=${item.getCart_id()}">Order</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<%@include file="commons/footer.jspf"%>
<%@include file="commons/end.jspf"%>