
package pureView.dao;

import java.sql.SQLException;

import pureView.dto.MemberDto;
import pureView.exception.DuplicatedIdException;

import pureView.exception.RecordNotFoundException;

public interface MemberDao {
	// 등록
	public void add(MemberDto m) throws SQLException, DuplicatedIdException;

	// 수정
	public void update(MemberDto m) throws SQLException, RecordNotFoundException;

	// 삭제
	public void delete(String id) throws SQLException, RecordNotFoundException;

	// 아이디 조회, 비밀번호 조회
	public MemberDto findById(String id) throws SQLException, RecordNotFoundException;

	public MemberDto findByPw(String id) throws SQLException, RecordNotFoundException;
}
