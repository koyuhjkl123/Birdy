$(document).ready(function() {
    $("#board-insert").submit(function(event) {
        event.preventDefault();

        const formData = new FormData();
        formData.append("title", $("input[name='boardTitle']").val());
        formData.append("content", $("textarea[name='boardContent']").val());
        const imgFiles = $("input[name='boardImgFile']")[0].files;
        for (let i = 0; i < imgFiles.length; i++) {
            formData.append("boardImgFile", imgFiles[i]);
        }

        const token = $("meta[name='_csrf']").attr("content");
        const header = $("meta[name='_csrf_header']").attr("content");

        $.ajax({
            url: "/board/save",
            type: "POST",
            enctype: 'multipart/form-data',
            headers: {
                [header]: token
            },
            data: formData,
            processData: false,
            contentType: false,
            cache: false,
            success: function(result, status) {
                alert("입력이 완료되었습니다.");
                location.reload();
            },
            error: function(jqXHR, status, error) {
                console.error("입력 중 오류가 발생했습니다:", error);
            }
        });
    });
});
