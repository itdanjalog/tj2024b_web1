package web.model.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;

// @Getter // 클래스내 모든 멤버변수에 getter 적용.
@NoArgsConstructor( access = lombok.AccessLevel.PRIVATE ) // 클래스내 디폴트생성자를 private 적용 
public class MemberDao extends Dao {
	
	// + 싱글톤 
		// [1] 멤버변수에 static 인스턴스를 만든다.
		// [2] 디폴트 생성자를 private 한다.
		// [3] static 인스턴스를 반환하는 메소드 만든다.
	@Getter // 지정된 멤버변수에 getter 적용
	private static MemberDao instance = new MemberDao();
	
	// @NoArgsConstructor( access = lombok.AccessLevel.PRIVATE ) 
	// private MemberDao() { }
	
	// @Getter 
	// public static MemberDao getInstance() { return instance;} 
	
} // class end 
