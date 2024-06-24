$(document).ready(function() {
    $(".board-delete").click(function(event) {
        if (!confirm("정말로 이 게시글을 삭제하시겠습니까?")) {
            return; // 사용자가 취소를 선택한 경우 함수 종료
        }
        event.preventDefault();
        const token = $("meta[name='_csrf']").attr("content");
        const header = $("meta[name='_csrf_header']").attr("content");
        const boardid = $("#boardId").val();
        const requestData = {
            "boardid": boardid
        };
        alert("값들 가져옴"+boardid);
     // AJAX 요청 보내기
        $.ajax({
            url: "/board/delete/" + boardid,
            type: "DELETE",
            contentType: "application/json",
            data: JSON.stringify(requestData),
            beforeSend: function(xhr) {
                xhr.setRequestHeader(header, token);
            },
            success: function(result, status) {
                alert("삭제가 완료되었습니다.");
                location.href="/board/list"; // 페이지 새로고침
            },
            error: function(jqXHR, status, error) {
                alert(jqXHR.responseText);
                console.error("삭제 중 오류가 발생했습니다:", error);
            }
        });

    });
});
