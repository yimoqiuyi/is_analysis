<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019-04-16
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" %>
<%@ page import="com.yp.common.pojo.*" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>角色权限</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<%
    Role role = (Role) request.getAttribute("role");
%>
<form class="layui-form" action="${pageContext.request.contextPath}/admin/rolePermission.do">
    <div class="layui-form-item">
        <div class="layui-input-block">
            <input type="text" name="roleId" value="<%=role.getRoleId()%>" hidden>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">角色名:</label>
        <div class="layui-input-block">
            <input type="text" name="name" value="<%=role.getName()%>" required lay-verify="required"
                   placeholder="请输入标题" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item" pane="">
        <label class="layui-form-label">权限:</label>
        <div class="layui-input-block">
            <%
                ArrayList<Permission> list = (ArrayList<Permission>) request.getAttribute("permissionList");
                for (int i = 0; i < list.size(); i++) {
                    Permission permission = (Permission) list.get(i);
            %>
            <input type="checkbox" lay-skin="primary" name="pId" value="<%=permission.getId()%>" title="<%= permission.getName()%>">
             <%
                }
            %>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" type="submit" lay-submit lay-filter="formDemo">提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use(['element','form'],function () {
        var form = layui.form;
        var element = layui.element;

    });
</script>
</body>
</html>
