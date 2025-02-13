package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.MemberDTO;

public class MemberDAOImpl implements MemberDAO {

	private Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/orcl");
		return ds.getConnection();
	}

	public MemberDTO login(String id, String password) throws Exception {
		String sql = "select * from memeber where id =? and pw=?";
		try (Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);) {

			pstat.setString(1,id);
			pstat.setString(2,password);
			try(ResultSet rs = pstat.executeQuery(sql)) {
				rs.next();
					String userId = rs.getString("id");
					String userPassword = rs.getString("password");

					if (id.equals(userId) && password.equals(userPassword)) {
						String name = rs.getString("name");
						String email = rs.getString("email");
						String phone = rs.getString("phone");
						int post = rs.getInt("postcode");
						String address1 = rs.getString("address1");
						String address2 = rs.getString("address2");
						Timestamp date = rs.getTimestamp("signup_date");
						return new MemberDTO(userId,userPassword, name, email, phone, post, address1, address2, date); // 로그인할때
					}
			}
		}
	}// 로그인

	@Override
	public int signup(MemberDTO dto) throws Exception {

		String sql = "insert into members (id, pw, name, email, phone, postcode, address1, address2) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
			pstat.setString(1, dto.getuserId());
			pstat.setString(2, dto.getuserPassword());
			pstat.setString(3, dto.getName());
			pstat.setString(4, dto.getEmail());
			pstat.setString(5, dto.getPhone());
			pstat.setInt(6, dto.getPost());
			pstat.setString(7, dto.getAddress1());
			pstat.setString(8, dto.getAddress2());

			return pstat.executeUpdate();
		}

	}

	public int update(MemberDTO dto) throws Exception {

		String sql = "update members set name =?, email=?, phone=?, postcode=?, address1=?, address2=? where id = ?";
		try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getEmail());
			pstat.setString(3, dto.getPhone());
			pstat.setInt(4, dto.getPost());
			pstat.setString(5, dto.getAddress1());
			pstat.setString(6, dto.getAddress2());
			pstat.setString(7, dto.getId());

			return pstat.executeUpdate();
		}
	}

	public int delete(String id) throws Exception {
		String sql = "delete from members where id = ?";
		try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
			pstat.setString(1, id);
			int result = pstat.executeUpdate();
			return result;
		}
	}

}
