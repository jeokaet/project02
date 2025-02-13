package dao;

import dto.MemberDTO;

public interface MemberDAO {
	MemberDTO login(String id, String password) throws Exception;
	int signup(MemberDTO dto) throws Exception;
	int update(MemberDTO dto) throws Exception;
	int delete(String id) throws Exception;
}
