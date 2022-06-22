package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	//정보 전달 받아서 mapper를 거쳐서 db에 저장
	@Inject
	private SqlSession sqlSession;
	
	static final String NAMESPACE="com.itwillbs.mapper.BoardMapper" ;
	
	
	@Override
	public void create(BoardVO vo) {
		
		log.info("정보 전달받아서 mapper 호출");
		sqlSession.insert(NAMESPACE+".createBoard",vo);
		log.info("mapper에서 처리 후 이동");
		
	}


	@Override
	public List<BoardVO> listAll() {
		
		log.info("listAll() 호출");
		
		//mapper 해당 sql 호출
		
		
		return sqlSession.selectList(NAMESPACE+".listAll");
	}


	@Override
	public BoardVO content(Integer bno) {
		
		
		log.info("contentBoard 호출");
		
		return sqlSession.selectOne(NAMESPACE+".contentBoard", bno);
		
	}


	@Override
	public void updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		
		log.info("boardModify 호출");
		log.info(vo+"");
		sqlSession.update(NAMESPACE+".updateBoard", vo);
		
	}


	@Override
	public void removeBoard(Integer bno) {
		// TODO Auto-generated method stub
		
		sqlSession.delete(NAMESPACE+".deleteBoard", bno);
		
		
		
		
	}


	@Override
	public void updateBoardCnt(int bno) {
		// TODO Auto-generated method stub
		sqlSession.update(NAMESPACE+".readCnt", bno);
	}
	

}
