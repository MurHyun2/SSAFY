CREATE DATABASE prj4;

USE prj4;

CREATE TABLE Video(
	video_no INT PRIMARY KEY AUTO_INCREMENT,
    video_URL VARCHAR(300) UNIQUE,
    video_title VARCHAR(50),
    category VARCHAR(50),
    part VARCHAR(50),
    channel_name VARCHAR(50)
);

CREATE TABLE Review(
	review_no int PRIMARY KEY AUTO_INCREMENT,
    video_no INT,
    review_content VARCHAR(50),
    writer VARCHAR(50),
    view_cnt INT DEFAULT 0,
    reg_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (video_no) REFERENCES Video(video_no)
);

CREATE TABLE Member(
	id VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50),
    name VARCHAR(50),
    nick_name VARCHAR(50) UNIQUE,
    phone_num VARCHAR(15) UNIQUE,
    addr_num CHAR(5),
    addr_basic VARCHAR(50),
    addr_detail VARCHAR(50)
);

INSERT INTO Video 
VALUES
(1, "https://www.youtube.com/embed/50WCSpZtdmA?si=YYrQCe5tfK7FBNs9", "심으뜸 매일 아침 10분 스트레칭", "요가", "전신", "심으뜸"),
(2, "https://www.youtube.com/embed/Kk7TQGqQ3nA?si=9naoHt8kGsxpLuHi", "하루 두 번🧘🏻‍♀️반드시 해야하는 20분 전신순환 스트레칭", "요가", "전신", "빵느"),
(3, "https://www.youtube.com/embed/D3yExRi7EME?si=BoWbkjhRG096F_Ip", "뭉친 어깨, 뻣뻣한 골반 풀어주는 요가", "요가", "전신", "에일린"),
(4, "https://www.youtube.com/embed/02K-k6daPb4?si=xKoo3YEocujZ6LcF", "빠르게 칼로리 버닝 - 서서하는 유산소 - 다이어트 운동", "유산소", "전신", "빅씨스 Bigsis"),
(5, "https://www.youtube.com/embed/swRNeYw1JkY?si=Fl2gaE1QjrnJLsgf", "하루 15분! 전신 칼로리 불태우는 다이어트 운동", "유산소", "전신", "ThankyouBUBU"),
(6, "https://www.youtube.com/embed/gMaB-fG4u4g?si=tPZehYaEmT-rwMA7", "전신 다이어트 최고의 운동 [칼소폭 찐 핵핵 매운맛]", "유산소", "전신", "ThankyouBUBU"),
(7, "https://www.youtube.com/embed/KXYi6bI-UPE?si=SKfraEr1DNE0myff", "Lv.5 13분만에 하체 마비시키는 루틴! 근육통100% 옵니다.", "근력운동", "하체", "권혁TV"),
(8, "https://www.youtube.com/embed/uTmsvZOAh5U?si=yI-7mMTroNORvT6j", "Lv.3 8분만에 상체전체를 탈탈 털어버리는 홈트루틴", "근력운동", "상체", "권혁TV"),
(9, "https://www.youtube.com/embed/DJPBglSOC88?si=jWur4cPrYtHU1q9s", "Lv.4.5 10가지 푸쉬업으로 10분안에 가슴완성하기! ", "근력운동", "상체", "권혁TV"),
(10, "https://www.youtube.com/embed/DWYDL-WxF1U?si=6onTqiz4XEcCLMAh", "하체 날, 딱 10분 밖에 없다면 - 스쿼트 10가지 동작 - 하체운동 홈트 루틴", "근력운동", "하체", "빅씨스 Bigsis");

INSERT INTO Review
VALUES(1, 1, "정말 좋아요", "김싸피", 0, current_timestamp());

INSERT INTO Member
VALUES("ssafy", "ssafy", "김띵균", "김싸피", "01012341234", 15321, "대전시 유성구 구암동", "빌라 301호"),
("admin", "admin", "종경대", "어드민", "01098765432", 13211, "대전시 유성구 궁동", "빌라 101호");

SELECT * FROM Video;
SELECT * FROM Review;
SELECT * FROM Member;

COMMIT;