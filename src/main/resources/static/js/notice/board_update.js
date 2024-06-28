$(document).ready(function() {
    $("#board-update").submit(function(event) {
        // 폼의 기본 동작을 막음 (페이지 새로고침 방지)
        event.preventDefault();

        // CSRF 토큰 가져오기
        const token = $("meta[name='_csrf']").attr("content");
        const header = $("meta[name='_csrf_header']").attr("content");
        const boardid = $("#boardid").val();
        var formData = new FormData(this);
        
        // AJAX 요청 보내기
        $.ajax({
            url: "/notice/update/" + boardid, // boardDTO.id를 URL에 포함시킴
            type: "PUT",
            processData: false,
            contentType: false,
            data: formData,
            beforeSend: function(xhr) {
                xhr.setRequestHeader(header, token);
            },
            success: function(result, status) {
                alert("수정이 완료되었습니다.");
                location.href = "/notice/list"; // 페이지 새로고침
            },
            error: function(jqXHR, status, error) {
                alert(jqXHR.responseText);
                console.error("수정 중 오류가 발생했습니다:", error);
            }
        });
    });
});
