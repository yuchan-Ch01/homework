package org.myapp.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.myapp.model.SearchCriteria;
import org.myapp.model.WebtoonDTO;

public interface WebtoonMapper {

	List<WebtoonDTO> searchAllWebtoon();

	List<WebtoonDTO> searchWebtoonByCriteria(SearchCriteria criteria);

	int insertNewWebtoon(WebtoonDTO webtoon);

	int modifyWebtoon(WebtoonDTO webtoon);

	int deleteWebtoon(String name);

	
}
