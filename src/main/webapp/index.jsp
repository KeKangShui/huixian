<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
    <title>高级页面</title>
</head>
<body>

<script type="text/javascript">
    var ajax = null;
        ajax = getAjax();
    function fuck() {
        /*1获取Ajax对象*/

//        alert(ajax);
        /*2告诉Ajax对象要发送什么数据 （请求方式，请求路径，是否异步）*/
  /*      var va=document.getElementById("na");

        var sp=document.getElementById("sp");
        var na=va.value;//这个是可以在文本域中直接拿数据*/
        ajax.open("get","/getpic",true);
        ajax.onreadystatechange=function () {
//            alert(ajax.status);
            if(ajax.readyState==4 || ajax.status==200){

                var url=ajax.responseText;
                alert(url);
//              $("#allImgUrl").setAttribute("src",sp);
                document.getElementById("allImgUrl").attr("src",url);
            }
        };
        ajax.send(null);
    }

    function getAjax() {
        var xmlhttp;
        if (window.XMLHttpRequest) {//非IE浏览器
            xmlhttp = new XMLHttpRequest();
        }
        if (window.ActiveXObject){
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            if(!xmlhttp){
                xmlhttp=new ActiveXObject("Msxml2.XMLHTTP");
            }
        }

        return xmlhttp;
    }

</script>
<div id="middle" style="text-align: center">
    <form action="/uploadPic.do" id="jvForm" method="post" enctype="multipart/form-data">

        <li style="font-size: 48px">
            <img id="user_image" class="denglu_pic" src="/res/img/timg.jpg"
                 style="height: 100px;width: 100px;border-radius:60px;margin-top: 30px"></li>
        <table style="margin-top: 30px" align="center">
            <tr>
                <td>用户名： <input type="text" name="name"/></td>
            </tr>
            <tr>
                <td>
                    <img width="100" height="100" id="allImgUrl"/>
                    <!--<input type="hidden" name="imgUrl" id="path"/>-->
                    <input type="file"  name="file" onchange="fuck()"/>
                </td>
            </tr>
        </table>
        <input type="submit"  value="提交">
    </form>
</div>
</body>
</html>
