<!DOCTYPE html>
<!--[if !IE]><!-->
<html lang="pt">
<!--<![endif]-->

<!-- Mirrored from seantheme.com/admetro/layout_starter.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 12 Apr 2019 17:39:42 GMT -->
<head>
    <meta charset="utf-8" />
    <title>Projecto</title>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />

    <!-- ================== BEGIN BASE CSS STYLE ================== -->
    %{--<link href="assets/css/app.min.css" rel="stylesheet" />--}%
    <asset:stylesheet src="app.min.css"/>
    <asset:stylesheet src="fonts/css/v4-shims.css"/>

    <!-- ================== END BASE CSS STYLE ================== -->
</head>
<body>
<!-- BEGIN #page-container -->
<div id="app" class="app app-header-fixed app-sidebar-fixed">
    <!-- BEGIN #header -->
    <header id="header" class="app-header">
        <!-- BEGIN navbar-toggle-minify -->
        %{--<button type="button" class="navbar-toggle navbar-toggle-minify" data-click="sidebar-minify">--}%
            %{--<span class="icon-bar"></span>--}%
            %{--<span class="icon-bar"></span>--}%
            %{--<span class="icon-bar"></span>--}%
        %{--</button>--}%
        <!-- END navbar-toggle-minify -->
        <!-- BEGIN navbar-header -->
        <div class="navbar-header">
            <a href="/" class="navbar-brand">
                Projecto
            </a>
            <button type="button" class="navbar-toggle" data-click="sidebar-toggled">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <!-- END navbar-header -->
        <!-- BEGIN navbar-nav -->
        <ul class="navbar-nav navbar-right">
            <li class="nav-item">
                <a href="#" data-toggle="search-bar" class="nav-link">
                    <i class="fa fa-search nav-icon"></i>
                </a>
            </li>
            <li class="nav-item">
                <a href="/entidade/index"  class="nav-link" title="Access System">
                    <i class="fa fa-sign-in nav-icon"></i>
                </a>
            </li>
        </ul>
        <!-- END navbar-nav -->
        <!-- BEGIN navbarf-search -->
        <div class="navbar-search">
            <form action="#" method="POST" name="navbar_search_form">
                <div class="form-group">
                    <div class="icon"><i class="fa fa-search"></i></div>
                    <input type="text" class="form-control" id="header-search" placeholder="Search admetro..." />
                    <div class="icon">
                        <a href="#" data-dismiss="search-bar" class="right-icon"><i class="fa fa-times"></i></a>
                    </div>
                </div>
            </form>
        </div>
        <!-- END navbar-search -->
    </header>
    <!-- END #header -->
    <!-- BEGIN #sidebar -->
    <sidebar id="sidebar" class="app-sidebar position-fixed">
        <!-- BEGIN scrollbar -->
        <div data-scrollbar="true" data-height="100%">
            <!-- BEGIN nav -->
            <ul class="nav">
                <li class="nav-profile">
                    <div class="profile-img">
                        %{--<img src="assets/img/user.jpg" />--}%
                    </div>
                    <div class="profile-info">
                        <h4>John Smith</h4>
                        <p>Frontend Developer</p>
                    </div>
                </li>
                <li class="nav-project">
                    <a href="#">
                        <div class="project-icon">
                            <i class="fab fa-github"></i>
                        </div>
                        <div class="project-info">
                            <h4 class="project-title">Repository Settings</h4>
                            <div class="progress">
                                <div class="progress-bar bg-gradient-blue-purple-to-right" style="width: 50%;" role="progressbar"></div>
                            </div>
                        </div>
                        <div class="project-percentage">50%</div>
                    </a>
                </li>
                <li class="nav-divider"></li>
                <li class="nav-copyright">&copy; 2019 seanTheme All Right Reserved</li>
            </ul>
            <!-- END nav -->
        </div>
        <!-- END scrollbar -->
    </sidebar>
    <!-- END #sidebar -->

    <!-- BEGIN #content -->
    <div id="content" class="app-content">
        <g:layoutBody/>
    </div>
    <!-- END #content -->

    <!-- BEGIN btn-scroll-top -->
    <a href="#" data-click="scroll-top" class="btn-scroll-top fade"><i class="fa fa-arrow-up"></i></a>
    <!-- END btn-scroll-top -->
</div>
<!-- END #app -->

<!-- ================== BEGIN BASE JS ================== -->
%{--<script src="assets/js/app.min.js"></script>--}%
<asset:javascript src="app.min.js"/>
<!-- ================== END BASE JS ================== -->
<script>

</script>
</body>

<!-- Mirrored from seantheme.com/admetro/layout_starter.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 12 Apr 2019 17:39:42 GMT -->
</html>