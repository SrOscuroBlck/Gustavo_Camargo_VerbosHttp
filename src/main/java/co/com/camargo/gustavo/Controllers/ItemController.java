    package co.com.camargo.gustavo.Controllers;

    import co.com.camargo.gustavo.Models.GroceryItem;
    import co.com.camargo.gustavo.Services.ItemService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpHeaders;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.MediaType;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/item")
    public class ItemController {
        @Autowired
        ItemService itemService;

        // 1. metodo de ejemplo para verbo GET
        @GetMapping("/getAll")
        public String getAll(){
            return itemService.getAll();
        }

        // 1.1 metodo de ejemplo para verbo GET con parametro en la URL
        @GetMapping("/getById")
        public String getByIdFromHeader(@RequestHeader("id") String id) {
            return itemService.getById(id);
        }

        // 2. metodo de ejemplo para verbo POST
        @PostMapping("/insert")
        public String insert(@RequestBody GroceryItem groceryItem){
            return itemService.insert(groceryItem);
        }

        // 3. metodo de ejemplo para verbo UPDATE sin procesado de datos, solo actualiza
        @PutMapping("/update")
        public String update(@RequestBody GroceryItem groceryItem){
            return itemService.update(groceryItem);
        }

        // 4. metodo de ejemplo para verbo PATCH con procesado de datos
        @PatchMapping("/updateData")
        public String updateData(@RequestHeader("id") String id, @RequestBody GroceryItem groceryItem) {
            return itemService.updateData(id, groceryItem);
        }

        // 5. metodo de ejemplo para verbo DELETE
        @DeleteMapping("/delete/{id}")
        public String deleteItem(@PathVariable("id") String id) {
            return itemService.delete(id);
        }

        // 6. metodo de ejemplo para verbo HEAD
        @RequestMapping(value = "/getAll", method = RequestMethod.HEAD)
        public ResponseEntity<?> handleHeadRequest() {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity<>(headers, HttpStatus.OK);
        }

    }
