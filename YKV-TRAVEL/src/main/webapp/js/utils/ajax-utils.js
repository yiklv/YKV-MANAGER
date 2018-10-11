'use strict';
// 格式化参数
function formatParams(data) {
	var arr = [];
	for ( var name in data) {
		arr.push(encodeURIComponent(name) + "="+ encodeURIComponent(data[name]));
	}
	arr.push(("v=" + Math.random()).replace(".", ""));
	return arr.join("&");
}

function jQAjax(options){
	options = options || {};
	options.url = options.url || "";
	if(JSON.stringify(options) == "{}" || options.url == ""){
		console.log('error message : ajax parameter is null,plz confirm, ths!')
		return;
	}
	
	options.type = (options.type || "GET").toUpperCase();
	// 要求为Number类型的参数，设置请求超时时间（毫秒）。此设置将覆盖$.ajaxSetup()方法的全局设置。
	options.timeout = options.timeout || 1000 * 60* 10;
	//要求为Boolean类型的参数，默认设置为true，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为false。注意，同步请求将锁住浏览器，用户其他操作必须等待请求完成才可以执行。
	options.async = options.async || true;
	//要求为Boolean类型的参数，默认为true（当dataType为script时，默认为false），设置为false将不会从浏览器缓存中加载请求信息
	options.cache = options.cache || false;
	options.data = options.data || null;
	/**
	 * 要求为String类型的参数，预期服务器返回的数据类型。如果不指定，JQuery将自动根据http包mime信息返回responseXML或responseText，并作为回调函数参数传递。
	 * 可用的类型如下：
			xml：返回XML文档，可用JQuery处理。
			html：返回纯文本HTML信息；包含的script标签会在插入DOM时执行。
			script：返回纯文本JavaScript代码。不会自动缓存结果。除非设置了cache参数。注意在远程请求时（不在同一个域下），所有post请求都将转为get请求。
			json：返回JSON数据。
			jsonp：JSONP格式。使用SONP形式调用函数时，例如myurl?callback=?，JQuery将自动替换后一个“?”为正确的函数名，以执行回调函数。
			text：返回纯文本字符串。
	 */
	options.dataType = options.dataType || "json";
	// 要求为String类型的参数，当发送信息至服务器时，内容编码类型默认为"application/x-www-form-urlencoded"。该默认值适合大多数应用场合。
	options.contentType = options.contentType|| "application/x-www-form-urlencoded";
	/**
	 * 要求为Function类型的参数，发送请求前可以修改XMLHttpRequest对象的函数，例如添加自定义HTTP头。在beforeSend中如果返回false可以取消本次ajax请求。XMLHttpRequest对象是惟一的参数。
		function(XMLHttpRequest){
			this; //调用本次ajax请求时传递的options参数
		}
	 */
	options.beforeSend = options.beforeSend || function() { };
	/**
	 * 要求为Function类型的参数，请求完成后调用的回调函数（请求成功或失败时均调用）。参数：XMLHttpRequest对象和一个描述成功请求类型的字符串。
		function(XMLHttpRequest, textStatus){
			this; //调用本次ajax请求时传递的options参数
		}
	 */
	options.complete = options.complete || function() { };
	/**
	 * 要求为Function类型的参数，请求成功后调用的回调函数，有两个参数。
		(1)由服务器返回，并根据dataType参数进行处理后的数据。
		(2)描述状态的字符串。
			function(data, textStatus){
				//data可能是xmlDoc、jsonObj、html、text等等
				this; //调用本次ajax请求时传递的options参数
			}
	 */
	options.success = options.success || function() { };
	/**
	 * 要求为Function类型的参数，请求失败时被调用的函数。该函数有3个参数，即XMLHttpRequest对象、错误信息、捕获的错误对象(可选)。
	 * ajax事件函数如下：
		function(XMLHttpRequest, textStatus, errorThrown){
			//通常情况下textStatus和errorThrown只有其中一个包含信息
			this; //调用本次ajax请求时传递的options参数
		}
	 */
	options.error = options.error || function() {};
	/**
	 * 要求为Function类型的参数，给Ajax返回的原始数据进行预处理的函数。
	 * 提供data和type两个参数。
	 * 		data是Ajax返回的原始数据，
	 * 		type是调用jQuery.ajax时提供的dataType参数。
	 * 函数返回的值将由jQuery进一步处理。
		function(data, type){
			//返回处理后的数据
			return data;
		}
	 */
	options.dataFilter = options.dataFilter || function() { };
	/**
	 * 发送的数据将被转换为对象（从技术角度来讲并非字符串）以配合默认内容类型"application/x-www-form-urlencoded"。如果要发送DOM树信息或者其他不希望转换的信息，请设置为false。
	 * 要求为Boolean类型的参数，默认为true。默认情况下，
	 */ 
	options.processData = options.processData || true; 
	
	$.ajax({
		type: options.type,
		url: options.url,
		data : options.data,
		dataType: options.dataType,
		timeout: options.timeout,
		async: options.async,
		cache: options.cache,
		contentType:options.contentType,
		beforeSend:options.beforeSend,
		complete: options.complete,/*function(req, textStatus){
			console.log("complete --------------------------");
			console.log(req);
			console.log(textStatus);
			console.log("complete --------------------------");
		},*/
		success: options.success,/*function (data, textStatus){
			console.log("success --------------------------");
			console.log(data);
			console.log(textStatus);
			console.log(options.success);
			console.log("success --------------------------");
			options.success;
		},*/
		error: options.error /*function(req, textStatus, errorThrown){
			console.log("error --------------------------");
			console.log(req);
			console.log(textStatus);
			console.log(errorThrown);
			console.log("error --------------------------");
			options.error;
		}*/
	});
}


