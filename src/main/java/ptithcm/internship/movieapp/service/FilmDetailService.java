package ptithcm.internship.movieapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.internship.movieapp.entrity.FilmDetail;
import ptithcm.internship.movieapp.repository.FilmDetailRepository;

@Service
public class FilmDetailService {
	@Autowired
	private FilmDetailRepository filmDetailRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FilmDetailService.class);
	
	public FilmDetail save(FilmDetail filmDetail) {
		return filmDetailRepository.save(filmDetail);
	}
	
	public void delete(FilmDetail filmDetail) {
		filmDetailRepository.delete(filmDetail);
	}
	
	public List<FilmDetail> findAll(){
		return filmDetailRepository.findAll();
	}
	
	public List<FilmDetail> findAllByFid(int fid) {
		return filmDetailRepository.findAllByFid(fid);
	}
	
	public List<FilmDetail> findAllByFidSearchCondition(int fid, int searchCondition) {
		return filmDetailRepository.findAllByFidSearchCondition(fid, searchCondition);
	}
	
	public List<FilmDetail> findAllByFidDeploy(int fid) {
		return filmDetailRepository.findAllByFidDeploy(fid);
	}
	
	public List<FilmDetail> findAllByFidNoDeploy(int fid){
		return filmDetailRepository.findAllByFidNoDeploy(fid);
	}
	
	public FilmDetail findByFdid(int fdid) {
		return filmDetailRepository.findByFdid(fdid);
	}
	
	public FilmDetail findByFidAndEpisode(int fid, int episode) {
		LOGGER.info("findByFidAndEpisode: " + "fid=" + fid + " episode=" + episode);
		
		return filmDetailRepository.findByFidAndEpisode(fid, episode);
	}
}
