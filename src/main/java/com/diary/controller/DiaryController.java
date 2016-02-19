package com.diary.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.diary.model.DiaryEntry;
import com.diary.service.DiaryEntryService;
import com.diary.service.ToneAnalyzerService;
import com.diary.utils.ToneInfo;

@Controller
public class DiaryController {

	@Autowired
	private DiaryEntryService diaryEntryService;

	@Autowired
	private ToneAnalyzerService toneAnalyzerService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "redirect:/list";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView lista() {
		List<DiaryEntry> entries = diaryEntryService.listAll();
		ModelAndView mv = new ModelAndView("list");
		mv.addObject("entries", entries);
		return mv;
	}

	@RequestMapping(value = "viewEntry/{id}", method = RequestMethod.GET)
	public ModelAndView viewEntry(@PathVariable("id") Long id) {
		DiaryEntry diaryEntry = diaryEntryService.findById(id);
		ModelAndView mv = new ModelAndView("viewEntry");

		ToneInfo toneInfo = toneAnalyzerService.getToneInfo(diaryEntry.getPost());
		mv.addObject("entry", diaryEntry);
		mv.addObject("toneInfo", toneInfo);
		return mv;
	}

	@RequestMapping(value = "addEntry")
	public String addEntry() {
		return "addEntry";
	}

	@RequestMapping(value = "saveEntry", method = RequestMethod.POST)
	public String saveEntry(DiaryEntry diaryEntry, RedirectAttributes redirectAttributes) {
		Date createDate = new Date();
		diaryEntry.setCreateDate(createDate);
		diaryEntry.setUpdateDate(createDate);
		diaryEntryService.save(diaryEntry);

		redirectAttributes.addFlashAttribute("successMessage", "Diary entry successfuly added.");
		return "redirect:/list";
	}

	@RequestMapping(value = "/prepareEditEntry/{id}")
	public String prepareEditEntry(@PathVariable("id") Long id, Model model) {
		DiaryEntry diaryEntry = diaryEntryService.findById(id);
		model.addAttribute("entry", diaryEntry);
		return "editEntry";
	}
	
	@RequestMapping(value = "updateEntry", method = RequestMethod.POST)
	public String updateEntry(DiaryEntry diaryEntry, RedirectAttributes redirectAttributes) {
		diaryEntry.setUpdateDate(new Date());
		diaryEntryService.update(diaryEntry);

		redirectAttributes.addFlashAttribute("successMessage", "Diary entry successfuly updated.");
		return "redirect:/list";
	}
	
	@RequestMapping(value = "deleteEntry/{id}", method = RequestMethod.GET)
	public String deleteEntry(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		diaryEntryService.delete(id);
		redirectAttributes.addFlashAttribute("successMessage", "Diary entry successfuly deleted.");
		return "redirect:/list";
	}
}