package com.ssafy.exam.inquiry.model.service;

import com.ssafy.exam.inquiry.model.dao.InquiryDAO;
import com.ssafy.exam.inquiry.model.dao.InquiryDAOImpl;
import com.ssafy.exam.inquiry.model.dto.Inquiry;

import java.sql.SQLException;
import java.util.List;

public class InquiryServiceImpl implements InquiryService {
    private InquiryDAO inquiryDAO;

    public InquiryServiceImpl() {
        this.inquiryDAO = new InquiryDAOImpl();
    }

    @Override
    public void createInquiry(Inquiry inquiry) throws SQLException {
        inquiryDAO.createInquiry(inquiry);
    }

    @Override
    public List<Inquiry> getAllInquiries() throws SQLException {
        return inquiryDAO.getAllInquiries();
    }

    @Override
    public Inquiry getInquiryById(int inquiryId) throws SQLException {
        return inquiryDAO.getInquiryById(inquiryId);
    }

    @Override
    public void updateInquiry(Inquiry inquiry) throws SQLException {
        inquiryDAO.updateInquiry(inquiry);
    }

    @Override
    public void deleteInquiry(int inquiryId) throws SQLException {
        inquiryDAO.deleteInquiry(inquiryId);
    }
}
