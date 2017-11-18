<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>

    <link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet"/>

    <script>


        function condition() {

            var deptId = document.getElementById("dept").value;
            var postId = document.getElementById("post").value;
            var staffName = document.getElementById("staffName").value;
            var data = new FormData();

            data.append("staff.post.dept.deptId", deptId);
            data.append("staff.post.postId", postId);
            data.append("staffName", staffName);

            var xhr = new XMLHttpRequest();
            xhr.withCredentials = true;

            xhr.addEventListener("readystatechange", function () {
                if (this.readyState === 4) {
                    console.log(this.responseText);
                    json = eval('(' + this.responseText + ')');
                    var tableEle = document.getElementById("staffId");
                    var length = tableEle.rows.length
                    for (var j = 0; j < length - 1; j++) {
                        tableEle.deleteRow(1);
                    }

                    for (var j = 0; j < json.length; j++) {
                        var tr = document.createElement("tr");
                        getId = json[j].staffId;

                        tr.appendChild(createTD(json[j].staffName));
                        tr.appendChild(createTD(json[j].gender));
                        tr.appendChild(createTD(json[j].onDutyDate));
                        tr.appendChild(createTD(json[j].post.dept.deptName));
                        tr.appendChild(createTD(json[j].post.postName));

                        function createA() {
                            var get_Id = json[j].staffId;
                            var path = "${pageContext.request.contextPath}/staff/editStaff?staffId=";
                            path += get_Id;

                            var td = document.createElement("td");
                            td.setAttribute("align", "center");
                            var a = document.createElement("a");
                            a.setAttribute("href", path);
                            var textNode = document.createElement("img");
                            textNode.setAttribute("src", "${pageContext.request.contextPath}/images/button/modify.gif")
                            textNode.setAttribute("class", "img");
                            a.appendChild(textNode);
                            td.appendChild(a);
                            return td;
                        }


                        tr.append(createA());
                        tableEle.appendChild(tr)
                    }


                    function createTD(text) {
                        var td = document.createElement("td");
                        td.setAttribute("align", "center")
                        var textNode = document.createTextNode(text);
                        td.appendChild(textNode);
                        return td;
                    }


                }


            });

            xhr.open("POST", "http://localhost:8080/staff/staffsJson.action");

            xhr.send(data);

        }

        <%--当选择部门的时候会执行--%>
        function changePost(value) {
            var data = new FormData();
            data.append("deptId", value);

            var xhr = new XMLHttpRequest();
            xhr.withCredentials = true;

            xhr.addEventListener("readystatechange", function () {
                if (this.readyState === 4) {
                    console.log(this.responseText);
                    json = eval('(' + this.responseText + ')');

                    postSelect = document.getElementById("post");
                    optionEle = postSelect.getElementsByTagName("option");
                    length = optionEle.length;
                    for (var i = 0; i < length; i++) {
                        postSelect.removeChild(optionEle[0]);
                    }
                    postSelect.innerHTML = "<option value = '-1'>---请选择---</option>";
                    for (var i = 0; i < json.length; i++) {
                        option = document.createElement("option");
                        option.setAttribute("value", json[i].postId);
                        text = document.createTextNode(json[i].postName);
                        option.appendChild(text);
                        postSelect.appendChild(option);
                    }
                }
            });

            xhr.open("POST", "http://localhost:8080/staff/findPost.action");

            xhr.send(data);
        }

    </script>


    <script type="text/javascript">
        function onStaffsQuery() {
            document.getElementById("getStaffs").submit();
        }
    </script>


    <script type="text/javascript">
        function showPage() {
            document.getElementById("pages").submit();
        }
    </script>
</head>

<body>
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
        <td class="topg"></td>
    </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
    <tr>
        <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
        <td width="39%" align="left">[员工管理]</td>

        <td width="57%" align="right">
            <%--高级查询 --%>
            <a href="javascript:void(0)" onclick="condition()">
                <img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif"/>
            </a>

            <%--员工注入 --%>
            <a href="/staff/findDept.action">
                <img src="${pageContext.request.contextPath}/images/button/tianjia.gif"/>
            </a>

        </td>
        <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
    </tr>
