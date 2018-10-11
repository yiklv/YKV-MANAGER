<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="./common/common.jsp"></jsp:include>
<script type="text/javascript">
	var intDiff = parseInt(90000);//倒计时总秒数量

	function timer(intDiff) {
		window.setInterval(function() {
			var day = 0, hour = 0, minute = 0, second = 0;//时间默认值
			if (intDiff > 0) {
				day = Math.floor(intDiff / (60 * 60 * 24));
				hour = Math.floor(intDiff / (60 * 60)) - (day * 24);
				minute = Math.floor(intDiff / 60) - (day * 24 * 60)
						- (hour * 60);
				second = Math.floor(intDiff) - (day * 24 * 60 * 60)
						- (hour * 60 * 60) - (minute * 60);
			}
			if (minute <= 9)
				minute = '0' + minute;
			if (second <= 9)
				second = '0' + second;
			$('#day_show').html(day + "天");
			$('#hour_show').html('<s id="h"></s>' + hour + '时');
			$('#minute_show').html('<s></s>' + minute + '分');
			$('#second_show').html('<s></s>' + second + '秒');
			intDiff--;
		}, 1000);
	}

	$(function() {
		timer(intDiff);
	});//倒计时结束

	$(function() {
		/*======右按钮======*/
		$(".you").click(function() {
			nextscroll();
		});
		function nextscroll() {
			var vcon = $(".v_cont");
			var offset = ($(".v_cont li").width()) * -1;
			vcon.stop().animate({
				marginLeft : offset
			}, "slow", function() {
				var firstItem = $(".v_cont ul li").first();
				vcon.find(".flder").append(firstItem);
				$(this).css("margin-left", "0px");
			});
		}
		;
		/*========左按钮=========*/
		$(".zuo").click(function() {
			var vcon = $(".v_cont");
			var offset = ($(".v_cont li").width() * -1);
			var lastItem = $(".v_cont ul li").last();
			vcon.find(".flder").prepend(lastItem);
			vcon.css("margin-left", offset);
			vcon.animate({
				marginLeft : "0px"
			}, "slow")
		});
	});
