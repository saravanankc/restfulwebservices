package com.kc.learnings.spring.restfulwebservices.responseFiltering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Static filtering - class level
//@JsonIgnoreProperties(value = {"field1", "field3ToBeIgnored"})
@JsonFilter("SomeBeanFilter") //Needed for dynamic filtering fields on controller method
public class SomeBean {
    private String field1;
    private String field2;

    //Static filtering - attribute level
//    @JsonIgnore
    private String field3ToBeIgnored;

    public SomeBean(String field1, String field2, String field3ToBeIgnored) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3ToBeIgnored = field3ToBeIgnored;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3ToBeIgnored() {
        return field3ToBeIgnored;
    }

    public void setField3ToBeIgnored(String field3ToBeIgnored) {
        this.field3ToBeIgnored = field3ToBeIgnored;
    }
}
