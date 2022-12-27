package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.MemberDao;
import util.DBUtil;
import vo.Member;

public class MemberService {
	private MemberDao memberDao;
	
	public Member login(Member member) {
		Member login = new Member();
		this.memberDao = new MemberDao();
		Connection conn = null; 
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			login = memberDao.login(conn, member);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return login;
	}
}