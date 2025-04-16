package ca.sheridancollege.giangma.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ca.sheridancollege.giangma.domain.Shirt;
import ca.sheridancollege.giangma.repository.ShirtRepository;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class ShirtServiceImpl implements ShirtService {
	private ShirtRepository shirtRepo;

	@Override
	public List<Shirt> findAll() {
		return shirtRepo.findAll();
	}

	@Override
	public Shirt findById(Long id) {
		if (shirtRepo.findById(id).isPresent()) {
			return shirtRepo.findById(id).get();
		} else {
			return null;
		}
	}

	@Override
	public Shirt save(Shirt shirt) {
		return shirtRepo.save(shirt);
	}

	@Override
	public Shirt editById(Shirt shirt, Long id) {
	    Shirt existingShirt = shirtRepo.findById(id).orElse(null);
	    if (existingShirt != null) {
	        existingShirt.setName(shirt.getName());
	        existingShirt.setQuantity(shirt.getQuantity());
	        existingShirt.setPrice(shirt.getPrice());
	        existingShirt.setEmployeeName(shirt.getEmployeeName());
	        return shirtRepo.save(existingShirt);
	    }
	    return null;
	}


	@Override
	public void deleteById(Long id) {
		shirtRepo.deleteById(id);
	}

}
