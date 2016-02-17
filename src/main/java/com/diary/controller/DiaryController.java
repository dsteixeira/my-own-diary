package com.diary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@RequestMapping(value = "newEntry", method = RequestMethod.GET)
	public ModelAndView newEntry() {
		ModelAndView mv = new ModelAndView("newEntry");
		return mv;
	}
	
	@RequestMapping(value = "saveEntry", method = RequestMethod.POST)
	public String saveEntry(DiaryEntry diaryEntry) {
		System.out.println(diaryEntry.getBody());
		System.out.println(diaryEntry.getTitle());
		
		return "redirect:/list";
	}
}
