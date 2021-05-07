package Project.Model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookEntity {
    private String name;
    private String category;
    private String type;


    public BookEntity(String name, String category, String type) {
        this.name = name;
        this.category = category;
        this.type = type;
    }
}
