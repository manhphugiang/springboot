package ca.sheridancollege.giangma.web.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.giangma.domain.Item;
import ca.sheridancollege.giangma.service.ItemService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/items")
public class RestItemController {
	private ItemService itemService;
	  // Get all items
    @GetMapping
    public List<Item> getAllItems() {
        return itemService.findAll();
    }
    
    
	@GetMapping(value={"/{id}"}, headers = {"Content-type=application/json"})
    public Item getItemById(@PathVariable Long id) {
        Item item = itemService.findById(id);
        return item;
    }

	@PostMapping(value={"","/"}, headers = {"Content-type=application/json"})
    public Item addItem(@RequestBody Item item) {
        item.setId(null); 
        return itemService.save(item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
            itemService.deleteById(id);
    }
}