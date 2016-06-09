package com.diary.service;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.diary.utils.ToneInfo;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;

@Service
public class ToneAnalyzerService {

	private static final String USERNAME = "<username>";
	private static final String PASSWORD = "<password>";

	private static final String TONE_CATEGORY_EMOTION = "emotion_tone";
	private static final String TONE_CATEGORY_WRITING = "language_tone";
	private static final String TONE_SOCIAL_EMOTION = "social_tone";

	public ToneInfo getToneInfo(String text) {

		ToneAnalyzer service = new ToneAnalyzer(ToneAnalyzer.VERSION_DATE_2016_05_19);
		service.setUsernameAndPassword(USERNAME, PASSWORD);

		// Call the service and get the tone
		ToneAnalysis tone = service.getTone(text, null).execute();

		ToneInfo toneInfo = new ToneInfo();
		
		// Fill tone info
		toneInfo.setEmotionTones(
				tone.getDocumentTone().getTones().stream()
		        .filter(t -> t.getId().equals(TONE_CATEGORY_EMOTION)).collect(Collectors.toList()).get(0).getTones());

		toneInfo.setWritingTones(tone.getDocumentTone().getTones().stream()
		        .filter(t -> t.getId().equals(TONE_CATEGORY_WRITING)).collect(Collectors.toList()).get(0).getTones());

		toneInfo.setSocialTones(tone.getDocumentTone().getTones().stream()
		        .filter(t -> t.getId().equals(TONE_SOCIAL_EMOTION)).collect(Collectors.toList()).get(0).getTones());

		return toneInfo;
	}
}
