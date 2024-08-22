package co.com.camargo.gustavo.Services;

import co.com.camargo.gustavo.Models.GroceryItem;
import co.com.camargo.gustavo.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public String getAll(){
        List<GroceryItem> groceryItems = itemRepository.findAll();
        return groceryItems.toString();
    }

    public String getById(String id){
        GroceryItem groceryItem = itemRepository.findById(id).get();
        return groceryItem.toString();
    }

    public String insert(GroceryItem groceryItem){
        itemRepository.save(groceryItem);
        return "---ITEM INSERTADO---\n" + groceryItem;
    }

    public String update(GroceryItem groceryItem){
        itemRepository.save(groceryItem);
        return "---ITEM ACTUALIZADO---\n" + groceryItem;
    }

    public String delete(String id) {
        itemRepository.deleteById(id);
        return "---ITEM ELIMINADO---";
    }

    public String updateData(String id, GroceryItem groceryItem) {
        Optional<GroceryItem> existingItem = itemRepository.findById(id);
        if (existingItem.isPresent()) {
            GroceryItem item = existingItem.get();
            if (groceryItem.getName() != null) {
                item.setName(groceryItem.getName());
            }
            if (groceryItem.getQuantity() != 0) {
                item.setQuantity(groceryItem.getQuantity());
            }
            if (groceryItem.getCategory() != null) {
                item.setCategory(groceryItem.getCategory());
            }
            itemRepository.save(item);
            return "---ITEM ACTUALIZADO---\n" + item;
        } else {
            itemRepository.save(groceryItem);
            return "---ITEM INSERTADO---\n" + groceryItem;
        }
    }

    public String optionsUpdate(){
        return "OPTIONS: It insert a new grocery item, if the grocery item doesn't exist, it will create automatically";
    }

}
