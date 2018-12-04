<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <style>
    .text {
      position:absolute;
      width:100%;
      top:50%;
      text-align:center;
    }
  </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/index" method="post">
<div class="text">
  <div class="field">
  <input type="submit" value="ВОЙТИ" />
</div>
</div>
  </form>
</body>
</html>