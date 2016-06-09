package com.diary.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diary.dao.DiaryEntryDAO;
import com.diary.model.DiaryEntry;

@Service
public class DiaryEntryService {

	private static final Logger log = LoggerFactory.getLogger(DiaryEntryService.class);

	@Autowired
	private DiaryEntryDAO diaryEntryDAO;

	public List<DiaryEntry> listAll() {
		return diaryEntryDAO.findAll();
	}

	public void save(DiaryEntry diaryEntry) {
		log.info("About to save {}", diaryEntry);
		diaryEntryDAO.save(diaryEntry);
		log.info("Entry [{}] saved!", diaryEntry.getId());
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
