<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'login.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link  href="../css/style.css"  rel='stylesheet' type='text/css'>
    <link   rel="stylesheet"   href="../js/layui/css/layui.css">

    <style type="text/css">
        #captcha2 {
            width: 300px;
            height: 60px;
            display: inline-block;
        }
        #wait2 {
            text-align: left;
            color: #666;
            margin: 0;
        }
        .show {
            display: block;
        }
        #notice2 {
            color: red;
        }
        .hide {
            display: none;
        }
    </style>


</head>
<body>
<h1>Mp3 Login Form</h1>
<div class="login-form">
    <div class="close"> </div>
    <div class="head-info">
        <label class="lbl-1"> </label>
        <label class="lbl-2"> </label>
        <label class="lbl-3"> </label>
    </div>
    <div class="clear"> </div>
    <div class="avtar">
        <img src="images/avtar.png" />
    </div>
    <%--<form action="admin/login.action"  method="post"      id="form1">--%>
        <input type="text" class="text" value="Username"  name="userName" id="userName"  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Username';}" >
        <div class="key">
            <input type="password" value="Password"  name="passWord" id="passWord"  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
        </div>

        <%--<div  id="tong"  style="margin-top:-40px;"  >
            <div>
                <label style="color: white;">???????????????</label>
                <div id="captcha2">
                    <p id="wait2" class="show">?????????????????????......</p>
                </div>
            </div>
        </div>--%>

        <div class="signin"  >
            <p id="notice2" class="hide">??????????????????</p>
            <input type="submit"   id="submit2"   value="Login" >
            <div    id="captcha2" style="margin-top: -60px;"></div>
        </div>
   <%-- </form>--%>
</div>
<div class="copy-rights">
    <p>Copyright &copy; 2015.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="????????????">????????????</a> - Collect from <a href="http://www.cssmoban.com/" title="????????????" target="_blank">????????????</a></p>
</div>



</body>
<!-- ???????????????????????????????????? jquery ?????????????????? jquery ???????????? demo ???????????????????????? -->
<script src="http://apps.bdimg.com/libs/jquery/1.9.1/jquery.js"></script>

<!-- ?????? gt.js????????????????????????????????? initGeetest ??????????????? -->
<script src="../js/gt.js"></script>
<script type="text/javascript" src="../js/layui/jquery-3.4.1.min.js"></script>
<script src="../js/layui/layui.js"></script>
<script type="text/javascript" src="../js/yanzhengma.js"></script>
<script type="text/javascript">


</script>
</html>
