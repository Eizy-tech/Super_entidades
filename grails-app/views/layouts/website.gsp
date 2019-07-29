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
    <asset:stylesheet src="animate.css"/>
    <asset:stylesheet src="style.css"/>
    <asset:stylesheet src="media-queries.css"/>
    <asset:stylesheet src="carousel.css"/>

    <!-- ================== END BASE CSS STYLE ================== -->
</head>
<body>
<!-- BEGIN #page-container -->
<div id="app" class="app h-100">
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

    <div class="d-flex flex-row bd-highlight mb-3 bg-cyan h-100">
        <div class="p-2 bd-highlight bg-red col-md-2">
            Categoria Menu
        </div>
        <div class="p-2 bd-highlight bg-yellow col-md-10">

            %{--<div class="row p-5 bg-gray-dark">--}%
                %{--<div class="top-content">--}%
                    %{--<div class="container-fluid">--}%
                        %{--<div id="carousel-example" class="carousel slide" data-ride="carousel">--}%
                            %{--<div class="carousel-inner row w-100 mx-auto" role="listbox">--}%
                                %{--<div class="carousel-item col-12 col-sm-6 col-md-4 col-lg-3 active">--}%
                                    %{--<asset:image class="img-fluid mx-auto d-block" src="eizy.png" style="height: 210px"/>--}%
                                %{--</div>--}%
                                %{--<div class="carousel-item col-12 col-sm-6 col-md-4 col-lg-3">--}%
                                    %{--<asset:image class="img-fluid mx-auto d-block" src="eizy.png" style="height: 210px"/>--}%
                                %{--</div>--}%
                                %{--<div class="carousel-item col-12 col-sm-6 col-md-4 col-lg-3">--}%
                                    %{--<asset:image class="img-fluid mx-auto d-block" src="eizy.png" style="height: 210px"/>--}%
                                %{--</div>--}%
                                %{--<div class="carousel-item col-12 col-sm-6 col-md-4 col-lg-3">--}%
                                    %{--<asset:image class="img-fluid mx-auto d-block" src="eizy.png" style="height: 210px"/>--}%
                                %{--</div>--}%
                                %{--<div class="carousel-item col-12 col-sm-6 col-md-4 col-lg-3">--}%
                                    %{--<asset:image class="img-fluid mx-auto d-block" src="eizy.png" style="height: 210px"/>--}%
                                %{--</div>--}%
                                %{--<div class="carousel-item col-12 col-sm-6 col-md-4 col-lg-3">--}%
                                    %{--<asset:image class="img-fluid mx-auto d-block" src="eizy.png" style="height: 210px"/>--}%
                                %{--</div>--}%
                                %{--<div class="carousel-item col-12 col-sm-6 col-md-4 col-lg-3">--}%
                                    %{--<asset:image class="img-fluid mx-auto d-block" src="eizy.png" style="height: 210px"/>--}%
                                %{--</div>--}%
                                %{--<div class="carousel-item col-12 col-sm-6 col-md-4 col-lg-3">--}%
                                    %{--<asset:image class="img-fluid mx-auto d-block" src="eizy.png" style="height: 210px"/>--}%
                                %{--</div>--}%
                            %{--</div>--}%
                            %{--<a class="carousel-control-prev" href="#carousel-example" role="button" data-slide="prev">--}%
                                %{--<span class="carousel-control-prev-icon" aria-hidden="true"></span>--}%
                                %{--<span class="sr-only">Previous</span>--}%
                            %{--</a>--}%
                            %{--<a class="carousel-control-next" href="#carousel-example" role="button" data-slide="next">--}%
                                %{--<span class="carousel-control-next-icon" aria-hidden="true"></span>--}%
                                %{--<span class="sr-only">Next</span>--}%
                            %{--</a>--}%
                        %{--</div>--}%
                    %{--</div>--}%
                %{--</div>--}%
            %{--</div>--}%

            <div class="row p-5">
                <div class="col-md-2">
                    <div class="card mb-4 shadow-lg image-container">
                        <asset:image class="image" src="eizy.png" style="height: 160px"/>
                        <div class="middle">
                            <div class="text d-flex flex-row">
                                <button class="btn btn-sm btn-primary mr-3" title="Mapa"><i class="fa fa-map"></i></button>
                                <button class="btn btn-sm btn-warning" title="Contactos"><i class="fa fa-phone"></i></button>
                            </div>
                        </div>
                        <div class="card-body" style="border-top: 1px solid cadetblue">
                            <span class="badge badge-pill badge-green float-lg-right" style="margin-top: -24px; margin-right: -14.5px">Tecnologia</span>
                            <p class="card-text"><b>Eizy Technology</b></p>
                        </div>
                    </div>
                </div>

                <div class="col-md-2">
                    <div class="card mb-4 shadow-lg image-container">
                        <asset:image class="image" src="eizy.png" style="height: 160px"/>
                        <div class="middle">
                            <div class="text d-flex flex-row">
                                <button class="btn btn-sm btn-primary mr-3" title="Mapa"><i class="fa fa-map"></i></button>
                                <button class="btn btn-sm btn-warning" title="Contactos"><i class="fa fa-phone"></i></button>
                            </div>
                        </div>
                        <div class="card-body" style="border-top: 1px solid cadetblue">
                            <span class="badge badge-pill badge-green float-lg-right" style="margin-top: -24px; margin-right: -14.5px">Tecnologia</span>
                            <p class="card-text"><b>Eizy Technology</b></p>
                        </div>
                    </div>
                </div>

                <div class="col-md-2">
                    <div class="card mb-4 shadow-lg image-container">
                        <asset:image class="image" src="eizy.png" style="height: 160px"/>
                        <div class="middle">
                            <div class="text d-flex flex-row">
                                <button class="btn btn-sm btn-primary mr-3" title="Mapa"><i class="fa fa-map"></i></button>
                                <button class="btn btn-sm btn-warning" title="Contactos"><i class="fa fa-phone"></i></button>
                            </div>
                        </div>
                        <div class="card-body" style="border-top: 1px solid cadetblue">
                            <span class="badge badge-pill badge-green float-lg-right" style="margin-top: -24px; margin-right: -14.5px">Tecnologia</span>
                            <p class="card-text"><b>Eizy Technology</b></p>
                        </div>
                    </div>
                </div>

                <div class="col-md-2">
                    <div class="card mb-4 shadow-lg image-container">
                        <asset:image class="image" src="eizy.png" style="height: 160px"/>
                        <div class="middle">
                            <div class="text d-flex flex-row">
                                <button class="btn btn-sm btn-primary mr-3" title="Mapa"><i class="fa fa-map"></i></button>
                                <button class="btn btn-sm btn-warning" title="Contactos"><i class="fa fa-phone"></i></button>
                            </div>
                        </div>
                        <div class="card-body" style="border-top: 1px solid cadetblue">
                            <span class="badge badge-pill badge-green float-lg-right" style="margin-top: -24px; margin-right: -14.5px">Tecnologia</span>
                            <p class="card-text"><b>Eizy Technology</b></p>
                        </div>
                    </div>
                </div>

                <div class="col-md-2">
                    <div class="card mb-4 shadow-lg image-container">
                        <asset:image class="image" src="eizy.png" style="height: 160px"/>
                        <div class="middle">
                            <div class="text d-flex flex-row">
                                <button class="btn btn-sm btn-primary mr-3" title="Mapa"><i class="fa fa-map"></i></button>
                                <button class="btn btn-sm btn-warning" title="Contactos"><i class="fa fa-phone"></i></button>
                            </div>
                        </div>
                        <div class="card-body" style="border-top: 1px solid cadetblue">
                            <span class="badge badge-pill badge-green float-lg-right" style="margin-top: -24px; margin-right: -14.5px">Tecnologia</span>
                            <p class="card-text"><b>Eizy Technology</b></p>
                        </div>
                    </div>
                </div>

                <div class="col-md-2">
                    <div class="card mb-4 shadow-lg image-container">
                        <asset:image class="image" src="eizy.png" style="height: 160px"/>
                        <div class="middle">
                            <div class="text d-flex flex-row">
                                <button class="btn btn-sm btn-primary mr-3" title="Mapa"><i class="fa fa-map"></i></button>
                                <button class="btn btn-sm btn-warning" title="Contactos"><i class="fa fa-phone"></i></button>
                            </div>
                        </div>
                        <div class="card-body" style="border-top: 1px solid cadetblue">
                            <span class="badge badge-pill badge-green float-lg-right" style="margin-top: -24px; margin-right: -14.5px">Tecnologia</span>
                            <p class="card-text"><b>Eizy Technology</b></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="row p-5 bg-gray-dark">
        <div class="top-content">
            <div class="container-fluid">
                <div id="carousel-example" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner row w-100 mx-auto" role="listbox">
                        <div class="carousel-item col-12 col-sm-6 col-md-4 col-lg-3 active">
                            <asset:image class="img-fluid mx-auto d-block" src="eizy.png" style="height: 210px"/>
                        </div>
                        <div class="carousel-item col-12 col-sm-6 col-md-4 col-lg-3">
                            <asset:image class="img-fluid mx-auto d-block" src="eizy.png" style="height: 210px"/>
                        </div>
                        <div class="carousel-item col-12 col-sm-6 col-md-4 col-lg-3">
                            <asset:image class="img-fluid mx-auto d-block" src="eizy.png" style="height: 210px"/>
                        </div>
                        <div class="carousel-item col-12 col-sm-6 col-md-4 col-lg-3">
                            <asset:image class="img-fluid mx-auto d-block" src="eizy.png" style="height: 210px"/>
                        </div>
                        <div class="carousel-item col-12 col-sm-6 col-md-4 col-lg-3">
                            <asset:image class="img-fluid mx-auto d-block" src="eizy.png" style="height: 210px"/>
                        </div>
                        <div class="carousel-item col-12 col-sm-6 col-md-4 col-lg-3">
                            <asset:image class="img-fluid mx-auto d-block" src="eizy.png" style="height: 210px"/>
                        </div>
                        <div class="carousel-item col-12 col-sm-6 col-md-4 col-lg-3">
                            <asset:image class="img-fluid mx-auto d-block" src="eizy.png" style="height: 210px"/>
                        </div>
                        <div class="carousel-item col-12 col-sm-6 col-md-4 col-lg-3">
                            <asset:image class="img-fluid mx-auto d-block" src="eizy.png" style="height: 210px"/>
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carousel-example" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carousel-example" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
        </div>
    </div>

    <a href="#" data-click="scroll-top" class="btn-scroll-top fade"><i class="fa fa-arrow-up"></i></a>
    <!-- END btn-scroll-top -->
</div>
<!-- END #app -->

<!-- ================== BEGIN BASE JS ================== -->
%{--<script src="assets/js/app.min.js"></script>--}%
<asset:javascript src="app.min.js"/>
<!-- ================== END BASE JS ================== -->
<script>
    $('#carousel-example').on('slide.bs.carousel', function (e) {
        /*
            CC 2.0 License Iatek LLC 2018
            Attribution required
        */
        var $e = $(e.relatedTarget);
        var idx = $e.index();
        var itemsPerSlide = 5;
        var totalItems = $('.carousel-item').length;

        if (idx >= totalItems-(itemsPerSlide-1)) {
            var it = itemsPerSlide - (totalItems - idx);
            for (var i=0; i<it; i++) {
                // append slides to end
                if (e.direction=="left") {
                    $('.carousel-item').eq(i).appendTo('.carousel-inner');
                }
                else {
                    $('.carousel-item').eq(0).appendTo('.carousel-inner');
                }
            }
        }
        console.log('fader')
    });
</script>
</body>

<!-- Mirrored from seantheme.com/admetro/layout_starter.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 12 Apr 2019 17:39:42 GMT -->
</html>