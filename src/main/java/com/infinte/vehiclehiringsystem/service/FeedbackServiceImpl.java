package com.infinte.vehiclehiringsystem.service;

import java.util.List;

import com.infinte.vehiclehiringsystem.bean.Feedback;
import com.infinte.vehiclehiringsystem.dao.FeedbackDAO;
import com.infinte.vehiclehiringsystem.dao.FeedbackDAOImpl;

public class FeedbackServiceImpl implements FeedbackService {
	FeedbackDAO feedbackDAO = new FeedbackDAOImpl();

	public String insertFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		return feedbackDAO.insertFeedback(feedback);
	}

	public String deleteFeedback(int fid) {
		// TODO Auto-generated method stub
		return feedbackDAO.deleteFeedback(fid);
	}

	public String getFeedback(int fid) {
		// TODO Auto-generated method stub
		return feedbackDAO.getFeedback(fid);
	}

	public String updateFeedBack(int fid) {
		// TODO Auto-generated method stub
		return feedbackDAO.updateFeedBack(fid);
	}

	public List<Feedback> getAllFeedback() {
		// TODO Auto-generated method stub
		return feedbackDAO.getAllFeedback();
	}

}
