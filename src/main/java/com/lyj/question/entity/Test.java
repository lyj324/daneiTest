package com.lyj.question.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/9/9 10:27
 */
@Data
@Table
@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer Id;
    @Column(columnDefinition="text")
    private String question;
    @Column
    private String A;
    @Column
    private String B;
    @Column
    private String C;
    @Column
    private String D;
    @Column
    private String answer;
    @Column(columnDefinition="text")
    private String analysis;
}
