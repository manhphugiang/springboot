package ca.sheridancollege.giangma.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ca.sheridancollege.giangma.domain.Programmer;
import ca.sheridancollege.giangma.repository.ProgrammerRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProgrammerServiceImpl implements ProgrammerService {
	private ProgrammerRepository progRepo;

	@Override
	public List<Programmer> findAll() {
		return progRepo.findAll();
	}

	@Override
	public Programmer findById(Long id) {
		if (progRepo.findById(id).isPresent()) {
			return progRepo.findById(id).get();
		} else {
			return null;
		}
	}

	@Override
	public Programmer save(Programmer progammer) {
		return progRepo.save(progammer);
	}
	
}
