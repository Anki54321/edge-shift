<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Anyar Bootstrap Template - Index</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="../home/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="../home/vendor/aos/aos.css" rel="stylesheet">
  <link href="../home/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="../home/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="../home/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="../home/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="../home/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="../home/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="../home/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: Anyar - v4.9.1
  * Template URL: https://bootstrapmade.com/anyar-free-multipurpose-one-page-bootstrap-theme/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
  <style>
  .dot {
    height: 25px;
    width: 25px;
    background-color: #bbb;
    border-radius: 50%;
    display: inline-block;
  }
  .timeline {
  display: flex;
  align-items: center;
  justify-content: center;
}

.circle {
  width: 20px;
  height: 20px;
  background: black;
  border-radius: 50%;
}
.circle1 {
  width: 20px;
  height: 20px;
  background: rgb(225, 9, 9);
  border-radius: 50%;
}

.dashed {
  width: 100px;
  border: 1px dashed #C4C4C4;
}
.vl {
  border-left: 6px solid green;
  top:20px;
  height: 34px;
}
</style>
</head>

<body>
  <h1 style="text-align: center;"></h1>
  <!-- ======= Top Bar ======= -->
  <div id="topbar" class="fixed-top d-flex align-items-center ">
    <div class="container d-flex align-items-center justify-content-center justify-content-md-between">
    
    
    </div>
  </div>

  <!-- ======= Header ======= -->
  <header id="header" class="fixed-top d-flex align-items-center ">
    <div class="container d-flex align-items-center justify-content-between">
      <p >

      <h1 class="logo"><a href="index.html"></a></h1>
      <!-- Uncomment below if you prefer to use an image logo -->
      <!-- <a href=index.html" class="logo"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

      <nav id="navbar" class="navbar">
        <ul>
          <li><a class="nav-link scrollto active" href="#hero">Home</a></li>
          <li><a class="nav-link scrollto" href="/profile/${um.userId}">User</a></li>
          <li><a class="nav-link scrollto" href="/getUsers/${um.userId}">Create Connection</a></li>
          <li><a class="nav-link scrollto" href="/viewReq/${um.userId}">View Connection Request</a></li>
          <li><a class="nav-link scrollto " href="/upload">Send File</a></li>
          <li><a class="nav-link scrollto " href="/view1/${um.userId}">View File</a></li>
          <li><a class="nav-link scrollto " href="logout">Logout</a></li>
         
         
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->

    </div>
  </header><!-- End Header -->

  <!-- ======= Hero Section ======= -->
  <section id="hero" class="d-flex justify-cntent-center align-items-center">
    
      <!-- Slide 1 -->
    
      <c:choose>
        <c:when test="${profile != null}">
          <div class="container animate__animated animate__fadeInDown">
            <div class="row">
              ${msg}
              <div class="col-lg-5 col-md-6">
                <div class="slider_detail-box">
                  <h1>
             
                  </h1>
                <table class="table" style="color:#FFF;">
                 <tr>
                  <td>Name</td>
                  <td>Email</td>
                  <td>Mobile</td>
                 </tr>
      <tr>
        <td>${um.name}</td>
        <td>${um.emailId}</td>
        <td>${um.mobile}</td>
      </tr>
                </table>
                  <div class="btn-box">
                   
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="slider_img-box">
                  <img src="../images/slider-img.png" alt=""/>
                </div>
              </div>
            </div>
          </div>
        </c:when>
      
        <c:when test="${upload != null}">
          
        <div class="container animate__animated animate__fadeInDown">
          <div class="row">
            <div class="col-lg-5 col-md-6">
              <div class="slider_detail-box">
                <img src="/images/system.jpg" width="100px" height="100px"/>
                
                <h2 class="animate__animated animate__fadeInDown">${msg}</h2>
                <p class="animate__animated animate__fadeInDown">${packet}</p>
                <form action="uploadSubmit" method="post" enctype = "multipart/form-data">
                  <label>Select file to upload</label>
                  <input type="file" name="file" class="form-control"><br/><br/>
                  <input type="hidden" name="userid" value="${um.userId}"/>
                  <input type="submit" value="submit" class="btn btn-success"/>
                </form> 
                </div>
              </div>
            </div>
            
          </div>
        
        </c:when>
      
        <c:when test="${create != null}">
          
        <div class="container animate__animated animate__fadeInDown">
          <div class="row">
            <div class="col-lg-5 col-md-6">
              <div class="slider_detail-box">
                <h2 class="animate__animated animate__fadeInDown">${msg}</h2>
               
     
                
              
                <form action="/sendKey" method="post">
                <label style="color:#FFf;">User Name</label>
                <input type="text" name="uname" class="form-control" value="${um.name}" readonly><br/>
                <input type="text" name="userid" class="form-control" value="${um.userId}" readonly ><br/>
                <label style="color:#FFf;">Hash code</label>
                <input type="text" class="form-control" name="hash" value="${hashcode}" readonly><br/>
                <label style="color:#FFf;">Select Users</label>
                <select name="user" class="form-control">
                  <c:forEach items="${values}" var="element"> 
                    <option>${element.userId},${element.emailId}</option>
                    </c:forEach>
                 
                </select>
                
                <br/>
