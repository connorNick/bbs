<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- html svn version:1995 -->
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>讨论区_百度阿里腾讯谷歌小米笔试面试分享_牛客网</title>

<script>
	
</script>
<link rel="stylesheet" href="/frontstatic/css/discuss.css">
<script charset="utf-8" async="" src="/frontstatic/js/discussCenter.js"></script>

<%--<link type="text/css" href="css/style.css" rel="stylesheet">
<link type="text/css" href="css/common_v119.css" rel="stylesheet">--%>
<link type="text/css" href="/frontstatic/css/info.css" rel="stylesheet">
<%--<link rel="stylesheet" href="css/share_style0_16.css">--%>

	<jsp:include page="../common/header_style.jsp"/>
	<%@include file="../common/taglib.jsp"%>
</head>
<body style="position: relative;">


	<div id="page">

		<jsp:include page="../common/header.jsp" />

		<div class="nk-container">


			<div class="nk-main clearfix" style="padding-top: 2px;">
				<div class="mini-banner">
					<a href="" target="_blank"><img src="/frontstatic/images/826546_1482116809065_960x80.jpg"></a>
				</div>
				<!--主体内容-->
				<div class="nk-content">
					<div class="module-box">
						<div class="module-head clearfix">
							<div class="module-head-oprt">
								<a class="btn btn-primary btn-b-publish nc-req-auth"
									href="https://www.nowcoder.com/discuss/post?type=0"> <i
									class="ico-submit"></i> 我要发布
								</a>
							</div>
							<h2>分享与求助</h2>
						</div>
						<div class="tags-box tag-mod">
							<a href="https://www.nowcoder.com/discuss?type=0&amp;order=0"
								class="tag-label selected">全部</a> <a
								href="https://www.nowcoder.com/discuss?type=4&amp;order=0"
								class="tag-label">站内公告</a> <a
								href="https://www.nowcoder.com/discuss?type=2&amp;order=0"
								class="tag-label">笔经面经</a> <a
								href="https://www.nowcoder.com/discuss?type=6&amp;order=0"
								class="tag-label">我要提问</a> <a
								href="https://www.nowcoder.com/discuss?type=1&amp;order=0"
								class="tag-label">技术交流</a> <a
								href="https://www.nowcoder.com/discuss?type=9&amp;order=0"
								class="tag-label">职业发展</a> <a
								href="https://www.nowcoder.com/discuss?type=7&amp;order=0"
								class="tag-label">招聘信息</a> <a
								href="https://www.nowcoder.com/discuss?type=5&amp;order=0"
								class="tag-label">资源分享</a> <a
								href="https://www.nowcoder.com/discuss?type=3&amp;order=0"
								class="tag-label">猿生活</a>
						</div>
						<div class="menu-txt-box">
							<ul class="menu-txt clearfix">
								<li class="selected"><a
									href="https://www.nowcoder.com/discuss?order=0&amp;type=0">最新回复</a>
								</li>
								<li class="menu-pipe">|</li>
								<li><a
									href="https://www.nowcoder.com/discuss?order=3&amp;type=0">最新发表</a>
								</li>
								<li class="menu-pipe">|</li>
								<li><a
									href="https://www.nowcoder.com/discuss?order=1&amp;type=0">最热</a>
								</li>
								<li class="menu-pipe">|</li>
								<li><a
									href="https://www.nowcoder.com/discuss?order=4&amp;type=0">精华</a>
								</li>
							</ul>
						</div>
						<div class="module-body">
							<ul class="common-list">
								<%--<li class="clearfix"><a class="head-pic"
									data-card-uid="450315"
									href="https://www.nowcoder.com/profile/450315"
									data-card-index="1"><img alt="头像"
										src="/frontstatic/images/450315_1475116367502_C21C18731D0C9B0BDD14C81BD06F16400e_100w.jpg"></a>
									<div class="discuss-detail">
										<div class="discuss-main clearfix">
											<a
												href="https://www.nowcoder.com/discuss/20129?type=0&amp;order=0&amp;pos=1&amp;page=1"
												target="_blank"> 免费领取牛客定制版鼠标垫+精美贴纸！ <span class="disTop">置顶</span>
											</a>
										</div>
										<div class="feed-foot">
											<div class="feed-origin">
												<p class="feed-tip">
													<a class="d-name level-color-6" data-card-uid="450315"
														href="https://www.nowcoder.com/profile/450315"
														data-card-index="2"> 我家的狗不咬人</a>&nbsp;&nbsp; 2016-12-12
													&nbsp;&nbsp;发表在 <a
														href="https://www.nowcoder.com/discuss?type=4"> [站内公告]</a>&nbsp;&nbsp;
													最后回复&nbsp;&nbsp;6天前
												</p>
											</div>
											<div class="feed-legend">
												<span>回复<span class="feed-legend-num">1</span></span> <span
													class="feed-legend-pipe">|</span> <span>赞<span
													class="feed-legend-num">0</span></span> <span
													class="feed-legend-pipe">|</span> <span>浏览<span
													class="feed-legend-num">1330</span></span>
											</div>
										</div>
									</div></li>--%>

								<c:forEach items="${list}" varStatus="i" var="item">

								<li class="clearfix"><a class="head-pic"
									data-card-uid="826546"
									href=""
									data-card-index="3"><img alt="头像"
										src="/frontstatic/images/826546_1476151364876_2BB901EB065225630E64E5B07FE0A9E50e_100w.jpg"></a>
									<div class="discuss-detail">
										<div class="discuss-main clearfix">
											<a href="/topic/content/${item.id}.htm" target="_blank"> ${item.name} <span
												class="disTop">置顶</span>
											</a>
										</div>
										<div class="feed-foot">
											<div class="feed-origin">
												<p class="feed-tip">
													<a class="d-name level-color-8" data-card-uid="826546"
														href="https://www.nowcoder.com/profile/826546"
														data-card-index="4"> 牛妹</a>&nbsp;&nbsp; <fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd"/>
													&nbsp;&nbsp;发表在 <a
														href="https://www.nowcoder.com/discuss?type=1"> [技术交流]</a>&nbsp;&nbsp;
													最后回复&nbsp;&nbsp;1小时前
												</p>
											</div>
											<div class="feed-legend">
												<span>回复<span class="feed-legend-num">${item.count}</span></span> <span
													class="feed-legend-pipe">|</span> <span>赞<span
													class="feed-legend-num">0</span></span> <span
													class="feed-legend-pipe">|</span> <span>浏览<span
													class="feed-legend-num">1181</span></span>
											</div>
										</div>
									</div></li>
								</c:forEach>


							</ul>
							<div class="pagination">
								<ul data-total="512">
									<li class="txt-pager disabled js-first-pager"><a
										data-page="1" href="javascript:void(0)">首页</a></li>
									<li class="txt-pager disabled js-pre-pager"><a
										data-page="1" href="javascript:void(0)">上一页</a></li>
									<li class="active js-1-pager"><a href="javascript:void(0)"
										data-page="1">1</a></li>
									<li class="js-2-pager"><a
										href="https://www.nowcoder.com/discuss?type=0&amp;order=0&amp;page=2"
										data-page="2">2</a></li>
									<li class="js-3-pager"><a
										href="https://www.nowcoder.com/discuss?type=0&amp;order=0&amp;page=3"
										data-page="3">3</a></li>
									<li class="js-4-pager"><a
										href="https://www.nowcoder.com/discuss?type=0&amp;order=0&amp;page=4"
										data-page="4">4</a></li>
									<li class="js-5-pager"><a
										href="https://www.nowcoder.com/discuss?type=0&amp;order=0&amp;page=5"
										data-page="5">5</a></li>
									<li class="js-6-pager"><a
										href="https://www.nowcoder.com/discuss?type=0&amp;order=0&amp;page=6"
										data-page="6">6</a></li>
									<li class="js-7-pager"><a
										href="https://www.nowcoder.com/discuss?type=0&amp;order=0&amp;page=7"
										data-page="7">7</a></li>
									<li class="js-8-pager"><a
										href="https://www.nowcoder.com/discuss?type=0&amp;order=0&amp;page=8"
										data-page="8">8</a></li>
									<li class="txt-pager js-next-pager"><a data-page="2"
										href="https://www.nowcoder.com/discuss?type=0&amp;order=0&amp;page=2">下一页</a></li>
									<li class="txt-pager js-last-pager"><a data-page="512"
										href="https://www.nowcoder.com/discuss?type=0&amp;order=0&amp;page=512">末页</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<!--主体内容结束-->
				<div class="nk-bar">
					<div class="module-box column-nk">
						<div class="module-head clearfix">
							<h1>牛客专栏</h1>
						</div>
						<div class="module-body">
							<ul class="column-nk-list">
								<li><a
									href="https://www.nowcoder.com/discuss/zhuanlan/723?type=0">
										<h4 class="column-nk-item column-nk-topic">每日话题</h4>
										<div class="column-nk-txt">
											每天聊点儿有趣的 <span class="column-nk-time">还有23小时结束</span>
										</div>
								</a></li>
								<li><a
									href="https://www.nowcoder.com/discuss/zhuanlan/724?type=0">
										<h4 class="column-nk-item column-nk-talk">牛客访谈</h4>
										<div class="column-nk-txt">
											与大牛零距离交流 <span class="column-nk-time">还有6天结束</span>
										</div>
								</a></li>
								<li><a
									href="https://www.nowcoder.com/discuss/zhuanlan/725?type=0">
										<h4 class="column-nk-item column-nk-code">编程之美</h4>
										<div class="column-nk-txt">
											每周编程进阶实操 <span class="column-nk-time">还有3天结束</span>
										</div>
								</a></li>
							</ul>
						</div>
					</div>

				</div>
			</div>
			<!--主体内容结束-->
			<div class="fixed-menu" style="display: block; bottom: 111.5px;">
				<ul>
					<li><a href="#top" class="gotop" title="回到顶部" id="gotop"></a>
					</li>
					<li><a class="fixed-wb" target="_blank"
						href="http://www.weibo.com/nowcoder"></a></li>
					<li><a
						href="tencent://groupwpa/?subcmd=all&amp;param="
						class="qq" title="QQ"></a></li>
					<li><a href="javascript:void(0);" class="wx"></a>
						<div class="wx-qrcode">
							<img src="/frontstatic/images/wx-rcode.jpg" alt="二维码">
							<p>扫描二维码，关注牛客网</p>
						</div></li>
					<li><a href="https://www.nowcoder.com/discuss/30"
						class="feedback" title="意见反馈"></a> <a
						href="https://www.nowcoder.com/discuss/30" class="feedback-letter">意见反馈</a>
					</li>
					<li><a href="javascript:void(0);" class="qrcode"></a>
						<div class="wx-qrcode">
							<img src="/frontstatic/images/app.png" alt="二维码">
							<p>下载牛客APP，随时随地刷题</p>
						</div></li>
				</ul>
				<div class="phone-qrcode" style="">
					<a href="javascript:void(0);" class="qrcode-close">x</a> <img
						src="/frontstatic/images/app.png" alt="二维码"
						style="width: 70px; height: 70px;">
					<p>扫一扫下载牛客APP</p>
				</div>
			</div>
			<jsp:include page="../common/footer.jsp" />

		</div>
</body>
</html>