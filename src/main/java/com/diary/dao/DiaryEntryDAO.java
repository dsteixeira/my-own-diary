package com.diary.dao;

import java.util.List;

import com.diary.model.DiaryEntry;

public interface DiaryEntryDAO {
	DiaryEntry findById(Integer id);

	List<DiaryEntry> findAll();

	void save(DiaryEntry diaryEntry);

	void update(DiaryEntry diaryEntry);

	void delete(Integer id);
}