<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>write</title>
</head>
<body>
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="write" method="post">
		<tr>
			<td>업무키</td>
			    <td><input type="text" name="img_key"></td>
			<td>고객번호</td>
			    <td><input type="text" name="cust_no"></td>
			<td>고객이름</td>
			    <td><input type="text" name="cust_nm"></td>
			<td>문서코드</td>
			    <td><input type="text" name="doc_cd"></td>
			<td>담당자</td>
			    <td><input type="text" name="enr_user_id"></td>
			<td>담당업무코드</td>
			    <td><input type="text" name="enr_org_cd"></td>
			
		</tr>
		
		<tr>
			<td colspan="5"><input type="submit" value="신규 등록"> &nbsp;&nbsp; 
			<a href="list">목록으로</td>
		</tr>
		</form>
		</table>
</body>
</html>