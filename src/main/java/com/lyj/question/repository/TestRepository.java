package com.lyj.question.repository;

import com.lyj.question.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/9/9 10:54
 */
public interface TestRepository extends JpaRepository<Test,Integer> {
}
