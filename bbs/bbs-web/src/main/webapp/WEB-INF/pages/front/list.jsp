<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- html svn version:1995 -->
<html  style="height: 100%;" xmlns:wb="http://open.weibo.com/wb" xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>分享牛</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<jsp:include page="../common/header_style.jsp"/>
	<%@include file="../common/taglib.jsp"%>

<link rel="stylesheet" href="/frontstatic/css/discuss.css">

</head>
<body style="position: relative;">
	<div id="page">
		<jsp:include page="../common/header.jsp" />
		<div class="nk-container">
			<div class="nk-main clearfix" style="padding-top: 2px;">
				<%--<div class="mini-banner">
					<a href="" target="_blank"><img src="/frontstatic/images/826546_1482116809065_960x80.jpg"></a>
				</div>--%>
				<!--主体内容-->
				<div class="nk-content" style="width:100%">
					<div class="module-box">
						<div class="module-head clearfix">
							<div class="module-head-oprt">
								<%--<a class="btn btn-primary btn-b-publish nc-req-auth"
									href="https://www.nowcoder.com/discuss/post?type=0"> <i
									class="ico-submit"></i> 我要发布
								</a>--%>
							</div>
							<h2>分享与求助</h2>
						</div>
						<div class="tags-box tag-mod">
							<a href="/topic/list" class="tag-label selected">全部</a>
							<c:forEach items="${techlist}" varStatus="i" var="item">
								<a href="/topic/list?categoryId=${item.id}" class="tag-label">${item.rmsValue}</a>
							</c:forEach>
						</div>
						<div class="menu-txt-box">
							<ul class="menu-txt clearfix">
								<%--<li class="selected"><a
									href="https://www.nowcoder.com/discuss?order=0&amp;type=0">最新回复</a>
								</li>--%>
								<li class="menu-pipe">|</li>
								<li><a
									href="https://www.nowcoder.com/discuss?order=3&amp;type=0">最新发表</a>
								</li>
								<li class="menu-pipe">|</li>
								<li><a
									href="https://www.nowcoder.com/discuss?order=1&amp;type=0">最热</a>
								</li>
								<li class="menu-pipe">|</li>
								<%--<li><a
									href="https://www.nowcoder.com/discuss?order=4&amp;type=0">精华</a>
								</li>--%>
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
											<a href="/topic/content/${item.id}.htm?length=5" target="_blank"> ${item.name}
												<%--<span class="disTop">置顶</span>--%>
											</a>
										</div>
										<div class="feed-foot">
											<div class="feed-origin">
												<p class="feed-tip">
													<a class="d-name level-color-8" data-card-uid="826546"
														href="https://www.nowcoder.com/profile/826546"
														data-card-index="4"> ${item.username}</a>&nbsp;&nbsp; <fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd"/>
													&nbsp;&nbsp;发表在 <a
														href="https://www.nowcoder.com/discuss?type=1"> [技术交流]</a>&nbsp;&nbsp;
													最后回复&nbsp;&nbsp;1小时前
												</p>
											</div>
											<div class="feed-legend">
												<span>回复<span class="feed-legend-num">${item.count}</span></span>
												<%--<span class="feed-legend-pipe">|</span> <span>赞<span
													class="feed-legend-num">0</span></span> --%>
												<%--<span class="feed-legend-pipe">|</span>
												<span>浏览<span class="feed-legend-num">1181</span></span>--%>
											</div>
										</div>
									</div></li>
								</c:forEach>


							</ul>
							<div class="demo customBootstrap">
								<%--<p id="demo2-text"></p>--%>
								<ul id="topicPage" class="pagination"></ul>
							</div>
						</div>
					</div>
				</div>
				<!--主体内容结束-->
				<%--<div class="nk-bar">
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

				</div>--%>
			</div>
			<!--主体内容结束-->
			<%--<div class="fixed-menu" style="display: block; bottom: 111.5px;">
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
			</div>--%>
			<script type="text/javascript" src="/frontstatic/jqPaginator/js/jqPaginator.js"></script>
			<script type="text/javascript">
				$(document).ready(function(){

					$("#topicPage").jqPaginator({
						totalCounts: ${total},//设置总条数
						visiblePages: 9,//设置最多显示的页码数（例如有100也，当前第1页，则显示1 - 7页）
						currentPage: ${vo.pageable.currentPage},//设置当前的页码
						pageSize:10,//设置每一页的条目数,注意：要么设置totalPages，要么设置totalCounts + pageSize，否则报错；设置了totalCounts和pageSize后，会自动计算出totalPages。
                        first: '<li class="first"><a href="javascript:void(0);">首页<\/a><\/li>',
                        prev: '<li class="prev"><a href="javascript:void(0);"><i class="arrow arrow2"><\/i>上一页<\/a><\/li>',
                        next: '<li class="next"><a href="javascript:void(0);">下一页<i class="arrow arrow3"><\/i><\/a><\/li>',
                        last: '<li class="last"><a href="javascript:void(0);">末页<\/a><\/li>',
						page: '<li class="page"><a href="javascript:void(0);">{{page}}<\/a><\/li>',
						onPageChange: function (n,type) {
							if(type!='init'){
								window.location.href="/topic/list?categoryId=${vo.parameters.categoryId}&start="+((n-1)*10)+"&length="+10;
							}
						}
					});
                });
			</script>
			<jsp:include page="../common/footer.jsp" />

		</div>
</body>
</html>