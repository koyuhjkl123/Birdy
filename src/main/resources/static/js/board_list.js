$(document).ready(function() {

    $("#search").click(function() {

        var searchType = $('#searchType').val();
        console.log("searchType"+searchType);
        var searchKeyword = $('#searchKeyword').val();
        console.log("searchKeyword"+searchKeyword);
        var page = 0; // 페이지는 0부터 시작
        var size = 10; // 게시시글 수
        var requestData = {
            type: searchType,
            keyword: searchKeyword,
            page: page,
            size: size
        };
        $.ajax({
            url: "/board/list/",
            type: "GET",
            contentType: "application/json",
            data: requestData, // JSON 형식으로 데이터 전송
            cache: false,
            success: function(){
                alert("검색 성공");
            },
            error: function(jqXHR, status, error) {
                alert(jqXHR.responseText);
                console.error("오류 확인", error);
            }
        });
    });


});
function saveReq() {
    location.href = "/board/insertForm";
}