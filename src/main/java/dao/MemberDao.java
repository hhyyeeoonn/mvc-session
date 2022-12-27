package dao;

import vo.Member;
import java.sql.*;

public class MemberDao {
	public Member login(Connection conn, Member member) throws Exception {
		Member loginMember = null;
		String sql = "SELECT member_id memberId from member Where member_id = ? AND member_pw = PASSWORD(?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, member.getMemberId());
		stmt.setString(2, member.getMemberPw());
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			loginMember = new Member();
			loginMember.setMemberId(rs.getString("memberId"));
		}
		rs.close();
		stmt.close();
		return loginMember;
	}
}