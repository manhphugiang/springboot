package ca.sheridancollege.giangma.service;

import java.util.List;

import ca.sheridancollege.giangma.domain.Programmer;

public interface ProgrammerService {
	public List<Programmer> findAll();
	public Programmer findById(Long id);
	public Programmer save(Programmer programmer);
}
