package com.diary.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.diary.model.DiaryEntry;
import com.diary.service.DiaryEntryService;

@Controller
public class DiaryController {

	@Autowired
	DiaryEntryService diaryEntryService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView lista() {
		List<DiaryEntry> entries = diaryEntryService.listAll();
		ModelAndView mv = new ModelAndView("list");
		mv.addObject("entries", entries);
		return mv;
	}
	
	@RequestMapping(value = "addEntry", method = RequestMethod.GET)
	public ModelAndView addEntry() {
		ModelAndView mv = new ModelAndView("addEntry");
		return mv;
	}
	
	@RequestMapping(value = "deleteEntry/{id}", method = RequestMethod.GET)
	public String deleteEntry(@PathVariable("id") Long id) {
		diaryEntryService.delete(id);
		return "redirect:/list";
	}
	
	@RequestMapping(value = "saveEntry", method = RequestMethod.POST)
	public String saveEntry(DiaryEntry diaryEntry) {
		Date createDate = new Date();
		diaryEntry.setCreateDate(createDate);;
		diaryEntry.setUpdateDate(createDate);
		diaryEntryService.save(diaryEntry);
		return "redirect:/list";
	}
	
	@RequestMapping(value = "updateEntry", method = RequestMethod.POST)
	public String updateEntry(DiaryEntry diaryEntry) {
		diaryEntry.setUpdateDate(new Date());
		diaryEntryService.update(diaryEntry);
		return "redirect:/list";
	}
}
