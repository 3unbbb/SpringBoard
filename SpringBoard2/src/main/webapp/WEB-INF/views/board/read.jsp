<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">스프링 게시판</h3>
				</div>
				<!-- /.box-header -->
				<form action="" role="form">
					<input type ="hidden" name="bno" value="${vo.bno}">
				</form>
				
			<%-- 	${sessionScope.upFlag } --%>
				
					<div class="box-body">
						<div class="form-group">
							<label for="exampleInputEmail1">글 번호</label>
							<input type="text" class="form-control" id="exampleInputEmail1" value="${vo.bno }"
							    name ="bno"  readonly="readonly">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">조회수</label>
							<input type="text" class="form-control" id="exampleInputEmail1" value="${vo.viewcnt }"
							    name ="viewcnt"  readonly="readonly">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">글 제목</label>
							<input type="text" class="form-control" id="exampleInputEmail1" value="${vo.title }"
							    name ="title" readonly="readonly">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">글쓴이</label>
							<input type="text" class="form-control" id="exampleInputPassword1" value="${vo.writer }"
								name="writer" readonly="readonly">
						</div>
						
						<div class="form-group">
							<label>글 내용</label>
							<textarea class="form-control"  name="content" rows="3" readonly="readonly">${vo.content }</textarea>
						</div>
						
						
					</div>

					<div class="box-footer">
						<button type="submit" class="btn bg-purple">수정</button>
						<button type="submit" class="btn btn-danger">삭제</button>
						<button type="submit" class="btn btn-success">목록</button>
					</div>
				



			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<script type="text/javascript">

		$(document).ready(function(){
			//목록버튼 클릭시
			$('.btn-success').click(function(){
				//form태그 밖에 있으니까 onsubmit 말고 click 사용
				//alert('목록버튼 클릭');
				location.href='/board/listCri';
			});
			
			//폼태그(객체)정보
			var formObj = $('form[role="form"]')
			//alert(formObj);
			console.log(formObj);
			
			
			//수정버튼 클릭시=> 폼태그(bno) 사용해서 페이지 이동
			$('.bg-purple').click(function(){
				//alert('수정버튼 클릭');
				//폼태그 정보 = >submit()
				//주소 (/board/modify)
				formObj.attr("action", "/board/modify");
				//get방식
				//formObj.attr("method", "get");
				
				formObj.submit();
				
			});
			
			//삭제버튼 클릭
			// /board/remove - post 방식
			$('.btn-danger').click(function(){
				
				
				formObj.attr("action","/board/remove");
				formObj.attr("method","post");
				
				formObj.submit();
			});
			
			
			
		});



</script>




<%@ include file="../include/footer.jsp" %>
