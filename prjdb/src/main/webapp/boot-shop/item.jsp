<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Shop Item - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="boot-shop/css/styles.css" rel="stylesheet" />
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
    </head>
    <body>
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="#!">Start Bootstrap</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="#!">About</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#!">All Products</a></li>
                                <li><hr class="dropdown-divider" /></li>
                                <li><a class="dropdown-item" href="#!">Popular Items</a></li>
                                <li><a class="dropdown-item" href="#!">New Arrivals</a></li>
                            </ul>
                        </li>
                    </ul>
                    <form class="d-flex">
                        <button class="btn btn-outline-dark" type="submit">
                            <i class="bi-cart-fill me-1"></i>
                            Cart
                            <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
                        </button>
                    </form>
                </div>
            </div>
        </nav>
        <!-- Product section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="boot-shop/img/${n.itemImg }" alt="..." /></div>
                    <div class="col-md-6">
                        <div class="small mb-1">${n.itemId}</div>
                        <h1 class="display-5 fw-bolder">${n.itemName}</h1>
                        <div class="fs-5 mb-5">
                            <c:choose>
                                <c:when test="${n.itemSalePrice ne 0}">
                                    <span class="text-decoration-line-through">${n.itemPrice}원</span>
                                    <span>${n.itemSalePrice}원</span>
                                </c:when>
                                <c:otherwise>
                                    ${n.itemPrice}원
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <p class="lead">${n.itemScript}</p>
                        <div class="d-flex">
                            <input class="form-control text-center me-3" id="inputQuantity" type="num" value="1" style="max-width: 3rem" />
                            <button class="btn btn-outline-dark flex-shrink-0" type="button">
                                <i class="bi-cart-fill me-1"></i>
                                Add to cart
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Related items section-->
        <section class="py-5 bg-light">
            <div class="container px-4 px-lg-5 mt-5">
                <h2 class="fw-bolder mb-4">Related products</h2>
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center" id="card">
                    
                   
                   

                </div>
            </div>
        </section>
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2023</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="boot-shop/js/scripts.js"></script>
        <script>
            let temp_html;

        	fetch('AjaxProductFour.do')
        	.then(resolve=>resolve.json())
        	.then(result=>four(result));
        	
        	function four(result) {
        		//console.log("실행");
        		//console.log(result);
                result.forEach(function (r) {
                    let num = r.itemStar;
                    //console.log(r.itemName);
                    temp_html = `<div class="col mb-5">
                            <div class="card h-100">
                                <!-- Sale badge-->`
                    if(r.itemSalePrice != 0) {
                        temp_html += `<div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>`
                    }
                    temp_html +=`
                                <!-- Product image-->
                                <img class="card-img-top" src="boot-shop/img/\${r.itemImg }" alt="..." />
                                <!-- Product details-->
                                <div class="card-body p-4">
                                    <div class="text-center">
                                        <!-- Product name-->
                                        <h5 class="fw-bolder">\${r.itemName}</h5>
                                        <!-- Product reviews-->
                                        <div class="d-flex justify-content-center small text-warning mb-2">`;
                    for(let i = 0; i < num; i++) {
                        temp_html += `<div class="bi-star-fill"></div>`;
                    }
                    temp_html+= `</div>
                                        <!-- Product price-->`;
                                        
                    if(r.itemSalePrice != 0) {
                        temp_html += `<span class="text-muted text-decoration-line-through">\${r.itemPrice}원</span>
                                             \${r.itemSalePrice}원`;
                    }
                    else {
                        temp_html += `\${r.itemPrice}원`;
                    }

                    temp_html += ` </div>
                                </div>
                                 <!-- Product actions-->
                             <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                     <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
                                 </div>
                             </div>
                            </div>`;
                                        
               
                        //console.log(temp_html);
                   $('#card').append(temp_html);
                })
        	}

           
        </script>
    </body>
</html>

