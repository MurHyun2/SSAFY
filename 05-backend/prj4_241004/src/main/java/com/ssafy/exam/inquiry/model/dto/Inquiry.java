package com.ssafy.exam.inquiry.model.dto;

public class Inquiry {
    private int inquiryId;
    private String memberId;
    private String title;
    private String message;
    private String createdAt;
    private String status;

    // 기본 생성자
    public Inquiry() {}

    // 모든 필드를 포함하는 생성자
    public Inquiry(int inquiryId, String memberId, String title, String message, String createdAt, String status) {
        this.inquiryId = inquiryId;
        this.memberId = memberId;
        this.title = title;
        this.message = message;
        this.createdAt = createdAt;
        this.status = status;
    }

    // Getter & Setter 메서드
    public int getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(int inquiryId) {
        this.inquiryId = inquiryId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "InquiryDTO{" +
                "inquiryId=" + inquiryId +
                ", memberId='" + memberId + '\'' +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
