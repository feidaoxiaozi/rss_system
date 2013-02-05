<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
  <title>RSS新闻管理系统</title>
<style type="text/css">
<!--
body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
}
.STYLE1 {
	color: #e1e2e3;
	font-size: 12px;
}
.STYLE6 {color: #000000; font-size: 12; }
.STYLE10 {color: #000000; font-size: 12px; }
.STYLE19 {
	color: #344b50;
	font-size: 12px;
}
.STYLE21 {
	font-size: 12px;
	color: #3b6375;
}
.STYLE22 {
	font-size: 12px;
	color: #295568;
}
-->
</style>
<script type="text/javascript">

       function del(){
          if(confirm("您真的确定要删除该记录吗？")){
            return true;
          }
          return false;
       }
   
var  highlightcolor='#d5f4fe';
//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
var  clickcolor='#51b2f6';
function  changeto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
}
}

function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
return
if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
//source.style.backgroundColor=originalcolor
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

function  clickto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=clickcolor;
}
else
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}
</script>


</head>

<body>
  <s:form action="addRssNews" method="post">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="images/tb.gif" width="14" height="30" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1"> <font size="+1">RSS新闻管理系统信息</font></span></td>
              </tr>
            </table></td>

        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce" onmouseover="changeto()"  onmouseout="changeback()">
      <tr>
       
        <td width="5%" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">序号</span></div></td>
        <td width="25%" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">新闻标题</span></div></td>
        <td width="30%" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">URL</span></div></td>
        <td width="20%" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">来源</span></div></td>
        <td width="15%" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">时间</span></div></td>
        <td width="5%" height="30" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">关注度</span></div></td>
        <!--  
        <td width="20%" height="30" bgcolor="d3eaef" class="STYLE6" colspan="2"><div align="center"><span class="STYLE10">操作</span></div></td>
        -->
      </tr>
      <s:iterator value="#request.list" id="rssNews">
       
			 <tr>              
                   <td height="30" bgcolor="#FFFFFF" class="STYLE6"><div align="center"><span class="STYLE19"><s:property value="#rssNews.newsId"/></span></div></td>
                   <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><s:property value="#rssNews.title"/></div></td>                  
                   <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><s:property value="#rssNews.url"/></div></td>
                   <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><s:property value="#rssNews.resource"/></div></td> 
                   <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><s:property value="#rssNews.time"/></div></td>                  
                   <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><s:property value="#rssNews.attention"/></div></td> 
                      <!--                                                                                
                   <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><s:a href="updatePRssNews.action?rssNews.newsId=%{#rssNews.newsId}">编辑</s:a></div></td>
                   <td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><s:a href="deleteRssNews.action?rssNews.newsId=%{#rssNews.newsId}" onclick="return del();">删除</s:a></div></td>                                 
              --> 
              </tr>
              </s:iterator> 
      
    </table></td>
  </tr>
  
</table>
</s:form>
</body>
</html>
