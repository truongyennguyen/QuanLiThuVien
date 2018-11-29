<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet'>
    <!-- Title Page-->
    <title>Đầu sách</title>

    <!-- Fontfaces CSS-->
    <link href="css/font-face.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

    <!-- Bootstrap CSS-->
    <link href="vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <link href="vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
    <link href="vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="vendor/wow/animate.css" rel="stylesheet" media="all">
    <link href="vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="vendor/slick/slick.css" rel="stylesheet" media="all">
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">

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
                        <a class="logo" href="index.html">
                            <img src="images/icon/logo.png" alt="CoolAdmin" />
                        </a>
                        <button class="hamburger hamburger--slider" type="button">
                            <span class="hamburger-box">
                                <span class="hamburger-inner"></span>
                            </span>
                        </button>
                    </div>
                </div>
            </div>
            <nav class="navbar-mobile">
                <div class="container-fluid">
                    <ul class="navbar-mobile__list list-unstyled">
                        <li class="has-sub">
                            <a class="js-arrow" href="#">
                                <i class="fas fa-tachometer-alt"></i>Mượn-trả sách</a>
                                <ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
                                    <li>
                                        <a href="muonsach.html">Mượn sách</a>
                                    </li>
                                    <li>
                                        <a href="trasach.html">Trả sách</a>
                                    </li>
                                    <li>
                                        <a href="dangki.html">Đăng kí thẻ thư viện</a>
                                    </li>
                                    <li>
                                        <a href="phieuphat.html">Lập phiếu phạt</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="has-sub">
                                <a class="js-arrow" href="#">
                                    <i class="fas fas fa-table"></i>Quản lí</a>
                                    <ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
                                        <li>
                                            <a href="quanlinhanvien.html">Nhân viên</a>
                                        </li>
                                        <li>
                                            <a href="docgia.html">Đọc giả</a>
                                        </li>
                                        <li>
                                            <a href="thongbao.html">Thông báo</a>
                                        </li>
                                        <li>
                                            <a href="dausach.html">Đầu sách</a>
                                        </li>
                                        <li>
                                            <a href="nhaxuatban.html">Nhà xuất bản</a>
                                        </li>
                                        <li>
                                            <a href="taikhoan.html">Tài khoản</a>
                                        </li>
                                        <li>
                                           <a href="phongphucvu.html">Phòng phục vụ</a>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="table.html">
                                        <i class="fas fa-chart-bar"></i>Thông kê</a>
                                    </li>
                                </ul>
                            </div>
                        </nav>
                    </header>
                    <!-- END HEADER MOBILE-->

                    <!-- MENU SIDEBAR-->
                    <aside class="menu-sidebar d-none d-lg-block">
                        <div class="logo">
                            <a href="#">
                                <img src="images/icon/logo.png" alt="Cool Admin" />
                            </a>
                        </div>
                        <div class="menu-sidebar__content js-scrollbar1">
                            <nav class="navbar-sidebar">
                                <ul class="list-unstyled navbar__list">
                                    <li class="active has-sub">
                                        <a class="js-arrow" href="#">
                                            <i class="fas fa-tachometer-alt"></i>Nghiệp vụ thư viện</a>
                                            <ul class="list-unstyled navbar__sub-list js-sub-list">
                                                <li>
                                                    <a href="muonsach.html">Mượn sách</a>
                                                </li>
                                                <li>
                                                    <a href="trasach.html">Trả sách</a>
                                                </li>
                                                <li>
                                                    <a href="dangki.html">Đăng kí thẻ thư viện</a>
                                                </li>
                                                <li>
                                                    <a href="phieuphat.html">Lập phiếu phạt</a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li class="has-sub">
                                            <a class="js-arrow" href="#">
                                                <i class="fas fas fa-table"></i>Quản lí</a>
                                                <ul class="list-unstyled navbar__sub-list js-sub-list">
                                                    <li>
                                            <a href="quanlinhanvien.html">Nhân viên</a>
                                        </li>
                                        <li>
                                            <a href="docgia.html">Đọc giả</a>
                                        </li>
                                        <li>
                                            <a href="thongbao.html">Thông báo</a>
                                        </li>
                                        <li>
                                            <a href="dausach.html">Đầu sách</a>
                                        </li>
                                        <li>
                                            <a href="nhaxuatban.html">Nhà xuất bản</a>
                                        </li>
                                        <li>
                                            <a href="taikhoan.html">Tài khoản</a>
                                        </li>
                                        <li>
                                            <a href="phongphucvu.html">Phòng phục vụ</a>
                                        </li>
                                                </ul>
                                            </li>
                                            <li>
                                                <a href="table.html">
                                                    <i class="fas fa-chart-bar"></i>Thống kê</a>
                                                </li>
                                            </ul>
                                        </nav>
                                    </div>
                                </aside>
                                <!-- END MENU SIDEBAR-->

                                <!-- PAGE CONTAINER-->
                                <div class="page-container">

            <!-- MAIN CONTENT-->
            <div class="main-content">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-sm-12 col-md-12">
                                <div class="card">
                                    <div class="card-header">
                                        <strong>Đầu sách</strong>
                                    </div>
                                    <div class="card-body card-block">
                                        
                                        <div class="col-12 col-md-12">
                                            <div class="table-responsive table--no-card m-b-30">
                                                <table class="table table-borderless table-striped table-earning">
                                                    <thead>
                                                        <tr>
                                                            <th>Mã đầu sách</th>
                                                            <th>Tên đầu sách</th>
                                                            <th>Nhà xuất bản</th>
                                                            <th>Thể loại</th>
                                                            <th>Tác giả</th>
                                                            <th>Năm xuất bản</th>
                                                            <th>Ngôn ngữ</th>
                                                            <th>Ảnh bìa</th>
                                                            <th>Trạng thái</th>
                                                            <th></th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td> ĐS01</td>
                                                            <td> abc</td>
                                                            <td> NXB Kim Đồng</td>
                                                            <td> Văn học</td>
                                                            <td> Trọng Tấn</td>
                                                            <td> 12-12-2012</td>
                                                            <td> Tiếng Việt</td>
                                                            <td> <img src="" alt=""></td>
                                                            <th>Còn sách</th>
                                                            <td>
                                                                <button type="button" class="btn btn-warning">Sửa</button>
                                                                <button type="button" class="btn btn-danger">Xóa</button>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td> ĐS02</td>
                                                            <td> xyz</td>
                                                            <td> NXB Kim Đồng</td>
                                                            <td> Văn học</td>
                                                            <td> Trọng Tấn</td>
                                                            <td> 12-12-2012</td>
                                                            <td> Tiếng Việt</td>
                                                            <td> <img src="" alt=""></td>
                                                            <th>Còn sách</th>
                                                            <td>
                                                                <button type="button" class="btn btn-warning">Sửa</button>
                                                                <button type="button" class="btn btn-danger">Xóa</button>
                                                            </td>
                                                        </tr>

                                                    </tbody>
                                                </table>
                                                    
                                            </div>
                                            <div>
                                                <button type="button" class="btn btn-success" data-toggle="modal" data-target="#exampleModal">
  Thêm
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" data-backdrop="false">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel" style="font-family: 'Roboto';">Thêm đầu sách</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="row" style="display: flex;
    align-items: center;font-family: 'Roboto';">
                        <div class="col-xs-12 col-md-4">
                            <h5 class="">Mã đầu sách</h3>
                        </div>
                        <div class="col-xs-12 col-md-8">
                            <input type="text" name="" id="input" class="form-control" value="" required="required" pattern="" title="">
                        </div>
                    </div>
                    <div style="height: 10px"></div>
                    <div class="row"  style="display: flex;
    align-items: center;font-family: 'Roboto';">
                        <div class="col-xs-12 col-md-4">
                            <h5 class="">Tên đầu sách</h3>
                        </div>
                        <div class="col-xs-12 col-md-8">
                            <input type="text" name="" id="input" class="form-control" value="" required="required" pattern="" title="">
                        </div>
                    </div>
                    <div style="height: 10px"></div>
                    <div class="row"  style="display: flex;
    align-items: center;font-family: 'Roboto';">
                        <div class="col-xs-12 col-md-4">
                            <h5 class="">Nhà xuất bản</h3>
                        </div>
                        <div class="col-xs-12 col-md-8">
                            <input type="text" name="" id="input" class="form-control" value="" required="required" pattern="" title="">
                        </div>
                    </div>
                    <div style="height: 10px"></div>
                    <div class="row" style="display: flex;
    align-items: center;font-family: 'Roboto';">
                        <div class="col-xs-12 col-md-4">
                            <h5 style="vertical-align: middle;">Thể loại</h3>
                        </div>
                        <div class="col-xs-12 col-md-8">
                            <input type="text" name="" id="input" class="form-control" value="" required="required" pattern="" title="">
                        </div>
                    </div>
                    <div style="height: 10px"></div>
                    <div class="row" style="display: flex;
    align-items: center;font-family: 'Roboto';">
                        <div class="col-xs-12 col-md-4">
                            <h5 class="">Tác giả</h3>
                        </div>
                        <div class="col-xs-12 col-md-8">
                            <input type="text" name="" id="input" class="form-control" value="" required="required" pattern="" title="">
                        </div>
                    </div>
                    <div style="height: 10px"></div>
                    <div class="row" style="display: flex;
    align-items: center;font-family: 'Roboto';">
                        <div class="col-xs-12 col-md-4">
                            <h5 class="">Năm xuất bản</h3>
                        </div>
                        <div class="col-xs-12 col-md-8">
                            <input type="text" name="" id="input" class="form-control" value="" required="required" pattern="" title="">
                        </div>
                    </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
        <button type="button" class="btn btn-primary">Lưu</button>
      </div>
    </div>
  </div>
</div>
                                            </div>
                                        </div>
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

