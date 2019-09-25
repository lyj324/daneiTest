package com.lyj.question.repository;

import com.lyj.question.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/9/9 10:54
 */
public interface TestRepository extends JpaRepository<Test,Integer> {
    @Transactional
    @Modifying
    @Query(value = "truncate table test",nativeQuery=true)
    void clear();
}
