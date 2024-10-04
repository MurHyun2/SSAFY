package com.ssafy.exam.inquiry.model.service;

import com.ssafy.exam.inquiry.model.dto.Inquiry;

import java.sql.SQLException;
import java.util.List;

public interface InquiryService {
    void createInquiry(Inquiry inquiry) throws SQLException;
    List<Inquiry> getAllInquiries() throws SQLException;
    Inquiry getInquiryById(int inquiryId) throws SQLException;
    void updateInquiry(Inquiry inquiry) throws SQLException;
    void deleteInquiry(int inquiryId) throws SQLException;
}
