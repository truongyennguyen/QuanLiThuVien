<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html class="no-js" lang="zxx">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Home</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Place favicon.ico in the root directory -->
<link rel="apple-touch-icon" href="images/apple-touch-icon.png">
<link rel="shortcut icon" type="image/ico" href="images/favicon.ico" />

<!-- Plugin-CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/icofont.css">
<link rel="stylesheet" href="css/animate.css">
<link rel="stylesheet" href="css/cardslider.css">
<link rel="stylesheet" href="css/responsiveslides.css">

<!-- Main-Stylesheets -->
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/overright.css">
<link rel="stylesheet" href="css/theme.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/responsive.css">
<script src="js/vendor/modernizr-2.8.3.min.js"></script>
<style type="text/css" media="screen">
</style>
</head>

<body data-spy="scroll" data-target="#mainmenu" data-offset="50">
	<header class="relative" id="sc1">
		<!-- Header-background-markup -->
		<div class="header-bg relative home-slide">
			<div class="item">
				<img src="images/slide/slide1.jpg" alt="library">
			</div>
			<div class="item">
				<img src="images/slide/slide2.jpg" alt="library">
			</div>
			<div class="item">
				<img src="images/slide/slide3.jpg" alt="library">
			</div>
			<div class="item">
				<img src="images/slide/slide4.jpg" alt="library">
			</div>
		</div>
		<!-- Mainmenu-markup-start -->
		<div class="mainmenu-area navbar-fixed-top" data-spy="affix"
			data-offset-top="10">
			<nav class="navbar">
				<div class="container">
					<div class="navbar-header">
						<div class="space-10"></div>
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#mainmenu">
							<span class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<!--Logo-->
						<!-- <a href="#sc1" class="navbar-left show"><img src="images/logo.png" alt="library"></a> -->
						<div class="space-10"></div>
					</div>
					<!--Toggle-button-->

					<!--Active User-->
					<!-- <div class="nav navbar-right">
                        <div class="active-user navbar-left active">
                            <ul class="list-unstyled">
                                <li>
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                        <img src="images/active_user.png" class="img-circle img-thumbnail" alt="library" />
                                    </a>
                                    <ul class="dropdown-menu">
                                        <li>
                                            <a href="#"> <span><i class="icofont icofont-user"></i></span> Thông tin cá nhân</a>
                                        </li>
                                        <li>
                                            <a href="#"> <span><i class="icofont icofont-notification"></i></span> Notifications</a>
                                        </li>
                                        <li>
                                            <a href="#"> <span><i class="icofont icofont-ui-password"></i></span> Đổi mật khẩu</a>
                                        </li>
                                        <li>
                                            <a href="#"> <span><i class="icofont icofont-read-book"></i></span> Sách của tôi</a>
                                        </li>
                                        <li>
                                            <a href="#"> <span><i class="icofont icofont-logout"></i></span> Đăng xuất</a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </div> -->
					<!--Mainmenu list-->
					<div class="navbar-right in fade" id="mainmenu">
						<ul class="nav navbar-nav nav-white text-uppercase">
							<li class="active"><a href="index.jsp">Trang chủ</a></li>
							<li><a href="#">Giới thiệu</a></li>
							<li><a href="noitification.jsp">Thông báo</a></li>
							<li><a href="room.jsp">Phòng đọc</a></li>
							<li><a href="feedback.jsp">Phản hồi</a></li>
							<li><a href="books.jsp">Sách</a></li>
							<li><a href="login.jsp">Đăng nhập</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
		<div class="space-100"></div>
		<!-- Mainmenu-markup-end -->
		<!-- Header-jumbotron -->
		<div class="space-100"></div>
		<div class="header-text">
			<div class="container">
				<div class="row wow fadeInUp">
					<div class="col-xs-12 col-sm-10 col-sm-offset-1 text-center">
						<div class="jumbotron">
							<h1 class="text-white">Có hơn 458,948 cuốn sách ở đây</h1>
							<p class="text-white">Đến với thư viện đa năng của chúng tôi
								bạn có thể tận hưởng sự tuyệt vời thời đại mới tha hồ đọc, tải,
								mượn trực tuyến cùng những cuốn sách mới nhất, hay nhất!!!</p>
						</div>
						<div class="title-bar white">
							<ul class="list-inline list-unstyled">
								<li><i class="icofont icofont-square"></i></li>
								<li><i class="icofont icofont-square"></i></li>
							</ul>
						</div>
						<div class="space-40"></div>
					</div>
				</div>
				<div class="row wow fadeInUp" data-wow-delay="0.5s">
					<div
						class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3 ">
						<div class="panel">
							<div class="panel-heading">
								<ul class="nav nav-tabs">
									<li class="active"><a data-toggle="tab" href="#book">Sách</a></li>
									<li><a data-toggle="tab" href="#author">Tác giả</a></li>
									<li><a data-toggle="tab" href="#publisher">Nhà xuất
											bản</a></li>
								</ul>
							</div>
							<div class="panel-body">
								<div class="tab-content">
									<div class="tab-pane fade in active" id="book">
										<form action="#">
											<div class="input-group">
												<input type="text" class="form-control"
													placeholder="Enter book name">
												<div class="input-group-btn">
													<button type="submit" class="btn btn-primary">
														<i class="icofont icofont-search-alt-2"></i>
													</button>
												</div>
											</div>
										</form>
									</div>
									<div class="tab-pane fade" id="author">
										<form action="#">
											<div class="input-group">
												<input type="text" class="form-control"
													placeholder="Enter author name">
												<div class="input-group-btn">
													<button type="submit" class="btn btn-primary">
														<i class="icofont icofont-search-alt-2"></i>
													</button>
												</div>
											</div>
										</form>
									</div>
									<div class="tab-pane fade" id="publisher">
										<form action="#">
											<div class="input-group">
												<input type="text" class="form-control"
													placeholder="Enter publisher name">
												<div class="input-group-btn">
													<button type="submit" class="btn btn-primary">
														<i class="icofont icofont-search-alt-2"></i>
													</button>
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="space-100"></div>
		<!-- Header-jumbotron-end -->
	</header>
	<section class="gray-bg" id="sc2">
		<div class="space-80"></div>
		<div class="container">
			<div class="row">
				<div
					class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3 text-center">
					<h2>
						<strong>Giới thiệu</strong>
					</h2>
					<div class="space-20"></div>
					<div class="title-bar blue">
						<ul class="list-inline list-unstyled">
							<li><i class="icofont icofont-square"></i></li>
							<li><i class="icofont icofont-square"></i></li>
						</ul>
					</div>
					<div class="space-30"></div>
					<p>Bạn sẽ thỏa mãn với những cuốn sách hay nhất. Chúng tôi sẽ
						luôn cập nhập sách mới nhất.</p>
				</div>
			</div>
			<div class="space-60"></div>
			<div class="row">
				<div
					class="hidden-xs hidden-sm col-sm-5 pull-right  wow fadeInRight">
					<div class="space-60"></div>
					<div class="my-slider">
						<ul>
							<li><img src="images/about-slide/slide1.jpg" alt="library"></li>
							<li><img src="images/about-slide/slide2.jpg" alt="library"></li>
							<li><img src="images/about-slide/slide3.jpg" alt="library"></li>
							<li><img src="images/about-slide/slide4.jpg" alt="library"></li>
							<li><img src="images/about-slide/slide5.jpg" alt="library"></li>
							<li><img src="images/about-slide/slide6.jpg" alt="library"></li>
						</ul>
					</div>
					<div class="mama"></div>
				</div>
				<div class="col-xs-12 col-md-7">
					<ul class="list-unstyled list-inline text-yellow tip">
						<li><i class="icofont icofont-square"></i></li>
						<li><i class="icofont icofont-square"></i></li>
						<li><i class="icofont icofont-square"></i></li>
					</ul>
					<div class="space-15"></div>
					<p>Thư viện sẽ đem lại điều tuyệt vời cho bạn khi ghé thăm.</p>
					<div class="space-60"></div>
					<div class="row">
						<div class="col-xs-12 col-sm-6 wow fadeIn">
							<ul class="list-unstyled list-inline icon-bar">
								<li><i class="icofont icofont-id-card"></i></li>
							</ul>
							<h3>Thẻ thành viên</h3>
							<p>Đăng kí thành viên để tận hưởng thư viện online hiện đại
								này!</p>
							<div class="space-30"></div>
						</div>
						<div class="col-xs-12 col-sm-6 wow fadeIn">
							<ul class="list-unstyled list-inline icon-bar">
								<li><i class="icofont icofont-medal-alt"></i></li>
							</ul>
							<h3>Sách chất lượng cao</h3>
							<p>Luôn cập nhập, đổi sách mới nhất, hay nhất!</p>
							<div class="space-30"></div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-6 wow fadeIn">
							<ul class="list-unstyled list-inline icon-bar">
								<li><i class="icofont icofont-read-book-alt"></i></li>
							</ul>
							<h3>Miễn phí tất cả các sách</h3>
							<p>Hot Hot đang những ngày dowload sách free!</p>
							<div class="space-30"></div>
						</div>
						<div class="col-xs-12 col-sm-6 wow fadeIn">
							<ul class="list-unstyled list-inline icon-bar">
								<li><i class="icofont icofont-book-alt"></i></li>
							</ul>
							<h3>Liên tục cập nhật</h3>
							<p>Nhiều sách mới nhất đã được nhập về!</p>
							<div class="space-30"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="space-60"></div>
	</section>
	<section>
		<div class="space-80"></div>
		<div class="container">
			<div class="row">
				<div
					class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3 text-center">
					<h2>
						<strong>Danh mục sách</strong>
					</h2>
					<div class="space-20"></div>
					<div class="title-bar blue">
						<ul class="list-inline list-unstyled">
							<li><i class="icofont icofont-square"></i></li>
							<li><i class="icofont icofont-square"></i></li>
						</ul>
					</div>
					<div class="space-30"></div>
					<p>Cùng tìm hiểu về sách nhé!!!</p>
				</div>
			</div>
			<div class="space-60"></div>
			<div class="row text-center">
				<div class="col-xs-12 col-sm-6 col-md-3 wow fadeInLeft"
					data-wow-delay="0.1s">
					<div class="category-item well blue text-cetnr">
						<div class="category_icon">
							<i class="icofont icofont-music"></i>
						</div>
						<div class="space-20"></div>
						<div class="title-bar">
							<ul class="list-inline list-unstyled">
								<li><i class="icofont icofont-square"></i></li>
							</ul>
						</div>
						<div class="space-20"></div>
						<a href="b_amNhacHoiHoa.jsp">Âm nhạc và hội họa</a>
					</div>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-3 wow fadeInLeft"
					data-wow-delay="0.2s">
					<div class="category-item well red text-cetnr">
						<div class="category_icon">
							<i class="icofont icofont-coins"></i>
						</div>
						<div class="space-20"></div>
						<div class="title-bar">
							<ul class="list-inline list-unstyled">
								<li><i class="icofont icofont-square"></i></li>
							</ul>
						</div>
						<div class="space-20"></div>
						<a href="b_Truyen.jsp">Truyện</a>
					</div>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-3 wow fadeInLeft"
					data-wow-delay="0.3s">
					<div class="category-item well yellow text-cetnr">
						<div class="category_icon">
							<i class="icofont icofont-bank-alt"></i>
						</div>
						<div class="space-20"></div>
						<div class="title-bar">
							<ul class="list-inline list-unstyled">
								<li><i class="icofont icofont-square"></i></li>
							</ul>
						</div>
						<div class="space-20"></div>
						<a href="b_ChinhTri.jsp">Chính trị</a>
					</div>
				</div>

				<div class="col-xs-12 col-sm-6 col-md-3 wow fadeInLeft"
					data-wow-delay="0.4s">
					<div class="category-item well green text-cetnr">
						<div class="category_icon">
							<i class="icofont icofont-globe-alt"></i>
						</div>
						<div class="space-20"></div>
						<div class="title-bar">
							<ul class="list-inline list-unstyled">
								<li><i class="icofont icofont-square"></i></li>
							</ul>
						</div>
						<div class="space-20"></div>
						<a href="b_tamLyXaHoi.jsp">Tâm lí - Kĩ năng sống </a>
					</div>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-3 wow fadeInLeft"
					data-wow-delay="0.4s">
					<div class="category-item well yellow text-cetnr">
						<div class="category_icon">
							<i class="icofont icofont-globe-alt"></i>
						</div>
						<div class="space-20"></div>
						<div class="title-bar">
							<ul class="list-inline list-unstyled">
								<li><i class="icofont icofont-square"></i></li>
							</ul>
						</div>
						<div class="space-20"></div>
						<a href="b_ngoaiNgu.jsp">Ngoại ngữ</a>
					</div>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-3 wow fadeInLeft"
					data-wow-delay="0.4s">
					<div class="category-item well red text-cetnr">
						<div class="category_icon">
							<i class="icofont icofont-globe-alt"></i>
						</div>
						<div class="space-20"></div>
						<div class="title-bar">
							<ul class="list-inline list-unstyled">
								<li><i class="icofont icofont-square"></i></li>
							</ul>
						</div>
						<div class="space-20"></div>
						<a href="b_khoaHocXaHoi.jsp">Khoa học - xã hội </a>
					</div>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-3 wow fadeInLeft"
					data-wow-delay="0.4s">
					<div class="category-item well green text-cetnr">
						<div class="category_icon">
							<i class="icofont icofont-globe-alt"></i>
						</div>
						<div class="space-20"></div>
						<div class="title-bar">
							<ul class="list-inline list-unstyled">
								<li><i class="icofont icofont-square"></i></li>
							</ul>
						</div>
						<div class="space-20"></div>
						<a href="b_GiaoKhoa.jsp">Giáo khoa </a>
					</div>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-3 wow fadeInLeft"
					data-wow-delay="0.4s">
					<div class="category-item well blue text-cetnr">
						<div class="category_icon">
							<i class="icofont icofont-globe-alt"></i>
						</div>
						<div class="space-20"></div>
						<div class="title-bar">
							<ul class="list-inline list-unstyled">
								<li><i class="icofont icofont-square"></i></li>
							</ul>
						</div>
						<div class="space-20"></div>
						<a href="b_KinhTe.jsp">Kinh tế </a>
					</div>
				</div>
				<div class="space-60"></div>
				<div class="row">
					<div class="col-xs-12 text-center">
						<a href="books.jsp" class="btn btn-primary">Xem thêm</a>
					</div>
				</div>
				<div class="space-80"></div>
			</div>
		</div>
	</section>
	<section class="relative fix" id="sc3">
		<div class="overlay-bg blue">
			<img src="images/blur-bg.jpg" alt="library">
		</div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-xs-12 col-md-6 book-list-position padding60  ">
					<div class="book-list-photo">
						<div class="book-list">
							<!-- book list -->
							<div class="book_item">
								<img src="images/book/book1.jpg" alt="library">
							</div>
							<div class="book_item">
								<img src="images/book/book2.jpg" alt="library">
							</div>
						</div>
					</div>
					<div class="bookslide_nav">
						<i class="icofont icofont-long-arrow-left testi_prev"></i> <i
							class="icofont icofont-long-arrow-right testi_next"></i>
					</div>
				</div>
				<div
					class="col-xs-12 pull-right col-md-6 padding60 gray-bg wow fadeInRight">
					<div class="space-60"></div>
					<div class="row">
						<div class="col-xs-12 col-sm-8 col-md-6">
							<h2>Sách phổ biến</h2>
							<div class="space-10"></div>
							<div class="title-bar left blue">
								<ul class="list-inline list-unstyled">
									<li><i class="icofont icofont-square"></i></li>
									<li><i class="icofont icofont-square"></i></li>
								</ul>
							</div>
							<div class="space-20"></div>
						</div>
					</div>
					<div class="space-20"></div>
					<div class="book-content">
						<!-- book details -->
						<div class="book-details">
							<div class="book-details-item">
								<h4 class="tip-left">Tiêu đề</h4>
								<p class="lead">Nghĩ khác</p>
								<div class="space-10"></div>
								<div class="row">
									<div class="col-xs-12 col-sm-8">
										<h4 class="tip-left">Tác giả</h4>
										<div class="media">
											<div class="media-left">
												<img src="images/author.jpg"
													class="media-object author-photo img-thumbnail"
													alt="library">
											</div>
											<div class="media-body">
												<h5>Michael heppell</h5>
												<p>23 Sách được viết</p>
											</div>
										</div>
									</div>
									<div class="col-xs-12 col-sm-4">
										<h4>Số trang</h4>
										<p>320 trang</p>
									</div>
								</div>
								<div class="space-30"></div>
								<h4 class="tip-left">Mô tả</h4>
								<p>Nghĩ khác được chia ra thành một số phần xoay quanh một
									lĩnh vực của đời sống: công việc, sức khỏe, gia đình, thành
									công, sáng tạo, văn minh. Đọc cuốn sách này bạn sẽ tự nhủ" Mình
									không thể làm điều này" hay" Mình không có thứ đó trong đời".</p>
								<div class="space-20"></div>
								<h4 class="tip-left">Xếp hạng</h4>
								<ul class="list-inline list-unstyled rating-star">
									<li class="active"><i class="icofont icofont-star"></i></li>
									<li class="active"><i class="icofont icofont-star"></i></li>
									<li class="active"><i class="icofont icofont-star"></i></li>
									<li class=""><i class="icofont icofont-star"></i></li>
									<li><i class="icofont icofont-star"></i></li>
								</ul>
								<div class="space-20"></div>
								<a href="books.jsp" class="btn btn-primary hover-btn-default">Xem
									sách</a> <a href="books.jsp"
									class="btn btn-primary hover-btn-default">Đọc sau</a>
							</div>
							<div class="book-details-item">
								<h4 class="tip-left">Tiêu đề</h4>
								<p class="lead">Nghệ thuật nhìn người đoán tính cách</p>
								<div class="space-10"></div>
								<div class="row">
									<div class="col-xs-12 col-sm-8">
										<h4 class="tip-left">Tác giả</h4>
										<div class="media">
											<div class="media-left">
												<img src="images/client/client1.jpg"
													class="media-object author-photo img-thumbnail"
													alt="library">
											</div>
											<div class="media-body">
												<h5>Shozo Shibuya, Pooh chan</h5>
												<p>23 Sách được viết</p>
											</div>
										</div>
									</div>
									<div class="col-xs-12 col-sm-4">
										<h4>Số trang</h4>
										<p>320 trang</p>
									</div>
								</div>
								<div class="space-30"></div>
								<h4 class="tip-left">Mô tả</h4>
								<p>Bạn có tin rằng chúng ta có thể nhìn thấu tính cách một
									con người qua ngoại hình của họ? Hay nói cách khác, ta hoàn
									toàn có thể phán đoán tính cách cũng như suy nghĩ, tâm trạng
									của người đối diện thông qua việc quan sát ngoại hình của họ,
									từ cách ăn mặc, sử dụng phụ kiện, đến gương mặt, mái tóc, màu
									da… Ta cũng có thể hiểu được tâm trạng, thái độ, cảm xúc của ai
									đó qua giao tiếp, ánh mắt, cử chỉ, hành động, lời nói. Với góc
									nhìn thú vị về “ngoại hình” và “tính cách” theo quan niệm của
									người Nhật Bản, cuốn sách NGHỆ THUẬT NHÌN NGƯỜI ĐOÁN TÍNH CÁCH
									sẽ giúp bạn nhận diện và thấu hiểu đối phương để có cách ứng xử
									phù hợp trong mọi hoàn cảnh.</p>
								<div class="space-20"></div>
								<h4 class="tip-left">Xếp hạng</h4>
								<ul class="list-inline list-unstyled rating-star">
									<li class="active"><i class="icofont icofont-star"></i></li>
									<li class="active"><i class="icofont icofont-star"></i></li>
									<li class=""><i class="icofont icofont-star"></i></li>
									<li class=""><i class="icofont icofont-star"></i></li>
									<li><i class="icofont icofont-star"></i></li>
								</ul>
								<div class="space-20"></div>
								<a href="books.jsp" class="btn btn-primary hover-btn-default">Xem
									sách</a> <a href="books.jsp"
									class="btn btn-primary hover-btn-default">Đọc sau</a>
							</div>
						</div>
					</div>
					<div class="space-60"></div>
				</div>
			</div>
		</div>
	</section>
	<section class="gray-bg relative" id="sc5">
		<div class="space-80"></div>
		<div class="container">
			<div class="row">
				<div
					class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3 text-center">
					<h2>
						<strong>Thông báo</strong>
					</h2>
					<div class="space-20"></div>
					<div class="title-bar blue">
						<ul class="list-inline list-unstyled">
							<li><i class="icofont icofont-square"></i></li>
							<li><i class="icofont icofont-square"></i></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="space-60"></div>
			<div class="row event-list">
				<!--                 <div class="hidden-xs hidden-sm col-md-5 inner-photo wow fadeInLeft">
                    <img src="images/inner-image.png" class="img-responsive" alt="library">
                </div> -->
				<div class="col-xs-12 col-md-7 col-md-offset-2">
					<div class="event-item wow fadeInRight">
						<h4 class="show tip-left">
							20-7-2017 <span class="pull-right">14.30</span>
						</h4>
						<div class="well">
							<div class="media">
								<div class="media-left">
									<img src="images/evemt/even-1.jpg" class="media-object"
										alt="library">
								</div>
								<div class="media-body">
									<div class="space-10"></div>
									<a href="books.jsp"><strong class="media-heading">Tuesday
											Networking &amp; Lecture</strong>></a>
									<div class="space-10"></div>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
										Ut gravida, quam vitae est Sed non eros elementum nulla
										sodales ullamcorper.</p>
								</div>
							</div>
						</div>
					</div>
					<div class="space-20"></div>
					<div class="event-item wow fadeInRight">
						<h4 class="show tip-left">
							15-9-2017 <span class="pull-right">8.30</span>
						</h4>
						<div class="well">
							<div class="media">
								<div class="media-left">
									<img src="images/evemt/event-2.jpg" class="media-object"
										alt="library">
								</div>
								<div class="media-body">
									<div class="space-10"></div>
									<a href="books.jsp"> <strong class="media-heading">Read
											Book For 500 People</strong>
									</a>
									<div class="space-10"></div>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
										Ut gravida, quam vitae est Sed non eros elementum nulla
										sodales ullamcorper.</p>
								</div>
							</div>
						</div>
					</div>
					<div class="space-20"></div>
					<div class="fix">
						<a href="#" class="btn btn-default pull-right hover-btn-primary">Xem
							thêm <span><i class="icofont icofont-long-arrow-right"></i></span>
						</a>
					</div>
				</div>
			</div>
		</div>
		<div class="space-80"></div>
	</section>
	<!-- Nhân viên -->
	<!-- <section id="sc4">
        <div class="space-80"></div>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3 text-center">
                    <h2>Meet Our <strong>Staff</strong></h2>
                    <div class="space-20"></div>
                    <div class="title-bar blue">
                        <ul class="list-inline list-unstyled">
                            <li><i class="icofont icofont-square"></i></li>
                            <li><i class="icofont icofont-square"></i></li>
                        </ul>
                    </div>
                    <div class="space-30"></div>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut gravida, quam vitae est Sed non eros elementum nulla sodales ullamcorper.</p>
                </div>
            </div>
            <div class="space-60"></div>
            <div class="row team_slide text-center">
                <div class="col-xs-12">
                    <div class="well single-team">
                        <h4>Alan Walker</h4>
                        <span>Librarian</span>
                        <div class="space-10"></div>
                        <ul class="list-inline list-unstyled social-list">
                            <li><a href="#"><i class="icofont icofont-social-facebook"></i></a></li>
                            <li><a href="#"><i class="icofont icofont-social-twitter"></i></a></li>
                            <li><a href="#"><i class="icofont icofont-social-behance"></i></a></li>
                            <li><a href="#"><i class="icofont icofont-brand-linkedin"></i></a></li>
                        </ul>
                        <div class="space-20"></div>
                        <div class="title-bar">
                            <ul class="list-inline list-unstyled">
                                <li><i class="icofont icofont-square"></i></li>
                            </ul>
                        </div>
                        <div class="space-20"></div>
                        <div class="team-member-photo relative">
                            <img src="images/team/team1.jpg" alt="library">
                            <div class="team_overlay_icon">
                                <a href="books.jsp" class="btn btn-default">See Prolife</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12">
                    <div class="well single-team">
                        <div class="team-member-photo relative">
                            <img src="images/team/team-2.jpg" alt="library">
                            <div class="team_overlay_icon">
                                <a href="books.jsp" class="btn btn-default">See Prolife</a>
                            </div>
                        </div>
                        <div class="space-20"></div>
                        <div class="title-bar">
                            <ul class="list-inline list-unstyled">
                                <li><i class="icofont icofont-square"></i></li>
                            </ul>
                        </div>
                        <div class="space-20"></div>
                        <h4>Steven William</h4>
                        <span>Director</span>
                        <div class="space-10"></div>
                        <ul class="list-inline list-unstyled social-list">
                            <li><a href="#"><i class="icofont icofont-social-facebook"></i></a></li>
                            <li><a href="#"><i class="icofont icofont-social-twitter"></i></a></li>
                            <li><a href="#"><i class="icofont icofont-social-behance"></i></a></li>
                            <li><a href="#"><i class="icofont icofont-brand-linkedin"></i></a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-xs-12">
                    <div class="well single-team">
                        <h4>Harry T Nevvit</h4>
                        <span>Manager</span>
                        <div class="space-10"></div>
                        <ul class="list-inline list-unstyled social-list">
                            <li><a href="#"><i class="icofont icofont-social-facebook"></i></a></li>
                            <li><a href="#"><i class="icofont icofont-social-twitter"></i></a></li>
                            <li><a href="#"><i class="icofont icofont-social-behance"></i></a></li>
                            <li><a href="#"><i class="icofont icofont-brand-linkedin"></i></a></li>
                        </ul>
                        <div class="space-20"></div>
                        <div class="title-bar">
                            <ul class="list-inline list-unstyled">
                                <li><i class="icofont icofont-square"></i></li>
                            </ul>
                        </div>
                        <div class="space-20"></div>
                        <div class="team-member-photo relative">
                            <img src="images/team/team-3.jpg" alt="library">
                            <div class="team_overlay_icon">
                                <a href="books.jsp" class="btn btn-default">See Prolife</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12">
                    <div class="well single-team">
                        <div class="team-member-photo relative">
                            <img src="images/team/team-3.jpg" alt="library">
                            <div class="team_overlay_icon">
                                <a href="books.jsp" class="btn btn-default">See Prolife</a>
                            </div>
                        </div>
                        <div class="space-20"></div>
                        <div class="title-bar">
                            <ul class="list-inline list-unstyled">
                                <li><i class="icofont icofont-square"></i></li>
                            </ul>
                        </div>
                        <div class="space-20"></div>
                        <h4>Harry T Nevvit</h4>
                        <span>Manager</span>
                        <div class="space-10"></div>
                        <ul class="list-inline list-unstyled social-list">
                            <li><a href="#"><i class="icofont icofont-social-facebook"></i></a></li>
                            <li><a href="#"><i class="icofont icofont-social-twitter"></i></a></li>
                            <li><a href="#"><i class="icofont icofont-social-behance"></i></a></li>
                            <li><a href="#"><i class="icofont icofont-brand-linkedin"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="space-80"></div>
    </section> -->
	<!-- Phản hồi -->
	<!-- <section class="relative" id="sc6">
        <div class="overlay-bg">
            <img src="images/say-bg.jpg" alt="library">
        </div>
        <div class="space-80"></div>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3 text-center">
                    <h2 class="text-white">What People <strong>Say</strong></h2>
                    <div class="space-20"></div>
                    <div class="title-bar white">
                        <ul class="list-inline list-unstyled">
                            <li><i class="icofont icofont-square"></i></li>
                            <li><i class="icofont icofont-square"></i></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="space-60"></div>
            <div class="row text-white testimonial-slide">
                <div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3 text-center">
                    <h5 class="text-white">Ariana Grande</h5>
                    <span class="show">Student</span>
                    <div class="space-30"></div>
                    <q>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla libero dui, pretium non mattis eu nunc. Aenean egestas nisi vel urna tempus aliquam. Etiam fringilla tempor risus.Nulla vitae elementum felis. Vestibulum ultricies feugiat est id ornare. Morbi non dapibus ante.</q>
                    <div class="space-30"></div>
                    <img src="images/client/client2.jpg" class="img-thumbnail img-circle" alt="library">
                </div>
                <div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3 text-center">
                    <h5 class="text-white">Ariana Grande</h5>
                    <span class="show">Student</span>
                    <div class="space-30"></div>
                    <q>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla libero dui, pretium non mattis eu nunc. Aenean egestas nisi vel urna tempus aliquam. Etiam fringilla tempor risus.Nulla vitae elementum felis. Vestibulum ultricies feugiat est id ornare. Morbi non dapibus ante.</q>
                    <div class="space-30"></div>
                    <img src="images/client/client1.jpg" class="img-thumbnail img-circle" alt="library">
                </div>
                <div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3 text-center">
                    <h5 class="text-white">Ariana Grande</h5>
                    <span class="show">Student</span>
                    <div class="space-30"></div>
                    <q>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla libero dui, pretium non mattis eu nunc. Aenean egestas nisi vel urna tempus aliquam. Etiam fringilla tempor risus.Nulla vitae elementum felis. Vestibulum ultricies feugiat est id ornare. Morbi non dapibus ante.</q>
                    <div class="space-30"></div>
                    <img src="images/client/client3.jpg" class="img-thumbnail img-circle" alt="library">
                </div>
            </div>
        </div>
        <div class="space-60"></div>
        <div class="space-80"></div>
    </section> -->
	<!--  Đăng nhập -->
	<!-- <section class="bg-primary relative">
        <div class="space-80"></div>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-7">
                    <h2 class="text-white">Lets Take <strong>Your Book</strong></h2>
                    <div class="space-20"></div>
                    <div class="title-bar left white">
                        <ul class="list-inline list-unstyled">
                            <li><i class="icofont icofont-square"></i></li>
                            <li><i class="icofont icofont-square"></i></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="space-60"></div>
            <div class="row">
                <div class="col-xs-12 col-sm-7">
                    <form action="#">
                        <div class="row">
                            <div class="col-xs-12 col-sm-6">
                                <div class="form-group">
                                    <label for="name">Name</label>
                                    <input type="text" id="name" class="form-control bg-none" placeholder="Enter your name...">
                                </div>
                            </div>
                            <div class="col-xs-12 col-sm-6">
                                <div class="form-group">
                                    <label for="email">Email</label>
                                    <input type="email" id="email" class="form-control bg-none" placeholder="Enter your email...">
                                </div>
                            </div>
                            <div class="space-20"></div>
                            <div class="col-xs-12 col-sm-6">
                                <button type="submit" class="btn btn-default">Create Accout <i class="fa fa-long-arrow-right"></i></button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="hidden-xs col-sm-5 outer-image wow fadeInRight">
                    <img src="images/outer-image.png" alt="library">
                </div>
            </div>
        </div>
        <div class="space-80"></div>
    </section> -->
	<footer class="black-bg text-white">
		<div class="space-60"></div>
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-4">
					<a href="#"><img src="images/logo.png" alt="library"></a>
					<div class="space-20"></div>
					<p>Đến, đọc, tận hưởng.</p>
					<div class="space-10"></div>
					<ul class="list-inline list-unstyled social-list">
						<li><a href="#"><i
								class="icofont icofont-social-facebook"></i></a></li>
						<li><a href="#"><i class="icofont icofont-social-twitter"></i></a></li>
						<li><a href="#"><i class="icofont icofont-social-behance"></i></a></li>
						<li><a href="#"><i class="icofont icofont-brand-linkedin"></i></a></li>
					</ul>
					<div class="space-10"></div>
					<ul class="list-unstyled list-inline tip yellow">
						<li><i class="icofont icofont-square"></i></li>
						<li><i class="icofont icofont-square"></i></li>
						<li><i class="icofont icofont-square"></i></li>
					</ul>
				</div>
				<div class="col-xs-12 col-sm-4 col-md-3 col-md-offset-1">
					<h4 class="text-white">Liên hệ</h4>
					<div class="space-20"></div>
					<table class="table border-none addr-dt">
						<tr>
							<td><i class="icofont icofont-social-google-map"></i></td>
							<td><address>Số 1, Võ Văn Ngân, Thủ Đức, TP. Hồ
									Chí Minh</address></td>
						</tr>
						<tr>
							<td><i class="icofont icofont-email"></i></td>
							<td>susislibrary@domain.com</td>
						</tr>
						<tr>
							<td><i class="icofont icofont-phone"></i></td>
							<td>+62 582 528 527 21</td>
						</tr>
						<tr>
							<td><i class="icofont icofont-globe-alt"></i></td>
							<td><a href="www.susislibrary.com" target="_blank">www.susislibrary.com</a></td>
						</tr>
					</table>
				</div>
				<!-- <div class="col-xs-12 col-sm-4 col-md-3 col-md-offset-1">
                    <h4 class="text-white">Useful Link</h4>
                    <div class="space-20"></div>
                    <ul class="list-unstyled menu-tip">
                        <li><a href="books.jsp">Costumer Service</a></li>
                        <li><a href="books.jsp">Help Desk</a></li>
                        <li><a href="books.jsp">Forum</a></li>
                        <li><a href="books.jsp">Staff Profile</a></li>
                        <li><a href="books.jsp">Live Chat</a></li>
                    </ul>
                </div> -->
			</div>
		</div>
		<div class="space-60"></div>
	</footer>

	<!-- Vandor-JS -->
	<script src="js/vendor/jquery-1.12.4.min.js"></script>
	<script src="js/vendor/bootstrap.min.js"></script>
	<!-- Plugin-JS -->
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/responsiveslides.min.js"></script>
	<script src="js/jquery.cardslider.min.js"></script>
	<script src="js/pagination.js"></script>
	<script src="js/scrollUp.min.js"></script>
	<script src="js/wow.min.js"></script>
	<script src="js/plugins.js"></script>
	<!-- Active-JS -->
	<script src="js/main.js"></script>

</body>
</html>