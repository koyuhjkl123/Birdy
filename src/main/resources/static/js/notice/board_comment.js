
$(document).ready(function () {
    $("#commentWrite").submit(function (event) {
        // 새로고침 방지
        event.preventDefault();

        // 입력받은 값 가져오기
        const comment = $("textarea[name='comment']").val();
        const boardId = $("input[name='boardId']").val();
        const token = $("meta[name='_csrf']").attr("content");
        const header = $("meta[name='_csrf_header']").attr("content");
        const requestData = {"comment": comment
        }
        alert("comment"+comment);
        alert("boardId"+boardId);



        $.ajax({
            url: "/comment/insert/" + boardId,
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(requestData),
            beforeSend: function(xhr) {
                xhr.setRequestHeader(header, token);
            },
            success: function(result, status, xhr) {
                if (xhr.status === 200) { 
                    alert("입력이 완료되었습니다.");
                    if (result && result.startsWith('/')) {
                        window.location.href = result;
                    } else {
                        // Reload the current page
                        location.reload();
                    }
                } else if (xhr.status === 302) {
                    window.location.href = result;
                }
            },
            error: function(jqXHR, status, error) {
                // Handle errors
                alert("입력 중 오류가 발생했습니다: " + error);
                console.error("입력 중 오류가 발생했습니다:", error);
            }
        });
    });




    $("#commentUpdate").click(function() {

    
        const token = $("meta[name='_csrf']").attr("content");
        const header = $("meta[name='_csrf_header']").attr("content");
        const comment = $("#comment-content").val();
        const boardId = $("input[name='boardId']").val();
        const commentId = $("input[name='commentId']").val();
        const requestData = { 
            "comment": comment,
            "boardId": boardId,

        }; // 요청 데이터 구성


        $.ajax({
            url: "/comment/update/"+commentId,  // 현재 위치를 돌아오기위해서 사용
            type: "PUT",
            contentType: "application/json",
            data: JSON.stringify(requestData), // JSON 형식으로 데이터 전송
            beforeSend: function(xhr){
                xhr.setRequestHeader(header, token);
            },
            cache: false,
            success: function(result, status){
                alert("수정이 완료되었습니다..");
                $('#exampleModal').modal('hide');
                location.reload(); // 페이지 새로고침
            },
            error: function(jqXHR, status, error) {
                alert(jqXHR.responseText);
                console.error("인증번호 발송 중 오류가 발생했습니다:", error);
            }
        });
    });


    //  댓글 삭제
    $(".commentDelete").click(function() {
        const token = $("meta[name='_csrf']").attr("content");
        const header = $("meta[name='_csrf_header']").attr("content");
        const commentId = $(this).attr("data-comment-id");
        const requestData = {
            "commentId": commentId
        }; // 요청 데이터 구성
        alert("commentId"+JSON.stringify(requestData));
        $.ajax({
            url: "/comment/delete/"+commentId,  // 삭제
            type: "DELETE",
            contentType: "application/json",
            data: JSON.stringify(requestData), // JSON 형식으로 데이터 전송
            beforeSend: function(xhr){
                xhr.setRequestHeader(header, token);
            },
            cache: false,
            success: function(result, status){
                alert("삭제가 완료되었습니다..");
                $('#exampleModal').modal('hide');
                location.reload(); // 페이지 새로고침
            },
            error: function(jqXHR, status, error) {
                alert(jqXHR.responseText);
                console.error("인증번호 발송 중 오류가 발생했습니다:", error);
            }
        });
    });




        $('.comment-update-btn').click(function () {
            const commentId = $(this).data('comment-id');
            const commentCreatedBy = $(this).data('comment-created-by');
            const commentContent = $(this).data('comment-content');

            $('#exampleModalLabel').text(commentCreatedBy);
            $('#comment-content').val(commentContent);
            $('#comment-id').val(commentId);
            $('#exampleModal').modal('show');
        });




});