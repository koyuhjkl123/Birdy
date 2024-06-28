$(document).ready(function() {
    $("#board-insert").submit(function(event) {
        // 폼의 기본 동작을 막음 (페이지 새로고침 방지)
        event.preventDefault();
        // CSRF 토큰 가져오기
        const token = $("meta[name='_csrf']").attr("content");
        const header = $("meta[name='_csrf_header']").attr("content");
        var formData = new FormData(this);

        $.ajax({
            url: "/notice/save", // boardCommunityId를 URL에 포함시킴
            type: "POST",
            processData: false,
            contentType: false,
            data: formData, // boardCommunityId는 URL에, reply만 JSON으로 전송
            beforeSend: function(xhr) {
                xhr.setRequestHeader(header, token);
            },
            success: function(result, status) {
                alert("입력이 완료되었습니다.");
                location.href="/notice/list";// 페이지 새로고침
            },
            error: function(jqXHR, status, error) {
                alert(jqXHR.responseText);
                console.error("입력 중 오류가 발생했습니다:", error);
            }
        });
    });
});
