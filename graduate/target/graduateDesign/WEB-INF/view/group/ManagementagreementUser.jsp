<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019-04-04
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="utf-8" import="java.util.*,com.yp.common.pojo.*" %>
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
<c:if test="${ empty sessionScope.user}">
    <li><a href="login.jsp">登录</a></li>
</c:if>
<c:if test="${not empty sessionScope.user}">

    <div class="layui-layout layui-layout-admin">
        <div class="layui-header">
            <div class="layui-logo">layui 后台布局</div>
            <!-- 头部区域（可配合layui已有的水平导航） -->
            <ul class="layui-nav layui-layout-left">
                <li class="layui-nav-item"><a href="">首页</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/user/viewUser.do">团队操作</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/group/selectAchievements.do">成果展示</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/group/Achievementoperation.do">成果操作</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/group/select.do">考核报告</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/group/userPosition.do">查看工位</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/group/agreement.do">合同查看</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/group/groupIntroduce.do">公司简介</a></li>

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
        <div class="layui-body">
            <div style="padding: 15px;">
                <form id="sch-form" class="layui-form layui-form-pane" action="${pageContext.request.contextPath}/group/selectManagementByTime.do" lay-filter="sch-form" >
                    <div class="layui-inline">
                        <label class="layui-form-label">签订时间</label>
                        <div class="layui-input-block">
                            <input name="beginTime" type="text" autocomplete="off" id="startTime" placeholder="yyyy-MM-dd" class="layui-input laydate">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">截止时间</label>
                        <div class="layui-input-block">
                            <input name="endTime" type="text" autocomplete="off" id="endTime" placeholder="yyyy-MM-dd" class="layui-input laydate">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <button class="layui-btn" type="submit">查询</button>
                        <button class="layui-btn layui-btn-primary" type="reset" id="btn-resert"> 重置</button>
                    </div>
                </form>
            </div>
            <!-- 内容主体区域 -->
            <div style="padding: 15px;">
                <table class="layui-table" lay-even lay-skin="nob">
                    <colgroup>
                        <col width="100">
                        <col width="100">
                        <col width="120">
                        <col width="140">
                        <col width="140">
                        <col width="100">
                    </colgroup>
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>合同名称</th>
                        <th>合同介绍</th>
                        <th>签订日期</th>
                        <th>过期日期</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach  items="${managementagreementList}" var="item">
                        <tr>
                            <td>${item.managementId}</td>
                            <td>${item.managementName}</td>
                            <td>${item.managementIntroduce}</td>
                            <td>${item.signDate}</td>
                            <td>${item.expirationDate}</td>
                            <td><a href="${pageContext.request.contextPath}/group/ManagementagreementDownload.do?managementId=${item.managementId}"
                                   class="layui-btn layui-btn-warm">下载</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </div>
        </div>

        <div class="layui-footer">
            <!-- 底部固定区域 -->
            © layui.com - 底部固定区域
        </div>
    </div>
</c:if>
<script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('laydate', function() {
        var laydate = layui.laydate;
        //日期
        var nowTime=new Date();
        var startTime=laydate.render({
            elem:'#startTime',
            btns: ['confirm'],
            max:'nowTime',//默认最大值为当前日期
            done:function(value,date){
//    		console.log(value); //得到日期生成的值，如：2017-08-18
//    	    console.log(date); //得到日期时间对象：{year: 2017, month: 8, date: 18, hours: 0, minutes: 0, seconds: 0}
                endTime.config.min={
                    year:date.year,
                    month:date.month-1,//关键
                    date:date.date
                };
            }
        });
        var endTime=laydate.render({
            //type默认为yyyy-mm-dd
            elem:'#endTime',
//             btns: ['confirm'],
//             // max:'nowTime',
//             done:function(value,date){
// //    		console.log(value); //得到日期生成的值，如：2017-08-18
// //    	    console.log(date); //得到日期时间对象：{year: 2017, month: 8, date: 18, hours: 0, minutes: 0, seconds: 0}
//                 startTime.config.max={
//                     year:date.year,
//                     month:date.month-1,//关键
//                     date:date.date
//                 }

        });

//重置
    })
</script>
</body>
</html>

