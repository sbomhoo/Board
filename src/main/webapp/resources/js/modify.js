$(document).ready(function() {
	var formObj = $("form[role='form']");
	
	// 게시글 수정한 내용 저장 기능 수행
	$(".btn-primary").on("click", function() {
		formObj.submit();
	});
	

	// 게시글 수정한 작업 취소 후 목록 페이지로 이동
	$(".btn-danger").on("click", function() {
		var page = document.getElementById ('page').value;
		var perPageNum = document.getElementById ('perPageNum').value;
		self.location = "/board/listPage?page="+page+"&perPageNum="+perPageNum;
	});

});