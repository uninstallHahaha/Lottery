<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

	<head>
		<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
		<title>公交路线规划</title>
		<!--百度地图-->
		<script type="text/javascript" src="http://api.map.baidu.com/api?v=3.0&ak=lG1VWYp7csmOHn3Au6WRSrLKlGaSXIk3"></script>
		<!--jquery-->
		<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
		<script src="layer/layer.js"></script>
		<script src="js/index.js"></script>

		<!-- 新 Bootstrap 核心 CSS 文件 -->
		<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

		<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
		<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

		<link href="../css/pCenter.css" rel="stylesheet">

		<title></title>
	</head>

	<body>
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<nav class="navbar navbar-default" role="navigation" style="margin: 0px;">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
							<a class="navbar-brand" href="../index.jsp">Buser</a>
						</div>

						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav">
								<li>
									<a href="../index.jsp">地图</a>
								</li>
								<li class="active">
									<a href="news.jsp">新闻</a>
								</li>
								<li class="dropdown">
									<a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
										<li>
											<a href="#">Action</a>
										</li>
										<li>
											<a href="#">Another action</a>
										</li>
										<li>
											<a href="#">Something else here</a>
										</li>
										<li class="divider">
										</li>
										<li>
											<a href="#">Separated link</a>
										</li>
										<li class="divider">
										</li>
										<li>
											<a href="#">One more separated link</a>
										</li>
									</ul>
								</li>
							</ul>

							<ul class="nav navbar-nav navbar-right">
								<li>
									<a href="#" id="showEw">码</a>
								</li>
								<li class="dropdown">
									<a href="#" class="dropdown-toggle" data-toggle="dropdown">我的<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
										<li>
											<a href="pCenter.jsp">个人中心</a>
										</li>
										<li>
											<a href="#">Another action</a>
										</li>
										<li>
											<a href="#">Something else here</a>
										</li>
										<li class="divider">
										</li>
										<li>
											<a href="#">Separated link</a>
										</li>
									</ul>
								</li>
							</ul>
						</div>

					</nav>
					<div class="row clearfix" style="    display: flex;justify-content : center;">
						<div class="col-md-12 column" style="width: 75%;;">

							<div class="col-md-12 column">
								<div class="row clearfix main">
									<div class="col-md-4 column">
										<div class="panel panel-default pPanel">

											<div class="panel-body">

											</div><img alt="140x140" src="v3/default3.jpg" class="img-circle" /> <button type="button" class="btn btn-default btn-link">修改个人信息</button>
										</div>

									</div>

									<div class="col-md-8 column">
										<div class="panel panel-default">
											<div class="panel-heading">
												<h3 class="panel-title">
								我的收藏
							</h3>
											</div>
											<div class="panel-body myFavList">
												<ul class="list-group newslist">
													<li class="list-group-item"><a href="#">免费 Window 空间托管</a></li>
													<li class="list-group-item">图像的数量</li>
													<li class="list-group-item">24*7 支持</li>
													<li class="list-group-item">每年更新成本</li>
													<li class="list-group-item">免费域名注册</li>
													<li class="list-group-item">免费 Window 空间托管</li>
													<li class="list-group-item">图像的数量</li>
													<li class="list-group-item">24*7 支持</li>
													<li class="list-group-item">每年更新成本</li>
													<li class="list-group-item">免费域名注册</li>
													<li class="list-group-item">免费 Window 空间托管</li>
													<li class="list-group-item">图像的数量</li>
													<li class="list-group-item">24*7 支持</li>
													<li class="list-group-item">每年更新成本</li>
													<li class="list-group-item">免费域名注册</li>
													<li class="list-group-item">免费 Window 空间托管</li>
													<li class="list-group-item">图像的数量</li>
													<li class="list-group-item">24*7 支持</li>
													<li class="list-group-item">每年更新成本</li>
													<li class="list-group-item">免费域名注册</li>
													<li class="list-group-item">免费 Window 空间托管</li>
													<li class="list-group-item">图像的数量</li>
													<li class="list-group-item">24*7 支持</li>
													<li class="list-group-item">每年更新成本</li>
												</ul>
											</div>

										</div>
									</div>

								</div>
							</div>

							<div class="coverCopyRight">@ 2020 Aaidu.com</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>

</html>