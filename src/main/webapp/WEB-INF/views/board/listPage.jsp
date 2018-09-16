<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" %>
<div class="container">
	<div class="page-header">
		<h1>게시글 목록 페이지</h1>
	</div>

	<div>
		<!-- 검색 키워드 -->
		<select name="searchType">
			<option value="n" <c:out value="${criteria.searchType == null ? 'selected' : ''}"/>>-----</option>
			<option value="t" <c:out value="${criteria.searchType eq 't' ? 'selected' : ''}"/>>Title</option>
			<option value="c" <c:out value="${criteria.searchType eq 'c' ? 'selected' : ''}"/>>Content</option>
			<option value="w" <c:out value="${criteria.searchType eq 'w' ? 'selected' : ''}"/>>Writer</option>
			<option value="tc" <c:out value="${criteria.searchType eq 'tc' ? 'selected' : ''}"/>>Title OR Content</option>
			<option value="cw" <c:out value="${criteria.searchType eq 'cw' ? 'selected' : ''}"/>>Content OR Writer</option>
			<option value="tcw" <c:out value="${criteria.searchType eq 'tcw' ? 'selected' : ''}"/>>Title OR Content OR Writer</option>
		</select>
		<input type="text" name="keyword" id="keywordInput" value="${criteria.keyword}"/>
		<button id="searchBtn">Search</button>
		<button id="newBtn">New Board</button>
		
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
					<td><a href='/board/read${pageMaker.makeSearch(pageMaker.criteria.page)}&bno=${boardVO.bno}'>${boardVO.title}</a></td>
					<td>${boardVO.writer}</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
								value="${boardVO.regdate}"/></td>
					<td><span class="badge">${boardVO.viewcnt}</span></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="text-center">
		<ul class="pagination">
			<c:if test="${pageMaker.prev}">
				<li><a href="listPage${pageMaker.makeSearch(pageMaker.startPage - 1)}">&laquo;</a></li>
			</c:if>

			<c:forEach begin="${pageMaker.startPage}"
			 end="${pageMaker.endPage }" var="idx">
				<li <c:out value="${pageMaker.criteria.page == idx?'class = active' : '' }"/>>
				<a href="listPage${pageMaker.makeSearch(idx)}">${idx}</a>
				</li>
			</c:forEach>
			
			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li><a href="listPage${pageMaker.makeSearch(pageMaker.endPage + 1)}">&raquo;</a></li>
			</c:if>
		</ul>
	</div>
</div>

<script>
var result = "${msg}";

if (result == 'SUCCESS') {
	alert("처리가 완료되었습니다.");
}

$(document).ready(function() {
	$('#searchBtn').on("click", function(event){
		self.location = "listPage"
		+ "${pageMaker.makeQuery(1)}"
		+ "&searchType="
		+ $("select option:selected").val()
		+ "&keyword="
		+ $('#keywordInput').val();
	});
	
	$('#newBtn').on("click", function(event) {
		self.location = "register";
	});
});
</script>