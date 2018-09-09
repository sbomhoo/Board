<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container">
	<div class="page-header">
		<h1>게시글 등록 페이지</h1>
	</div>

	<div>
		<form role="form" method="post">
			<!-- 게시글 제목 -->
			<div class="form-group">
				<label for="title">Title:</label>
				<input type="text" class="form-control" name="title" placeholder="Enter Title"/>
			</div>
			
			<!-- 게시글 내용 -->
			<div class="form-group">
				<label for="content">Content</label>
				<textarea class="form-control" name="content" rows="5" placeholder="Enter Content"></textarea>
			</div>
			
			<!-- 게시글 작성자 -->
			<div class="form-group">
				<label for="writer">Writer</label>
				<input type="text" class="form-control" name="writer" placeholder="Enter Writer"/>
			</div>
			
			<!-- 게시글 등록 버튼 -->
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</div>