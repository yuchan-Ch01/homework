package org.myapp.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.myapp.controller.WebtoonController;
import org.myapp.model.SearchCriteria;


public class Application {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		WebtoonController wtController = new WebtoonController();
		
		do {		
			System.out.println("==== 웹툰 관리 시스템 ====");
			System.out.println("1. 웹툰 전체 조회");
			System.out.println("2. 웹툰 상세 조회");
			System.out.println("3. 신규 웹툰 추가");
			System.out.println("4. 웹툰 정보 수정");
			System.out.println("5. 웹툰 삭제");
			System.out.print("메뉴 번호를 입력 : ");
			int no = sc.nextInt();
			
			switch(no) {
			case 1 : wtController.searchAllWebtoon(); break;
			case 2 : wtController.searchWebtoonByCriteria(inputSearchCriteria()); break;
			case 3 : wtController.insertNewWebtoon(inputWebtoon()); break;
			case 4 : wtController.modifyWebtoon(inputInfo()); break;
			case 5 : wtController.deleteWebtoon(inputName());break;
			default : return;			
			}
			
		} while(true);
	}


	private static SearchCriteria inputSearchCriteria() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("[ 장르별 | 요일별 ]");
		System.out.println("[ genre | date ]");
		System.out.print("검색 기준을 입력해주세요. : ");
		String condition = sc.nextLine();
		
		
		switch(condition){
		case "genre" : System.out.println("[ 무협 | 일상 | 판타지 | 로맨스 | 스포츠 ]"); break;
		case "date" : System.out.println("[ 월 | 화 | 수 | 목 | 금 | 토 | 일 ]"); break;
		default : System.out.println("[ 잘 못 입력 하셨습니다. 다시 입력하세요 ]"); 		
		}
		
		System.out.println("검색어를 입력해주세요.");
		String value = sc.nextLine();

		
		return new SearchCriteria(condition, value);
	}
	
	private static Map<String, String> inputWebtoon() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("* 표시는 필수 입력 정보입니다.");
		System.out.print("* 웹툰 이름 : ");
		String webtoonName = sc.nextLine();
		System.out.print("연재 코드 : ");
		int serialCode = sc.nextInt();
		sc.nextLine();
		System.out.print("작가 이름 : ");
		String writer = sc.nextLine();
		System.out.print("그림작가 이름 : ");
		String illustrator = sc.nextLine();
		System.out.print("장르 코드 : ");
		int genreCode = sc.nextInt();
				
		Map<String, String> parameter = new HashMap<>();
		parameter.put("webtoonName", webtoonName);
		parameter.put("serialCode", String.valueOf(serialCode));
		parameter.put("writer", writer);
		parameter.put("illustrator", illustrator);
		parameter.put("genreCode", String.valueOf(genreCode));
		
		return parameter;
	}
	
	private static Map<String, String> inputInfo() {

		Scanner sc = new Scanner(System.in);
		System.out.println("수정할 웹툰 번호 입력 : ");
		int webtoonNo = sc.nextInt();
		sc.nextLine();
		System.out.print("수정할 웹툰 이름 : ");
		String webtoonName = sc.nextLine();
		System.out.print("수정할 연재 코드 : ");
		int serialCode = sc.nextInt();
		sc.nextLine();
		System.out.print("수정할 작가 이름 : ");
		String writer = sc.nextLine();
		System.out.print("수정할 그림작가 이름 : ");
		String illustrator = sc.nextLine();
		System.out.print("수정할 장르 코드 : ");
		int genreCode = sc.nextInt();
				
		Map<String, String> parameter = new HashMap<>();
		parameter.put("webtoonNo", String.valueOf(webtoonNo));
		parameter.put("webtoonName", webtoonName);
		parameter.put("serialCode", String.valueOf(serialCode));
		parameter.put("writer", writer);
		parameter.put("illustrator", illustrator);
		parameter.put("genreCode", String.valueOf(genreCode));
		
		return parameter;
	}
	
	private static Map<String, String> inputName() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 웹툰 이름 입력 : ");
		String name = sc.nextLine();
		
		Map<String, String> parameter = new HashMap<>();
		parameter.put("name", name);
		
		return parameter;
	}

}
