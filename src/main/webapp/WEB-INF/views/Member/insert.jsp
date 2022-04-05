<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../include/header.jsp"%>
<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">
<div class="card-header py-3">
	<h6 class="m-0 font-weight-bold text-primary">
		<a href="/member/list">리스트</a>
	</h6>
</div>
<form method="post" action="/member/insert" class="user">
<input type="text"
		class="form-control form-control-user" name="m_name" placeholder="이름">
<input type="text" class="form-control form-control-user"
		name="m_id" placeholder="아이디"> 
<input type="text" class="form-control form-control-user"
		name="m_passwd" placeholder="비밀번호">
	
	<input type="submit" class="form-control">
</form>

<%@include file="../include/footer.jsp"%>