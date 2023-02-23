package kodlamaio.Kodlama.io.Devs.business.abstratcs;

import java.util.List;

import kodlamaio.Kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import kodlamaio.Kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import kodlamaio.Kodlama.io.Devs.business.responses.GetAllTechnologyResponses;
import kodlamaio.Kodlama.io.Devs.business.responses.GetTechnologyByIdResponse;

public interface TechnologyService {
	List<GetAllTechnologyResponses> getAll();
	void add(CreateTechnologyRequest createTechnologyRequest) throws Exception;
	void update(UpdateTechnologyRequest updateTechnologyRequest);
	void delete(int id);
	GetTechnologyByIdResponse getById(int id);
}
