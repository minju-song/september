<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글상세보기</title>
<link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square-round.css" rel="stylesheet">
<link href="//cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script src="//cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
<style>
	#div {
		font-family: 'NanumSquareRound';
	}

	table td {
		text-align: center;
		padding: 5px;
	}
	table th {
		text-align: center;
		padding: 5px;
	}
    h3 {
        text-align: center;
    }
</style>
</head>
<body>
<div align="center" id="div">
	<jsp:include page="../menu/header.jsp"/>
	<div><h1>&#127802;게시글 상세보기&#127802;</h1></div>
	<div>
	<div>
				<table border="2">
					<tr>
						<th width="100">작성자</th>
						<td width="150">${n.noticeWriterName }</td>
						<th width="100">작성일자</th>
						<td width="150" align="center"> ${n.noticeDate }</td>
						<th width="100">조회수</th>
						<td width="50" align="center"> ${n.noticeHit +1}</td>
					</tr>
					<tr>
						<th>이미지</th>
						<td colspan="5">
							<img height="200px" src="attech/notice/${n.noticeImage }">
						</td>
					</tr>
					<tr>
						<th>제 목</th>
						<td colspan="5">${n.noticeTitle }</td>
					</tr>
					<tr>
						<th>내 용</th>
						<td colspan="5">
							<textarea rows="10" cols="80">${n.noticeSubject }</textarea>
						</td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td colspan="5">${n.noticeAttech }</td>
					</tr>
				</table>
			</div>
		</div>
        </div>
        <h3>&#127799;댓글등록&#127799;</h3>
        <div>
            <table align="center" class="addR">
                <tr>
                    <th>댓글번호</th>
                    <td><input type="text" name="rid"></td>
                </tr>
                <tr>
                    <th>댓글내용</th>
                    <td><input type="text" name="content"></td>
                </tr>
                <tr>
                    <th>댓글작성자</th>
                    <td><input type="text" name="writer"></td>
                </tr>
                <tr>
                    <th>작성일자</th>
                    <td><input type="text" name="replyDate"></td>
                </tr>
                <tr>
                    <td colspan="2"><button class="addRow">추가</button></td>
                </tr>
            </table>
        </div>
        <h3>&#127799;댓글목록&#127799;</h3>
        <p><button id="deleteRow">Delete</button></p>
            <table id="example" class="display" style="width:100%">
                <thead>
                    <tr>
                        <th>댓글번호</th>
                        <th>댓글내용</th>
                        <th>댓글작성자</th>
                        <th>작성일자</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>댓글번호</th>
                        <th>댓글내용</th>
                        <th>댓글작성자</th>
                        <th>작성일자</th>
                    </tr>
                </tfoot>
            </table>
            <script src="js/reply.js"></script>
        <script>
            const rep = new Reply();
            let noticeId = "${n.noticeId}";
            const table = new DataTable('#example', {
                ajax: 'AjaxReplyList.do?nid='+noticeId+'&param=jquery',
                columns : [
                    { data: 'replyId'},
                    { data : 'reply'},
                    { data : 'replyer'},
                    { data : 'replyDate',
                        render : function(data, type) {
                            return rep.displayDate(data);
                        }}
                ]
            });
            // const table = new DataTable('#example');

            function addNewRow() {
                // console.log($('.addR input[name="rid"]').val());
                // let rid = $('.addR input[name="rid"]').val();
                // let content = $('.addR input[name="content"]').val();
                // let writer = $('.addR input[name="writer"]').val();
                // let replyDate = $('.addR input[name="replyDate"]').val();
                // console.log(rid+" "+content+" "+writer+" "+replyDate);
                // console.log(table);
                table.row
                .add({
                    replyId : $('.addR input[name="rid"]').val(),
                    reply : $('.addR input[name="content"]').val(),
                    replyer : $('.addR input[name="writer"]').val(),
                    replyDate : $('.addR input[name="replyDate"]').val()
            })
                .draw(false);
                $('.addR input[name="rid"]').val('');
                $('.addR input[name="content"]').val('');
                $('.addR input[name="writer"]').val('');
                $('.addR input[name="replyDate"]').val('');


            }

            table.on('click', 'tbody tr', (e) => {
                let classList = e.currentTarget.classList;

                if( classList.contains('selected')) {
                    classList.remove('selected');
                }
                else {
                    table.rows('.selected').nodes().each((row) => row.classList.remove('selected'));
                    classList.add('selected');
                }
            })

            $('.addRow').on('click', addNewRow);
            $('#deleteRow').on('click', function() {
                table.row('.selected').remove().draw(false);
            })
        </script>
    </body>
</html>
