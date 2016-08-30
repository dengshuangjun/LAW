<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="zh">
<head>
<base href="/law/">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>法律网站_后台登陆</title>
<link rel="shortcut icon" href="back/images/logo_ .png">
<link rel="stylesheet" type="text/css" href="back/css/styles.css">
<script src="back/js/jquery-1.9.1.min.js"></script>
</head>
<body>
	<div class="jq22-container" style="padding-top: 100px">
		<div class="login-wrap">
			<div class="login-html">
				<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label
					for="tab-1" class="tab">后台登陆</label> <input id="tab-2" type="radio"
					name="tab" class="sign-up"><label for="tab-2" class="tab"></label>
				<div class="login-form">
					<div class="sign-in-htm">
						<form method="post"  action="law/back/user/login">
							<div class="group">
								<label for="user" class="label">用户名</label> <input id="user"
									type="text" class="input" name="usname">
							</div>
							<div class="group">
								<label for="pass" class="label">密码</label> <input id="pass"
									type="password" class="input" data-type="password" name="upwd">
							</div>
							<div class="group">
								<input id="check" type="checkbox" class="check" checked>
								<label for="check"><span class="icon"></span>记住密码</label>
							</div>
							<div class="group">
								<input type="submit" class="button" value="登陆">
							</div>
						</form>
						<div class="error">${errorMsg }</div>
						<div class="hr"></div>
						<div class="foot-lnk">
							<a href="#forgot"></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>