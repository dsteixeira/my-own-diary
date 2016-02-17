package com.diary.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.diary.model.DiaryEntry;

@Service
public class DiaryEntryService {

	public List<DiaryEntry> listAll() {
		List<DiaryEntry> entries = new LinkedList<DiaryEntry>();

		DiaryEntry diaryEntry = new DiaryEntry();
		diaryEntry.setId(1);
		diaryEntry.setTitle("My vacations");
		diaryEntry.setBody("My vacations were boring");
		diaryEntry.setCreateDate(new Date());
		diaryEntry.setEntryDate(new Date());

		DiaryEntry diaryEntry1 = new DiaryEntry();
		diaryEntry1.setId(2);
		diaryEntry1.setTitle("My Job");
		diaryEntry1.setBody("My job is awesome!");
		diaryEntry1.setCreateDate(new Date());
		diaryEntry1.setEntryDate(new Date());

		entries.add(diaryEntry);
		entries.add(diaryEntry1);

		return entries;
	}
}
