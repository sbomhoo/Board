$(document).ready(function() {
	var formObj = $("form[role='form']");
	
	// 게시글 수정 기능 수행
	$(".btn-warning").on("click", function() {
		formObj.attr("action", "/board/modify");
		formObj.attr("method", "get");
		formObj.submit();
	});

	// 게시글 삭제 기능 수행
	$(".btn-danger").on("click", function() {
		formObj.attr("action", "/board/remove");
		formObj.submit();
	});

	// 게시글 목록 페이지로 이동
	$(".btn-primary").on("click", function() {
		formObj.attr("action", "/board/listPage");
		formObj.attr("method", "get");
		formObj.submit();
	});
});