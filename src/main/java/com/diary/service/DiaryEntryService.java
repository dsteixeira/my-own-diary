package com.diary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diary.dao.DiaryEntryDAO;
import com.diary.model.DiaryEntry;

@Service
public class DiaryEntryService {

	@Autowired
	private DiaryEntryDAO diaryEntryDAO;

	public List<DiaryEntry> listAll() {
		return diaryEntryDAO.findAll();
	}

	public void save(DiaryEntry diaryEntry) {
		diaryEntryDAO.save(diaryEntry);
	}

	public void delete(Long id) {
		diaryEntryDAO.delete(id);
	}

	public DiaryEntry findById(Long id) {
		return diaryEntryDAO.findById(id);
	}

	public void update(DiaryEntry diaryEntry) {
		diaryEntryDAO.update(diaryEntry);
	}
}
