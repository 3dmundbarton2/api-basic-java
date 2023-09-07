package com.bartonsoft.apibasicjava.common;

public class CategoryDetailsTable {
    public String jsonPointer;
    public Boolean exactMatch;
    public String expectedContent;

    public CategoryDetailsTable(String jsonPointer, Boolean exactMatch, String expectedContent){
        this.jsonPointer = jsonPointer;
        this.exactMatch = exactMatch;
        this.expectedContent = expectedContent;
    }


}
