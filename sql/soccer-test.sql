--001. 전제 축구팀 목록을 팀이름 오름차순으로 출력하시오
select team_name,region_name  from team order by team_name asc;
-- 002. 플레이어 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 빈 공간으로 두시오
SELECT DISTINCT POSITION from player;
--003. 플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 '신입'으로 기재하시오
-- 문제 6
-- 다음 조건을 만족하는 선수명단을 출력하시오
-- 소속팀이 삼성블루윙즈이거나
-- 드래곤즈에 소속된 선수들이어야 하고,
-- 포지션이 미드필더(MF:Midfielder)이어야 한다.
-- 키는 170 센티미터 이상이고 180 이하여야 한다.
SELECT player.player_name
FROM player
WHERE team_id IN (SELECT team_id
               FROM team
               WHERE team_name = '삼성블루윙즈' OR '드래곤즈')
    AND  POSITION = 'MF' AND height >= 170 AND height <=180;
-- 문제 7-- 수원을 연고지로 하는 골키퍼는 누구인가?
select player.player_name
FROM player
where team_id=(select team_id
               FROM team
               WHERE region_name = '수원') and POSITION = 'GK';
-- 문제 8-- 서울팀 선수들 이름, 키, 몸무게 목록으로 출력하시오-- 키와 몸무게가 없으면 "0" 으로 표시하시오-- 키와 몸무게는 내림차순으로 정렬하시오
SELECT player.player_name,IFNULL(NULLIF(player.height,''),0), IFNULL(NULLIF(player.weight,''),0)
FROM player ORDER BY player.height DESC ,weight DESC ;
-- 문제 9-- 서울팀 선수들 이름과 포지션과-- 키(cm표시)와 몸무게(kg표시)와  각 선수의 BMI지수를 출력하시오-- 단, 키와 몸무게가 없으면 "0" 표시하시오-- BMI는 "NONE" 으로 표시하시오(as bmi)-- 최종 결과는 이름내림차순으로 정렬하시오
SELECT player.player_name,IFNULL(NULLIF(CONCAT(player.height,'CM'),'CM'),'0') height
     ,IFNULL(NULLIF(CONCAT(player.weight,'KG'),'KG'),0) weight,IFNULL(height/((player.weight*player.weight)*100),"NONE")AS BMI
FROM player ORDER BY player.height desc , weight desc ;
WHERE team_id=(select team_id
               FROM team
               WHERE team_name = 'FC서울');
-- full scan
-- 4개의 테이블을 모두 조인하시오

SELECT COUNT(*) count
from stadium s
    join team t on s.stadium_id=t.stadium_id
    join player p on t.team_id=p.team_id
    join SCHEDULE sc on s.stadium_id = sc.stadium_id

-- 문제 10
-- 수원팀(K02) 과 대전팀(K10) 선수들 중 포지션이 골키퍼(GK) 인
-- 선수를 출력하시오
-- 단 , 팀명, 선수명 오름차순 정렬하시오
SELECT team_name , player_name
FROM team t
         join player p on t.team_id =p.team_id
where region_name = '수원' or region_name = '대전' and POSITION = 'GK'
order by team_name asc , player_name asc;

-- 문제 11
-- 팀과 연고지를 연결해서 출력하시오
-- [팀 명]             [홈구장]
-- 수원[ ]삼성블루윙즈 수원월드컵경기장
select concat(region_name,space(1),team_name,space(1),stadium_name)
from stadium s
         join team t on s.stadium_id = t.stadium_id;
-- 문제 12
-- 수원팀(K02) 과 대전팀(K10) 선수들 중
-- 키가 180 이상 183 이하인 선수들
-- 키, 팀명, 사람명 오름차순
select height,team_name,player_name,region_name
from team t
         join player p on t.team_id = p.team_id
where (region_name = '수원' or region_name = '대전') and height >= 180 and height <= 183
order by height desc , team_name desc , player_name desc ;
-- 문제 13
-- 모든 선수들 중 포지션을 배정 받지 못한 선수들의
-- 팀명과 선수이름 출력 둘다 오름차
select team_name,player_name,POSITION
from team t
         join player p on t.team_id = p.team_id
where POSITION = ''
order by player_name desc , team_name desc;

스칼라와 조인  사용
 -- 문제 14
