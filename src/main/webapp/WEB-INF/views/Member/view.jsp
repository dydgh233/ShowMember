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

<h1 class="h3 mb-2 test-gray-800">상세보기</h1>

<label>아이디</label>
<input type="text" class="form-control form-control-user"
	value="${member.m_id}" readonly>
<label>이름</label>
<input type="text" class="form-control form-control-user"
	value="${member.m_name}" readonly>
<label>비밀번호</label>
<input type="text" class="form-control form-control-user"
	value="${member.m_passwd}" readonly>
<label>내용</label>

<input type="text" class="form-control form-control-user"
	value="${member.m_udate}" readonly>





<div class="form-control">
	<a href="/member/update?m_id=${member.m_id }">[수정]</a>&nbsp;&nbsp;&nbsp;
	<a href="/member/delete?m_id=${member.m_id}">[삭제]</a>&nbsp;&nbsp;&nbsp;
</div>











<%@include file="../include/footer.jsp"%>