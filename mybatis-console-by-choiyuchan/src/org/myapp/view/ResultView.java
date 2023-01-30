package org.myapp.view;

import java.util.List;

import org.myapp.model.WebtoonDTO;

public class ResultView {

	public void printWtList(List<WebtoonDTO> wtList) {
		for(WebtoonDTO webtoon : wtList) {
			System.out.println(webtoon.getWebtoonName());
		}
		
	}

	public void printError(String result) {
		String message = "";
		
		switch(result) {
		case "searchList" : message = "웹툰 조회에 실패 하였습니다."; break;
		case "insertFailed" : message = "신규 웹툰 추가에 실패하셨습니다."; break;
		case "updateFailed" : message = "웹툰 정보 수정에 실패하셨습니다."; break;
		case "deleteFailed" : message = "웹툰 정보 삭제에 실패하셨습니다."; break;
		}
		
		System.out.println(message);
		
	}

	public void printSuccess(String result) {
		String message = "";
		
		switch(result) {
		case "insertSuccess" : message = "신규 웹툰 추가에 성공하셨습니다."; break;
		case "updateSuccess" : message = "웹툰 정보 수정에 성공하셨습니다."; break;
		case "deleteSuccess" : message = "웹툰 정보 삭제에 성공하셨습니다."; break;
		}
		
		System.out.println(message);
	}
}
