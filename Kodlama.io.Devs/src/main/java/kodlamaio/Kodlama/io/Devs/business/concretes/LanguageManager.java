package kodlamaio.Kodlama.io.Devs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlamaio.Kodlama.io.Devs.business.abstratcs.LanguageService;
import kodlamaio.Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlamaio.Kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import kodlamaio.Kodlama.io.Devs.business.responses.GetAllLanguageResponses;
import kodlamaio.Kodlama.io.Devs.business.responses.GetLanguageByIdResponse;
import kodlamaio.Kodlama.io.Devs.core.utilities.mappers.ModelMapperService;
import kodlamaio.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlamaio.Kodlama.io.Devs.entities.concretes.Language;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LanguageManager implements LanguageService {

	private LanguageRepository languageRepository;
	List<Language> languages;
	private ModelMapperService modelMapperService;



	@Override
	public List<GetAllLanguageResponses> getAll() {

		List<Language> languages = languageRepository.findAll();
		
		List<GetAllLanguageResponses> brandsResponse = languages.stream()
				.map(language->this.modelMapperService.forResponse()
						.map( language, GetAllLanguageResponses.class)).collect(Collectors.toList());

		return brandsResponse;
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) throws Exception {
		Language language = this.modelMapperService.forRequest()
				.map(createLanguageRequest,Language.class);
		this.languageRepository.save(language);
		

	}

	@Override
	public void delete(int id) {
		this.languageRepository.deleteById(id);
		
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) {
		Language language = this.modelMapperService.forRequest()
				.map(updateLanguageRequest,Language.class);
		this.languageRepository.save(language);
		
	}



	@Override
	public GetLanguageByIdResponse getById(int id) {
		Language language=  this.languageRepository.findById(id).orElseThrow();
		GetLanguageByIdResponse response = this.modelMapperService.forResponse().map(language, GetLanguageByIdResponse.class);
		return response;
	}

	

	

}

/*
 * @Override public void add(Language language) throws Exception { if
 * (language.getName().isEmpty()) { throw new Exception("İsim boş olamaz!"); }
 * for (Language lang1 : languages) { if (lang1.getName()==language.getName()) {
 * throw new Exception("İsimler tekrar edemez!"); } }
 * 
 * 
 * languageRepository.add(language); }
 * 
 * 
 * @Override public void delete(i nt id) { languageRepository.delete(id);
 * 
 * }
 * 
 * 
 * @Override public void update(Language language) { for (Language lang2 :
 * languages) { if (lang2.getId()==language.getId()) {
 * lang2.setName(language.getName()); } } }
 */


/*
 * Language language = new Language();
 * language.setName(createLanguageRequest.getName());
 * 
 * if (createLanguageRequest.getName().isEmpty()) { throw new
 * Exception("İsim boş olamaz!"); }
 * 
 * for (Language lang1 : languages) { if (lang1.getName() ==
 * createLanguageRequest.getName()) {
 * 
 * throw new Exception("İsimler tekrar edemez!"); } }
 */
