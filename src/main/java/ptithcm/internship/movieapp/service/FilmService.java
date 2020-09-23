package ptithcm.internship.movieapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.internship.movieapp.entrity.Film;
import ptithcm.internship.movieapp.repository.FilmRepository;

@Service
public class FilmService {
	@Autowired
	FilmRepository filmRepository;
	
	public List<Film> findAllFilm(){
		return filmRepository.findAllFilm();
	}
	
	public List<Film> findAll(){
		return filmRepository.findAll();
	}
	
	public Film findFilmById(int id) {
		return filmRepository.getFilmById(id);
	}
	
	public List<Film> findFilmsByCid(String cid){
		return filmRepository.findFilmsByCategoryId(cid);
	}
	
	public List<Film> findFilmsByCoid(String coid){
		return filmRepository.findFilmsByCountryId(coid);
	}
	
	public List<Film> findFilmsByYear(int fyear){
		return filmRepository.findFilmsByYear(fyear);
	}
	
	public List<Film> findFilmsByFstatusAndDeploy(int fstatus){
		return filmRepository.findFilmsByFstatusAndDeploy(fstatus);
	}
	
	public List<Film> findFilmsByCidAndYear(String cid, int fyear){
		return filmRepository.findFilmsByCategoryIdAndYear(cid, fyear);
	}
	
	public List<Film> findHotFilmsByView(){
		return filmRepository.findHotFilmsByView();
	}
	
	public List<Film> findFilmsByTextSearch(String textSearch){
		return filmRepository.findFilmsByTextSearch(textSearch);
	}
	
	public List<Film> findHotFilmsByViewAndHasBanner(String url){
		return filmRepository.findHotFilmsByViewAndHasBanner(url);
	}
	
	public List<Film> findHotFilmsByCategoryId(String cid, String url){
		return filmRepository.findHotFilmsByCategoryId(cid, url);
	}
	
	public Film save(Film film) {
		return filmRepository.save(film);
	}
	
	public List<Film> findFilmsNoDeployOrHasRequest(){
		return filmRepository.findFilmsNoDeployOrHasRequest();
	}
	
	public void delete(Film film) {
		filmRepository.delete(film);
	}
	
}
