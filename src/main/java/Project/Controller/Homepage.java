package Project.Controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value = "/homepage")
public class Homepage {
    @GetMapping(value = "/book/{bookCategory}")
    public String getBookListAndSort(@PathVariable (value = "bookCategory") int bookCategory
                                       /*(@RequestParam (name = "orderBy") String orderBy*/) throws SQLException {
        int bookListId = 0;
        String message;
        List<Book> result = null;
        if (CheckingData.checkId(bookCategory)){
            result = DatabaseWorking.getBookListByCategoryId(bookCategory);
            bookListId += 1;
            message = " Getting books by Category: " ;

        }else{
            message = "Invalid Category";
            System.out.println(message);

        }
        BookList newBooklist = new BookList(bookListId, message, result);

        return  newBooklist.toString();
    }
}

@Getter @Setter @ToString
class BookList{
    private int code;
    private String message;
    private List<Book> data;

    public BookList(int code, String message, List data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}

@Getter @Setter
class Book{
    private String name;
    private String category;
    private String type;


    public Book(String name, String category, String type) {
        this.name = name;
        this.category = category;
        this.type = type;
    }
}
