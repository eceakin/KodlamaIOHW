package kodlamaio.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import kodlamaio.Kodlama.io.Devs.business.abstratcs.LanguageService;
import kodlamaio.Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlamaio.Kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import kodlamaio.Kodlama.io.Devs.business.responses.GetAllLanguageResponses;
import kodlamaio.Kodlama.io.Devs.business.responses.GetLanguageByIdResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	private LanguageService languageService;


	@GetMapping()
	public List<GetAllLanguageResponses> getAll() {
		return languageService.getAll();
	}
	
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody CreateLanguageRequest createLanguageRequest) throws Exception {
		this.languageService.add(createLanguageRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.languageService.delete(id);
	}
	
	@PutMapping
	public void update(@RequestBody UpdateLanguageRequest updateLanguageRequest) {
		this.languageService.update(updateLanguageRequest);
	}
	
	@GetMapping("/{id}")
	public GetLanguageByIdResponse getById(@PathVariable int id) {
		return languageService.getById(id);
	}
	
	/*
	 * @PostMapping("/add") public void add(Language language) throws Exception {
	 * languageService.add(language); }
	 * 
	 * @DeleteMapping("/delete") public void delete(int id){
	 * languageService.delete(id); }
	 * 
	 * @PutMapping("/update") public void update(Language language){
	 * languageService.update(language); }
	 */

}