</script>
</head>
<body>
	<div id="pc-header">
	<jsp:include page="./common/front-login.jsp"></jsp:include>
	<!--  顶部    start-->
	<div class="yHeader">
		<!-- 导航   start  -->
		<div class="yNavIndex">
				<div class="pullDown">
					<h2 class="pullDownTitle">
						<i class="icon-class"></i>所有商品分类
					</h2>
					<ul class="pullDownList">
						<c:forEach items="${ Categorys }" var="categoryType" varStatus="typeStatus">
							<li class=""> <i style="background-image: url(../img/categ/${categoryType.categoryImg});background-size:20px 20px;"></i>
							<c:forEach items="${categoryType.categoryBeans }" var="category" varStatus="cStatus">
								<a id="${category.categoryId }">${category.categoryName}</a>
								<c:if test="${!cStatus.last }">/</c:if>
								<c:if test="${cStatus.last }"></c:if>
							</c:forEach>
							<span></span>
							</li>
						</c:forEach>
					</ul>
					<!-- 下拉详细列表具体分类 -->
					<div class="yMenuListCon" id="">
						<c:forEach items="${Categorys }" var="categoryType" varStatus="indexStatus">
							<div class="yMenuListConin">
								<div class="yMenuLCinList">
									<c:forEach items="${categoryType.categoryBeans}" var="category">
										<h3>
											<a href="${pageContext.request.contextPath}/index/" class="yListName">${category.categoryName}</a> 
											<a href="" class="yListMore">更多 ></a>
										</h3>
										<p>
											<c:if test="${category.categoryBeans != null }">
												<c:forEach items="${category.categoryBeans }" var="subCategory">
													<a href="" class="ecolor610" id="${subCategory.categoryId }">${subCategory.categoryName }</a>
												</c:forEach>
											</c:if>
										</p>
									</c:forEach>
								</div>
								<%-- 
						<div class="yMenuLCinList">
							<h3>
								<a href="" class="yListName">精品男装</a><a href=""
									class="yListMore">更多 ></a>
							</h3>
							<p>
								<a href="" class="ecolor610">大牌上新</a> <a href="">商场同款</a> <a
									href="">男装集结</a> <a href="">羽绒服</a> <a href="">加厚羽绒 </a> <a
									href="">高帮鞋</a> <a href="">商场同款</a> <a href="">男装集结</a> <a
									href="">羽绒服</a> <a href="">加厚羽绒 </a> <a href="">高帮鞋</a> <a
									href="">商场同款</a> <a href="">男装集结</a> <a href="">羽绒服</a> <a
									href="">加厚羽绒 </a> <a href="">高帮鞋</a>
							</p>
						</div> --%>
							</div>
						</c:forEach>
					</div>
				</div>
				<ul class="yMenuIndex">
				<li><a href="" target="_blank">首页</a></li>
				<li><a href="" target="_blank">云购物 </a></li>
				<li><a href="" target="_blank">限时购</a></li>
				<li><a href="" target="_blank">电器城</a></li>
				<li><a href="" target="_blank">家具城</a></li>
				<li><a href="" target="_blank">母婴专场</a></li>
				<li><a href="" target="_blank">数码专场</a></li>
			</ul>
		</div>
		<!-- 导航   end  -->
	</div>
	<!--  顶部    end--> <!-- banner  -->
	<div class="yBanner">
		<div class="yBannerList">
			<div class="yBannerListIn">
				<a href=""><img class="ymainBanner" src="../images/banner1.jpg"
					width="100%"></a>
				<div class="yBannerListInRight">
					<a href=""><img src="../images/BR2.png" width="100%" /></a> <a href=""><img
						src="../images/BR3.png" width="100%" /></a>
				</div>
			</div>
		</div>

		<div class="yBannerList ybannerHide">
			<div class="yBannerListIn">
				<a href=""><img class="ymainBanner" src="../images/banner1.jpg"
					width="100%"></a>
				<div class="yBannerListInRight">
					<a href=""><img src="../images/BR6.png" width="100%" /></a> <a href=""><img
						src="../images/BR4.png" width="100%" /></a>
				</div>
			</div>
		</div>

		<div class="yBannerList ybannerHide">
			<div class="yBannerListIn">
				<a href=""><img class="ymainBanner" src="../images/banner1.jpg"
					width="100%"></a>
				<div class="yBannerListInRight">
					<a href=""><img src="../images/BR7.png" width="100%" /></a> <a href=""><img
						src="../images/BR5.png" width="100%" /></a>
				</div>
			</div>
		</div>
	</div>
	<!-- banner end --> </div>
	<section id="">
	<div class="center pc-ad-img clearfix">
		<div class="pc-center-img">
			<img src="../img/ad/ad1.jpg">
		</div>
		<div class="pc-center-img">
			<img src="../img/ad/ad2.jpg">
		</div>
		<div class="pc-center-img">
			<img src="../img/ad/ad3.jpg">
		</div>
		<div class="pc-center-img">
			<img src="../img/ad/ad4.jpg">
		</div>
		<div class="pc-center-img">
			<img src="../img/ad/ad5.jpg">
		</div>
	</div>
	</section>
	<section id="s">
	<div class="center">
		<div class="pc-center-he">
			<div class="pc-box-he clearfix">
				<div class="fl">
					<i class="pc-time-icon"></i>
				</div>
				<div class="time-item fr">
					<span id="day_show">0天</span> <strong id="hour_show">0时</strong> <strong
						id="minute_show">00分</strong> <strong id="second_show">00秒</strong>
					<em style="color: #fff">后结束抢购</em>
				</div>
			</div>
			<div class="pc-list-goods">
				<div class="flashSale_wrap">
					<div class="flashSale area">
						<div class="tab-content">
							<div class="tab-pane active">
								<div class="flashSaleDeals">
									<div class="v_cont" style="width: 9648px; overflow: hidden">
										<ul class="flder">
											<li index="0">
												<div class="xsq_deal_wrapper">
													<a class="saleDeal" href="page.html" target="_blank">
														<div class="dealCon">
															<img class="dealImg" src="../images/xlqg1.jpg" alt="">
															<div class="zt2Qrcode overlay">
																<div class="xsqMask"></div>
																<p class="word1">15:00开抢</p>
																<p class="word2">限100件，抢完恢复25.8元</p>
																<p class="word3">查看商品&gt;&gt;</p>
															</div>
															<!--<span class="soldOut xsqIcon"></span>-->
														</div>
														<div class="title_new">
															<p class="word" title="YDA-826E 除湿机家用抽湿机除湿器（除湿、干衣力荐）">YDA-826E
																除湿机家用抽湿机除湿器（除湿、干衣力荐）</p>
														</div>
														<div class="dealInfo">
															<span class="price">¥<em>299</em></span> <span
																class="shop_preferential">满2件8.8折</span>
														</div>
													</a>
												</div>
												<div class="xsq_deal_wrapper">
													<a class="saleDeal" href="" target="_blank">
														<div class="dealCon">
															<img class="dealImg" src="../images/xlqg2.jpg" alt="">
															<div class="zt2Qrcode overlay">
																<div class="xsqMask"></div>
																<p class="word1">15:00开抢</p>
																<p class="word2">限100件，抢完恢复25.8元</p>
																<p class="word3">查看商品&gt;&gt;</p>
															</div>
															<div class="stock">
																<div class="xsqMask"></div>
																<span class="stockWord"><i class="stocknumber">还剩73件</i>
																	抢完恢复原价16.8元</span>
															</div>
														</div>
														<div class="title_new">
															<p class="word" title="升级版原汁机低速榨汁机HUZK24WNM ">
																<span class="baoyouText">[包邮]</span>升级版原汁机低速榨汁机HUZK24WNM
															</p>
														</div>
														<div class="dealInfo">
															<span class="price">¥<em>1980</em></span> <span
																class="shop_preferential">满2件8.8折</span>
														</div>
													</a>
												</div>
												<div class="xsq_deal_wrapper">
													<a class="saleDeal" href="" target="_blank">
														<div class="dealCon">
															<img class="dealImg" src="../images/xlqg3.jpg" alt="">
															<div class="finish overlay">
																<div class="xsqMask"></div>
																<p class="word1">15:00开抢</p>
																<p class="word2">限100件，抢完恢复25.8元</p>
																<p class="word3">查看商品&gt;&gt;</p>
															</div>
															<span class="finishIcon xsqIcon"></span>
														</div>
														<div class="title_new">
															<p class="word" title="飞利浦PHILIPS刷头HX6013标准3支装 ">
																<span class="baoyouText">[包邮]</span>飞利浦PHILIPS刷头HX6013标准3支装
															</p>
														</div>
														<div class="dealInfo">
															<span class="price">¥<em>149</em></span> <span
																class="shop_preferential">满2件8.8折</span>
														</div>
													</a>
												</div>
												<div class="xsq_deal_wrapper">
													<a class="saleDeal" href="" target="_blank">
														<div class="dealCon">
															<img class="dealImg" src="../images/xlqg4.jpg" alt="">
															<div class="zt2Qrcode overlay">
																<div class="xsqMask"></div>
																<p class="word1">15:00开抢</p>
																<p class="word2">限100件，抢完恢复25.8元</p>
																<p class="word3">查看商品&gt;&gt;</p>
															</div>
															<div class="stock">
																<div class="xsqMask"></div>
																<span class="stockWord"><i class="stocknumber">还剩73件</i>
																	抢完恢复原价16.8元</span>
															</div>
														</div>
														<div class="title_new">
															<p class="word" title="贝拉米 Bellamy’s 婴幼儿有机奶粉3段">
																<span class="baoyouText">[包邮]</span>贝拉米 Bellamy’s
																婴幼儿有机奶粉3段
															</p>
														</div>
														<div class="dealInfo">
															<span class="price">¥<em>199</em></span> <span
																class="shop_preferential">满2件8.8折</span>
														</div>
													</a>
												</div>
												<div class="xsq_deal_wrapper">
													<a class="saleDeal" href="" target="_blank">
														<div class="dealCon">
															<img class="dealImg" src="../images/xlqg5.jpg" alt="">
															<div class="zt2Qrcode overlay">
																<div class="xsqMask"></div>
																<p class="word1">15:00开抢</p>
																<p class="word2">限100件，抢完恢复25.8元</p>
																<p class="word3">查看商品&gt;&gt;</p>
															</div>
															<div class="stock">
																<div class="xsqMask"></div>
																<span class="stockWord"><i class="stocknumber">还剩73件</i>
																	抢完恢复原价16.8元</span>
															</div>
														</div>
														<div class="title_new">
															<p class="word" title="925银流苏珍珠耳坠耳钉">
																<span class="baoyouText">[包邮]</span>925银流苏珍珠耳坠耳钉
															</p>
														</div>
														<div class="dealInfo">
															<span class="price">¥<em>1</em></span> <span
																class="shop_preferential">满2件8.8折</span>
														</div>
													</a>
												</div>
												<div class="xsq_deal_wrapper">
													<a class="saleDeal" href="" target="_blank">
														<div class="dealCon">
															<img class="dealImg" src="../images/xlqg6.jpg" alt="">
															<div class="zt2Qrcode overlay">
																<div class="xsqMask"></div>
																<p class="word1">15:00开抢</p>
																<p class="word2">限100件，抢完恢复25.8元</p>
																<p class="word3">查看商品&gt;&gt;</p>
															</div>
															<div class="stock">
																<div class="xsqMask"></div>
																<span class="stockWord"><i class="stocknumber">还剩73件</i>
																	抢完恢复原价16.8元</span>
															</div>
														</div>
														<div class="title_new">
															<p class="word" title="925银流苏珍珠耳坠耳钉">
																<span class="baoyouText">[包邮]</span>925银流苏珍珠耳坠耳钉
															</p>
														</div>
														<div class="dealInfo">
															<span class="price">¥<em>1</em></span> <span
																class="shop_preferential">满2件8.8折</span>
														</div>
													</a>
												</div>
											</li>
											<li index="1">
												<div class="xsq_deal_wrapper">
													<a class="saleDeal" href="" target="_blank">
														<div class="dealCon">
															<img class="dealImg" src="../images/xlqg7.jpg" alt="">
															<div class="zt2Qrcode overlay">
																<div class="xsqMask"></div>
																<p class="word1">15:00开抢</p>
																<p class="word2">限100件，抢完恢复25.8元</p>
																<p class="word3">查看商品&gt;&gt;</p>
															</div>
														</div>
														<div class="title_new">
															<p class="word" title="925银流苏珍珠耳坠耳钉">
																<span class="baoyouText">[包邮]</span>925银流苏珍珠耳坠耳钉
															</p>
														</div>
														<div class="dealInfo">
															<span class="price">¥<em>2</em></span> <span
																class="shop_preferential">满2件8.8折</span>
														</div>
													</a>
												</div>
												<div class="xsq_deal_wrapper">
													<a class="saleDeal" href="" target="_blank">
														<div class="dealCon">
															<img class="dealImg" src="../images/xlqg8.jpg" alt="">
															<div class="zt2Qrcode overlay">
																<div class="xsqMask"></div>
																<p class="word1">15:00开抢</p>
																<p class="word2">限100件，抢完恢复25.8元</p>
																<p class="word3">查看商品&gt;&gt;</p>
															</div>
															<div class="stock">
																<div class="xsqMask"></div>
																<span class="stockWord"><i class="stocknumber">还剩73件</i>
																	抢完恢复原价16.8元</span>
															</div>
														</div>
														<div class="title_new">
															<p class="word" title="925银流苏珍珠耳坠耳钉">
																<span class="baoyouText">[包邮]</span>925银流苏珍珠耳坠耳钉
															</p>
														</div>
														<div class="dealInfo">
															<span class="price">¥<em>2</em></span> <span
																class="shop_preferential">满2件8.8折</span>
														</div>
													</a>
												</div>
												<div class="xsq_deal_wrapper">
													<a class="saleDeal" href="" target="_blank">
														<div class="dealCon">
															<img class="dealImg" src="../images/xlqg9.jpg" alt="">
															<div class="finish overlay">
																<div class="xsqMask"></div>
																<p class="word1">15:00开抢</p>
																<p class="word2">限100件，抢完恢复25.8元</p>
																<p class="word3">查看商品&gt;&gt;</p>
															</div>
															<span class="finishIcon xsqIcon"></span>
														</div>
														<div class="title_new">
															<p class="word" title="925银流苏珍珠耳坠耳钉">
																<span class="baoyouText">[包邮]</span>925银流苏珍珠耳坠耳钉
															</p>
														</div>
														<div class="dealInfo">
															<span class="price">¥<em>2</em></span> <span
																class="shop_preferential">满2件8.8折</span>
														</div>
													</a>
												</div>
												<div class="xsq_deal_wrapper">
													<a class="saleDeal" href="" target="_blank">
														<div class="dealCon">
															<img class="dealImg" src="../images/xlqg10.jpg" alt="">
															<div class="zt2Qrcode overlay">
																<div class="xsqMask"></div>
																<p class="word1">15:00开抢</p>
																<p class="word2">限100件，抢完恢复25.8元</p>
																<p class="word3">查看商品&gt;&gt;</p>
															</div>
															<div class="stock">
																<div class="xsqMask"></div>
																<span class="stockWord"><i class="stocknumber">还剩73件</i>
																	抢完恢复原价16.8元</span>
															</div>
														</div>
														<div class="title_new">
															<p class="word" title="925银流苏珍珠耳坠耳钉">
																<span class="baoyouText">[包邮]</span>925银流苏珍珠耳坠耳钉
															</p>
														</div>
														<div class="dealInfo">
															<span class="price">¥<em>2</em></span> <span
																class="shop_preferential">满2件8.8折</span>
														</div>
													</a>
												</div>
												<div class="xsq_deal_wrapper">
													<a class="saleDeal" href="" target="_blank">
														<div class="dealCon">
															<img class="dealImg" src="../images/xlqg11.jpg" alt="">
															<div class="zt2Qrcode overlay">
																<div class="xsqMask"></div>
																<p class="word1">15:00开抢</p>
																<p class="word2">限100件，抢完恢复25.8元</p>
																<p class="word3">查看商品&gt;&gt;</p>
															</div>
															<div class="stock">
																<div class="xsqMask"></div>
																<span class="stockWord"><i class="stocknumber">还剩73件</i>
																	抢完恢复原价16.8元</span>
															</div>
														</div>
														<div class="title_new">
															<p class="word" title="925银流苏珍珠耳坠耳钉">
																<span class="baoyouText">[包邮]</span>925银流苏珍珠耳坠耳钉
															</p>
														</div>
														<div class="dealInfo">
															<span class="price">¥<em>2</em></span> <span
																class="shop_preferential">满2件8.8折</span>
														</div>
													</a>
												</div>
												<div class="xsq_deal_wrapper">
													<a class="saleDeal" href="" target="_blank">
														<div class="dealCon">
															<img class="dealImg" src="../images/xlqg12.jpg" alt="">
															<div class="zt2Qrcode overlay">
																<div class="xsqMask"></div>
																<p class="word1">15:00开抢</p>
																<p class="word2">限100件，抢完恢复25.8元</p>
																<p class="word3">查看商品&gt;&gt;</p>
															</div>
															<div class="stock">
																<div class="xsqMask"></div>
																<span class="stockWord"><i class="stocknumber">还剩73件</i>
																	抢完恢复原价16.8元</span>
															</div>
														</div>
														<div class="title_new">
															<p class="word" title="925银流苏珍珠耳坠耳钉">
																<span class="baoyouText">[包邮]</span>925银流苏珍珠耳坠耳钉
															</p>
														</div>
														<div class="dealInfo">
															<span class="price">¥<em>2</em></span> <span
																class="shop_preferential">满2件8.8折</span>
														</div>
													</a>
												</div>
											</li>
										</ul>
										<a href="javascript:;" class="zuo trigger"></a> <a
											href="javascript:;" class="you trigger"></a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="center pc-top-20">
		<div class="pc-center-he">
			<div class="pc-box-he pc-box-blue clearfix">
				<div class="fl">
					<i class="pc-time-icon"></i>
				</div>
				<div class="fr pc-box-blue-link">
					<a href="#">上衣</a> <a href="#">短裙</a> <a href="#">牛仔裤</a> <a
						href="#">短袖</a> <a href="#">帽子</a>
				</div>
			</div>
			<div class="pc-list-goods">
				<div class="xsq_deal_wrapper pc-deal-list clearfix">
					<a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg13.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word" title="【京东超市】福临门 葵花籽原香食用调和油5L 中粮出品">
								<span class="baoyouText">[包邮]</span>【京东超市】福临门 葵花籽原香食用调和油5L 中粮出品
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>39.9</em></span>
						</div>
					</a> <a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg14.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word"
								title="神火（supfire）C8T6 强光手电筒 远射LED充电式防身灯 配18650电池">
								<span class="baoyouText">[包邮]</span>神火（supfire）C8T6 强光手电筒
								远射LED充电式防身灯 配18650电池
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>99.0</em></span>
						</div>
					</a> <a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg15.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word" title="【京东超市】福临门 葵花籽原香食用调和油5L 中粮出品">
								<span class="baoyouText">[包邮]</span>【京东超市】福临门 葵花籽原香食用调和油5L 中粮出品
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>99.9</em></span>
						</div>
					</a> <a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg16.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word" title="暖风机家用取暖器婴儿电暖气暖手宝浴室防水N">
								<span class="baoyouText">[包邮]</span>暖风机家用取暖器婴儿电暖气暖手宝浴室防水N
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>199.9</em></span>
						</div>
					</a> <a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg17.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word" title="CIKOO 洗澡玩具 戏水玩具 水枪玩具 高压水枪玩具">
								<span class="baoyouText">[包邮]</span>CIKOO 洗澡玩具 戏水玩具 水枪玩具 高压水枪玩具
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>29.0</em></span>
						</div>
					</a> <a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg18.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word"
								title="联想（ThinkPad）轻薄系列E470c（20H3A004CD）14英寸笔记本电脑（i5-6200U 8G 500G 2G独显 Win10）黑色 ">
								<span class="baoyouText">[包邮]</span>联想（ThinkPad）轻薄系列E470c（20H3A004CD）14英寸笔记本电脑（i5-6200U
								8G 500G 2G独显 Win10）黑色
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>4499.9</em></span>
						</div>
					</a>
				</div>
			</div>
		</div>
	</div>
	<div class="center pc-top-20">
		<div class="pc-center-he">
			<div class="pc-box-he pc-box-ge clearfix">
				<div class="fl">
					<i class="pc-time-icon"></i>
				</div>
				<div class="fr pc-box-blue-link">
					<a href="#">上衣</a> <a href="#">短裙</a> <a href="#">牛仔裤</a> <a
						href="#">短袖</a> <a href="#">帽子</a>
				</div>
			</div>
			<div class="pc-list-goods">
				<div class="xsq_deal_wrapper pc-deal-list clearfix">
					<a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg13.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word" title="【京东超市】福临门 葵花籽原香食用调和油5L 中粮出品">
								<span class="baoyouText">[包邮]</span>【京东超市】福临门 葵花籽原香食用调和油5L 中粮出品
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>39.9</em></span>
						</div>
					</a> <a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg14.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word"
								title="神火（supfire）C8T6 强光手电筒 远射LED充电式防身灯 配18650电池">
								<span class="baoyouText">[包邮]</span>神火（supfire）C8T6 强光手电筒
								远射LED充电式防身灯 配18650电池
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>99.0</em></span>
						</div>
					</a> <a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg15.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word" title="【京东超市】福临门 葵花籽原香食用调和油5L 中粮出品">
								<span class="baoyouText">[包邮]</span>【京东超市】福临门 葵花籽原香食用调和油5L 中粮出品
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>99.9</em></span>
						</div>
					</a> <a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg16.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word" title="暖风机家用取暖器婴儿电暖气暖手宝浴室防水N">
								<span class="baoyouText">[包邮]</span>暖风机家用取暖器婴儿电暖气暖手宝浴室防水N
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>199.9</em></span>
						</div>
					</a> <a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg17.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word" title="CIKOO 洗澡玩具 戏水玩具 水枪玩具 高压水枪玩具">
								<span class="baoyouText">[包邮]</span>CIKOO 洗澡玩具 戏水玩具 水枪玩具 高压水枪玩具
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>29.0</em></span>
						</div>
					</a> <a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg18.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word"
								title="联想（ThinkPad）轻薄系列E470c（20H3A004CD）14英寸笔记本电脑（i5-6200U 8G 500G 2G独显 Win10）黑色 ">
								<span class="baoyouText">[包邮]</span>联想（ThinkPad）轻薄系列E470c（20H3A004CD）14英寸笔记本电脑（i5-6200U
								8G 500G 2G独显 Win10）黑色
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>4499.9</em></span>
						</div>
					</a>
				</div>
			</div>
		</div>
	</div>
	<div class="center pc-top-20">
		<div class="pc-center-he">
			<div class="pc-box-he pc-box-re clearfix">
				<div class="fl">
					<i class="pc-time-icon"></i>
				</div>
				<div class="fr pc-box-blue-link">
					<a href="#">上衣</a> <a href="#">短裙</a> <a href="#">牛仔裤</a> <a
						href="#">短袖</a> <a href="#">帽子</a>
				</div>
			</div>
			<div class="pc-list-goods">
				<div class="xsq_deal_wrapper pc-deal-list clearfix">
					<a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg13.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word" title="【京东超市】福临门 葵花籽原香食用调和油5L 中粮出品">
								<span class="baoyouText">[包邮]</span>【京东超市】福临门 葵花籽原香食用调和油5L 中粮出品
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>39.9</em></span>
						</div>
					</a> <a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg14.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word"
								title="神火（supfire）C8T6 强光手电筒 远射LED充电式防身灯 配18650电池">
								<span class="baoyouText">[包邮]</span>神火（supfire）C8T6 强光手电筒
								远射LED充电式防身灯 配18650电池
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>99.0</em></span>
						</div>
					</a> <a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg15.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word" title="【京东超市】福临门 葵花籽原香食用调和油5L 中粮出品">
								<span class="baoyouText">[包邮]</span>【京东超市】福临门 葵花籽原香食用调和油5L 中粮出品
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>99.9</em></span>
						</div>
					</a> <a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg16.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word" title="暖风机家用取暖器婴儿电暖气暖手宝浴室防水N">
								<span class="baoyouText">[包邮]</span>暖风机家用取暖器婴儿电暖气暖手宝浴室防水N
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>199.9</em></span>
						</div>
					</a> <a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg17.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word" title="CIKOO 洗澡玩具 戏水玩具 水枪玩具 高压水枪玩具">
								<span class="baoyouText">[包邮]</span>CIKOO 洗澡玩具 戏水玩具 水枪玩具 高压水枪玩具
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>29.0</em></span>
						</div>
					</a> <a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg18.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word"
								title="联想（ThinkPad）轻薄系列E470c（20H3A004CD）14英寸笔记本电脑（i5-6200U 8G 500G 2G独显 Win10）黑色 ">
								<span class="baoyouText">[包邮]</span>联想（ThinkPad）轻薄系列E470c（20H3A004CD）14英寸笔记本电脑（i5-6200U
								8G 500G 2G独显 Win10）黑色
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>4499.9</em></span>
						</div>
					</a>
				</div>
			</div>
		</div>
	</div>
	<div class="center pc-top-20">
		<div class="pc-center-he">
			<div class="pc-box-he pc-box-qr clearfix">
				<div class="fl">
					<i class="pc-time-icon"></i>
				</div>
				<div class="fr pc-box-blue-link">
					<a href="#">上衣</a> <a href="#">短裙</a> <a href="#">牛仔裤</a> <a
						href="#">短袖</a> <a href="#">帽子</a>
				</div>
			</div>
			<div class="pc-list-goods">
				<div class="xsq_deal_wrapper pc-deal-list clearfix">
					<a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg13.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word" title="【京东超市】福临门 葵花籽原香食用调和油5L 中粮出品">
								<span class="baoyouText">[包邮]</span>【京东超市】福临门 葵花籽原香食用调和油5L 中粮出品
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>39.9</em></span>
						</div>
					</a> <a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg14.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word"
								title="神火（supfire）C8T6 强光手电筒 远射LED充电式防身灯 配18650电池">
								<span class="baoyouText">[包邮]</span>神火（supfire）C8T6 强光手电筒
								远射LED充电式防身灯 配18650电池
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>99.0</em></span>
						</div>
					</a> <a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg15.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word" title="【京东超市】福临门 葵花籽原香食用调和油5L 中粮出品">
								<span class="baoyouText">[包邮]</span>【京东超市】福临门 葵花籽原香食用调和油5L 中粮出品
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>99.9</em></span>
						</div>
					</a> <a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg16.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word" title="暖风机家用取暖器婴儿电暖气暖手宝浴室防水N">
								<span class="baoyouText">[包邮]</span>暖风机家用取暖器婴儿电暖气暖手宝浴室防水N
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>199.9</em></span>
						</div>
					</a> <a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg17.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word" title="CIKOO 洗澡玩具 戏水玩具 水枪玩具 高压水枪玩具">
								<span class="baoyouText">[包邮]</span>CIKOO 洗澡玩具 戏水玩具 水枪玩具 高压水枪玩具
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>29.0</em></span>
						</div>
					</a> <a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg18.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word"
								title="联想（ThinkPad）轻薄系列E470c（20H3A004CD）14英寸笔记本电脑（i5-6200U 8G 500G 2G独显 Win10）黑色 ">
								<span class="baoyouText">[包邮]</span>联想（ThinkPad）轻薄系列E470c（20H3A004CD）14英寸笔记本电脑（i5-6200U
								8G 500G 2G独显 Win10）黑色
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>4499.9</em></span>
						</div>
					</a>
				</div>
			</div>
		</div>
	</div>
	<div class="center pc-top-20">
		<div class="pc-center-he">
			<div class="pc-box-he pc-box-ue clearfix">
				<div class="fl">
					<i class="pc-time-icon"></i>
				</div>
				<div class="fr pc-box-blue-link">
					<a href="#">上衣</a> <a href="#">短裙</a> <a href="#">牛仔裤</a> <a
						href="#">短袖</a> <a href="#">帽子</a>
				</div>
			</div>
			<div class="pc-list-goods" style="height: auto">
				<div class="xsq_deal_wrapper pc-deal-list clearfix">
					<a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg19.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word" title="【京东超市】福临门 葵花籽原香食用调和油5L 中粮出品">
								<span class="baoyouText">[包邮]</span>【京东超市】福临门 葵花籽原香食用调和油5L 中粮出品
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>39.9</em></span>
						</div>
					</a> <a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg14.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word"
								title="神火（supfire）C8T6 强光手电筒 远射LED充电式防身灯 配18650电池">
								<span class="baoyouText">[包邮]</span>神火（supfire）C8T6 强光手电筒
								远射LED充电式防身灯 配18650电池
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>99.0</em></span>
						</div>
					</a> <a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg15.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word" title="【京东超市】福临门 葵花籽原香食用调和油5L 中粮出品">
								<span class="baoyouText">[包邮]</span>【京东超市】福临门 葵花籽原香食用调和油5L 中粮出品
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>99.9</em></span>
						</div>
					</a> <a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg16.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word" title="暖风机家用取暖器婴儿电暖气暖手宝浴室防水N">
								<span class="baoyouText">[包邮]</span>暖风机家用取暖器婴儿电暖气暖手宝浴室防水N
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>199.9</em></span>
						</div>
					</a> <a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg17.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word" title="CIKOO 洗澡玩具 戏水玩具 水枪玩具 高压水枪玩具">
								<span class="baoyouText">[包邮]</span>CIKOO 洗澡玩具 戏水玩具 水枪玩具 高压水枪玩具
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>29.0</em></span>
						</div>
					</a> <a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg18.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word"
								title="联想（ThinkPad）轻薄系列E470c（20H3A004CD）14英寸笔记本电脑（i5-6200U 8G 500G 2G独显 Win10）黑色 ">
								<span class="baoyouText">[包邮]</span>联想（ThinkPad）轻薄系列E470c（20H3A004CD）14英寸笔记本电脑（i5-6200U
								8G 500G 2G独显 Win10）黑色
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>4499.9</em></span>
						</div>
					</a>
				</div>
				<div class="xsq_deal_wrapper pc-deal-list clearfix">
					<a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg13.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word" title="【京东超市】福临门 葵花籽原香食用调和油5L 中粮出品">
								<span class="baoyouText">[包邮]</span>【京东超市】福临门 葵花籽原香食用调和油5L 中粮出品
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>39.9</em></span>
						</div>
					</a> <a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg14.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word"
								title="神火（supfire）C8T6 强光手电筒 远射LED充电式防身灯 配18650电池">
								<span class="baoyouText">[包邮]</span>神火（supfire）C8T6 强光手电筒
								远射LED充电式防身灯 配18650电池
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>99.0</em></span>
						</div>
					</a> <a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg15.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word" title="【京东超市】福临门 葵花籽原香食用调和油5L 中粮出品">
								<span class="baoyouText">[包邮]</span>【京东超市】福临门 葵花籽原香食用调和油5L 中粮出品
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>99.9</em></span>
						</div>
					</a> <a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg16.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word" title="暖风机家用取暖器婴儿电暖气暖手宝浴室防水N">
								<span class="baoyouText">[包邮]</span>暖风机家用取暖器婴儿电暖气暖手宝浴室防水N
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>199.9</em></span>
						</div>
					</a> <a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg17.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word" title="CIKOO 洗澡玩具 戏水玩具 水枪玩具 高压水枪玩具">
								<span class="baoyouText">[包邮]</span>CIKOO 洗澡玩具 戏水玩具 水枪玩具 高压水枪玩具
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>29.0</em></span>
						</div>
					</a> <a class="saleDeal" href="" target="_blank">
						<div class="dealCon">
							<img class="dealImg" src="../images/xlqg18.jpg" alt="">
						</div>
						<div class="title_new">
							<p class="word"
								title="联想（ThinkPad）轻薄系列E470c（20H3A004CD）14英寸笔记本电脑（i5-6200U 8G 500G 2G独显 Win10）黑色 ">
								<span class="baoyouText">[包邮]</span>联想（ThinkPad）轻薄系列E470c（20H3A004CD）14英寸笔记本电脑（i5-6200U
								8G 500G 2G独显 Win10）黑色
							</p>
						</div>
						<div class="dealInfo">
							<span class="price">¥<em>4499.9</em></span>
						</div>
					</a>
				</div>
			</div>
		</div>
	</div>
	</section>

	<div style="height: 100px"></div>
	<jsp:include page="./common/footer.jsp"></jsp:include>
	<script type="text/javascript">
		//hover 触发两个事件，鼠标移上去和移走
		//mousehover 只触发移上去事件
		$(".top-nav ul li").hover(function() {
			$(this).addClass("hover").siblings().removeClass("hover");
			$(this).find("li .nav a").addClass("hover");
			$(this).find(".con").show();
		}, function() {
			//$(this).css("background-color","#f5f5f5");
			$(this).find(".con").hide();
			//$(this).find(".nav a").removeClass("hover");
			$(this).removeClass("hover");
			$(this).find(".nav a").removeClass("hover");
		})
	</script>
	<debug/>
</body>
</html>
