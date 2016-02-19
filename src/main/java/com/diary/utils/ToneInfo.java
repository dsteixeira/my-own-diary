package com.diary.utils;

import java.io.Serializable;
import java.util.List;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneScore;

public class ToneInfo implements Serializable {

	private static final long serialVersionUID = -8539484097936817544L;

	private List<ToneScore> emotionTones;
	private List<ToneScore> writingTones;
	private List<ToneScore> socialTones;

	public List<ToneScore> getEmotionTones() {
		return emotionTones;
	}

	public void setEmotionTones(List<ToneScore> emotionTones) {
		this.emotionTones = emotionTones;
	}

	public List<ToneScore> getWritingTones() {
		return writingTones;
	}

	public void setWritingTones(List<ToneScore> writingTones) {
		this.writingTones = writingTones;
	}

	public List<ToneScore> getSocialTones() {
		return socialTones;
	}

	public void setSocialTones(List<ToneScore> socialTones) {
		this.socialTones = socialTones;
	}
}