<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${btc}
<script>

setInterval(function(){  $.ajax({
    type : "메소드명",
    url : "url",
    dataType : "JSON",
    error : function(error){
      console.log(error)
    },
    data:{
      currency:"all"
    },
    sucess : function(data){
      $("btc").html(data.btc.last)
      $("xrp").html(data.xrp.last)
      $("eth").html(data.eth.last)
      $("bch").html(data.bch.last)
      $("etc").html(data.etc.last)
      $("ltc").html(data.ltc.last)
    }
  })},400)


</script>


  
</body>
</html>