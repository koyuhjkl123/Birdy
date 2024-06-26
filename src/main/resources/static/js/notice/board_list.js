// $(document).ready(function() {
//     $("#search").click(function() {
//         var searchType = $('#searchType').val();
//         var searchKeyword = $('#searchKeyword').val();
//         var page = 0; // 페이지는 0부터 시작
//         var size = 10; // 페이지당 게시글 수

//         // 쿼리 문자열 구성
//         var queryParams = $.param({
//             type: searchType,
//             page: page,
//             size: size,
//             keyword: searchKeyword
//         });

//         // AJAX 요청
//         $.ajax({
//             url: "/api/board/list?" + queryParams,
//             type: "GET",
//             success: function(response) {
//                 updateResults(response); // 검색 결과 업데이트
//             },
//             error: function(jqXHR, textStatus, errorThrown) {
//                 console.error("AJAX 오류 발생: " + textStatus, errorThrown);
//             }
//         });
//     });

//     function updateResults(data) {
//         var resultsTableBody = $("#resultsTable tbody");
//         resultsTableBody.empty(); // 기존 결과 지우기

//         // 데이터를 테이블에 추가
//         data.content.forEach(function(board) {
//             var row = "<tr>" +
//                       "<td>" + board.boardTitle + "</td>" +
//                       "<td>" + board.boardContent + "</td>" +
//                       "</tr>";
//             resultsTableBody.append(row);
//         });
//     }
// });

function saveReq() {
    location.href = "/notice/insertForm";
}
