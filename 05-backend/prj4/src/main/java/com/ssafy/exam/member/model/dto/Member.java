package com.ssafy.exam.member.model.dto;

public class Member {
    private String id;
    private String password;
    private String name;
    private String nickName;
    private String phoneNum;
    private String addrNum;
    private String addBasic;
    private String addrDetail;

   
    public Member() {}

    
    public Member(String id, String password, String name, String nickName, String phoneNum, String addrNum, String addBasic, String addrDetail) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.nickName = nickName;
        this.phoneNum = phoneNum;
        this.addrNum = addrNum;
        this.addBasic = addBasic;
        this.addrDetail = addrDetail;
    }

   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddrNum() {
        return addrNum;
    }

    public void setAddrNum(String addrNum) {
        this.addrNum = addrNum;
    }

    public String getAddBasic() {
        return addBasic;
    }

    public void setAddBasic(String addBasic) {
        this.addBasic = addBasic;
    }

    public String getAddrDetail() {
        return addrDetail;
    }

    public void setAddrDetail(String addrDetail) {
        this.addrDetail = addrDetail;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", addrNum='" + addrNum + '\'' +
                ", addBasic='" + addBasic + '\'' +
                ", addrDetail='" + addrDetail + '\'' +
                '}';
    }
}
