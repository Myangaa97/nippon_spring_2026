import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Book;
import model.Novel;
import model.TextBook;

@WebServlet("/books")
public class BookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        List<Book> books = new ArrayList<>();

        books.add(new Novel(1, "Harry Potter", "Rowling", 20, "Fantasy"));
        books.add(new Novel(2, "Sherlock Holmes", "Conan Doyle", 18, "Mystery"));

        request.setAttribute("books", books);

        request.getRequestDispatcher("/admin/dashboard.jsp")
               .forward(request, response);
    }
}