create table apt_deal
(
    SEQ       int(30) auto_increment primary key,
    LAWD_CD   varchar(10)    not null,
    ZIP       varchar(30)    not null,
    DEAL_YEAR int(6)         not null,
    DEAL_MON  int(4)         not null,
    DEAL_DAY  varchar(10)    null,
    PRICE     varchar(15)    null,
    APT_NAME  varchar(50)    null,
    APT_FLOOR varchar(20)    null,
    APT_SIZE  decimal(12, 5) null,
    APT_FOUND varchar(10)    null,
    DONG      varchar(30)    null,
    REGDATE   datetime       null,
    MODDATE   datetime       null,
    USER_ID   varchar(20)    null
);

create table apt_lawd
(
    LAWD_CD varchar(10) not null,
    LAWD_NM varchar(20) not null,
    USE_YN  varchar(10) null
);

INSERT INTO apt.apt_lawd (LAWD_CD, LAWD_NM, USE_YN) VALUES ('11110', '종로구', null);
INSERT INTO apt.apt_lawd (LAWD_CD, LAWD_NM, USE_YN) VALUES ('11140', '중구', null);
INSERT INTO apt.apt_lawd (LAWD_CD, LAWD_NM, USE_YN) VALUES ('11170', '용산구', null);
INSERT INTO apt.apt_lawd (LAWD_CD, LAWD_NM, USE_YN) VALUES ('11200', '성동구', null);
INSERT INTO apt.apt_lawd (LAWD_CD, LAWD_NM, USE_YN) VALUES ('11215', '광진구', null);
INSERT INTO apt.apt_lawd (LAWD_CD, LAWD_NM, USE_YN) VALUES ('11230', '동대문구', null);
INSERT INTO apt.apt_lawd (LAWD_CD, LAWD_NM, USE_YN) VALUES ('11260', '중랑구', null);
INSERT INTO apt.apt_lawd (LAWD_CD, LAWD_NM, USE_YN) VALUES ('11290', '성북구', null);
INSERT INTO apt.apt_lawd (LAWD_CD, LAWD_NM, USE_YN) VALUES ('11305', '강북구', null);
INSERT INTO apt.apt_lawd (LAWD_CD, LAWD_NM, USE_YN) VALUES ('11320', '도봉구', null);
INSERT INTO apt.apt_lawd (LAWD_CD, LAWD_NM, USE_YN) VALUES ('11350', '노원구', null);
INSERT INTO apt.apt_lawd (LAWD_CD, LAWD_NM, USE_YN) VALUES ('11380', '은평구', null);
INSERT INTO apt.apt_lawd (LAWD_CD, LAWD_NM, USE_YN) VALUES ('11410', '서대문구', null);
INSERT INTO apt.apt_lawd (LAWD_CD, LAWD_NM, USE_YN) VALUES ('11440', '마포구', null);
INSERT INTO apt.apt_lawd (LAWD_CD, LAWD_NM, USE_YN) VALUES ('11470', '양천구', null);
INSERT INTO apt.apt_lawd (LAWD_CD, LAWD_NM, USE_YN) VALUES ('11500', '강서구', null);
INSERT INTO apt.apt_lawd (LAWD_CD, LAWD_NM, USE_YN) VALUES ('11530', '구로구', null);
INSERT INTO apt.apt_lawd (LAWD_CD, LAWD_NM, USE_YN) VALUES ('11545', '금천구', null);
INSERT INTO apt.apt_lawd (LAWD_CD, LAWD_NM, USE_YN) VALUES ('11560', '영등포구', null);
INSERT INTO apt.apt_lawd (LAWD_CD, LAWD_NM, USE_YN) VALUES ('11590', '동작구', null);
INSERT INTO apt.apt_lawd (LAWD_CD, LAWD_NM, USE_YN) VALUES ('11620', '관악구', null);
INSERT INTO apt.apt_lawd (LAWD_CD, LAWD_NM, USE_YN) VALUES ('11650', '서초구', null);
INSERT INTO apt.apt_lawd (LAWD_CD, LAWD_NM, USE_YN) VALUES ('11680', '강남구', null);
INSERT INTO apt.apt_lawd (LAWD_CD, LAWD_NM, USE_YN) VALUES ('11710', '송파구', null);
INSERT INTO apt.apt_lawd (LAWD_CD, LAWD_NM, USE_YN) VALUES ('11740', '강동구', null);