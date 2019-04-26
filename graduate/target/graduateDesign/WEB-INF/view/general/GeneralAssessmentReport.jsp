<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019-04-13
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="utf-8" import="com.yp.common.pojo.*,java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<%
    AssessmentReport assessmentReport = (AssessmentReport) request.getAttribute("assessmentReport");
%>
<c:if test="${ empty sessionScope.user}">
    <li><a href="login.jsp">登录</a></li>
</c:if>
<div class="layui-layout layui-layout-admin">
    <c:if test="${not empty sessionScope.user}">
        <div class="layui-header">
            <div class="layui-logo">layui 后台布局</div>
            <!-- 头部区域（可配合layui已有的水平导航） -->
            <ul class="layui-nav layui-layout-left">
                 <li class="layui-nav-item layui-nav-itemed">
                    <a class=""
                       href="${pageContext.request.contextPath}/general/checkGeneralAssessmentReport.do?groupId=<%=assessmentReport.getGroupId()%>">
                        考核信息</a>
                </li>
                 <li class="layui-nav-item">
                    <a href="${pageContext.request.contextPath}/general/selectSubparkAttendance.do?groupId=<%=assessmentReport.getGroupId()%>">
                        考勤信息</a>
                </li>
                <li class="layui-nav-item">
                    <a href="${pageContext.request.contextPath}/general/selectgeneralAchievementsNumber.do?groupId=<%=assessmentReport.getGroupId()%>">
                        成果信息</a>
                </li>
            </ul>
            <ul class="layui-nav layui-layout-right">
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                            ${user.userName}
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/user/select.do">个人资料</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/logout.do">退了</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </c:if>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <form class="layui-form" action="">
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <input type="text" name="reportId"  style="width: 200px" value="<%=assessmentReport.getReportId()%>" hidden>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">任务情况描述:</label>
                    <div class="layui-input-block">
                           <textarea name="assessmentMessage"  style="width: 200px" placeholder="任务情况"
                                     class="layui-textarea"> <%=assessmentReport.getAssessmentMessage()%></textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">卫生情况描述:</label>
                    <div class="layui-input-block">
                        <textarea name="sDescription"  style="width: 200px" placeholder="卫生情况"
                                  class="layui-textarea"> <%=assessmentReport.getsDescription()%></textarea>
                    </div>
                </div>

                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">考勤情况描述:</label>
                    <div class="layui-input-block">
                            <textarea name="attendanceDescription" style="width: 200px" placeholder="考勤情况"
                                      class="layui-textarea"> <%=assessmentReport.getAttendanceDescription()%></textarea>
                    </div>
                </div>
              </form>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });
</script>
</body>
</html>

