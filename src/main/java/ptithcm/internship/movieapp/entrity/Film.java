package ptithcm.internship.movieapp.entrity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fid;
	private String fname;
	private int fepisodecount;
	private int fyear;
	private int fstatus;
	private int frequest;
	private String introduction;
	private String length;
	private String fimageurl;
	private String fbanner;
	private String requestEmail;
	private String acceptAccount;
	private String requestType;
	private int fdeploy;
	private int fview;
	private double fevaluatecount;
	private double fevaluatepoint;
	@ManyToMany
	@JoinTable(name = "category_film", joinColumns = @JoinColumn(name = "film_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> belongedCategories = new HashSet<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id")
	private Country country;

	public Film() {
		super();
	}
	
	public Film(String fname, int fepisodecount, int fyear, int fstatus, int frequest, String introduction,
			String length, String fimageurl, String fbanner, String requestEmail, String acceptAccount,
			String requestType, int fdeploy, int fview, double fevaluatecount, double fevaluatepoint,
			Set<Category> belongedCategories, Country country) {
		super();
		this.fname = fname;
		this.fepisodecount = fepisodecount;
		this.fyear = fyear;
		this.fstatus = fstatus;
		this.frequest = frequest;
		this.introduction = introduction;
		this.length = length;
		this.fimageurl = fimageurl;
		this.fbanner = fbanner;
		this.requestEmail = requestEmail;
		this.acceptAccount = acceptAccount;
		this.requestType = requestType;
		this.fdeploy = fdeploy;
		this.fview = fview;
		this.fevaluatecount = fevaluatecount;
		this.fevaluatepoint = fevaluatepoint;
		this.belongedCategories = belongedCategories;
		this.country = country;
	}

	public Film(int fid, String fname, int fepisodecount, int fyear, int fstatus, int frequest, String introduction,
			String length, String fimageurl, String fbanner, String requestEmail, String acceptAccount,
			String requestType, int fdeploy, int fview, double fevaluatecount, double fevaluatepoint,
			Set<Category> belongedCategories, Country country) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.fepisodecount = fepisodecount;
		this.fyear = fyear;
		this.fstatus = fstatus;
		this.frequest = frequest;
		this.introduction = introduction;
		this.length = length;
		this.fimageurl = fimageurl;
		this.fbanner = fbanner;
		this.requestEmail = requestEmail;
		this.acceptAccount = acceptAccount;
		this.requestType = requestType;
		this.fdeploy = fdeploy;
		this.fview = fview;
		this.fevaluatecount = fevaluatecount;
		this.fevaluatepoint = fevaluatepoint;
		this.belongedCategories = belongedCategories;
		this.country = country;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public int getFepisodecount() {
		return fepisodecount;
	}

	public void setFepisodecount(int fepisodecount) {
		this.fepisodecount = fepisodecount;
	}

	public int getFyear() {
		return fyear;
	}

	public void setFyear(int fyear) {
		this.fyear = fyear;
	}

	public int getFstatus() {
		return fstatus;
	}

	public void setFstatus(int fstatus) {
		this.fstatus = fstatus;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getFimageurl() {
		return fimageurl;
	}

	public void setFimageurl(String fimageurl) {
		this.fimageurl = fimageurl;
	}

	public String getFbanner() {
		return fbanner;
	}

	public void setFbanner(String fbanner) {
		this.fbanner = fbanner;
	}

	public int getFdeploy() {
		return fdeploy;
	}

	public void setFdeploy(int fdeploy) {
		this.fdeploy = fdeploy;
	}

	public int getFview() {
		return fview;
	}

	public void setFview(int fview) {
		this.fview = fview;
	}

	public double getFevaluatecount() {
		return fevaluatecount;
	}

	public void setFevaluatecount(double fevaluatecount) {
		this.fevaluatecount = fevaluatecount;
	}

	public double getFevaluatepoint() {
		return fevaluatepoint;
	}

	public void setFevaluatepoint(double fevaluatepoint) {
		this.fevaluatepoint = fevaluatepoint;
	}

	public Set<Category> getBelongedCategories() {
		return belongedCategories;
	}

	public void setBelongedCategories(Set<Category> belongedCategories) {
		this.belongedCategories = belongedCategories;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getRequestEmail() {
		return requestEmail;
	}

	public void setRequestEmail(String requestEmail) {
		this.requestEmail = requestEmail;
	}

	public String getAcceptAccount() {
		return acceptAccount;
	}

	public void setAcceptAccount(String acceptAccount) {
		this.acceptAccount = acceptAccount;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	
	public int getFrequest() {
		return frequest;
	}

	public void setFrequest(int frequest) {
		this.frequest = frequest;
	}

	@Override
	public String toString() {
		return "Film [fid=" + fid + ", fname=" + fname + ", fepisodecount=" + fepisodecount + ", fyear=" + fyear
				+ ", fstatus=" + fstatus + ", frequest=" + frequest + ", introduction=" + introduction + ", length="
				+ length + ", fimageurl=" + fimageurl + ", fbanner=" + fbanner + ", requestEmail=" + requestEmail
				+ ", acceptAccount=" + acceptAccount + ", requestType=" + requestType + ", fdeploy=" + fdeploy
				+ ", fview=" + fview + ", fevaluatecount=" + fevaluatecount + ", fevaluatepoint=" + fevaluatepoint
				+ ", belongedCategories=" + belongedCategories + ", country=" + country + "]";
	}
	
}