</table>


<!-- 查询条件：马上查询 -->
<form action="/staff/findStaff.action" method="post" id="getStaffs">
    <table width="88%" border="0" style="margin: 20px;">
        <tr>
            <td width="80px">部门：</td>
            <td width="200px">

                <select onchange="changePost(value)" name="deptId" id="dept">
                    <option value="-1">---请选择---</option>
                    <s:iterator value="departmentList" var="deptme">
                        <option value="${deptme.deptId}">${deptme.deptName}</option>
                    </s:iterator>
                </select>

            </td>
            <td width="80px">职务：</td>
            <td width="200px">

                <select id="post" name="postId">
                    <option value="-1">---请选择---</option>
                </select>

            </td>
            <td width="80px">姓名：</td>
            <td width="200px"><input type="text" name="staffName" id = "staffName" size="12"/></td>
            <td></td>
        </tr>
    </table>
</form>


<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
    <tr>
        <td><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
    </tr>
</table>

<table width="100%" border="1" id="staffId">
    <tr class="henglan" style="font-weight:bold;">
        <td width="10%" align="center">员工姓名</td>
        <td width="6%"  align="center">性别</td>
        <td width="12%" align="center">入职时间</td>
        <td width="15%" align="center">所属部门</td>
        <td width="10%" align="center">职务</td>
        <td width="10%" align="center">编辑</td>
    </tr>


    <s:iterator value="allList">
        <tr class="table2">
            <td align="center"><s:property value="staffName"/></td>
            <td align="center"><s:property value="gender"/></td>
            <td align="center"><s:property value="onDutyDate"/></td>
            <td align="center"><s:property value="post.dept.deptName"/></td>
            <td align="center"><s:property value="post.postName"/></td>
            <td width="7%" align="center">
                <s:a namespace="/staff" action="editStaff">
                    <s:param name="staffId" value="staffId"/>
                    <s:param name="postId" value="post.postId"/>
                    <s:param name="deptId" value="post.dept.deptId"/>
                    <img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
                </s:a>
            </td>
        </tr>
    </s:iterator>
</table>













<%--<table border="0" cellspacing="0" cellpadding="0" align="center">--%>
    <%--<tr>--%>
        <%--<td align="right">--%>

            <%--第<s:property value="%{#page.pageNum}"/>页/共<s:property--%>
                <%--value="#pageBean.totalPage"/>页</span>--%>
            <%--<s:a action="findAllPage">--%>
                <%--首页--%>
                <%--<s:param name="pageNum" value="'1'"/>--%>
            <%--</s:a>--%>
            <%--<s:if test="%{#page.pageNum > 1}">--%>
                <%--<s:a action="findAllPage">--%>
                    <%--上一页--%>
                    <%--<s:param name="pageNum" value="%{#page.pageNum - 1}"/>--%>
                <%--</s:a>--%>
            <%--</s:if>--%>
            <%--<s:iterator var="i" begin="%{#page.start}" end="%{#page.end}">--%>
                <%--<s:if test="%{#i eq #page.pageNum}">--%>
                    <%--<font color="red">--%>
                        <%--<s:property value="%{#i}"/>--%>
                    <%--</font>--%>
                <%--</s:if>--%>
                <%--<s:else>--%>
                    <%--<s:a action="findAllPage">--%>
                        <%--[<s:property value="%{#i}"/>]--%>
                        <%--<s:param name="pageNum" value="%{#i}"/>--%>
                    <%--</s:a>--%>
                <%--</s:else>--%>
            <%--</s:iterator>--%>
            <%--<s:if test="%{#page.pageNum < #page.totalPage}">--%>
                <%--<s:a action="findAllPage">--%>
                    <%--<s:param name="pageNum" value="%{#page.pageNum + 1}"/>--%>
                    <%--下一页--%>
                <%--</s:a>--%>
            <%--</s:if>--%>
            <%--<s:a action="findAllPage">--%>
                <%--<s:param name="pageNum" value="%{#page.totalPage}"/>--%>
                <%--尾页--%>
            <%--</s:a>--%>
        <%--</td>--%>
    <%--</tr>--%>
<%--</table>--%>



</body>
</html>
