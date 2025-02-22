package ptithcm.internship.movieapp.entrity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Country {
	@Id
	private String coid;
	private String coname;
	@OneToMany(mappedBy = "country")
	private List<Film> films;
	public Country(String coid, String coname, List<Film> films) {
		super();
		this.coid = coid;
		this.coname = coname;
		this.films = films;
	}
	public Country(String coname, List<Film> films) {
		super();
		this.coname = coname;
		this.films = films;
	}
	public Country() {
		super();
	}
	public String getCoid() {
		return coid;
	}
	public void setCoid(String coid) {
		this.coid = coid;
	}
	public String getConame() {
		return coname;
	}
	public void setConame(String coname) {
		this.coname = coname;
	}
	public List<Film> getFilms() {
		return films;
	}
	public void setFilms(List<Film> films) {
		this.films = films;
	}
	@Override
	public String toString() {
		return "Country [coid=" + coid + ", coname=" + coname + "]";
	}
	
	
}
