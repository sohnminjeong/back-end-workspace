/* 
	- 데이터(data) : 필요에 의해 수집했지만 아직 특정 목적을 위해 정제하지 않은 것
		vs 정보(info) : 수집한 데이터를 어떠한 목적을 위해 분석하거나 가공하여 새로운 의미 부여
	- 데이터베이스 : 데이터(data) + 베이스(base)
    - DBMS : Database Management System의 약자, 데이터베이스 관리 시스템

	- 관계형(Relational) 데이터베이스
	   1. 가장 대표적인 데이터베이스 시스템
       2. 데이터를 테이블 형태로 저장하고 여러 테이블을 조합하여 비즈니스 관계를 도출하는 구조
       3. 데이터의 중복을 최소화할 수 있으며 사용하기 편리하고 
		  데이터의 무결성, 트랜잭션 처리 등 데이터베이스 관리 시스템으로 뛰어난 성능을 보여준다.

	- SQL(Structured Query Language)
		: 관계형 데이터베이스에서 데이터를 조회하거나 조작하기 위해 사용하는 표준 검색 언어
        
	- SQL 종류
	  1. DML(Data Manipulation Language) : 데이터 조작어
		 - 실제 데이터를 조작하기 위해 사용하는 언어
		   (INSERT : 추가, UPDATE : 수정, DELETE : 삭제)
	  2. DQL(Data Query LanguagE) : 데이터 질의어
		 - 데이터를 조회(검색)하기 위해 사용 하는 언어 (SELECT : 조회)
*/

/*
		SELECT 컬럼, [컬럼, ....]
        FROM 테이블명;
        
        - 테이블에서 데이터를 조회할 때 사용하는 SQL문
        - SELECT를 통해서 조회된 결과를 RESULT SET이라고 한다.
		  (즉, 조회된 행들의 집합)
		- 조회하고자 하는 컬럼들은 반드시 FROM 절에 기술한 테이블에 존재하는 컬럼이어야 한다.
        - 모든 컬럼을 조회할 경우 컬럼명 대신 * 기호 사용
*/

-- employee 테이블에 전체 사원의 모든 컬럼(*) 정보 조회
SELECT *
FROM employee;

-- employee 테이블의 전체 사원들의 사번(emp_id), 이름(emp_name), 급여(salary) 만을 조회
SELECT emp_id, emp_name, salary
FROM employee;

-- 관례상 대문자로 작성
select emp_id, emp_name, salary
from employee;

-- 실습문제 --------------------------
-- 1. job 테이블의 모든 정보 조회
SELECT *
FROM job;
-- 2. job 테이블의 직급 이름(job_name) 조회
SELECT job_name
FROM job;
-- 3. department 테이블의 모든 정보 조회
SELECT *
FROM department;
-- 4. employee 테이블의 직원명(emp_name), 이메일(email), 전화번호(phone), 입사일(hire_date) 정보만 조회
SELECT emp_name, email, phone, hire_date
FROM employee;
-- 5. employee 테이블의 입사일, 직원명, 급여 조회
SELECT hire_date, emp_name, salary
FROM employee;

/*
	컬럼 산술 연산
    - SELECT 절에 컬럼명 입력 부분에 
	  산술연산자를 사용하여 결과를 조회할 수 있다. 
*/
-- employee 테이블에서 직원명(emp_name), 직원 연봉(salary*12) 조회
SELECT emp_name, salary, salary * 12
FROM employee;

/*
	컬럼 별칭
    컬럼 as 별칭 / 컬럼 as "별칭" / 컬럼 별칭 / 컬럼 "별칭"
    
    - 산술연산을 하면 컬럼명이 지저분해진다.
	  이때 컬럼명에 별칭을 부여해서 깔끔하게 보여줄 수 있다.
	- 별칭을 부여할 때 띄어쓰기 혹은 특수문자가 포함될 경우
	  반드시 큰따옴표(")로 감싸줘야 한다.
*/
-- employee 테이블에서 직원명(emp_name), 직원 연봉(salary*12) 조회
SELECT emp_name as 직원명, salary 월급, salary * 12 as "연봉"
FROM employee;

/*
	리터럴
    - SELECT 절에 리터럴을 사용하면 테이블에 존재하는 데이터처럼 조회가 가능
*/
-- employee 테이블에서 사번(emp_id), 직원명(emp_name), 급여(salary), 단위(원) 조회
SELECT 
	emp_id 사번, emp_name 직원명, salary 급여, '원' as "단위(원)"
FROM employee;

/*
	DISTINCT
    - 컬럼에 중복된 값들을 한번씩만 표시하고자 할 때 사용
*/
-- employee 테이블에 직급코드(job_code) 조회
SELECT DISTINCT job_code 직급코드
FROM employee;

-- employee 테이블에 부서코드(dept_code) 조회
SELECT DISTINCT dept_code 부서코드
FROM employee;

-- 유의사항! DISTINCT는 SELECT절에 딱 한번만 기술 가능 
SELECT DISTINCT job_code, dpet_code
FROM employee;

/*
	WHERE 절
    
    SELECT 컬럼, 컬럼, ....
    FROM 테이블명
    WHERE 조건식;
    
    - 조회하고자 하는 테이블로부터 특정 조건에 만족하는 데이터만 조회하고자 할 때 사용
    - 이때 WHERE 절에 조건식을 제시
    - 조건식에는 다양한 연산자를 사용 가능!
    
    비교 연산자
    >, <, >=, <= : 대소 비교
    =            : 같은지 비교
    !=, ^=, <>   : 같지 않은지 비교
*/
-- employee에서 부서코드(dept_code)가 'D9'인 사원들만 조회 (이때, 모든 컬럼 조회)
SELECT *
FROM employee
WHERE  dept_code = 'D9';

-- 실습문제 --------------------------------------------------------
-- 1. employee에서 부서코드(dept_code)가 'D1'인 사원들의 사원명(emp_name), 급여(salary), 부서코드만 조회
SELECT emp_name, salary, dept_code
FROM employee
WHERE dept_code = 'D1';
-- 2. employee에서 부서코드가 'D1'이 아닌 사원들의 사번(emp_id), 사원명(emp_name), 부서코드 조회
SELECT emp_id, emp_name, dept_code
FROM employee
WHERE dept_code != 'D1';
-- 3. 급여가 400만원 이상인 사원들의 사원명, 부서코드, 급여 조회
SELECT emp_name, dept_code, salary
FROM employee
WHERE salary >= 4000000;
-- 4. 재직중(ent_yn 컬럼값이 'N')인 사원들의 사번, 사원명, 입사일(hire_date) 조회
SELECT emp_id, emp_name, hire_date
FROM employee
WHERE ent_yn = 'N';