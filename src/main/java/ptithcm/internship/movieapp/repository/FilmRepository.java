package ptithcm.internship.movieapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ptithcm.internship.movieapp.entrity.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer>{
	@Query("SELECT film FROM Film film WHERE film.fid = ?1")
	Film getFilmById(int fid);
	
	@Query("SELECT film FROM Film film INNER JOIN film.belongedCategories belongedCategories WHERE belongedCategories.cid = ?1")
	List<Film> findFilmsByCategoryId(String cid);
	
	@Query("SELECT film FROM Film film INNER JOIN film.belongedCategories belongedCategories WHERE belongedCategories.cid = ?1 AND film.fyear = ?2")
	List<Film> findFilmsByCategoryIdAndYear(String cid, int fyear);
	
	@Query("SELECT film FROM Film film WHERE film.fyear = ?1")
	List<Film> findFilmsByYear(int year);
	
	@Query("SELECT film FROM Film film WHERE film.fdeploy = 1 ORDER BY film.fview DESC")
	List<Film> findHotFilmsByView();
	
	@Query("SELECT film FROM Film film WHERE film.fbanner <> ?1 ORDER BY film.fview DESC")
	List<Film> findHotFilmsByViewAndHasBanner(String url);
	
	@Query("SELECT film FROM Film film INNER JOIN film.belongedCategories belongedCategories WHERE belongedCategories.cid = ?1 AND film.fbanner <> ?2 AND film.fdeploy = 1 ORDER BY film.fview DESC")
	List<Film> findHotFilmsByCategoryId(String cid, String url);
	
	@Query("SELECT film FROM Film film WHERE film.country.coid = ?1")
	List<Film> findFilmsByCountryId(String coid);
	
	@Query("SELECT film FROM Film film WHERE film.fdeploy = 1")
	List<Film> findAllFilm();
	
	@Query("SELECT film FROM Film film WHERE film.fdeploy = 0 OR film.frequest = 1")
	List<Film> findFilmsNoDeployOrHasRequest();
	
	@Query("SELECT film FROM Film film WHERE film.fdeploy = 0 AND film.fstatus = ?1")
	List<Film> findFilmsByFstatusAndDeploy(int fstatus);
	
	@Query("SELECT film FROM Film film WHERE film.fname LIKE %?1%")
	List<Film> findFilmsByTextSearch(String textSearch);
}
