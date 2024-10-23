package com.ssafy.mvc.util;

public class PageResult {
	private int page;
	private int beginPage;
	private int endPage;
	private int lastPage;
	private int listSize;
	private boolean prev;
	private boolean next;

	public int getListSize() {
		return listSize;
	}

	public int getPage() {
		return page;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	public static final int LAST_SIZE = 10;
	public static final int TAB_SIZE = 10;

	public PageResult(int page, int totalCount) {
		this(page, LAST_SIZE, TAB_SIZE);
	}

	public PageResult(int page, int totalCount, int listSize) {
		this(page, totalCount, listSize, TAB_SIZE);
	}

	public PageResult(int page, int totalCount, int listSize, int tabSize) {
		this.page = page;
		this.listSize = listSize;
		this.lastPage = (totalCount % listSize == 0 ? totalCount / listSize : totalCount / listSize + 1);

		// page-block 번호 계산하기
		// page = 1 -> 1번째 블락
		// page = 10 -> 1번째 블락
		// page = 13 -> 2번째 블락
		int tab = (page - 1) / tabSize + 1;
		this.beginPage = (tab - 1) * tabSize + 1;
		this.endPage = (tab * tabSize < lastPage) ? tab * tabSize : lastPage;

		// 이전 번호가 있는지
		this.prev = beginPage != 1;
		// 다음 번호가 있는지
		this.next = endPage != lastPage;
	}
}
