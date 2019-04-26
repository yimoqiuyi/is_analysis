<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019-04-16
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.yp.common.pojo.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>layui在线调试</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css?t=1551352891258"
          media="all">
    <style>
        body {
            margin: 10px;
        }

        .demo-carousel {
            height: 200px;
            line-height: 200px;
            text-align: center;
        }
    </style>
</head>
<body>
<input type="hidden" value="${groupId}" id="groupId">
<div class="layui-layout layui-layout-admin">
    <c:if test="${not empty sessionScope.user}">
        <div class="layui-header">
            <div class="layui-logo">layui 后台布局</div>
            <!-- 头部区域（可配合layui已有的水平导航） -->
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
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class=""
                       href="${pageContext.request.contextPath}/general/attendacneHistogram.do?groupId=${groupId}">
                        考勤柱状图</a>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class=""
                       href="${pageContext.request.contextPath}/general/attendacneGraph.do?groupId=${groupId}">
                        考勤曲线图</a>
                </li>
            </ul>

        </div>
    </div>
    <div class="layui-body">
        <div style="padding: 15px;">
        <form id="sch-form" class="layui-form layui-form-pane" action="${pageContext.request.contextPath}/general/selectGeneralUser.do" lay-filter="sch-form" >
             <div class="layui-inline">
                 <div class="layui-input-block">
                    <input name="condition" type="text" autocomplete="off"   placeholder="姓名/电话/身份证号" class="layui-input laydate">
                </div>
            </div>
            <input name="page" value="1" type="hidden">
            <input name="limit" value="10" type="hidden">
            <input type="hidden" name="groupId" value="${groupId}">
            <div class="layui-inline">
                <button class="layui-btn" type="submit">查询</button>
             </div>
        </form>
        </div>
        <!-- 内容主体区域 -->
         <div style="padding: 15px;">
            <table class="layui-hide" id="demo" lay-filter="test"></table>

            <script type="text/html" id="barDemo">
                <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
            </script>
            <div class="layui-tab layui-tab-brief" lay-filter="demo">
                <div class="layui-tab-item">
                    <div id="pageDemo"></div>
                </div>

                <div class="layui-tab-item">
                    <div id="sliderDemo" style="margin: 50px 20px;"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/layui/layui.js?t=1551352891258"></script>
<script>
    layui.config({
        version: '1551352891258' //为了更新 js 缓存，可忽略
    });

    layui.use(['laypage', 'layer', 'table', 'element', 'slider'], function () {
        var laypage = layui.laypage //分页
            , layer = layui.layer //弹层
            , table = layui.table //表格
            , element = layui.element //元素操作
            , slider = layui.slider //滑块

        //向世界问个好
        layer.msg('Hello World');
        var groupId = document.getElementById("groupId").value;
        //监听Tab切换
        element.on('tab(demo)', function (data) {
            layer.tips('切换了 ' + data.index + '：' + this.innerHTML, this, {
                tips: 1
            });
        });
        //执行一个 table 实例
        table.render({
            elem: '#demo'
            , height: 420
            , url: 'checkUserAttendance.do?groupId=' + groupId //数据接口
            , title: '用户表'
            , page: true //开启分页
            , toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            , totalRow: true //开启合计行
            , cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                , {field: 'userId', title: 'ID', width: 40, sort: true, fixed: 'left', totalRowText: '合计：'}
                , {field: 'userName', title: '姓名', width: 60}
                , {field: 'sex', title: '性别', width: 60}
                , {field: 'joinTime', title: '加入时间', width: 100}
                , {field: 'awayTime', title: '离开时间', width: 100}
                , {field: 'attendanceScore', title: '考勤得分', width: 100}
                , {field: 'workRatio', title: '工位利用率', width: 100}
                , {field: 'state', title: '状态', width: 80}
                , {fixed: 'right', width: 200, align: 'center', toolbar: '#barDemo'}
            ]]
        });
        //监听头工具栏事件
        table.on('toolbar(test)', function (obj) {
            <%--var checkStatus = table.checkStatus(obj.config.id)--%>
            <%--, data = checkStatus.data; //获取选中的数据--%>
            <%--switch (obj.event) {--%>
            <%--case 'add':--%>
            <%--window.location.href = "${pageContext.request.contextPath}/user/insert.do"--%>
            <%--layer.msg('添加');--%>
            <%--break;--%>
            <%--case 'update':--%>
            <%--if (data.length === 0) {--%>
            <%--layer.msg('请选择一行');--%>
            <%--} else if (data.length > 1) {--%>
            <%--layer.msg('只能同时编辑一个');--%>
            <%--} else {--%>
            <%--window.location.href = "${pageContext.request.contextPath}/${pageContext.request.contextPath}/user/select.do?userId=${checkStatus.data[0].userId}"--%>
            <%--layer.alert('编辑 [id]：' + checkStatus.data[0].id);--%>
            <%--}--%>
            <%--break;--%>
            <%--case 'delete':--%>
            <%--if (data.length === 0) {--%>
            <%--layer.msg('请选择一行');--%>
            <%--} else {--%>
            <%--window.location.href = "${pageContext.request.contextPath}/user/delete.do?userId=${checkStatus.data[0].userId}"--%>
            <%--layer.msg('删除');--%>
            <%--}--%>
            <%--break;--%>
            <%--}--%>
            <%--;--%>
        });
        //监听行工具事件
        table.on('tool(test)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                , layEvent = obj.event; //获得 lay-event 对应的值
            if (layEvent === 'detail') {
                window.location.href = "${pageContext.request.contextPath}/general/selectGeneralUserAttendance.do?userId=" + data.userId
                layer.msg('查看操作');
            }
            // else if (layEvent === 'del') {--%>
            <%--layer.confirm('真的删除行么', function (index) {--%>
            <%--window.location.href = "${pageContext.request.contextPath}/user/delete.do?userId="+data.userId--%>
            <%--obj.del(); //删除对应行（tr）的DOM结构--%>
            <%--layer.close(index);--%>
            <%--//向服务端发送删除指令--%>
            <%--});--%>
            <%--} else if (layEvent === 'edit') {--%>
            <%--window.location.href = "${pageContext.request.contextPath}/${pageContext.request.contextPath}/user/select.do?userId="+data.userId--%>
            <%--layer.msg('编辑操作');--%>
            <%--}--%>
        });
        //分页
        laypage.render({
            elem: 'pageDemo' //分页容器的id
            , count: 100 //总页数
            , skin: '#1E9FFF' //自定义选中色值
            //,skip: true //开启跳页
            , jump: function (obj, first) {
                if (!first) {
                    layer.msg('第' + obj.curr + '页', {offset: 'b'});
                }
            }
        });
        slider.render({
            elem: '#sliderDemo'
            , input: true //输入框
        });
    });
</script>
</body>
</html>

