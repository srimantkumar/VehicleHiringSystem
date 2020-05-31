package com.infinte.vehiclehiringsystem.service;

import java.util.List;

import com.infinte.vehiclehiringsystem.bean.Feedback;

public interface FeedbackService {
	public String insertFeedback(Feedback feedback);

	public String deleteFeedback(int fid);

	public String getFeedback(int fid);

	public String updateFeedBack(int fid);

	public List<Feedback> getAllFeedback();


}
