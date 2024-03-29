
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>NewLogIn</title>
  <!-- <link href="https://fonts.googleapis.com/css?family=Cabin:400,600" rel="stylesheet"> -->
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
          <a href="http://localhost:8080/myTry/love.jsp">爱在同济</a>
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
<div class="page-content">
  <div class="breadcrumbs-container">
  <div class="container">
    <ul class="breadcrumbs min-list inline-list">
      <li class="breadcrumbs__item">
        <a href="index.html" class="breadcrumbs__link">
          <span class="breadcrumbs__title">Home</span>
        </a>
      </li>

      <li class="breadcrumbs__item">
        <a href="#" class="breadcrumbs__link">
          <span class="breadcrumbs__title">Pages</span>
        </a>
      </li>

      <li class="breadcrumbs__item">
        <span class="breadcrumbs__page c-gray">Login/Signup</span>
      </li>
    </ul><!-- .breadcrumbs -->
  </div><!-- .container -->
</div>
  <div class="container">
  <div class="row">
    <div class="col-md-4 offset-md-4">
      <div class="form-login js-login-form">
        <div class="form-login__block js-form-block is-selected" id="signin">
          <form action="loginServlet" method="post">
            <div class="form-container">
              <h3 class="form-title t-center">登录</h3>
              <div class="form-social">
                <div class="form-group">
                  <div class="form-group__wrapper">
                    <button
                      class="button button--social button--twitter button--pill button--large button--block"
                      type="button"
                    >
                      Connect to Twitter
                    </button>
                    <span class="form-group__icon form-group__icon--social">
                  <i class="fa fa-twitter c-white"></i>
                </span>
                  </div><!-- .form-group__wrapper -->
                </div><!-- .form-group -->

                <div class="form-group">
                  <div class="form-group__wrapper">
                    <button
                      class="button button--social button--facebook button--pill button--large button--block"
                      type="button"
                    >
                      Connect to Facebook
                    </button>
                    <span class="form-group__icon form-group__icon--social">
                  <i class="fa fa-facebook-f c-white"></i>
                </span>
                  </div><!-- .form-group__wrapper -->
                </div><!-- .form-group -->
              </div><!-- .form-social -->
              
              
                <div class="col-md-6">
                  <div class="form-group">
                    <label for="categories">类型</label>
                    <select
                      required
                      class="chosen-select"
                      name="utype"
                      id="categories"
                      data-placeholder="Choose a category..."
                    >
                      <option value="0" label="高中生">高中生</option>
                      <option value="1">大学生</option>
                  
                    </select>
                  </div><!-- .form-group -->
                </div><!-- .col -->
       
       
              <div class="form-group">
                <label for="login-user">用户名</label>
                <input
                  type="text"
                  name="uname"
                  id="login-user"
                  class="form-input form-input--pill form-input--border-c-gallery"
                  required
                  placeholder="johndoe"
                >
              </div><!-- .form-group -->

              <div class="form-group">
                <label for="login-password">密码</label>
                <input
                  type="password"
                  name="upassword"
                  id="login-password"
                  class="form-input form-input--pill form-input--border-c-gallery"
                  required
                  placeholder="******"
                >
              </div><!-- .form-group -->

              <div class="form-group">
                <div class="form-group__container">
                  <label for="remember-me" class="icheck_label">
                    <input type="checkbox" id="remember-me" name="iCheck">
                    记住我
                  </label>
                  <a href="#reset" class="c-gray js-block-trigger">忘记密码?</a>
                </div><!-- .form-group__container -->
              </div><!-- .form-group -->

              <div class="form-group--submit">
                <button
                  class="button button--primary button--pill button--large button--block button--submit"
                  type="submit"
                >
                  登录
                </button>
              </div>

              <div class="form-group--footer">
            <span class="c-gray">
              没有账号? <a href="#signup" class="c-secondary t-underline js-block-trigger">现在注册</a>
            </span>
              </div>
            </div><!-- .form-container -->
          </form><!-- .signin -->
        </div><!-- .form-login__block -->

        <div class="form-login__block js-form-block" id="signup">
          <form>
            <div class="form-container">
              <h3 class="form-title t-center">Sign Up</h3>
              <div class="form-social">
                <div class="form-group">
                  <div class="form-group__wrapper">
                    <button
                      class="button button--social button--twitter button--pill button--large button--block"
                      type="button"
                    >
                      <a href="www.twitter.com">Connect to Twitter</a>
                    </button>
                    <span class="form-group__icon form-group__icon--social">
                    <i class="fa fa-twitter c-white"></i>
                  </span>
                  </div><!-- .form-group__wrapper -->
                </div><!-- .form-group -->

                <div class="form-group">
                  <div class="form-group__wrapper">
                    <button
                      class="button button--social button--facebook button--pill button--large button--block"
                      type="button"
                    > <a href="www.twitter.com">Connect to Facebook</a>
                      
                    </button>
                    <span class="form-group__icon form-group__icon--social">
                    <i class="fa fa-facebook-f c-white"></i>
                  </span>
                  </div><!-- .form-group__wrapper -->
                </div><!-- .form-group -->
              </div><!-- .form-social -->
              <div class="form-group">
                <label for="signup-email">Email *</label>
                <input
                  type="email"
                  name="signup-email"
                  id="signup-email"
                  class="form-input form-input--pill form-input--border-c-gallery"
                  required
                  placeholder="johndoe@gmail.com"
                >
              </div><!-- .form-group -->

              <div class="form-group">
                <label for="signup-name">Name *</label>
                <input
                  type="text"
                  name="signup-name"
                  id="signup-name"
                  class="form-input form-input--pill form-input--border-c-gallery"
                  required
                  placeholder="John Doe"
                >
              </div><!-- .form-group -->

              <div class="form-group">
                <label for="signup-password">Confirm new password *</label>
                <input
                  type="password"
                  name="signup-password"
                  id="signup-password"
                  class="form-input form-input--pill form-input--border-c-gallery"
                  required
                  placeholder="******"
                >
              </div><!-- .form-group -->

              <div class="form-group">
              <span class="c-gray">
                By creating an account your agree to our <a href="#" class="t-underline">Terms and Conditions</a>
                and our <a href="#" class="t-underline">Privacy Policy</a>
              </span>
              </div><!-- .form-group -->

              <div class="form-group--submit">
                <button
                  class="button button--primary button--pill button--large button--block button--submit"
                  type="submit"
                >
                  Sign Up
                </button>
              </div>

              <div class="form-group--footer">
              <span class="c-gray">
                Already have an account?
                <a href="#signin" class="c-secondary t-underline js-block-trigger">登录</a>
              </span>登录
              </div>
            </div><!-- .form-container -->
          </form><!-- .signup -->
        </div><!-- .form-login__block -->

        <div class="form-login__block js-form-block" id="reset">
          <form action="/" method="post">
            <div class="form-container">
              <div class="form-group">
                <label for="reset-password">Email</label>
                <input
                  type="email"
                  name="reset-password"
                  id="reset-password"
                  class="form-input form-input--pill form-input--border-c-gallery"
                  placeholder="johndoe@gmail.com"
                  required
                >
              </div><!-- .form-group -->

              <div class="form-group--submit">
                <button
                  class="button button--primary button--pill button--large button--block button--submit"
                  type="submit"
                >
                  Reset Password
                </button>
              </div>

              <div class="form-group--footer">
                <a href="#signin" class="c-secondary t-underline js-block-trigger">Back to Sign in</a>
              </div>
            </div><!-- .form-container -->
          </form><!-- .reset -->
        </div><!-- .form-login__block -->
      </div><!-- .form-login -->
    </div><!-- .col -->
  </div><!-- .row -->