-- 팀과 스타디움, 스케줄을 조인하여
-- 2012년 3월 17일에 열린 각 경기의
-- 팀이름, 스타디움, 어웨이팀 이름 출력
-- 다중테이블 join 을 찾아서 해결하시오.

select stadium_name,(select t.team_name
                     from team t
                     where t.team_id = sc.hometeam_id)HOMETEAM,(select t.team_name
                                                                from team t
                                                                where t.team_id = awayteam_id) AWAYTEAM
from stadium s

         join schedule sc on s.stadium_id = sc.stadium_id
where sche_date='20120317';

-- 문제 15
-- 2012년 3월 17일 경기에
-- 포항 스틸러스 소속 골키퍼(GK)
-- 선수, 포지션,팀명 (연고지포함),
-- 스타디움, 경기날짜를 구하시오
-- 연고지와 팀이름은 간격을 띄우시오(수원[]삼성블루윙즈)
select player_name,POSITION,concat(region_name,space(1),team_name),stadium_name,sche_date
from stadium s
         join team t on s.stadium_id = t.stadium_id
         join player p on t.team_id = p.team_id
         join schedule sc on s.stadium_id = sc.stadium_id
where sche_date = '20120317' and POSITION = 'GK' and team_name = '스틸러스';


-- 문제 16
-- 홈팀이 3점이상 차이로 승리한 경기의
-- 경기장 이름, 경기 일정
-- 홈팀 이름과 원정팀 이름을
-- 구하시오
select stadium_name, sche_date,(select team_name
                                from team t
                                where t.team_id = sc.hometeam_id)HOMETEAM,(select team_name
                                                                           from team t
                                                                           where t.team_id = sc.awayteam_id)AWAYTEAM
from stadium s
         join schedule sc on s.stadium_id = sc.stadium_id
where (home_score - away_score ='3');
-- 문제 17
-- STADIUM 에 등록된 운동장 중에서
-- 홈팀이 없는 경기장까지 전부 나오도록
-- 카운트 값은 19
-- 힌트 : LEFT JOIN 사용해야함
-- 경기장 이름, 홈팀(없을경우 null)
SELECT stadium_name, (select t.team_name
                      from team t
                      where team_id=hometeam_id)
from stadium;

-- 문제 18 페이지 네이션 로직을 위한플레이어 테이블에서 최상단 5개 로우를 출력
select * from player
    order By 1 limit 0,5;
-- 문제 19 (그룹바이: 집계함수 - 딱 5개 min, max, count, sum, avg)
-- 평균키가 인천 유나이티스팀('K04')의 평균키  보다 작은 팀의
-- 팀ID, 팀명, 평균키 추출
-- 인천 유나이티스팀의 평균키 -- 176.59
-- 키와 몸무게가 없는 칸은 0 값으로 처리한 후 평균값에
-- 포함되지 않도록 하세요.
/*CASE WHEN p.height = 0 THEN NULL ELSE p.height END*/
/*select t.team_id,t.team_name,round(avg(IFNULL(NULLIF(p.height,''),0)),2)
from team t
         join player p on t.team_id=p.team_id
group by t.team_id
having avg(height) < 176.59;*/

select t.team_id,t.team_name,round(avg(NULLIF(p.height,'')),2)
from team t
         join player p on t.team_id=p.team_id
group by t.team_id
having avg(NULLIF(p.height,'')) < 176.59;
-- 문제 20
-- 포지션이 MF 인 선수들의 소속팀명 및  선수명, 백넘버 출력
select team_name,player_name,back_no
from team t
         join player p on t.team_id=p.team_id
where POSITION = 'MF';
-- 문제 21
-- 가장 키큰 선수 5명 소속팀명 및  선수명, 백넘버 출력,
-- 단 키  값이 없으면 제외
select team_name,player_name,back_no,height
from team t
         join player p on t.team_id=p.team_id
order by height desc
    limit 5; /*키값 없으면 제외 추가*/

-- 문제 22
-- 선수 자신이 속한 팀의 평균키보다 작은  선수 정보 출력
-- (select round(avg(height),2) from player)

-- 문제 23
-- 2012년 5월 한달간 경기가 있는 경기장  조회
select t.stadium_name
from stadium t
         join SCHEDULE sc on t.stadium_id = sc.stadium_id
where sc.sche_date LIKE '____05%';