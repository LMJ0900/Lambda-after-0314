-- Soccer JPA 버전

show tables;

CREATE TABLE board(
                      id INT NOT NULL AUTO_INCREMENT,
                      title VARCHAR(20) NOT NULL,
                      content VARCHAR(100) NULL,
                      writer VARCHAR(20) NOT NULL,
                      register_date  VARCHAR(20),
                      CONSTRAINT board_pk PRIMARY KEY(id)

);
CREATE TABLE members (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         member_name VARCHAR(20) NOT NULL,
                         password VARCHAR(20) NOT NULL,
                         name VARCHAR(20),
                         phone_number VARCHAR(20),
                         job VARCHAR(20),
                         height VARCHAR(20),
                         weight VARCHAR(20)
);

CREATE TABLE stadium(
                        id INT NOT NULL AUTO_INCREMENT,
                        stadium_name VARCHAR(40),
                        hometeam_id VARCHAR(10),
                        seat_count INT,
                        address VARCHAR(60),
                        ddd VARCHAR(10),
                        tel VARCHAR(10),
                        PRIMARY KEY (id)
);
CREATE TABLE schedule(
                         id INT NOT NULL AUTO_INCREMENT,
                         sche_date VARCHAR(10),
                         gubun VARCHAR(10),
                         hometeam_id VARCHAR(10),
                         awayteam_id VARCHAR(10),
                         home_score INT,
                         away_score INT,
                         stadium_id INT,
                         PRIMARY KEY (id),
                         FOREIGN KEY (stadium_id) REFERENCES stadium(id)
);
CREATE TABLE team(
                     id INT NOT NULL AUTO_INCREMENT,
                     region_name VARCHAR(10),
                     team_name VARCHAR(40),
                     e_team_name VARCHAR(50),
                     orig_yyyy VARCHAR(10),
                     zip_code1 VARCHAR(10),
                     zip_code2 VARCHAR(10),
                     address VARCHAR(80),
                     ddd VARCHAR(10),
                     tel VARCHAR(10),
                     fax VARCHAR(10),
                     homepage VARCHAR(50),
                     owner VARCHAR(10),
                     stadium_id INT,
                     PRIMARY KEY (id),
                     FOREIGN KEY (stadium_id) REFERENCES stadium(id)
);
CREATE TABLE player(
                       id INT NOT NULL AUTO_INCREMENT,
                       player_name VARCHAR(20),
                       e_player_name VARCHAR(20),
                       nickname VARCHAR(30),
                       join_yyyy VARCHAR(10),
                       position VARCHAR(10),
                       back_no INT,
                       nation VARCHAR(20),
                       birth_date DATE,
                       solar VARCHAR(10),
                       height INT,
                       weight INT,
                       team_id INT,
                       PRIMARY KEY (id),
                       FOREIGN KEY (team_id) REFERENCES team(id)
);

select * from members;
DROP TABLE player;
DROP TABLE schedule;
DROP TABLE team;
DROP TABLE stadium;








select * from board;
insert into articles(title, content,writer) values ('테스트 제목','테스트글','로드');
select * from articles;
rename table board to articles;
