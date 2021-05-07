package Project.Model.ResponseModel;

import Project.Model.BookEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter @ToString
public class BookList {
    private int code;
    private String message;
    private List<BookEntity> data;

    public BookList(int code, String message, List<BookEntity> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
