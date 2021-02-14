package com.example.demo.listener;

public class CustomMessageDTO {
    private String keyword;

    public CustomMessageDTO(){

    }

    public CustomMessageDTO(String keyword){
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}

