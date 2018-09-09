<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container">
	<div class="page-header">
		<h1>게시글 수정 페이지</h1>
	</div>

	<div>
		<form role="form" method="post">
			<!-- 게시글 번호 -->
			<div class="form-group">
				<label for="bno">BNO</label>
				<input type="text" class="form-control" name='bno' value="${boardVO.bno}" readonly="readonly"/> 
			</div>
			
			<!-- 게시글 제목 -->
			<div class="form-group">
				<label for="title">Title</label>
				<input type="text" class="form-control" name="title" value="${boardVO.title}"/>
			</div>
			
			<!-- 게시글 내용 -->
			<div class="form-group">
				<label for="content">Content</label>
				<textarea class="form-control" name="content" rows="5">${boardVO.content}</textarea>
			</div>
			
			<!-- 게시글 작성자 -->
			<div class="form-group">
				<label for="writer">Writer</label>
				<input type="text" class="form-control" name="writer" value="${boardVO.writer}"/>
			</div>
		</form>
		
		<!-- 게시글 저장 및 취소 버튼 -->
		<button type="submit" class="btn btn-primary">SAVE</button>
		<button type="submit" class="btn btn-danger">CANCEL</button>
	</div>
</div>