package com.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookStore.entity.MybookList;
@Repository

public interface MyBookRepository  extends JpaRepository<MybookList,Integer>{

}
