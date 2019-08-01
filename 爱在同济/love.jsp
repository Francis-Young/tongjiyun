<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Listiry</title>
  <link href="https://fonts.googleapis.com/css?family=Cabin:400,600" rel="stylesheet">
  <link rel="stylesheet" href="assets/styles/style.css">
</head>
<body>
<header id="masthead" class="site-header site-header--fluid bg-primary">
  <div class="d-lg-flex justify-content-lg-between align-items-lg-center site-header__container">
    <div class="d-lg-flex align-items-lg-center">
      <div class="site-header__logo">
        <a href="index.html">
          <h1 class="screen-reader-text">Listiry</h1>
          <img src="assets/images/logo-1.png" alt="Listiry">
        </a>
      </div><!-- .site-header__logo -->

      <form class="search-form" action="index.html">
        <div class="form-group__wrapper">
          <input type="text" name="place" placeholder="coffee shop, dinner..." class="form-input form-input--no-br">
        </div>
        <div class="form-group__wrapper">
          <input type="text" name="location" placeholder="location" class="form-input form-input--no-br">
          <a href="#" class="form-group__action c-dusty-gray">
            <i class="fa fa-map-marker"></i>
          </a>
        </div>
        <div class="form-group__wrapper">
          <button type="submit" class="button button--primary button--medium">
            <i class="fa fa-search"></i>
          </button>
        </div>
      </form>
    </div>

    <div class="d-lg-flex align-items-lg-center">
      <ul class="min-list main-navigation main-navigation--white">
        <li>
          <a href="#">Home</a>
          <ul class="min-list">
            <li>
              <a href="index.html">Home 1</a>
            </li>
            <li>
              <a href="index-2.html">Home 2</a>
            </li>
            <li>
              <a href="index-3.html">Home 3</a>
            </li>
            <li>
              <a href="index-4.html">Home 4</a>
            </li>
          </ul>
        </li>
        <li>
          <a href="#">吃在同济</a>
          <ul class="min-list">
            <li>
              <a href="listing-1.html">Listings Column Map 1</a>
            </li>
            <li>
              <a href="listing-2.html">Listings Column Map 2</a>
            </li>
            <li>
              <a href="listing-3.html">Listings Column Map 3</a>
            </li>
            <li>
              <a href="listing-5.html">Listings Fullwidth Map</a>
            </li>
            <li>
              <a href="listing-4.html">Listings Without Map</a>
            </li>
          </ul>
        </li>
        <li>
          <a href="#">学在同济</a>
          <ul class="min-list">
            <li>
              <a href="single-listing-1.html">Single Listing 1</a>
            </li>
            <li>
              <a href="single-listing-2.html">Single Listing 2</a>
            </li>
            <li>
              <a href="single-listing-3.html">Single Listing 3</a>
            </li>
            <li>
              <a href="single-listing-4.html">Single Listing 4</a>
            </li>
          </ul>
        </li>
        <li>
          <a href="#">住在同济</a>
          <ul class="min-list">
            <li>
              <a href="#">My Account</a>
              <ul class="min-list">
                <li>
                  <a href="profile.html">My Profile</a>
                </li>
                <li>
                  <a href="my-listings.html">My Listings</a>
                </li>
                <li>
                  <a href="bookmarked-listings.html">Bookmarked Listings</a>
                </li>
                <li>
                  <a href="change-password.html">Change Password</a>
                </li>
              </ul>
            </li>
            <li>
              <a href="contact.html">Contact</a>
            </li>
            <li>
              <a href="coming-soon.html">Coming Soon</a>
            </li>
            <li>
              <a href="404.html">404 Page</a>
            </li>
            <li>
              <a href="pricing-table.html">Pricing Table</a>
            </li>
            <li>
              <a href="login.html">Login/Signup</a>
            </li>
          </ul>
        </li>
        <li>
          <a href="blog.html">爱在同济</a>
        </li>
      </ul><!-- .main-navigation -->

      <div class="user-action">
        <a href="login.html" class="sign-in c-white">
          <i class="fa fa-user"></i>
                    登录
        </a>
        <button class="button button--small button--pill button--primary d-none d-lg-inline-block">&plus; Add Listing</button>
      </div><!-- .user-action -->
    </div>

    <div class="d-lg-none nav-mobile">
      <a href="#" class="nav-toggle js-nav-toggle nav-toggle--white">
        <span></span>
      </a><!-- .nav-toggle -->
    </div><!-- .nav-mobile -->
  </div><!-- .site-header__container -->
</header><!-- #masthead -->
<div class="col-md-6" >
        <h2 class="page-section__title">                          传声筒</h2>
        <form action="${pageContext.request.contextPath}/loveServlet" method="post">
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <label for="recieveid">对方学号 *</label>
                <input
                  type="text"
                  id="name"
                  name="recieveid"
                  class="form-input form-input--large form-input--border-c-alto"
                  placeholder=" "
                  required
                >
              </div><!-- .form-group -->
            </div><!-- .col -->

         
            <div class="col-md-12">
              <div class="form-group">
                <label for="message">正文</label>
                <textarea
                  name="text"
                  id="message"
                  rows="10"
                  class="form-input form-input--large form-input--border-c-alto"
                  placeholder="说些心里话吧..."></textarea>
              </div><!-- .form-group -->
            </div><!-- .col -->

            <div class="col-md-12">
              <div class="form-group--submit">
                <button class="button button--large button--square button--primary" type="submit">Send Message</button>
              </div>
            </div><!-- .col -->
          </div><!-- .row -->
        </form>
      </div>
</body>
</html>