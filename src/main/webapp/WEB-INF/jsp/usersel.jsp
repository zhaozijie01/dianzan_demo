<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
</head>
<body>
<form>

    <div class="form-group row">
        <c:forEach items="${user}" var="user">
            <label class="col-sm-2 col-form-label">编号：</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" value="${user.id}" disabled="disabled">
            </div>
        <label class="col-sm-2 col-form-label">用户名：</label>
        <div class="col-sm-10">
                <input type="text" class="form-control"  value="${user.name}" disabled="disabled">
        </div>
        <label class="col-sm-2 col-form-label">评论内容：</label>
        <div class="col-sm-10">
                <input type="text" class="form-control"  value="${user.title}" disabled="disabled">
        </div>
        <label class="col-sm-2 col-form-label">点赞数</label>
        <div class="col-sm-10">
                <input type="text" class="form-control"  value="${user.zan}" disabled="disabled">
        </div>
        </c:forEach>
    </div>
    <div  class="form-check form-check-inline">
        <button class="btn btn-success" onclick="javascript:window.history.back(-1);">返回</button>
    </div>
  </form>
</body>
</html>