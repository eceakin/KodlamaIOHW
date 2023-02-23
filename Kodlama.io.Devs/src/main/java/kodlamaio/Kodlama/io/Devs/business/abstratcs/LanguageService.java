package kodlamaio.Kodlama.io.Devs.business.abstratcs;

import java.util.List;

import kodlamaio.Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlamaio.Kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import kodlamaio.Kodlama.io.Devs.business.responses.GetAllLanguageResponses;
import kodlamaio.Kodlama.io.Devs.business.responses.GetLanguageByIdResponse;



public interface LanguageService {
	List<GetAllLanguageResponses> getAll();
	void add(CreateLanguageRequest createLanguageRequest) throws Exception;
	void delete(int id);
	void update(UpdateLanguageRequest updateLanguageRequest);
	GetLanguageByIdResponse getById(int id);
	/*
	 * void add(Language language) throws Exception; 
	 * 
	 * void delete(int id); void
	 * update(Language language);
	 */
}
