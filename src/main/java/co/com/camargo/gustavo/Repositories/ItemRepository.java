package co.com.camargo.gustavo.Repositories;

import co.com.camargo.gustavo.Models.GroceryItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends MongoRepository<GroceryItem, String> {
}
