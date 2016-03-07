package com.news.report;

public enum WordEnum {
	    fizz(3), buzz(5), fizzbuzz(5);
	
    private final int wordCode;

    WordEnum(int wordCode) {
        this.wordCode = wordCode;
    }
    
    public int getWordCode() {
        return this.wordCode;
    }
	
}
