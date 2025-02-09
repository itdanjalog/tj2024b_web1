package web.model.dto;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class PageDto {
	
	private int page; 		// 현재 페이지 
	private int listsize; 	// 페이지당 게시물을 표시할 개수 
	private int startrow; 	// 현재 페이지에서 시작되는 게시물번호 
	private int totalsize;	// 총 게시물수 
	private int totalpage;	// 총 페이지수
	private int btnsize;	// 페이지별 최대 페이징버튼수
	private int startbtn;	// 페이지별 시작 페이징버튼의 번호
	private int endbtn;		// 페이지별 끝 페이징버튼의 번호
	
	// !! : 게시물 목록 
	Object datalist ; // 출력할 데이터[게시물] 리스트

}
