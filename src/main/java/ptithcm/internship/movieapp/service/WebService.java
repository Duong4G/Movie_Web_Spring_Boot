package ptithcm.internship.movieapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.internship.movieapp.entrity.Web;
import ptithcm.internship.movieapp.repository.WebRepository;

@Service
public class WebService {
	@Autowired
	private WebRepository webRepository;
	
	public List<Web> findAllWeb(){
		return webRepository.findAll();
	}
	
	public Web findByWid(int wid) {
		return webRepository.findByWid(wid);
	}
	
	public Web findByHasUse() {
		return webRepository.findByHasUse();
	}
	
	public Web save(Web web) {
		return webRepository.save(web);
	}
	
	public void delete(Web web) {
		webRepository.delete(web);
	}
}
