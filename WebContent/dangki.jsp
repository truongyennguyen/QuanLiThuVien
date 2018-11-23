<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags-->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Title Page-->
<title>Đăng kí</title>

<!-- Fontfaces CSS-->
<link href="css/font-face.css" rel="stylesheet" media="all">
<link href="vendor/font-awesome-4.7/css/font-awesome.min.css"
	rel="stylesheet" media="all">
<link href="vendor/font-awesome-5/css/fontawesome-all.min.css"
	rel="stylesheet" media="all">
<link href="vendor/mdi-font/css/material-design-iconic-font.min.css"
	rel="stylesheet" media="all">

<!-- Bootstrap CSS-->
<link href="vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet"
	media="all">

<!-- Vendor CSS-->
<link href="vendor/animsition/animsition.min.css" rel="stylesheet"
	media="all">
<link
	href="vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css"
	rel="stylesheet" media="all">
<link href="vendor/wow/animate.css" rel="stylesheet" media="all">
<link href="vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet"
	media="all">
<link href="vendor/slick/slick.css" rel="stylesheet" media="all">
<link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
<link href="vendor/perfect-scrollbar/perfect-scrollbar.css"
	rel="stylesheet" media="all">

<!-- Main CSS-->
<link href="css/theme_1.css" rel="stylesheet" media="all">

</head>

