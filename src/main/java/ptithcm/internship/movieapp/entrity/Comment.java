package ptithcm.internship.movieapp.entrity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cmid;
	private String uname;
	private String content;
	@Temporal(TemporalType.TIMESTAMP)
	private Date ctime;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "film_id")
	private Film film;
	public Comment() {
		super();
	}
	public Comment(int cmid, String uname, String content, Film film) {
		super();
		this.cmid = cmid;
		this.uname = uname;
		this.content = content;
		this.film = film;
	}
	public Comment(String uname, String content, Film film) {
		super();
		this.uname = uname;
		this.content = content;
		this.film = film;
	}
	
	public Comment(String uname, String content, Date ctime, Film film) {
		super();
		this.uname = uname;
		this.content = content;
		this.ctime = ctime;
		this.film = film;
	}
	public int getCmid() {
		return cmid;
	}
	public void setCmid(int cmid) {
		this.cmid = cmid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	
	
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	@Override
	public String toString() {
		return "Comment [cmid=" + cmid + ", uname=" + uname + ", content=" + content + ", ctime=" + ctime + ", film="
				+ film + "]";
	}
	
	
}
