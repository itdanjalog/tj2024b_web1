package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString	
// 롬복 이용한 getter and setter / ToString 메소드 자동 생성 
@NoArgsConstructor@AllArgsConstructor // 기본생성자 and 전체매개변수 생성자를 자동 생성 
public class ReplyDto {
    private int rno;            // 게시물번호  
    private String rcontent;	// 게시물내용
    private String rdate;		// 게시물작성일
    private int mno; 			// 작성자의 회원번호 
    private int bno; 			// 작성자의 회원번호 
    // + HTML에 출력할때 작성자의 회원번호가 아닌 작성자 ID 출력 
    private String mid;
    private String mimg;
}
