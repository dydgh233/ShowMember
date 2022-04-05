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

<h1 class="h3 mb-2 test-gray-800">수정</h1>

<form Method="POST" action="/member/update">
<label>아이디</label>
<input type="text" class="form-control form-control-user" name="m_id"
	value="${member.m_id}" readonly>
	
<label>비밀번호</label>
<input type="text" class="form-control form-control-user"
	name="m_passwd" value="${member.m_passwd}">
	
<label>이름</label>
<input type="text" class="form-control form-control-user" name="m_name"
	value="${member.m_name}" readonly>
	



<label>작성일</label>
${member.m_udate}


<input type="submit" class="form-control" value="수정하기">
</form>

<%@include file="../include/footer.jsp"%>