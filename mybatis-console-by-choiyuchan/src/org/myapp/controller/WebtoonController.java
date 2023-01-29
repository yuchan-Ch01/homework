package org.myapp.controller;

import java.util.List;
import java.util.Map;

import org.myapp.model.SearchCriteria;
import org.myapp.model.WebtoonDTO;
import org.myapp.service.WebtoonService;
import org.myapp.view.ResultView;

public class WebtoonController {

	private final WebtoonService wtService;
	private final ResultView resultView;
	
	public WebtoonController() {
		wtService = new WebtoonService();
		resultView = new ResultView();
	}
	
	public void searchAllWebtoon() {
	
		List<WebtoonDTO> wtList = wtService.searchAllWebtoon();
	
		if(wtList != null && !wtList.isEmpty()) {
			resultView.printWtList(wtList);
		} else {
			resultView.printError("searchList");
		}
	}

	public void searchWebtoonByCategory(SearchCriteria criteria) {
	
		List<WebtoonDTO> wtList = wtService.serchWebtoonByCategory(criteria);
		
		if(wtList != null && !wtList.isEmpty()) {
			resultView.printWtList(wtList);
		} else {
			resultView.printError("searchList");
		}
		
	}

	public void insertNewWebtoon(Map<String, String> parameter) {

		WebtoonDTO webtoon = new WebtoonDTO();
		webtoon.setWebtoonName(parameter.get("webtoonName"));
		webtoon.setSerialCode(Integer.parseInt(parameter.get("serialCode")));;
		webtoon.setWriter(parameter.get("writer"));
		webtoon.setIllustrator(parameter.get("illustrator"));
		webtoon.setGenreCode(Integer.parseInt(parameter.get("genreCode")));;
		
		if(wtService.insertNewWebtoon(webtoon)) {
			resultView.printSuccess("insertSuccess");
		} else {
			resultView.printError("insertFailed");
		}
	
	
	}

	public void modifyWebtoon(Map<String, String> parameter) {

		WebtoonDTO webtoon = new WebtoonDTO();
		webtoon.setWebtoonNo(Integer.parseInt(parameter.get("webtoonNo")));
		webtoon.setWebtoonName(parameter.get("webtoonName"));
		webtoon.setSerialCode(Integer.parseInt(parameter.get("serialCode")));;
		webtoon.setWriter(parameter.get("writer"));
		webtoon.setIllustrator(parameter.get("illustrator"));
		webtoon.setGenreCode(Integer.parseInt(parameter.get("genreCode")));;
		
		if(wtService.modifyWebtoon(webtoon)) {
			resultView.printSuccess("updateSuccess");
		} else {
			resultView.printError("updateFailed");
		}
	
		
	}

	public void deleteWebtoon(Map<String, String> parameter) {

		String name = parameter.get("name");
		
		if(wtService.deleteWebtoon(name)) {
			resultView.printSuccess("deleteSuccess");
		} else {
			resultView.printError("deleteFailed");
		}
		
	}
	
	

}
