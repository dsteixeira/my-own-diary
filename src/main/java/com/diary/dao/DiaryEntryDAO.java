package com.diary.dao;

import java.util.List;

import com.diary.model.DiaryEntry;

public interface DiaryEntryDAO {
	DiaryEntry findById(Long id);

	List<DiaryEntry> findAll();

	void save(DiaryEntry diaryEntry);

	void update(DiaryEntry diaryEntry);

	void delete(Long id);
}