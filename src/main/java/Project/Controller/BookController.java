package Project.Controller;

import Project.Model.ResponseModel.BookList;
import Project.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;


@RestController
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping(value = "/{bookCategory}")
    public BookList getBookListAndSort(@PathVariable(value = "bookCategory") int bookCategory,
                                       @RequestParam(name = "order", defaultValue = "ASC") String order) throws SQLException {
        return bookService.getBookListByCategory(bookCategory, order);
    }

}
