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
<form action="${pageContext.request.contextPath}/insertObject">
 <table class="table table-dark">
      <tr>
         <td>用户编号：</td>
         <td><input type="text" name="id"></td>
      </tr>
      <tr>
         <td>用户名：</td>
         <td><input type="text" name="name"></td>
      </tr>

      <tr>
         <td>评论内容：</td>
         <td><input type="text" name="title"></td>
      </tr>
     <tr>
         <td>赞数：</td>
         <td><input type="text" name="zan"></td>
     </tr>
      <tr>
         <td></td>
         <td><button class="btn btn-success">添加</button></td>
          <button class="btn btn-success" onclick="javascript:window.history.back(-1);">返回</button>
      </tr>
 </table>
  </form>
</body>
</html>