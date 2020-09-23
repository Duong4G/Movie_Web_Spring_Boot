package ptithcm.internship.movieapp.entrity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Web {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int wid;
	private String wname;
	private String wtitle;
	private String wlogoUrl;
	private String wguestAvatartUrl;
	private String wmemberAvatartUrl;
	private String wadminAvatarUrl;
	private int isUse;
	public Web() {
		super();
	}
	
	public Web(String wname, String wtitle, String wlogoUrl, String wguestAvatartUrl, String wmemberAvatartUrl,
			String wadminAvatarUrl, int isUse) {
		super();
		this.wname = wname;
		this.wtitle = wtitle;
		this.wlogoUrl = wlogoUrl;
		this.wguestAvatartUrl = wguestAvatartUrl;
		this.wmemberAvatartUrl = wmemberAvatartUrl;
		this.wadminAvatarUrl = wadminAvatarUrl;
		this.isUse = isUse;
	}

	public Web(int wid, String wname, String wtitle, String wlogoUrl, String wguestAvatartUrl, String wmemberAvatartUrl,
			String wadminAvatarUrl, int isUse) {
		super();
		this.wid = wid;
		this.wname = wname;
		this.wtitle = wtitle;
		this.wlogoUrl = wlogoUrl;
		this.wguestAvatartUrl = wguestAvatartUrl;
		this.wmemberAvatartUrl = wmemberAvatartUrl;
		this.wadminAvatarUrl = wadminAvatarUrl;
		this.isUse = isUse;
	}

	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public String getWtitle() {
		return wtitle;
	}
	public void setWtitle(String wtitle) {
		this.wtitle = wtitle;
	}
	public String getWlogoUrl() {
		return wlogoUrl;
	}
	public void setWlogoUrl(String wlogoUrl) {
		this.wlogoUrl = wlogoUrl;
	}
	public String getWguestAvatartUrl() {
		return wguestAvatartUrl;
	}
	public void setWguestAvatartUrl(String wguestAvatartUrl) {
		this.wguestAvatartUrl = wguestAvatartUrl;
	}
	public String getWmemberAvatartUrl() {
		return wmemberAvatartUrl;
	}
	public void setWmemberAvatartUrl(String wmemberAvatartUrl) {
		this.wmemberAvatartUrl = wmemberAvatartUrl;
	}
	public String getWadminAvatarUrl() {
		return wadminAvatarUrl;
	}
	public void setWadminAvatarUrl(String wadminAvatarUrl) {
		this.wadminAvatarUrl = wadminAvatarUrl;
	}

	public int getIsUse() {
		return isUse;
	}

	public void setIsUse(int isUse) {
		this.isUse = isUse;
	}

	@Override
	public String toString() {
		return "Web [wid=" + wid + ", wname=" + wname + ", wtitle=" + wtitle + ", wlogoUrl=" + wlogoUrl
				+ ", wguestAvatartUrl=" + wguestAvatartUrl + ", wmemberAvatartUrl=" + wmemberAvatartUrl
				+ ", wadminAvatarUrl=" + wadminAvatarUrl + ", isUse=" + isUse + "]";
	}
	
	
}
