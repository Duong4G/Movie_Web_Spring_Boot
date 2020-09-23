package ptithcm.internship.movieapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.internship.movieapp.entrity.Country;
import ptithcm.internship.movieapp.repository.CountryRepository;

@Service
public class CountryService {
	@Autowired
	private CountryRepository countryRepository;
	
	public List<Country> findAllCountry(){
		return countryRepository.findAll();
	}
	
	public Country findById(String id) {
		return countryRepository.findCountryById(id);
	}
	
	public Country save(Country country) {
		return countryRepository.save(country);
	}
	
	public void delete(Country country) {
		countryRepository.delete(country);
	}
}
