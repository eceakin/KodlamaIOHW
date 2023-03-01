package kodlamaio.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlamaio.Kodlama.io.Devs.business.abstratcs.TechnologyService;
import kodlamaio.Kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import kodlamaio.Kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import kodlamaio.Kodlama.io.Devs.business.responses.GetAllTechnologyResponses;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {
	private TechnologyService technologyService;


	@GetMapping()
	public List<GetAllTechnologyResponses> getAll() {
		return technologyService.getAll();
	}

	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateTechnologyRequest createTechnologyRequest) throws Exception {
		this.technologyService.add(createTechnologyRequest);
	}

	@PutMapping()
	public void update(@RequestBody UpdateTechnologyRequest updateTechnologyRequest) {
		this.technologyService.update(updateTechnologyRequest);
	}
		
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.technologyService.delete(id);
	}
	
	@GetMapping("/{id}")
	public void GetTechnologyByIdResponse(@PathVariable int id) {
		this.technologyService.getById(id);
	}
}
