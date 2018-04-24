package com.j.ch17.spring.store.model;

//아이템을 찾지못할경우의 사용자 정의 예외
public class ItemNotFoundException extends RuntimeException{

    static final long serialVersionUID = 1L;

    private Integer itemId;

    public ItemNotFoundException(Integer itemId) {
        super("not found item : id "+itemId+" is no exist...");
        this.itemId = itemId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
}
