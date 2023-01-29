package org.myapp.service;

import static org.myapp.common.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.myapp.mapper.WebtoonMapper;
import org.myapp.model.SearchCriteria;
import org.myapp.model.WebtoonDTO;

public class WebtoonService {

	private WebtoonMapper webtoonMapper;
	
	public List<WebtoonDTO> searchAllWebtoon() {
		
		SqlSession sqlSession = getSqlSession();
		
		webtoonMapper = sqlSession.getMapper(WebtoonMapper.class); 
		List<WebtoonDTO> wtList = webtoonMapper.searchAllWebtoon();
		
		sqlSession.close();
		
		return wtList;	
	}

	public List<WebtoonDTO> serchWebtoonByCategory(SearchCriteria criteria) {
		
		SqlSession sqlSession = getSqlSession();
		
		webtoonMapper = sqlSession.getMapper(WebtoonMapper.class); 
		
		List<WebtoonDTO> wtList = webtoonMapper.searchWebtoonByCategory(criteria);
		
		sqlSession.close();
		
		return wtList;
		
		
	}

	public boolean insertNewWebtoon(WebtoonDTO webtoon) {
		
		SqlSession sqlSession = getSqlSession();
		webtoonMapper = sqlSession.getMapper(WebtoonMapper.class);
		
		int result = webtoonMapper.insertNewWebtoon(webtoon);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result > 0 ? true : false;
	}

	public boolean modifyWebtoon(WebtoonDTO webtoon) {
		
		SqlSession sqlSession = getSqlSession();		
		webtoonMapper = sqlSession.getMapper(WebtoonMapper.class);
		
		int result = webtoonMapper.modifyWebtoon(webtoon);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result > 0 ? true : false;
	}

	public boolean deleteWebtoon(String name) {
		SqlSession sqlSession = getSqlSession();		
		webtoonMapper = sqlSession.getMapper(WebtoonMapper.class);
		
		int result = webtoonMapper.deleteWebtoon(name);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result > 0 ? true : false;	
		
	}
	

}
