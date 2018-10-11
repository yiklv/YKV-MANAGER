$(function() {
	// 导航左侧栏js效果 start
	$(".pullDownList li").hover(
			function() {
				$(".yMenuListCon").fadeIn();// fadeIn() 方法使用淡入效果来显示被选元素，假如该元素是隐藏的。
				var index = $(this).index(".pullDownList li");
				if (!($(this).hasClass("menulihover") || $(this).hasClass("menuliselected"))) {
					$($(".yBannerList")[index]).css("display", "block").siblings().css("display", "none");
					$($(".yBannerList")[index]).removeClass("ybannerExposure");
					setTimeout( function() { $($(".yBannerList")[index]).addClass( "ybannerExposure"); }, 60)
				} else {
				}
				$(this).addClass("menulihover").siblings().removeClass("menulihover");//siblings() 获得匹配集合中每个元素的同胞，通过选择器进行筛选是可选的。
				$(this).addClass("menuliselected").siblings().removeClass("menuliselected");
				$($(".yMenuListConin")[index]).fadeIn().siblings().fadeOut();// fadeOut() 方法使用淡出效果来隐藏被选元素，假如该元素是隐藏的
			}, function() {

			})
	$(".pullDown").mouseleave(function() {
		$(".yMenuListCon").fadeOut();
		$(".yMenuListConin").fadeOut();
		$(".pullDownList li").removeClass("menulihover");

	})
	// 导航左侧栏js效果 end

})
