package co.com.camargo.gustavo.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "groceryItem")
public class GroceryItem {
    @Id
    private String id;

    @Field(name = "name")
    private String name;

    @Field(name = "quantity")
    private int quantity;

    @Field(name = "category")
    private String category;
}
