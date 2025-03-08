<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>List Todos Page</title>
	</head>
	<body>
	Welcome ${name} to Todos page using JSP!
	<br>
	Your todos are :
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>User Name</th>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is Done?</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.id}</td>
					<td>${todo.username}</td>
					<td>${todo.description}</td>
					<td>${todo.targetDate}</td>
					<td>${todo.done}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</body>
</html>