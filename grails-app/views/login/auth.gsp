<html>
    <head>
        <title>Login</title>
        <asset:stylesheet src="app.min.css"/>
    </head>

    <body >
        <g:if test='${flash.message}'>
            <div class="login_message">${flash.message}</div>
        </g:if>
        <div id="app" class="app app-full-height app-without-header">
            <div class="login">
                <!-- BEGIN login-cover -->
                <div class="login-cover"></div>
                <div class="login-content">
                    <div class="login-brand">
                        %{--<a href="#"><b>Ad</b>metro</a>--}%
                    </div>
                    <form action="${postUrl ?: '/login/authenticate'}" method="POST" id="loginForm" class="form-signin" autocomplete="off">
                        <div class="form-group">
                            <label>Username <span class="text-danger">*</span></label>
                            <input type="text" class="form-control" value="" name="${usernameParameter ?: 'username'}" id="username" />
                        </div>
                        <div class="form-group">
                            <label>Password <span class="text-danger">*</span></label>
                            <input type="password" class="form-control" value="" name="${passwordParameter ?: 'password'}" id="password" placeholder="Senha" />
                        </div>

                        <div class="d-flex align-items-center">
                            <button type="submit" class="btn btn-primary width-150 btn-rounded">Sign In</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>


        <asset:javascript src="app.min.js"/>

        <script>
            (function() {
                document.forms['loginForm'].elements['${usernameParameter ?: 'username'}'].focus();
            })();
        </script>
    </body>
</html>