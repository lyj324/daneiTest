package com.lyj.question.utils;

import com.lyj.question.entity.Test;
import com.lyj.question.repository.TestRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/9/9 12:29
 */
public class Crawling {
    public static List<Test> Craw(String url, int minTime, int maxTime){
        Document document= null;
        Random random = new Random();
        try {
            Thread.sleep((random.nextInt(maxTime-minTime)+minTime)*1000);
            document = Jsoup.connect(url).get();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println(document);
        Elements elementsByClass = document.getElementsByClass("other-1221-bd");
        int size = elementsByClass.size();
        List<Test> tests =new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Element element = elementsByClass.get(i);
            //System.out.println(element);
            Element child = element.child(0);
            //题目
            String question = child.child(0).child(0).child(2).text();
            //选项
            String A = child.child(1).child(0).child(0).child(2).text();
            String B = child.child(1).child(1).child(0).child(2).text();
            String C = child.child(1).child(2).child(0).child(2).text();
            String D = child.child(1).child(3).child(0).child(2).text();
            //答案
            String answer = child.child(2).child(0).text();
            String analysis = child.child(2).child(1).text();
            Test test =new Test();
            test.setQuestion(question);
            test.setA(A);
            test.setB(B);
            test.setC(C);
            test.setD(D);
            test.setAnswer(answer);
            test.setAnalysis(analysis);
            tests.add(test);
        }
        return tests;
    }
    public static void Crawing(List<String> urls,int minTime,int maxTime,TestRepository repository,boolean delTable){
        if (delTable) {
            repository.deleteAll();
        }
        for (String s:urls) {
            int flag=0;
            while (flag != 25) {
                int count=0;
                boolean save=false;
                List<Test> craw = Crawling.Craw(s, minTime, maxTime);
                for (Test test : craw) {
                    Example<Test> example = Example.of(test);
                    if (!repository.exists(example)) {
                        repository.save(test);
                    }else {
                        count++;
                        if(count==craw.size()){
                            save=true;
                        }
                    }
                }
                if(save){
                    flag++;
                }
            }
        }
    }
}
