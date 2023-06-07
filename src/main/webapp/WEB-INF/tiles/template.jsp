<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
 
<html>
    <head>
        <meta charset="EUC-KR">
        <title>Insert title here</title>
        <style>
            #header{            
                width:100%;
                height:50px;
                text-align: center;
                line-height: 50px;
                background-color: #61868e;
            }
            #left{
                float:left;
                 width:15%;
                 text-align: center;
                background-color: #d78b7d;
            }
            #main{
                float:left;
                 width:85%;
                background-color: #f9f3e3;
            }

            #footer{
                width: 100%;
                height: 50px;            
                text-align: center;
                background-color: #cfc8b5;
                clear:both;
            }
             #left, #main{ 
                   min-height: 700px;
             } 
        </style>
    </head>
    <body>
        <div style="width:100%; height:100%;">
        <div id="header"><tiles:insertAttribute name="header" /></div>
        <div id="left"><tiles:insertAttribute name="left" /></div>
        <div id="main"><tiles:insertAttribute name="body" /></div>    
        <div id="footer"><tiles:insertAttribute name="footer" /></div>
        </div>
     
    </body>
</html>