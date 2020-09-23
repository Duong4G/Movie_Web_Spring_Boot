package ptithcm.internship.movieapp.entrity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FilmDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fdid;
	private int episode;
	private String furl;
	private String acceptAccount;
	private String requestEmail;
	private int fddeploy;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "film_id")
	private Film film;
	public FilmDetail() {
		super();
	}
	
	public FilmDetail(int episode, String furl, String requestEmail, int fddeploy, Film film) {
		super();
		this.episode = episode;
		this.furl = furl;
		this.requestEmail = requestEmail;
		this.fddeploy = fddeploy;
		this.film = film;
	}

	public FilmDetail(int episode, String furl, String acceptAccount, String requestEmail, int fddeploy, Film film) {
		super();
		this.episode = episode;
		this.furl = furl;
		this.acceptAccount = acceptAccount;
		this.requestEmail = requestEmail;
		this.fddeploy = fddeploy;
		this.film = film;
	}

	public FilmDetail(int fdid, int episode, String furl, String acceptAccount, String requestEmail, int fddeploy,
			Film film) {
		super();
		this.fdid = fdid;
		this.episode = episode;
		this.furl = furl;
		this.acceptAccount = acceptAccount;
		this.requestEmail = requestEmail;
		this.fddeploy = fddeploy;
		this.film = film;
	}

	public int getFdid() {
		return fdid;
	}
	public void setFdid(int fdid) {
		this.fdid = fdid;
	}
	public int getEpisode() {
		return episode;
	}
	public void setEpisode(int episode) {
		this.episode = episode;
	}
	public String getFurl() {
		return furl;
	}
	public void setFurl(String furl) {
		this.furl = furl;
	}
	public int getFddeploy() {
		return fddeploy;
	}
	public void setFddeploy(int fddeploy) {
		this.fddeploy = fddeploy;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}

	public String getAcceptAccount() {
		return acceptAccount;
	}

	public void setAcceptAccount(String acceptAccount) {
		this.acceptAccount = acceptAccount;
	}

	public String getRequestEmail() {
		return requestEmail;
	}

	public void setRequestEmail(String requestEmail) {
		this.requestEmail = requestEmail;
	}

	@Override
	public String toString() {
		return "FilmDetail [fdid=" + fdid + ", episode=" + episode + ", furl=" + furl + ", acceptAccount="
				+ acceptAccount + ", requestEmail=" + requestEmail + ", fddeploy=" + fddeploy + ", film=" + film + "]";
	}

}
