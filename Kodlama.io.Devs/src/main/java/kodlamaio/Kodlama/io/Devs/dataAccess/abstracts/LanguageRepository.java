package kodlamaio.Kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Kodlama.io.Devs.entities.concretes.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
	
}
