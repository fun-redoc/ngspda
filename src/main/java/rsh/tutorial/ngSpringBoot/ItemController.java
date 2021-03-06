package rsh.tutorial.ngSpringBoot;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemRepository repo;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Item> findItems() {
		return repo.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Item addItem(@RequestBody Item item) {
		item.setId(null);
		return repo.saveAndFlush(item);
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public Item updateItem(@RequestBody Item item, @PathVariable Integer id) {
		item.setId(id);
		return repo.saveAndFlush(item);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void deleteItem(@PathVariable Integer id) {
		repo.delete(id);
	}
}
