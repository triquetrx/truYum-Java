<%@include file="commons/head.jspf"%>

<section class="vh-100">
  <div class="container py-5 h-100">
    <div class="row d-flex align-items-center justify-content-center h-100">
      <div class="col-md-8 col-lg-7 col-xl-6">
        <img src="/images/loginPage.png" class="img-fluid" alt="Login Page image">
      </div>
      <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
         <form class="form-signup" method="post">
          <!-- Username input -->
          <div class="form-outline mb-4">
            <label for="username" class="sr-only">Username</label>
          	<input type="text" id="username" name="username" class="form-control" placeholder="Username" 
          	required autofocus>
          </div>

          <!-- Password input -->
          <div class="form-outline mb-4">
           	<label for="password" class="sr-only">Password</label>
          	<input type="password" id="password" name="password" class="form-control" placeholder="Password" 
          	required>
          </div>

          <div class="mb-4 row">
            <div class="form-check col" style="padding-left:2.3rem">
              <input class="form-check-input" type="checkbox" value="" id="form1Example3" />
              <label class="form-check-label" for="form1Example3"> Remember me </label>
            </div>
            <a class="col d-flex justify-content-end" href="#">Forgot password?</a>
          </div>

          <!-- Submit button -->
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>  
          <button type="submit" class="btn btn-primary btn-lg btn-block" 
          style="backgroud-color: #4056F4">Login</button>

          <div class="divider d-flex align-items-center my-4">
            <p class="text-center fw-bold mx-3 mb-0 text-muted">OR</p>
          </div>

          <a class="btn btn-outline-primary btn-lg btn-block" href="/signup"
            role="button">
            Create new account
          </a>

        </form>
      </div>
    </div>
  </div>
</section>

</body>
</html>

