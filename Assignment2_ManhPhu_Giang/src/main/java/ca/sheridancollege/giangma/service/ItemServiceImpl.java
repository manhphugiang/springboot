package ca.sheridancollege.giangma.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ca.sheridancollege.giangma.domain.Item;
import ca.sheridancollege.giangma.repositories.ItemRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ItemServiceImpl implements ItemService{
	
	private ItemRepository itemRepo;

	@Override
	public List<Item> findAll() {
		return itemRepo.findAll();
	}

	@Override
	public Item findById(Long id) {
		if (itemRepo.findById(id).isPresent()) {
			return itemRepo.findById(id).get();
		} else {
			return null;
		}
	}

	@Override
	public Item save(Item item) {
		return itemRepo.save(item);
	}

	@Override
	public void deleteById(Long id) {
		itemRepo.deleteById(id);
	}


}
