package Project.Services;

import Project.Config.DatabaseTask;
import Project.Model.BookEntity;
import Project.Model.ResponseModel.BookList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.List;

@Service
public class BookService {

    @Autowired
    DatabaseTask databaseTask;

    public BookList getBookListByCategory(int categoryId, String order) throws SQLException {
        int bookListId = 0;
        String message = "Get books success!";
        List<BookEntity> result = null;
        BookList newBooklist;
        if (databaseTask.checkIdExist(categoryId)){
                result = databaseTask.getBookListByCategoryId(categoryId, order);
                bookListId += 1;
                message = " Getting books by Category: " + databaseTask.getCategoryName(categoryId) ;

        }else{
                message = "Invalid Category";
                System.out.println(message);

        }

        newBooklist = new BookList(bookListId, message, result);
        return newBooklist;
    }

}
