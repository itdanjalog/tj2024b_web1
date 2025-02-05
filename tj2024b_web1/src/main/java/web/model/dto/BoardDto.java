package web.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class BoardDto {
	private int bno;		// 회원번호
	private String btitle;		// 아이디 
	private String bcontent;	// 비밀번호
	private String bdate;	// 이름
	private int bview;	// 연락처 
	private int mno;	// 가입일 
	private	int cno;	// 프로필
	private String mid;	// DB member 테이블에는 존재하지 않지만. 자바 내부적으로 사용할 예정 
	private String cname;

}
