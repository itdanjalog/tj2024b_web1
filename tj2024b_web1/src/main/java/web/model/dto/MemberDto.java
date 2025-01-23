package web.model.dto;

public class MemberDto {
	
	private int mno;
	private String mid	;
	private String mpwd	;
	private String mimg	;
	private String memail;
	private String mdate;
	
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}


	public MemberDto(int mno, String mid, String mpwd, String mimg, String memail, String mdate) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpwd = mpwd;
		this.mimg = mimg;
		this.memail = memail;
		this.mdate = mdate;
	}

	

	public String getMdate() {
		return mdate;
	}


	public void setMdate(String mdate) {
		this.mdate = mdate;
	}


	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpwd() {
		return mpwd;
	}

	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}

	public String getMimg() {
		return mimg;
	}

	public void setMimg(String mimg) {
		this.mimg = mimg;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	@Override
	public String toString() {
		return "MemberDto [mno=" + mno + ", mid=" + mid + ", mpwd=" + mpwd + ", mimg=" + mimg + ", memail=" + memail
				+ "]";
	}
	
}
