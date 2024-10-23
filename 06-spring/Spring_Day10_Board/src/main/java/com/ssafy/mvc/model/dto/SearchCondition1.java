package com.ssafy.mvc.model.dto;

public class SearchCondition1 {
    private String key;
    private String word;
    private String orderBy;
    private String orderByDir;
    
    private int offset; // 페이지 오프셋
    private int listSize; // 리스트 사이즈

    public SearchCondition1() {
    }

    // Getter Methods
    public String getKey() {
        return key;
    }

    public String getWord() {
        return word;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public String getOrderByDir() {
        return orderByDir;
    }

    public int getOffset() {
        return offset;
    }

    public int getListSize() {
        return listSize;
    }
}
