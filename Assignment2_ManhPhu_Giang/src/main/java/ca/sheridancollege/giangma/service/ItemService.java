package ca.sheridancollege.giangma.service;

import java.util.List;

import ca.sheridancollege.giangma.domain.Item;

public interface ItemService {

	public List<Item> findAll();
	public Item findById(Long id);
	public Item save(Item item);
	public void deleteById(Long id);
}
