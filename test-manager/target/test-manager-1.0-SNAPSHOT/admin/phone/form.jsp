
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.test_manager.entity.Phone" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.time.LocalDate" %>
<%
    request.setCharacterEncoding("utf-8");
    //thêm để không bị lỗi font chữ
    Phone phone =(Phone) request.getAttribute("food");
    if(phone==null){
       phone = new Phone();
    }
  HashMap<String,String> errors = (HashMap<String, String>) request.getAttribute("errors");
    if(errors==null){
        errors = new HashMap<>();
    }
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/admin/include/header.jsp">
        <jsp:param name="title" value="Phone form"/>
        <jsp:param name="description" value="Phone form"/>
        <jsp:param name="keywords" value="Admin, page...."/>
    </jsp:include>
    <style>.msg-error{color: red}</style>
</head>
<body class="w3-light-grey">

<!-- Top container -->
<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
    <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i>  Menu</button>
    <span class="w3-bar-item w3-right">Create Phone Form</span>
</div>

<!-- Sidebar/menu -->
<jsp:include page="/admin/include/left-menu.jsp"/> <!--tách giao diện ra các file jsp khác nhau dùng jsp:include để nối vào-->


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">

    <!-- Header -->
    <header class="w3-container" style="padding-top:22px">
        <h5><b><i class="fa fa-dashboard"></i>Phone Form</b></h5>
    </header>

    <div class="w3-row-padding w3-margin-bottom">
        <form action="" method="post" class="w3-container">
            <div class="w3-margin">
                <label>Name</label>
                <input class="w3-input" value="<%=phone.getName()%>" name="name" type="text" >
                <br>
                <%if(errors.containsKey("name")){%>
                <span class="msg-error"><%=errors.get("name")%></span>
                <%}%>
            </div>
            <div class="w3-margin">
                <label>Description</label>
                <input class="w3-input" value="<%=phone.getDescription()%>" name="description" type="text">
                <br>
                <%if(errors.containsKey("description")){%>
                <span class="msg-error"><%=errors.get("description")%></span>
                <%}%>
            </div>
            <div class="w3-margin">
                <label>Price</label>
                <input class="w3-input" value="<%=phone.getPrice()%>" name="price" type="text">
                <br>
                <%if(errors.containsKey("price")){%>
                <span class="msg-error"><%=errors.get("price")%></span>
                <%}%>
            </div>
            <div class="w3-margin">
                <label>Brand</label>
                <br>
                <select name="category_id" >
                    <%if (phone.getBrand()==4){%>
                    <option value="4">Apple</option>
                    <option value="1">SamSung</option>
                    <option value="2">Nokia</option>
                    <option value="3">Others</option>
                    <%}else if(phone.getBrand()==2){%>
                    <option value="2">Nokia</option>
                    <option value="1">SamSung</option>
                    <option value="3">Others</option>
                    <option value="4">Apple </option>
                    <%}else if(phone.getBrand()==3){%>
                    <option value="3">Others</option>
                    <option value="1">SamSung</option>
                    <option value="2">Nokia</option>
                    <option value="4">Apple</option>
                    <%}else {%>
                    <option value="1">SamSung</option>
                    <option value="2">Nokia</option>
                    <option value="3">Others</option>
                    <option value="4">Apple</option>
                    <%}%>
                </select>
            </div>
            <button class="w3-button  w3-blue w3-margin">Submit </button>
        </form>
    </div>
</div>
<!-- Footer -->
<footer class="w3-container w3-padding-16 w3-light-grey">
    <jsp:include page="/admin/include/footer.jsp"/>
</footer>

<!-- End page content -->
</body>

</div>
<jsp:include page="/admin/include/script.jsp"/>
</html>




