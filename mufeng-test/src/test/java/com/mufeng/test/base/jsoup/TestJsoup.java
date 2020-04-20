package com.mufeng.test.base.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class TestJsoup {
    @Test
    public void test1() throws Exception{
        Document document = Jsoup.connect("http://www.baidu.com").get();
        String title = document.title();
        //Element body = document.body();
        Elements select = document.select("a[href]");
        for(Element link :select){
            System.out.println(link.attr("href"));
            System.out.println(link.text());
        }
       // System.out.println(title);
        //System.out.println(body);
    }
    @Test
    public void testCreatHtml(){
        CreatJsoupHtml.makeHeatMapHtml();
    }
    @Test
    public void test2() throws  Exception{
        Document document = Jsoup.connect("http://192.168.0.247:8002/pages/viewpage.action?pageId=25231492").get();
        String html = document.html();
        System.out.println(html);
    }
}
