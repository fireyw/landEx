package com.example.demo.domain;

import lombok.Data;

@Data
public class Apt {
    String	zip    = "";
    String	lawdCd = "";
    Long	dealYear ;
    Long	dealMon  ;
    String	dealDay  ;
    String	price    ;
    String	aptName  = "";
    String	aptFloor = "";
    Double	aptSize ;
    Long	aptFound ;
    String	dong     = "";
}
