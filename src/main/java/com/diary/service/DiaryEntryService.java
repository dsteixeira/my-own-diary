package com.diary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diary.dao.DiaryEntryDAO;
import com.diary.model.DiaryEntry;

@Service
public class DiaryEntryService {

	@Autowired
	DiaryEntryDAO diaryEntryDAO;
	
	public List<DiaryEntry> listAll() {
		return diaryEntryDAO.findAll();
	}
}