<body class="animsition">
	<div class="page-wrapper">
		<!-- HEADER MOBILE-->
		<header class="header-mobile d-block d-lg-none">
			<div class="header-mobile__bar">
				<div class="container-fluid">
					<div class="header-mobile-inner">
						<a class="logo" href="index.jsp"> <img
							src="images/icon/logo.png" alt="CoolAdmin" />
						</a>
						<button class="hamburger hamburger--slider" type="button">
							<span class="hamburger-box"> <span class="hamburger-inner"></span>
							</span>
						</button>
					</div>
				</div>
			</div>
			<nav class="navbar-mobile">
				<div class="container-fluid">
					<ul class="navbar-mobile__list list-unstyled">
						<li class="has-sub"><a class="js-arrow" href="#"> <i
								class="fas fa-tachometer-alt"></i>Mượn-trả sách
						</a>
							<ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
								<li><a href="muonsach.jsp">Mượn sách</a></li>
								<li><a href="trasach.jsp">Trả sách</a></li>
								<li><a href="dangki.jsp">Đăng kí thẻ thư viện</a></li>
								<li><a href="phieuphat.jsp">Lập phiếu phạt</a></li>
							</ul></li>
						<li class="has-sub"><a class="js-arrow" href="#"> <i
								class="fas fas fa-table"></i>Quản lí
						</a>
							<ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
								<li><a href="quanlinhanvien.jsp">Nhân viên</a></li>
								<li><a href="docgia.jsp">Đọc giả</a></li>
								<li><a href="thongbao.jsp">Thông báo</a></li>
								<li><a href="dausach.jsp">Đầu sách</a></li>
								<li><a href="nhaxuatban.jsp">Nhà xuất bản</a></li>
								<li><a href="taikhoan.jsp">Tài khoản</a></li>
								<li><a href="phongphucvu.jsp">Phòng phục vụ</a></li>
							</ul></li>
						<li><a href="#"> <i class="fas fa-chart-bar"></i>Thông kê
						</a></li>
					</ul>
				</div>
			</nav>
		</header>
		<!-- END HEADER MOBILE-->

		<!-- MENU SIDEBAR-->
		<aside class="menu-sidebar d-none d-lg-block">
			<div class="logo">
				<a href="#"> <img src="images/icon/logo.png" alt="Cool Admin" />
				</a>
			</div>
			<div class="menu-sidebar__content js-scrollbar1">
				<nav class="navbar-sidebar">
					<ul class="list-unstyled navbar__list">
						<li class="active has-sub"><a class="js-arrow" href="#">
								<i class="fas fa-tachometer-alt"></i>Nghiệp vụ thư viện
						</a>
							<ul class="list-unstyled navbar__sub-list js-sub-list">
								<li><a href="muonsach.jsp">Mượn sách</a></li>
								<li><a href="trasach.jsp">Trả sách</a></li>
								<li><a href="dangki.jsp">Đăng kí thẻ thư viện</a></li>
								<li><a href="phieuphat.jsp">Lập phiếu phạt</a></li>
							</ul></li>
						<li class="has-sub"><a class="js-arrow" href="#"> <i
								class="fas fas fa-table"></i>Quản lí
						</a>
							<ul class="list-unstyled navbar__sub-list js-sub-list">
								<li><a href="quanlinhanvien.jsp">Nhân viên</a></li>
								<li><a href="docgia.jsp">Đọc giả</a></li>
								<li><a href="thongbao.jsp">Thông báo</a></li>
								<li><a href="dausach.jsp">Đầu sách</a></li>
								<li><a href="nhaxuatban.jsp">Nhà xuất bản</a></li>
								<li><a href="taikhoan.jsp">Tài khoản</a></li>
								<li><a href="phongphucvu.jsp">Phòng phục vụ</a></li>
							</ul></li>
						<li><a href="#"> <i class="fas fa-chart-bar"></i>Thống kê
						</a></li>
					</ul>
				</nav>
			</div>
		</aside>
		<!-- END MENU SIDEBAR-->

		<!-- PAGE CONTAINER-->
		<div class="page-container">
			<!-- HEADER DESKTOP-->
			<header class="header-desktop">
				<div class="section__content section__content--p30">
					<div class="container-fluid">
						<div class="header-wrap"></div>
					</div>
				</div>
			</header>
			<!-- HEADER DESKTOP-->

			<!-- MAIN CONTENT-->
			<div class="main-content">
				<div class="section__content section__content--p30">
					<div class="container-fluid">
						<div class="row">
							<div class="col-sm-12 col-md-12">
								<div class="card">
									<div class="card-header">
										<strong>Đăng kí thẻ thư viện</strong>
									</div>
									<div class="card-body card-block">
										<form action="" method="post" enctype="multipart/form-data"
											class="form-horizontal">
											<div class="row form-group">
												<div class="col col-md-3">
													<label for="fullname_input" class=" form-control-label">Họ
														và tên</label>
												</div>
												<div class="col-12 col-md-9">
													<input type="text" id="fullname" name="fullname_input"
														placeholder="Họ và tên" class="form-control">
												</div>
											</div>
											<div class="row form-group">
												<div class="col col-md-3">
													<label for="sex_input" class=" form-control-label">Giới
														tính</label>
												</div>
												<div class="col-12 col-md-9">
													<select name="sex_input">
														<option value="Nam">Nam</option>
														<option value="Nữ">Nữ</option>
													</select>
												</div>
											</div>
											<div class="row form-group">
												<div class="col col-md-3">
													<label for="birthdate_input" class=" form-control-label">Ngày
														sinh</label>
												</div>
												<div class="col-12 col-md-9">
													<input type="date" id="birthdate" name="birthdate_input"
														class="form-control">
												</div>
											</div>
											<div class="row form-group">
												<div class="col col-md-3">
													<label for="address_input" class=" form-control-label">Ghi
														chú</label>
												</div>
												<div class="col-12 col-md-9">
													<textarea name="address_input" id="address" rows="9"
														placeholder="Địa chỉ" class="form-control"></textarea>
												</div>
											</div>
											<div class="row form-group">
												<div class="col col-md-3">
													<label for="mail_input" class=" form-control-label">Mail</label>
												</div>
												<div class="col-12 col-md-9">
													<input type="email" id="mail" name="mail_input"
														class="form-control" placeholder="Mail">
												</div>
											</div>
											<div class="card-footer">
												<button type="submit" class="btn btn-primary btn-sm">
													<i class="fa fa-check"></i> Đăng kí
												</button>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- END MAIN CONTENT-->
			<!-- END PAGE CONTAINER-->
		</div>

	</div>

	<!-- Jquery JS-->
	<script src="vendor/jquery-3.2.1.min.js"></script>
	<!-- Bootstrap JS-->
	<script src="vendor/bootstrap-4.1/popper.min.js"></script>
	<script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>
	<!-- Vendor JS       -->
	<script src="vendor/slick/slick.min.js">
		
	</script>
	<script src="vendor/wow/wow.min.js"></script>
	<script src="vendor/animsition/animsition.min.js"></script>
	<script src="vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
		
	</script>
	<script src="vendor/counter-up/jquery.waypoints.min.js"></script>
	<script src="vendor/counter-up/jquery.counterup.min.js">
		
	</script>
	<script src="vendor/circle-progress/circle-progress.min.js"></script>
	<script src="vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
	<script src="vendor/chartjs/Chart.bundle.min.js"></script>
	<script src="vendor/select2/select2.min.js">
		
	</script>

	<!-- Main JS-->
	<script src="js/main_admin.js"></script>

</body>

</html>
<!-- end document-->
