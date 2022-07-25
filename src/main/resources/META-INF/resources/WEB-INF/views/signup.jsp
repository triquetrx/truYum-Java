<%@include file="commons/head.jspf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<style>
form i {
	color: #4056F4;
	font-size: 0.9rem;
}
form i:hover{
    cursor: pointer;
	color: #4056F4;
    text-decoration: underline;
}
</style>

<section class="vh-100">
	<div class="container py-5 h-100">
		<div
			class="row d-flex align-items-center justify-content-center h-100">
			<div class="col-md-8 col-lg-7 col-xl-6">
				<img src="images/signup.png" class="img-fluid" alt="Sign Up image">
			</div>
			<div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
				<form:form cssClass="form-signin" method="post"
					modelAttribute="newUser">
					<div class="form-outline mb-4">
						<form:label path="userFirstName" cssClass="sr-only">Your First Name</form:label>
						<form:input cssClass="form-control" path="userFirstName"
							placeholder="First Name" required="required" autofocus="true" />
						<form:errors cssClass="text-danger" path="userFirstName" />
					</div>

					<div class="form-outline mb-4">
						<form:label path="userLastName" cssClass="sr-only">Your Last Name</form:label>
						<form:input cssClass="form-control" path="userLastName"
							placeholder="Last Name" />
					</div>

					<div class="form-outline mb-4">
						<form:label path="username" cssClass="sr-only">Username</form:label>
						<form:input path="username" class="form-control"
							placeholder="Username" required="required" />
						<form:errors cssClass="text-danger" path="username" />
					</div>

					<!-- Password input -->
					<div class="form-outline mb-4">
						<form:label path="password" class="sr-only">Password</form:label>
						<form:input type="password" path="password" class="form-control"
							placeholder="Password" required="required" id="password" />
						<i class="d-flex justify-content-end" id="togglePassword">Toggle password visibility</i>
						<form:errors cssClass="text-danger" path="password" />
					</div>

					<div class="d-flex justify-content-start align-items-center mb-4">
						<a href="/login">Already have an account</a>
					</div>

					<!-- Submit button -->
					<button type="submit" class="btn btn-primary btn-lg btn-block">Sign
						up</button>

				</form:form>
			</div>
		</div>
	</div>
</section>

<script>
    const togglePassword = document.querySelector('#togglePassword');
    const password = document.querySelector('#password');
    togglePassword.addEventListener('click', () => {
        const type = password
            .getAttribute('type') === 'password' ?
            'text' : 'password';
    	password.setAttribute('type', type);
    });
</script>

</body>
</html>
