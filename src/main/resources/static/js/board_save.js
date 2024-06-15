$(document).ready(function() {
    alert("스크립트 연결");
    $("#board-insert").submit(function(event) {
        alert("클릭함");
        // 폼의 기본 동작을 막음 (페이지 새로고침 방지)
        event.preventDefault();
        // 리뷰 내용 가져오기
        const title = $("input[name='boardTitle']").val();
        const content = $("textarea[name='boardContent']").val();
        const img = $("input[name='boardImgFile']").val();

        // CSRF 토큰 가져오기
        const token = $("meta[name='_csrf']").attr("content");
        const header = $("meta[name='_csrf_header']").attr("content");

        const requestData = {
            "title": title,
            "content": content,
            "img": img
        };
        alert("requestData"+JSON.stringify(requestData));
        alert("token"+token);
        alert("header"+header);

        // AJAX 요청 보내기
        $.ajax({
            url: "/board/save", // boardCommunityId를 URL에 포함시킴
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(requestData), // boardCommunityId는 URL에, reply만 JSON으로 전송
            beforeSend: function(xhr) {
                xhr.setRequestHeader(header, token);
            },
            success: function(result, status) {
                alert("입력이 완료되었습니다.");
                location.reload(); // 페이지 새로고침
            },
            error: function(jqXHR, status, error) {
                // alert(jqXHR.responseText);
                console.error("입력 중 오류가 발생했습니다:", error);
            }
        });
    });
});
