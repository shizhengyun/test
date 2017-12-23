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
.center {
	text-align: left;
}

td.disabled,th.disabled {
	width: 100px;
	text-align: center;
	min-width: 100px;
}

td.left {
	border-left: 1px solid #2e638e;
}

td.right {
	border-right: 1px solid #2e638e;
}

td.bottom {
	border-bottom: 1px solid #2e638e;
}

.grip {
	width: 20px;
	height: 15px;
	margin-top: -3px;
	background-image: url('../img/grip.png');
	margin-left: -5px;
	position: relative;
	z-index: 88;
	cursor: e-resize;
}

.grip:hover {
	background-position-x: -20px;
}

.JCLRLastGrip .grip {
	background-position-y: -18px;
	left: -2px;
}

.dragging .grip {
	background-position-x: -40px;
}

.sampleText {
	position: relative;
	width: 100%;
}

.dotted {
	background-image: url('../img/dotted.png');
	background-repeat: repeat-y;
}

input.check {
	
}

#sample2Txt {
	float: right;
}

label {
	color: #0361ae;
}

#resizable {
	width: 150px;
	height: 150px;
	padding: 0.5em;
}

*.bodys {
	height: 400px;
	width: 255px;
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
<script src="colResizable-1.6.js"></script>
<script type="text/javascript">
	$(function() {
		$("#tableconfiguration_information_list").colResizable({
			liveDrag : true,
			gripInnerHtml : "<div class='grip'></div>",
			draggingClass : "dragging",
			resizeMode : 'fit'
		});
		$("#normal").colResizable({
			liveDrag : true,
			gripInnerHtml : "<div class='grip'></div>",
			draggingClass : "dragging",
			resizeMode : 'fit'
		});

	});
</script>
<script src="stupidtable.js?dev"></script>
<script>
	$(function() {
		$("#Main1").resizable();
	});
	$(function() {
		$("#Main2").resizable();
	});
	$(function() {
		$("#Main3").resizable();
	});
	$(function() {
		$("#tableuser").stupidtable();
	});
	$(function() {
		$("#tablepeople").stupidtable();
	});
	$(function() {
		$("#tableconfiguration_information_list").stupidtable();
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
		$("p#drag1").SliderObject($("#Main1"));
		$("p#drag2").SliderObject($("#Main2"));
		$("p#drag3").SliderObject($("#Main3"));
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
		$("#configuration_information_listsearch")
				.click(
						function() {
							$
									.ajax({
										url : "configuration_information_listsearch",
										dataType : "json",
										data : {
											configuration_information_listtext : $(
													"#configuration_information_listtext")
													.val(),
											configuration_information_listcondition : $(
													"#configuration_information_listcondition")
													.val(),
											configuration_information_listpage : $(
													"#configuration_information_listpage")
													.val(),
											configuration_information_listpagesize : $(
													"#configuration_information_listpagesize")
													.val()
										},

										success : function(data) {
											$(
													"#configuration_information_listshow2")
													.empty();
											$(
													"#configuration_information_listshow1")
													.hide();
											console.log(data[data.length - 1]);
											document
													.getElementById("tableconfiguration_information_listcount").innerHTML = "共"
													+ data[data.length - 1]
													+ "条数据";
											data.splice(data.length - 1, 1);
											console.log(data);
											$
													.each(
															data,
															function(key, value) {
																$(
																		"#configuration_information_listshow2")
																		.append(
																				"<tr>");
																$
																		.each(
																				value,
																				function(
																						keya,
																						valuea) {

																					$(
																							"#configuration_information_listshow2 tr:last")
																							.append(
																									"<td style=\"border: solid; border-width: 1px\">"
																											+ valuea
																											+ "</td>");

																				});
																$(
																		"#configuration_information_listshow2")
																		.append(
																				"</tr>");

															});

										},

									});
						});

	});
</script>

<script type="text/javascript">
	$(function() {
		$("#userregister").click(function() {
			user = {
				"user.username" : $("#usernameregister").val(),
				"user.password" : $("#passwordregister").val()
			};
			$.ajax({
				url : "userregister",
				dataType : "json",
				data : user,
				success : function(data) {
					alert(data)
				}
			});
		});
		$("#peopleregister").click(

		function() {
			var key1 = 'people.' + $("#peoplenameregistercondition").val();
			var key2 = 'people.' + $("#peopleworkregistercondition").val();
			var people = {
				key1 : "value1",
			};
			people[key1] = $("#peoplenameregister").val();
			people[key2] = $("#peopleworkregister").val();
			delete people.key1;

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

		$("#configuration_information_listregister").click(

				function() {
					var key1 = 'configuration_information_list.'
							+ $("#caller_material_classificationconditionid1")
									.val();
					var key2 = 'configuration_information_list.'
							+ $("#caller_material_classificationconditionid2")
									.val();
					var key3 = 'configuration_information_list.'
							+ $("#caller_material_classificationconditionid3")
									.val();
					var key4 = 'configuration_information_list.'
							+ $("#caller_material_classificationconditionid4")
									.val();
					var key5 = 'configuration_information_list.'
							+ $("#caller_material_classificationconditionid5")
									.val();

					var configuration_information_list = {
						key1 : "value1",
					};

					configuration_information_list[key1] = $(
							"#caller_material_classificationtextid1").val();
					configuration_information_list[key2] = $(
							"#caller_material_classificationtextid2").val();
					configuration_information_list[key3] = $(
							"#caller_material_classificationtextid3").val();
					configuration_information_list[key4] = $(
							"#caller_material_classificationtextid4").val();
					configuration_information_list[key5] = $(
							"#caller_material_classificationtextid5").val();

					delete configuration_information_list.key1;

					console.log(configuration_information_list);
					$.ajax({
						url : "configuration_information_listregister",
						dataType : "json",
						data : configuration_information_list,

						success : function(data) {
							console.log(data);

							alert(data)
						},
						error : function(XMLHttpRequest, textStatus,
								errorThrown) {

							alert('AJAX DATA SEND ERROR! status:'
									+ XMLHttpRequest.status + ', status text: '
									+ XMLHttpRequest.statusText);
						},
					});
				});
	});
</script>
<script language="javascript">
	var idcount = 1;
	function AddElement(mytype) {
		var mytype, TemO = document.getElementById("add");
		var newInput = document.createElement("input");
		var newInput2 = document.createElement("input");
		newInput.type = mytype;
		newInput2.type = mytype;
		newInput.placeholder = "register_condition";
		newInput2.placeholder = "register_text";
		idcount = idcount + 1;
		newInput.name = "caller_material_classificationconditionname" + idcount;
		newInput.id = "caller_material_classificationconditionid" + idcount;
		newInput2.name = "caller_material_classificationtextname" + idcount;
		newInput2.id = "caller_material_classificationtextid" + idcount;
		var newline = document.createElement("br");
		newline.id = "br" + idcount;
		TemO.appendChild(newline);
		TemO.appendChild(newInput);
		TemO.innerHTML += '&nbsp;';
		TemO.appendChild(newInput2);
	}
	function RemoveElement(mytype) {
		var mytype, TemO = document.getElementById("add");
		var child = document
				.getElementById("caller_material_classificationtextid"
						+ idcount);
		var child2 = document
				.getElementById("caller_material_classificationconditionid"
						+ idcount);
		var child3 = document.getElementById("br" + idcount);
		TemO.removeChild(child);
		TemO.removeChild(child2);
		TemO.removeChild(child3);
		idcount = idcount - 1;
	}
</script>
</head>
<body>
	<div>
		<table>
			<tr>

				<td><b>Users Result</b></td>
				<td>
					<form action="write" method="post">
						<input type="submit" value="result">
					</form>
				</td>

			</tr>
		</table>
	</div>

	<div id="Main2" class="bodys ui-widget-content">
		<p id="drag2" class="ui-widget-header" style="margin: 0; cursor: move">Drag
			Me</p>
		<div id="Container">
			<form method="post">
				<input type="text" name="peoplenameconditon"
					placeholder="register_condition" id="peoplenameregistercondition" /><input
					type="text" name="peoplename" placeholder="register_text"
					id="peoplenameregister" /><br /> <input type="text"
					name="peopleworkcondition" placeholder="register_condition"
					id="peopleworkregistercondition" /><input type="text"
					name="peoplework" placeholder="register_text"
					id="peopleworkregister" /><br /> <input type="button"
					id="peopleregister" value="register" />
			</form>
			<form method="post">
				<input type="text" placeholder="peoplename" name="peoplename"
					id="peoplename" /> <input type="button" id="peoplenamesearch"
					value="search" />
			</form>
			</br>
			<table id="tablepeople" cellspacing="0" cellpadding="0">
				<thead>
					<tr>
						<s:iterator value="peoplescolumnname">
							<th data-sort="string"
								style="border: solid; border-width: 1px; cursor: pointer;"><b><s:property />
							</b></th>
						</s:iterator>
					</tr>
				</thead>
				<tbody id="peopleshow1">
					<s:iterator value="peoples" var="searchList">

						<tr>
							<s:iterator value="searchList">
								<td style="border: solid; border-width: 1px"><s:property /></td>
							</s:iterator>
						</tr>

					</s:iterator>
				</tbody>
				<tbody id="peopleshow2">
					<s:iterator value="peoples" var="searchList">

						<tr>
							<s:iterator value="searchList">
								<td style="border: solid; border-width: 0px"></td>
							</s:iterator>
						</tr>

					</s:iterator>
				</tbody>
			</table>

		</div>
	</div>
	<div id="Main1" class="bodys ui-widget-content">
		<p id="drag1" class="ui-widget-header" style="margin: 0; cursor: move">Drag
			Me</p>
		<div id="Container">

			<form method="post">
				username:<input type="text" name="username" id="usernameregister" /><br />
				password:<input type="text" name="password" id="passwordregister" /><br />

				<input type="button" id="userregister" value="register" />
			</form>

			<form method="post">
				<input type="text" placeholder="username" name="username"
					id="username" /> <input type="button" id="btn" value="search" />
			</form>

			</br>
			<table id="tableuser" cellspacing="0" cellpadding="0">
				<thead>
					<tr>
						<s:iterator value="userscolumnname">
							<th data-sort="string"
								style="border: solid; border-width: 1px; cursor: pointer"><b><s:property />
							</b></th>
						</s:iterator>
					</tr>
				</thead>
				<tbody id="show1">
					<s:iterator value="users" var="searchList">

						<tr>
							<s:iterator value="searchList">
								<td style="border: solid; border-width: 1px"><s:property /></td>
							</s:iterator>
						</tr>

					</s:iterator>
				</tbody>
				<tbody id="show2">
					<s:iterator value="users" var="searchList">

						<tr>
							<s:iterator value="searchList">
								<td style="border: solid; border-width: 0px"></td>
							</s:iterator>
						</tr>

					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>

	<div id="Main3" class="bodys ui-widget-content">
		<p id="drag3" class="ui-widget-header" style="margin: 0; cursor: move">Drag
			Me</p>
		<div id="Container">

			<form method="post">
				<div id="add">
					<input type="text"
						name="caller_material_classificationconditionname1"
						placeholder="register_condition"
						id="caller_material_classificationconditionid1"> <input
						type="text" name="caller_material_classificationtextname1"
						placeholder="register_text"
						id="caller_material_classificationtextid1">
				</div>
				<input name="" type="button" value="add"
					onClick="AddElement('text')" /> <input name="" type="button"
					value="remove" onClick="RemoveElement('text')" />&nbsp;<input
					type="button" id="configuration_information_listregister"
					value="register" />
			</form>
			<hr>
			<form method="post">
				<input type="text" placeholder="search_condition"
					name="configuration_information_listcondition"
					id="configuration_information_listcondition" /> <input type="text"
					placeholder="searchtext" name="configuration_information_listtext"
					id="configuration_information_listtext" /> <input type="text"
					name="configuration_information_listpage"
					id="configuration_information_listpage" value="1"
					style="width: 40px" /> <select
					name="configuration_information_listpagesize"
					id="configuration_information_listpagesize">
					<option value="20">20</option>
					<option value="100">100</option>
					<option value="1000">1000</option>
					<option value="10000">10000</option>
				</select> <input type="button" id="configuration_information_listsearch"
					value="search" />
			</form>
			<p id="tableconfiguration_information_listcount"></p>
			</br>
			<div class="center">
				<table id="tableconfiguration_information_list" width="98%"
					cellspacing="0" cellpadding="0">

					<thead>
						<tr>
							<s:iterator value="configuration_information_listcolumnname">
								<th data-sort="string"
									style="border: solid; border-width: 1px; cursor: pointer; overflow: hidden;"><s:property />
								</th>
							</s:iterator>
						</tr>
					</thead>
					<tbody id="configuration_information_listshow1">
						<s:iterator value="configuration_information_list"
							var="searchList">
							<tr>
								<s:iterator value="searchList">
									<td style="border: solid; border-width: 1px"><s:property /></td>
								</s:iterator>
							</tr>
						</s:iterator>
					</tbody>
					<tbody id="configuration_information_listshow2">
						<s:iterator value="configuration_information_list"
							var="searchList">
							<tr>
								<s:iterator value="searchList">
									<td style="border: solid; border-width: 0px"></td>
								</s:iterator>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>