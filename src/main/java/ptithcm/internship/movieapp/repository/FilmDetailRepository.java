package ptithcm.internship.movieapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ptithcm.internship.movieapp.entrity.FilmDetail;

@Repository
public interface FilmDetailRepository extends JpaRepository<FilmDetail, Integer>{
	@Query("SELECT fd FROM FilmDetail fd WHERE fd.film.fid = ?1")
	List<FilmDetail> findAllByFid(int fdid);
	
	@Query("SELECT fd FROM FilmDetail fd WHERE fd.film.fid = ?1 AND fd.fddeploy = 1")
	List<FilmDetail> findAllByFidDeploy(int fid);
	
	@Query("SELECT fd FROM FilmDetail fd WHERE fd.film.fid = ?1 AND fd.fddeploy = 0")
	List<FilmDetail> findAllByFidNoDeploy(int fid);
	
	@Query("SELECT fd FROM FilmDetail fd WHERE fd.fdid = ?1")
	FilmDetail findByFdid(int fdid);
	
	@Query("SELECT fd FROM FilmDetail fd WHERE fd.film.fid = ?1 AND fd.episode = ?2")
	FilmDetail findByFidAndEpisode(int fid, int episode);
	
	@Query("SELECT fd FROM FilmDetail fd WHERE fd.film.fid = ?1 AND fd.episode = ?2")
	List<FilmDetail> findAllByFidSearchCondition(int fid, int searchCondition);
}
