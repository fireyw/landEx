package com.example.demo.controller;

import com.example.demo.domain.Apt;
import com.example.demo.service.AptService;
import org.json.XML;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

@Controller
public class AptController {

    @Autowired
    AptService aptService;

    @GetMapping("/getAptData")
    @ResponseBody
    public String getAptData() throws Exception {
        StringBuilder urlBuilder = new StringBuilder("http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTrade"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=FHMB8NWs0fi%2BoAqRfUc4oarG18XYQ4ii%2BbCdi9JGGlgps%2BMU%2B4rx2%2BTtK9QBZOEx9ABsT0zpA7vgVga5ditSRg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("LAWD_CD", "UTF-8") + "=" + URLEncoder.encode("11215", "UTF-8")); /*각 지역별 코드*/
        urlBuilder.append("&" + URLEncoder.encode("DEAL_YMD", "UTF-8") + "=" + URLEncoder.encode("201904", "UTF-8")); /*월 단위 신고자료*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        //System.out.println(sb.toString());

        org.json.JSONObject xmlJSONObj = XML.toJSONObject(sb.toString());
        String xmlJSONObjString = xmlJSONObj.toString();
        System.out.println("### xmlJSONObjString=>"+xmlJSONObjString);

        JSONParser jsonParser=new JSONParser();
        JSONObject jsonObject = (JSONObject)jsonParser.parse(xmlJSONObjString);
        JSONObject parse_response = (JSONObject)jsonObject.get("response");
        JSONObject parse_body     = (JSONObject)parse_response.get("body");
        JSONObject parse_items    = (JSONObject)parse_body.get("items");
        JSONArray parse_item     = (JSONArray)parse_items.get("item");

        JSONObject obj;
        ArrayList <Apt> arrayList = new ArrayList<Apt>();

        for(int i =0; i<parse_item.size(); i++){
            obj = (JSONObject) parse_item.get(i);

            Apt apt = new Apt();
            apt.setZip(obj.get("지번").toString());
            apt.setLawdCd(obj.get("지역코드").toString());
            apt.setDealYear((Long)obj.get("년"));
            apt.setDealMon((Long)obj.get("월"));
            apt.setDong(obj.get("법정동").toString());
            apt.setAptFloor(obj.get("층").toString());
            apt.setPrice(obj.get("거래금액").toString());
            apt.setDealDay(obj.get("일").toString());
            apt.setAptName(obj.get("아파트").toString());
            apt.setAptFound((Long)obj.get("건축년도"));
            apt.setAptSize((Double)obj.get("전용면적"));

            System.out.println("확인 : " + apt.toString());

            arrayList.add(apt);
        }

        aptService.saveAptData(arrayList);

        return xmlJSONObjString;
    }
}