</div><!-- .container -->
</div><!-- .page-content -->
<footer id="colophone" class="site-footer">
  <div class="t-center site-footer__primary">
    <div class="container">
      <div class="site-footer__logo">
        <a href="index.html">
          <h1 class="screen-reader-text">Listiry</h1>
          <img src="assets/images/logo-footer.png" alt="Listiry">
        </a>
      </div>
      <p class="t-small">Listiry is making finding destination faster, easier, and customized for you.</p>
      <ul class="min-list inline-list site-footer__links site-footer__social">
        <li>
          <a href="#">
            <i class="fa fa-facebook-f"></i>
          </a>
        </li>
        <li>
          <a href="#">
            <i class="fa fa-twitter"></i>
          </a>
        </li>
        <li>
          <a href="#">
            <i class="fa fa-pinterest"></i>
          </a>
        </li>
        <li>
          <a href="#">
            <i class="fa fa-google-plus"></i>
          </a>
        </li>
        <li>
          <a href="#">
            <i class="fa fa-linkedin"></i>
          </a>
        </li>
        <li>
          <a href="#">
            <i class="fa fa-instagram"></i>
          </a>
        </li>
        <li>
          <a href="#">
            <i class="fa fa-youtube"></i>
          </a>
        </li>
      </ul>
    </div>
  </div>
  <!-- .site-footer__primary -->

  <div class="site-footer__secondary">
    <div class="container">
      <div class="site-footer__secondary-wrapper">
        <p class="site-footer__copyright">&copy; 2018
          <span class="c-secondary">Listiry</span> by Felix. All Rights Reserved.</p>
        <ul class="min-list inline-list site-footer__links site-footer__details">
          <li>
            <a href="tel:+0987654321">Tel: +098 765 4321</a>
          </li>
          <li>
            <a href="#">Get this theme</a>
          </li>
          <li>
            <a href="#">About</a>
          </li>
          <li>
            <a href="#">Contact</a>
          </li>
        </ul>
      </div>
    </div>
  </div>
  <!-- .site-footer__secondary -->
</footer><!-- #colophone -->
 <!--<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBDyCxHyc8z9gMA5IlipXpt0c33Ajzqix4"></script>
<script src="https://cdn.rawgit.com/googlemaps/v3-utility-library/master/infobox/src/infobox.js"></script>
导致选择框样式不可用的原因-->
<script src="assets/scripts/app.js"></script>
</body>
</html>