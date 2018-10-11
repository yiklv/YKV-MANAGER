'use strict';
function disableButton(obj) {
	$(obj).attr("disabled", true);
	$(obj).css("background-color", "#959ba9");
}

function unDisableButton(obj) {
	$(obj).attr("disabled", false);
	$(obj).css("background-color", "#e22");
}

function isNullCheck(val) {
	if (!val || val == '' || val == null) {
		return false;
	}
	return true;
}

function _flushToken(_contextPath, obj){
	var contextPath =_contextPath;
	jQAjax({
		url: contextPath + "/index/flushToken.do",
		data:{},
		type: "GET",
		dataType: "text",
		cache: false,
		success: function(data, status){
			obj.val(data);
		},
		error: function(req, textStatus, errorThrown){
			console.log(req);
			console.log(errorThrown);
			
		}
	});
}