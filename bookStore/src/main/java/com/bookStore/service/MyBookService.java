package com.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entity.MybookList;
import com.bookStore.repository.MyBookRepository;

@Service
public class MyBookService {

	@Autowired
	private MyBookRepository mybook;
	
	public void saveMyBooks(MybookList book) {
		mybook.save(book);
		
		}
	public List<MybookList> getAllMyBooks(){
		return mybook.findAll();
	}
	
	public void deleteById(int id) {
		
		mybook.deleteById(id);
		
	}

}



