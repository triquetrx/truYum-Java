<%@include file="commons/head.jspf"%>
<%@include file="commons/navbar-admin.jspf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container p-3">
	<h2>Add Menu Item</h2>
	<form:form cssClass="my-2 py-2" method="POST" modelAttribute="newItem">
		<div class="form-group">
			<form:label path="name">Name</form:label>
			<form:input cssClass="form-control" path="name" />
			<form:errors cssClass="text-warning" path="name"/>
		</div>
		<div class="row">
		<div class="form-group col-md">
			<form:label path="price">Price</form:label>
			<form:input cssClass="form-control" path="price" />
			<form:errors cssClass="text-warning" path="price"/>
		</div>
		<div class="form-group col-md">
			<form:label path="isActive">Active</form:label>
			<form:select cssClass="form-control" path="isActive" items="${activeList}"/>
		</div>
		<div class="form-group col-md">
			<form:label path="dateOfLaunch">Date of Launch</form:label>
			<form:input cssClass="form-control" type="date" path="dateOfLaunch" />
			<form:errors cssClass="text-warning" path="dateOfLaunch"/>
		</div>
		<div class="form-group col-md">
			<form:label path="category">Category</form:label>
			<form:select cssClass="form-control" path="category" items="${categoryList}"/>
			<form:errors cssClass="text-warning" path="category"/>
		</div>
		</div>
		<div class="form-check">
			<form:checkbox cssClass="form-check-input" id="freeDelivery" path="isFreeDelivery" />
			<form:label path="isFreeDelivery" for="freeDelivery" cssClass="form-check-label">Free Delivery</form:label>
		</div>
		<br/>
		<form:button name="submit" id="btn">Submit</form:button>
	</form:form>
</div>

<%@include file="commons/footer.jspf"%>
<%@include file="commons/end-admin.jspf"%>