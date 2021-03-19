<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <!-- 화면 최적화 -->
    <meta name="viewport" content="width-device-width" , initial-scale="1">
    <!-- 루트 폴더에 부트스트랩을 참조하는 링크 -->
    <link rel="stylesheet" href="css/bootstrap.css">
    <title>글쓰기 게시판</title>

</head>
<Style>
    * {
        margin: 0 auto;

    }

    .inner {
        width: 1200px;
    }
    header{
        background-color: black
        ;
        height: 100px;
        color: wheat;
      
    }
    .write_btn{
        text-align: right;
    }
    .container{
        margin-top: 30px
    }
    body{
        background-color: lightgoldenrodyellow;
    }


</Style>

<body>
   <header>
    
     <a href ="index">  <h1 style="padding: 20px;">배너</h1></a> 
   </header>
<nav>
    <div class="inner">
<h3 style="text-align: center; padding-left: 20px;">글쓰기</h3>
</div>
</nav>


    <!-- 게시판 글쓰기 양식 영역 시작 -->
    <div class="container inner">
        <div class="row">
            <form method="post" action="write">
                <table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
                    <thead>
                        <tr>
                            <th colspan="2" style="background-color: #eeeeee; text-align: center;">
                                게시판
                                </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                          
                            <input type="hidden" value="${sessionScope.id}" name="userid">
                            <input type="text" class="form-control" placeholder="글 제목" name="title" maxlength="50" style="width:1200px; height:30px">
                            </td>
                        </tr>
                        <tr>
                            <td><input type="text" class="form-control" placeholder="글 내용" name="content" maxlength="2048"
                                    style="height: 500px; width: 1200px;"></input></td>
                        </tr>
                    </tbody>
                </table>
                <!-- 글쓰기 버튼  -->
               <input type="submit" class="write_btn"  style="float: right;"value="글쓰기">
            </form>
        </div>
    </div>
    <!-- 게시판 글쓰기 양식 영역 끝 -->

    <!-- 부트스트랩 참조 영역 -->
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
</body>

</html>