<input type="submit" value="submit" class="form-control btn btn-success">
</form>       
                </div>
              </div>

              <c:choose>
                <c:when test="${malnode!=null}">
                 <div class="col-lg-5 col-md-6">
                <c:forEach begin="${malnode}" end="${malnode1}" varStatus="loop">
                  <div class="timeline">
                    ${loop.index}
                    
                    <div class="circle"></div>
                    <div class="dashed"></div>
                    ${loop.index + 13}
                    <c:choose>
                      <c:when test="${loop.index==malnode}">
                        <div class="circle1"></div>
                        <div class="dashed"></div>
                       
                      </c:when>
                      <c:when test="${loop.index==malnode1}">
                        <div class="circle1"></div>
                        <div class="dashed"></div>
                       
                      </c:when>
                      <c:otherwise>
                      
                        <div class="circle"></div>
                        <div class="dashed"></div>
                      </c:otherwise>
                    </c:choose>
                  
                    ${loop.index + 26}
                   
                    <div class="circle"></div>
                   
                    </div><br/>
              </c:forEach>

              </div>
                    
                </c:when>    
                <c:otherwise>
                
                    
                </c:otherwise>
            </c:choose>
              
            </div>
            
          </div>
        </div>
        
        </c:when>

        <c:when test="${view1 != null}">
          
        <div class="container animate__animated animate__fadeInDown">
          <div class="row">
            <div class="col-lg-5 col-md-6">
              <div class="slider_detail-box">
                <h1>
                  welcome ${um.name}
                
                  <p>${msg}</p>
                   </h1>
                  <table class="table" style="color:#fff;">
                  <tr>
                   <td>FileName</td>
                   <td>timetaken</td>
                   <td>File Url</td>
                  </tr>
         
                  <tr>
         
                   <c:forEach items="${files}" var="element"> 
           <tr>
             <td>${element.fileName}</td>
            
             <td>${element.timetaken} "ms"</td>
             <td><a href="${element.fileUrl}">Download</a></td>
             
           </tr>
         </c:forEach>
                  </tr>
         
                  </table>
               
                </div>
              </div>
            </div>
            
          </div>
        </div>
        
        </c:when>

        <c:when test="${view != null}">
          
        <div class="container animate__animated animate__fadeInDown">
          <div class="row">
           
              <div class="slider_detail-box">
                <h1>
                  welcome ${um.name}
                
                  <p>${msg}</p>
                   </h1>
                  <table class="table" style="color:#fff;">
                  <tr>
                   <td>FileId</td>
                   <td>Hash Code</td>
                   <td>ipaddress</td>
                   <td>Mac address</td>
                  </tr>
         
                  <tr>
         
                 
           <tr>
             <td>${values.id}</td>
             <td>${values.hashCode}</td>
             <td>${values.ipaddress}</td>
             <td>${values.macaddress}</td>

             <c:choose>
              <c:when test="${values.status == 'pending'}">
             <td> <a href="/accept/${values.id}">Accept</a></td>
              </c:when>    
              <c:otherwise>
                
              </c:otherwise>
          </c:choose>
             
           </tr>
        
                  </tr>
         
                  </table>
               
                </div>
              
            </div>
            
          </div>
        </div>
        
        </c:when>
      
        <c:otherwise>
          <div class="container">
        <h2 class="animate__animated animate__fadeInDown">welcome ${um.name}</h2>
            <h2 class="animate__animated animate__fadeInDown">A Secure Optimization Routing Algorithm
  
  <span>for Mobile Ad Hoc Networks</span></h2>
            
          
        </div>
        </c:otherwise>
      </c:choose>
              
      

     

    </div>
  </section><!-- End Hero -->

  <main id="main">

    <!-- ======= Icon Boxes Section ======= -->
  

    <!-- ======= About Us Section ======= -->
    
    <!-- ======= Clients Section ======= -->
    
<div id="preloader"></div>
  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>


  <!-- Template Main JS File -->
  <script src="../js/main.js"></script>

</body>

</html>