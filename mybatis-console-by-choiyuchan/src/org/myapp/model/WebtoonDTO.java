package org.myapp.model;

public class WebtoonDTO {

	private int webtoonNo;
	private String webtoonName;
	private int serialCode;
	private String writer;
	private String illustrator;
	private int genreCode;
	
	public WebtoonDTO() {}

	public WebtoonDTO(int webtoonNo, String webtoonName, int serialCode, String writer, String illustrator,
			int genreCode) {
		super();
		this.webtoonNo = webtoonNo;
		this.webtoonName = webtoonName;
		this.serialCode = serialCode;
		this.writer = writer;
		this.illustrator = illustrator;
		this.genreCode = genreCode;
	}

	public int getWebtoonNo() {
		return webtoonNo;
	}

	public void setWebtoonNo(int webtoonNo) {
		this.webtoonNo = webtoonNo;
	}

	public String getWebtoonName() {
		return webtoonName;
	}

	public void setWebtoonName(String webtoonName) {
		this.webtoonName = webtoonName;
	}

	public int getSerialCode() {
		return serialCode;
	}

	public void setSerialCode(int serialCode) {
		this.serialCode = serialCode;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getIllustrator() {
		return illustrator;
	}

	public void setIllustrator(String illustrator) {
		this.illustrator = illustrator;
	}

	public int getGenreCode() {
		return genreCode;
	}

	public void setGenreCode(int genreCode) {
		this.genreCode = genreCode;
	}

	@Override
	public String toString() {
		return "[ 웹툰 번호 : " + webtoonNo + ", 웹툰 이름 : " + webtoonName +
			   ", 연재 번호 : " + serialCode + ", 글 작가 : " + writer + 
			   ", 그림 작가 : " + illustrator + ", 장르 번호  : " + genreCode + " ]"; 
	}
	
	
}
