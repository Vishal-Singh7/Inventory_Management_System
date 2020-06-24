<html>
<head>
<title>IMS - Delete</title>
</head>
<body>
	<jsp:include page="/header" />

	<h2>Are you sure to delete the below Books?</h2>

	<table border="1" width="100%">
		<tr>
			<td>Bcode</td>
			<td>${books.bcode }</td>
		</tr>
		<tr>
			<td>Title</td>
			<td>${books.title }</td>
		</tr>
		<tr>
			<td>Author</td>
			<td>${books.author}</td>
		</tr>	
		
		<tr>
			<td>Publish Date</td>
			<td>${books.publishDate }</td>
		</tr>
	</table>

	<form method="post">
		<input type="hidden" name="bcode" value="${books.bcode }" />
		<button name="confirm" value="false">Cancel Delete</button>
		<button name="confirm" value="true">Confirm Delete</button>
	</form>

	<jsp:include page="/footer" />
</body>
</html>