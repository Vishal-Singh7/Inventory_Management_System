<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<html>
<head>
<title>LMS - Home</title>
</head>
<body>
	<jsp:include page="/header" />

	<div>
		<h3>Filter</h3>
		<form action="findByTitle">
			<label>Title: <input type="text" name="title" required /></label>
			<button>Search By Title</button>
		</form>

		<form action="findByPublishDate">
			<label>Publish Date: <input type="date" name="publishDate"
				required /></label>
			<button>Search By Publish Date</button>
		</form>

	</div>

	<c:choose>
		<c:when test="${books ne null and books.size()>0 }">
			<table border="1" width="100%">
				<tr>
					<th>Bcode</th>
					<th>Title</th>
					<th>Author</th>
					<th>Date Of Publish</th>
					<th>Actions</th>
				</tr>
				<c:forEach items="${books }" var="books">
					<tr>
						<td>${books.bcode }</td>
						<td>${books.title }</td>
						<td>${books.author }</td>
						<td>${books.publishDate }</td>
						<td><a href="editBook?bcode=${books.bcode }">EDIT</a> <span>
								| </span> <a href="deleteBook?bcode=${books.bcode }">DELETE</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<p>
				<strong>No Books In The Library!</strong>
		</c:otherwise>
	</c:choose>

	<jsp:include page="/footer" />
</body>
</html>