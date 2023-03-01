package kodlamaio.Kodlama.io.Devs.business.rules;

import org.springframework.stereotype.Service;

import kodlamaio.Kodlama.io.Devs.core.utilities.exceptions.BusinessException;
import kodlamaio.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LanguageBusinessRules {
	private LanguageRepository languageRepository;
	
	
	public void checkIfLanguageNameExists(String name) {
		if (this.languageRepository.existsByName(name)) {
			throw new BusinessException("Language already exists");
		}
	}

}
//jpa keywords
//Language find