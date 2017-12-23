<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>


<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
#resizable {
	width: 150px;
	height: 150px;
	padding: 0.5em;
}

*.bodys {
	height: 850px;
	width: 1255px;
	position: absolute;
	top: 10px;
	left: 0;
	border: 1px solid #CCC;
	border-radius: 5px;
	overflow: scroll;
}
</style>

<script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
<link rel="stylesheet"
	href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
<script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>

<script src="stupidtable.js?dev"></script>
<script>
	$(function() {
		$("#Main1").resizable();
	});
	$(function() {
		$("#Main2").resizable();
	});
	$(function() {
		$("#tableuser").stupidtable();
	});
	$(function() {
		$("#tablepeople").stupidtable();

	});
</script>
<script type="text/javascript">
	//注册一个Jquery的鼠标拖动函数,参数为要拖动的对象
	$.fn.extend({
		SliderObject : function(objMoved) {
			var mouseDownPosiX;
			var mouseDownPosiY;
			var InitPositionX;
			var InitPositionY;
			var obj = $(objMoved) == undefined ? $(this) : $(objMoved);
			$(this).mousedown(
					function(e) {
						//当鼠标按下时捕获鼠标位置以及对象的当前位置
						mouseDownPosiX = e.pageX;
						mouseDownPosiY = e.pageY;

						InitPositionX = obj.css("left").replace("px", "");
						InitPositionY = obj.css("top").replace("px", "");
						obj.mousemove(
								function(e) {//这个地方改成$(document).mousemove貌似可以避免因鼠标移动太快而失去焦点的问题
									//貌似只有IE支持这个判断，Chrome和Firefox还没想到好的办法
									//if ($(this).is(":focus")) {
									var tempX = parseInt(e.pageX)
											- parseInt(mouseDownPosiX)
											+ parseInt(InitPositionX);
									var tempY = parseInt(e.pageY)
											- parseInt(mouseDownPosiY)
											+ parseInt(InitPositionY);
									obj.css("left", tempX + "px").css("top",
											tempY + "px");
									//};
									//当鼠标弹起或者离开元素时，将鼠标弹起置为false，不移动对象
								}).mouseup(function() {
							obj.unbind("mousemove");
						}).mouseleave(function() {
							obj.unbind("mousemove");
						});
					});
		}
	});
	$(document).ready(function() {

		$("p").SliderObject($("#Main1"));
		$("h4").SliderObject($("#Main2"));

	});
</script>
<script type="text/javascript">
	$(function() {
		$("#btn").click(
				function() {
					$.ajax({
						url : "usersearch",
						dataType : "json",
						data : {
							username : $("#username").val()
						},

						success : function(data) {
							$("#show2").empty();
							$("#show1").hide();
							$.each(data, function(key, value) {
								$("#show2").append("<tr>");

								$.each(value, function(keya, valuea) {
									$("#show2 tr:last").append(
											"<td style=\"border: solid; border-width: 1px\">"
													+ valuea + "</td>");
								});
								$("#show2").append("</tr>");
							});
							console.log(data);
						}
					});
				});
		$("#peoplenamesearch").click(
				function() {
					$.ajax({
						url : "peoplesearch",
						dataType : "json",
						data : {
							peoplename : $("#peoplename").val()
						},

						success : function(data) {
							$("#peopleshow2").empty();
							$("#peopleshow1").hide();
							$.each(data, function(key, value) {
								$("#peopleshow2").append("<tr>");

								$.each(value, function(keya, valuea) {
									$("#peopleshow2 tr:last").append(
											"<td style=\"border: solid; border-width: 1px\">"
													+ valuea + "</td>");
								});
								$("#peopleshow2").append("</tr>");
							});
							console.log(data);
						}
					});
				});
	});
</script>

<script type="text/javascript">
	$(function() {

		$("#userregister").click(

		function() {
			user = {
				"user.username" : $("#usernameregister").val(),
				"user.password" : $("#passwordregister").val()
			};

			console.log(user);
			$.ajax({
				url : "userregister",
				dataType : "json",
				data : user,

				success : function(data) {
					console.log(data);

					alert(data)
				}
			});
		});
		$("#peopleregister").click(

		function() {
			people = {
				"people.peoplename" : $("#peoplenameregister").val(),
				"people.peoplework" : $("#peopleworkregister").val()
			};

			console.log(people);
			$.ajax({
				url : "peopleregister",
				dataType : "json",
				data : people,

				success : function(data) {
					console.log(data);

					alert(data)
				}
			});
		});
	});
</script>

        <script>
            $(document).ready(function(){
                document.getElementById("page").value = localStorage.getItem("item1");
            });
            $(document).ready(function(){
                document.getElementById("pagesize").value = localStorage.getItem("item2");
            });
        </script>
        <script>
            $(window).on('beforeunload', function() {
                localStorage.setItem("item1",document.getElementById("page").value);
            });
            $(window).on('beforeunload', function() {
                localStorage.setItem("item2",document.getElementById("pagesize").value);
            });

        </script>

</head>
<body>
	<div>

		<table>
			<tr>
				<td><b>Configuration_information_list Result</b></td>
				<td>
					<form action="configuration_information_list" method="post">
						<input type="submit" value="result">
					</form>
				</td>

			</tr>
		</table>
	</div>
	<div id="Main2" class="bodys ui-widget-content">
		<h4 class="ui-widget-header" style="margin: 0; cursor: move">Drag
			Me</h4>



		<div id="Container">

			<table id="tableconfiguration_information_list" cellspacing="0"
				cellpadding="0">
				<thead>
					<tr>
						<s:iterator value="configuration_information_listcolumnname">
							<th data-sort="string"
								style="border: solid; border-width: 1px; cursor: pointer;"><b><s:property />
							</b></th>
						</s:iterator>
					</tr>
				</thead>
				<tbody id="configuration_information_listshow1">
					<s:iterator value="configuration_information_list" var="searchList">

						<tr>
							<s:iterator value="searchList">
								<td style="border: solid; border-width: 1px"><s:property /></td>
							</s:iterator>
						</tr>

					</s:iterator>
				</tbody>

			</table>
			<form action="configuration_information_list" method="post" >
				<input type="text" placeholder="PageNo." name="page" id="page"  /> 
				<select name="pagesize" id="pagesize" >
					<option value="20">20</option>
					<option value="100">100</option>
					<option value="1000">1000</option>
					<option value="10000">10000</option>
				</select>  <input type="submit" value="GoTo">
			</form>
			
		</div>
	</div>


</body>
</html>