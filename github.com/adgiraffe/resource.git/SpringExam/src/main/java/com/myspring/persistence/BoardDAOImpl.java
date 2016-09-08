package com.myspring.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.myspring.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Inject
	private SqlSession session;	
	
	@Override
	public void create(BoardVO vo) throws Exception {
		session.insert("create",vo);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return session.selectOne("read",bno);
	}
		
	@Override
	public void update(BoardVO vo) throws Exception {
		session.update("update",vo);	
	}

	@Override
	public void delete(Integer bno) throws Exception {
		session.selectList("delete",bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return session.selectList("listAll");
	}
}
