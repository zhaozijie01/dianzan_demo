<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>hello world</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
</head>
</head>
<body>

<script type="text/javascript">

    function plsc(){
        id = $("[name='check']:checked").map(function(){
            return $(this).val();
        }).get().join();
        if(id!=""){
            $.post(
                "delAll",
                {id:id},
                function(flag){
                    if(flag){
                        alert("删除成功")
                        location.href="home";
                    } else{
                        alert("删除失败")
                    }
                },
                "json"
            );
        }else{
            alert("请选择要删除的数据");
        }
    }
</script>

    <form action="home" method="post">用户名：
        <input type="text" name="name" value="${zan.name }">
        <button class="btn btn-success">搜索</button>
    </form>
    <a href="${pageContext.request.contextPath}/add" class="btn btn-success">添加</a>
    <a onclick="plsc()" class="btn btn-success">批量删除</a>
<table class="table table-dark" >

    <tr>
        <td><input type="checkbox" name="xuan"></td>
        <td>编号</td>
        <td>用户名</td>
        <td>评论内容</td>
        <td>赞数</td>
    </tr>
    <c:forEach  items="${pageInfo.list}" var="zans">
        <tr>
            <td><input type="checkbox" name="check" value="${zans.id }"></td>
            <td>${zans.id}</td>
            <td>${zans.name }</td>
            <td>${zans.title }</td>
            <td>${zans.zan }</td>
            <td>
                <a href="${pageContext.request.contextPath}/upd?id=${zans.id }" class="btn btn-success">修改</a>
                <a href="${pageContext.request.contextPath}/sel?id=${zans.id }" class="btn btn-success">详情</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="6">
            <nav>
                <ul class="pagination">
                    <c:if test="${pageInfo.pageNum>1}">
                        <li class="page-item"><a class="page-link"
                            href="${pageContext.request.contextPath}/home?page=${pageInfo.pageNum-1}&name=${zan!=null?zan.name:''}">上一页</a>
                        </li>
                    </c:if>

                    <c:forEach var="page" items="${pageInfo.navigatepageNums }">
                        <li class="page-item ${pageInfo.pageNum==page?'active':''}">
                            <a class="page-link"
                               href="${pageContext.request.contextPath}/home?page=${page}&name=${zan!=null?zan.name:''}">${page}</a>
                        </li>
                    </c:forEach>

                    <c:if test="${pageInfo.pageNum<pageInfo.pages}">
                        <li class="page-item"><a class="page-link"
                            href="${pageContext.request.contextPath}/home?page=${pageInfo.pageNum+1}&name=${zan!=null?zan.name:''}">下一页</a>
                        </li>
                    </c:if>
                </ul>
            </nav>
        </td>
    </tr>
</table>

</body>
</html>
