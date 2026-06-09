<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Flexbox & Grid Masterclass</title>
    <link rel="stylesheet" href="../css/style.css">
</head>

<body>

    <div class="dashboard-grid">

        <header class="header">
            <h2>My Application Dashboard</h2>
        </header>

        <aside class="sidebar">
            <ul>
                <li><a href="#">Dashboard</a></li>
                <li><a href="#">All Books</a></li>
                <li><a href="#">Logout</a></li>
            </ul>
        </aside>

        <main class="main">

            <div class="search-section">
                <h3>Search Photos</h3>
                <form class="search-form-flex" onsubmit="event.preventDefault();">
                    <input type="text" class="search-input" placeholder="Search for nature, cars, cities...">
                    <button type="submit" class="search-button">Search</button>
                </form>
            </div>

            <div class="book-section">
                <h3>Recent Uploads</h3>
                <%@ page contentType="text/html;charset=UTF-8" %>
                <%@ taglib prefix="c" uri="jakarta.tags.core" %>

                <table border="1">
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Price</th>
                        <th>Genre</th>
                    </tr>

                    <c:forEach var="b" items="${books}">
                        <tr>
                            <td>${b.bookId}</td>
                            <td>${b.title}</td>
                            <td>${b.author}</td>
                            <td>${b.price}</td>
                            <td>${b.genre}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

        </main>

        <footer class="footer">
            <p>&copy; 2026 Your Company Name. All rights reserved.</p>
        </footer>

    </div>

</body>

</html>