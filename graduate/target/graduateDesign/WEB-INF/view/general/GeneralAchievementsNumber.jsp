<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019-04-16
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019-04-16
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.yp.common.pojo.User" %>
<%@ page import="org.apache.shiro.session.Session" %>
<%@ page import="com.yp.common.pojo.AchievementsNumber" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>个人信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<%
    AchievementsNumber achievementsNumber = (AchievementsNumber) request.getAttribute("achievementsNumber");
%>
<form class="layui-form" action="">
    <div class="layui-form-item">
        <div class="layui-input-block">
            <input type="text" name="userId" hidden>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">专利数量:</label>
        <div class="layui-input-block">
            <input type="text" name="s" value="<%=achievementsNumber.getPatentNum()%>" style="width: 200px"  required lay-verify="required"
                   placeholder="请输入标题" autocomplete="off" class="layui-input" readonly>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">软件数量:</label>
        <div class="layui-input-block">
            <input type="text" name="phone" value="<%=achievementsNumber.getSoftwareNum()%>" style="width: 200px"  required lay-verify="required"
                   placeholder="请输入标题" autocomplete="off" class="layui-input" readonly>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">论文数量:</label>
        <div class="layui-input-block">
            <input type="text" name="cardNumber" value="<%=achievementsNumber.getPaperNum()%>" style="width: 200px"  required lay-verify="required"
                   placeholder="请输入标题" autocomplete="off" class="layui-input" readonly>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">竞赛数量:</label>
        <div class="layui-input-block">
            <input type="text" name="email" value="<%=achievementsNumber.getCompetitionNum()%>"  style="width: 200px" required lay-verify="required"
                   placeholder="请输入标题" autocomplete="off" class="layui-input" readonly>
        </div>
    </div>
 </form>
<script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });
</script>
</body>
</html>
