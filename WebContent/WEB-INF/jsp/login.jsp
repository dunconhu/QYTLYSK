<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>登陆</title>	
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.1.0.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/core.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/menu.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/amazeui.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/component.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/page/form.css" />
		<script src="${pageContext.request.contextPath }/js/amazeui.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/md5.js"></script>
        <%-- <script src="${pageContext.request.contextPath }/js/app.js"></script> --%>
		</head>
		<script type="text/javascript">
		function logIn(){
			//console.log("登录函数被调用");
			var username = $("#loginForm input[name=username]").val();
			/* MD5加密 */
			var password = md5($("#loginForm input[name=password]").val());
			var url="${pageContext.request.contextPath }/loginCheck";
			/* alert(password);  */
			if(remember.checked){ 
		        setCookie('user',username,7); //保存帐号到cookie，有效期7天
		      }
			
			$.post(url,{
				"username":username,
				"password":password
			},function(data){
				if(data=="1"){
					alert("用户名或密码不能为空！");
				}else if(data=="2"){
					alert("用户名或密码错误！");
				}else if(data=="3"){
					window.location="${pageContext.request.contextPath }/main";
				}
			});
		};
		
		window.onload = function(){
		    var oForm = document.getElementById('loginForm');
		    var oUser=$("#loginForm input[name=username]").val();
		    var oRemember = document.getElementById('remember');
		    //页面初始化时，如果帐号密码cookie存在则填充
		    if(getCookie('user') ){
		    	$("#loginForm input[name=username]").val(getCookie('user'));
		      oRemember.checked = true;
		    }
		    //复选框勾选状态发生改变时，如果未勾选则清除cookie
		    oRemember.onchange = function(){
		      if(!this.checked){
		        delCookie('user');
		      }
		    };
		  };
		  //设置cookie
		  function setCookie(name,value,day){
		    var date = new Date();
		    date.setDate(date.getDate() + day);
		    document.cookie = name + '=' + value + ';expires='+ date;
		  };
		  //获取cookie
		  function getCookie(name){
		    var reg = RegExp(name+'=([^;]+)');
		    var arr = document.cookie.match(reg);
		    if(arr){
		      return arr[1];
		    }else{
		      return '';
		    }
		  };
		  //删除cookie
		  function delCookie(name){
		    setCookie(name,null,-1);
		  };
		</script>
	
	<body>
		<div class="account-pages">
			<div class="wrapper-page">
				<div class="text-center">
	                <a class="logo"><span style="text-align: center;display:block;">乾元通蓝牙水控</span></a>
	                <a class="logo"><span style="text-align: right;display:block;"> —后台管理&nbsp;</span></a>
	            </div>
	            
	            <div class="m-t-40 card-box">
	            	<div class="text-center">
	                    <h4 class="text-uppercase font-bold m-b-0">登陆</h4>
	                </div>
	                <div class="panel-body">
	                	<form id="loginForm" class="am-form" action="/loginCheck" method="post">
	                		<div class="am-g">
	                			<div class="am-form-group">
							      <input type="text" class="am-radius" name="username" placeholder="用户名">
							    </div>
							
							    <div class="am-form-group form-horizontal m-t-20">
							      <input type="password" class="am-radius" name="password" placeholder="密    码">
							    </div>
							    
							   <div class="am-form-group tpl-login-remember-me">
			                        <label id="rememberme" style="font-weight: normal;color: #999;font-size:15px;">
			                        <input id="remember" type="checkbox" >
								        记住用户名
								    </label>
			                    </div>

		                        
		                        <div class="am-form-group ">
		                        	<button  id="login"  type="button" class="am-btn am-btn-primary am-radius" onclick="logIn()" style="width: 100%;height: 100%;">登陆</button>
		                        </div>
		                        
		                        <!-- <div class="am-form-group ">
		                        <a href="page-recoverpw.html" class="text-muted"><i class="fa fa-lock m-r-5"></i> 忘记密码?</a>
		                        </div> -->
	                		</div>
	                	</form>					
	                </div>
	            </div>
			</div>
		</div>
	</body>
</html>