package com.mapper;

import com.domain.Student;

/**
 * Created by 16440 on 2017/2/13.
 */
public interface StudentMapper {
    Student findOneById(int id);

    //动态sql
    Student findBySomeThing(Student student);
}
