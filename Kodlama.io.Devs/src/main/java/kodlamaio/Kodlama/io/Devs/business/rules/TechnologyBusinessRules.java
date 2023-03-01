package kodlamaio.Kodlama.io.Devs.business.rules;

import org.springframework.stereotype.Service;

import kodlamaio.Kodlama.io.Devs.core.utilities.exceptions.BusinessException;
import kodlamaio.Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TechnologyBusinessRules {
	private TechnologyRepository technologyRepository;
	
	public void checkIfLanguageNameExists(String name) {
		if (this.technologyRepository.existsByName(name)) {
			throw new BusinessException("Technology already exists");
		}
	}


}
