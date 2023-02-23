package kodlamaio.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.Kodlama.io.Devs.business.abstratcs.TechnologyService;
import kodlamaio.Kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import kodlamaio.Kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import kodlamaio.Kodlama.io.Devs.business.responses.GetAllTechnologyResponses;
import kodlamaio.Kodlama.io.Devs.business.responses.GetTechnologyByIdResponse;
import kodlamaio.Kodlama.io.Devs.core.utilities.mappers.ModelMapperService;
import kodlamaio.Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import kodlamaio.Kodlama.io.Devs.entities.concretes.Technology;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TechnologyManager implements TechnologyService {

	List<Technology> technologies;
	private TechnologyRepository technologyRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllTechnologyResponses> getAll() {
		List<Technology> technologies = technologyRepository.findAll();

		List<GetAllTechnologyResponses> technologiesResponse = technologies.stream().map(
				technology -> this.modelMapperService.forResponse().map(technology, GetAllTechnologyResponses.class))
				.toList();
		return technologiesResponse;

	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {
		Technology technology = this.modelMapperService.forRequest().map(createTechnologyRequest, Technology.class);
		this.technologyRepository.save(technology);

	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest) {
		Technology technology = this.modelMapperService.forRequest().map(updateTechnologyRequest, Technology.class);

		this.technologyRepository.save(technology);
	}

	@Override
	public void delete(int id) {
		this.technologyRepository.deleteById(id);

	}

	@Override
	public GetTechnologyByIdResponse getById(int id) {
		Technology technology = this.technologyRepository.findById(id).orElseThrow();
		GetTechnologyByIdResponse response = this.modelMapperService.forResponse().map(technology,
				GetTechnologyByIdResponse.class);
		return response;
	}

}
