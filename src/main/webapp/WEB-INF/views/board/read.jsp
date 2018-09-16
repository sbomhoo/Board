<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container">
	<div class="page-header">
		<h1>게시글 조회 페이지</h1>
	</div>

	<div>
		<form role="form" method="post">
			<input type="hidden" name="bno" value="${boardVO.bno}">
			<input type="hidden" name="page" value="${criteria.page}">
			<input type="hidden" name="perPageNum" value="${criteria.perPageNum}">
			<input type="hidden" name="searchType" value="${criteria.searchType}">
			<input type="hidden" name="keyword" value="${criteria.keyword}">
		</form>
		
		<!-- 게시글 제목 -->
		<div class="form-group">
			<label for="title">Title</label>
			<input type="text" class="form-control" name="title" value="${boardVO.title}"/>
		</div>
		
		<!-- 게시글 내용 -->
		<div class="form-group">
			<label for="content">Content</label>
			<textarea class="form-control" name="content" rows="5" readonly="readonly">${boardVO.content}</textarea>
		</div>
		
		<!-- 게시글 작성자 -->
		<div class="form-group">
			<label for="writer">Writer</label>
			<input type="text" class="form-control" name="writer" value="${boardVO.writer}"/>
		</div>
		
		<!-- 게시글 수정 및 삭제, 전체 게시글 조회 버튼 -->
		<button type="submit" class="btn btn-warning">Modify</button>
		<button type="submit" class="btn btn-danger">Remove</button>
		<button type="submit" class="btn btn-primary">List All</button>
	</div>
</div>