function ajax(options) {
	options = options || {};
	if(JSON.stringify(options) == "{}"){
		console.log('error message : ajax parameter is null,plz confirm, ths!')
		return;
	}
	options.type = (options.type || "GET").toUpperCase();
	options.url = options.url || "";
	options.async = options.async || "true";
	options.data = options.data || null;
	options.dataType = options.dataType || "json";
	options.contentType = options.contentType|| "application/x-www-form-urlencoded";
	options.beforeSend = options.beforeSend || function() { };
	options.success = options.success || function() { };
	options.error = options.error || function() {};
	var params = formatParams(options.data);

	var xhr;
	// 第一步
	if (window.ActiveXObject) {// 返回true为ie浏览器内核,否则不是ie内核
		// 为ie内核创建传输对象的方式
		xhr = new window.ActiveXObject("Microsoft.XMLHTTP");
	} else {
		// 为非ie 内核浏览器创建传输对象的方式
		xhr = new XMLHttpRequest();
	}
	/**
	 * readyState:
	 *   0:初始化对象还没有调用open()方法
	 *   1: 已经调用了open()方法 .还没有调用send()方法
	 *   2:已经调用了send()方法
	 *   3.已经开始接受服务器返回来的数据,但是不完整.
	 *   4:完全接收服务器返回来的数据,请求完毕
	 * status :http响应状态码 
	 *   200:ok 
	 *   404:not found 
	 *   304 :not modified 
	 *   5XX(一般都是服务器相关的错误)
	 * responseText :
	 * 	 接收服务器返回来的字符串数据.(html.css,js). php echo 'fasfd';
	 * responseXML :
	 *   接收服务器返回来的xml数据. php: echo $xml;
	 */

	// 接收 - 第三步
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			var status = xhr.status;
			if (status === 200) {
				options.success(xhr.responseText);
			} else {
				options.error(xhr.responseText);
			}
		} else {
			
		}
	}

	// 连接 和 发送 - 第二步
	if (options.type == "GET") {
		xhr.open("GET", options.url + "?" + params, options.async);
		xhr.send(null);
	} else if (options.type == "POST") {
		xhr.open("POST", options.url, options.async);
		// 设置表单提交时的内容类型
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send(params);
	}
}