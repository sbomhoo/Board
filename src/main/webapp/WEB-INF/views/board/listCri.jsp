<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" %>
<div class="container">
	<div class="page-header">
		<h1>게시글 목록 페이지</h1>
	</div>

	<div>
		<!-- 게시글 목록 -->
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th style="width: 10px">BNO</th>
					<th style="width: 100px">TITLE</th>
					<th style="width: 50px">WRITTER</th>
					<th style="width: 30px">REGDATE</th>
					<th style="width: 30px">VIEWCNT</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="boardVO">
				<tr>
					<td>${boardVO.bno}</td>
					<td><a href='/board/read?bno=${boardVO.bno}'>${boardVO.title}</a></td>
					<td>${boardVO.writer}</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
								value="${boardVO.regdate}"/></td>
					<td><span class="badge">${boardVO.viewcnt}</span></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<script>
var result = "${msg}";

if (result == 'SUCCESS') {
	alert("처리가 완료되었습니다.");
}
</script>