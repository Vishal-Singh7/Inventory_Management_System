<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<title>LMS - books</title>
</head>
<body>
	<jsp:include page="/header" />

	<form:form method="POST" modelAttribute="books">

		<div>
			<form:label path="bcode">Book Code</form:label>
			<form:input type="number" path="bcode" />
			<form:errors path="bcode"></form:errors>
		</div>


		<div>
			<form:label path="title">Title</form:label>
			<form:input type="text" path="title" />
			<form:errors path="title"></form:errors>
		</div>

		
		<div>
			<form:label path="author">Author</form:label>
			<form:input type="text" path="author" />
			<form:errors path="author"></form:errors>
		</div>

		<div>
			<form:label path="publishDate">Date Published On</form:label>
			<form:input type="date" path="publishDate" />
			<form:errors path="publishDate"></form:errors>
		</div>

		<div>
			<button>SAVE</button>
		</div>
	</form:form>
	<jsp:include page="/footer" />
</body>
</html>