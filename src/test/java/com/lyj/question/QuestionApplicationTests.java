package com.lyj.question;

import com.lyj.question.repository.TestRepository;
import com.lyj.question.utils.Crawling;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionApplicationTests {
    @Autowired
    private TestRepository repository;

    /**
     * Crawling.Craw(例题网址,最短爬取间隔,最长爬取间隔,是否清空表)
     */
    @org.junit.Test
    public void contextLoads() {
        List<String> urls =Arrays.asList(
                "http://tes.tmooc.cn/qsexam/QSRandomPaperExam?courseId=qw8671"
        );
        urls=new ArrayList();
        String pre="http://tes.tmooc.cn/qsexam/QSRandomPaperExam?courseId=qw";
        for (int i = 8657; i <=8693; i++) {
            String s= pre+i;
            urls.add(s);
        }
        for (int i = 9328; i <=9366; i++) {
            String s= pre+i;
            urls.add(s);
        }
        Crawling.Crawing(urls,0,0,repository,true);
    }
}
