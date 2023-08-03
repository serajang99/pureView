package pureView.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pureView.dto.BoardDto;
import pureView.util.JdbcUtil;

public class BoardDaoImpl implements BoardDao {

	@Override
	public void add(BoardDto dto) throws SQLException, DuplicatedIdException {
		//DBMS연결과 
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.connect();
			//3. SQL 작성
			String sql = " INSERT INTO BOARD(boardNum, boardTitle, boardContent, "
					+ "writeTime, starRating, memberId, cosNum) ";
			sql += " VALUES(BOARD_SEQ.NEXTVAL, ?, ?, SYSDATE, ?, ?, ?) ";
			//4. statement 생성
			pstmt = con.prepareStatement(sql);
			//5. 데이터 설정 
			pstmt.setString(1, dto.getBoardTitle());
			pstmt.setString(2, dto.getBoardContent());
//			pstmt.setDate(3, (java.sql.Date)dto.getWriteTime());
			pstmt.setInt(3, dto.getStarRating());
			pstmt.setString(4, dto.getMemberId());
			pstmt.setInt(5, dto.getCosNum());
			//6. SQL 전송, 결과수신
			int count = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);		//내부에서 classNotFoundException이 발생했지만 이걸 최종적으로 SQLException으로 보냄
		} finally {
			//DBMS해제
			JdbcUtil.close(pstmt,con);
		}
	}

	@Override
	public void update(BoardDto dto) throws SQLException, RecordNotFoundException {

	}

	@Override
	public void delete(int no) throws SQLException, RecordNotFoundException {

	}

	@Override
	public int count() throws SQLException {
		return 0;
	}

	@Override
	public List<BoardDto> list() throws SQLException {
		//DBMS연결
		List<BoardDto> result = new ArrayList<BoardDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.connect();
			//3. SQL 작성
			String sql = "SELECT * FROM BOARD order by boardNum DESC ";
			//4. statement 생성
			pstmt = con.prepareStatement(sql);
			//5. 데이터 설정 
			//6. SQL 전송, 결과수신-
			//	DML 전송 : executeUpdate() : int
			//	SELECT전송 : executeQuery() : ResultSet
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int boardNum = rs.getInt("boardNum");
				String boardTitle = rs.getString("boardTitle");
				String boardContent = rs.getString("boardContent");
				Date writeTime = rs.getDate("writeTime");
				int starRating = rs.getInt("starRating");
				String memberId = rs.getString("memberId");
				int cosNum = rs.getInt("cosNum");
				BoardDto dto = new BoardDto(boardNum, boardTitle, boardContent, writeTime, starRating, memberId, cosNum);
				result.add(dto);
			}
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		} finally {
			JdbcUtil.close(pstmt,con);
		}
		return result;
	}

	@Override
	public BoardDto findById(int no) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}