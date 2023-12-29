/*
	서브쿼리(SUBQUERY), 중첩쿼리
    - 하나의 SQL문 안에 포함된 또 달느 SQL문
    - 서브쿼리를 수행한 결과값이 몇 행 몇 열이냐에 따라 분류
    - 서브쿼리 종류에 따라 서브쿼리와 사용하는 연산자가 달라짐
    
    1. 단일행 서브쿼리 (SINGLE ROW SUBQUERY)
    - 서브쿼리의 조회 결과값의 개수가 오로지 1개일 때 (한 행 한 열)
    - 일반 비교연산자 사용 가능 : =, !=, <>, >, < >=, <=, ...
*/
-- 노옹철 사원과 같은 부서원들을 조회
-- 1) 노옹철 사원의 부서코드 조회
SELECT dept_code
FROM employee
WHERE emp_name = '노옹철';   -- D9

-- 2) 부서코드가 D9인 사원 조회
SELECT emp_name
FROM employee 
WHERE dept_code = 'D9';    -- 선동일, 송종기, 노옹철 

-- 3) 위의 2단계를 하나의 쿼리문으로!
SELECT emp_name
FROM employee 
WHERE dept_code = (SELECT dept_code
					FROM employee
					WHERE emp_name = '노옹철');
                    
-- 전 직원의 평균 급여보다 더 많은 급여를 받는 사원들의 사번, 사원명, 직급코드, 급여 조회
SELECT emp_id, emp_name, dept_code, salary
FROM employee
WHERE salary > (SELECT avg(salary)
				FROM employee);

-- 최저 급여를 받는 사원의 사번, 이름, 직급 코드, 급여, 입사일 조회
SELECT emp_id, emp_name, dept_code, salary, hire_date
FROM employee
WHERE salary = (SELECT min(salary)
				FROM employee);

-- 전지연 사원이 속해있는 부서원들의 사번, 직원명, 전화번호, 직급명, 부서명, 입사일 조회
-- 단, 전지연 사원은 제외 
SELECT emp_id, emp_name, phone, job_name, dept_title, hire_date
FROM employee
JOIN department ON(dept_code = dept_id)
JOIN job USING(job_code)
WHERE dept_code
	= (SELECT dept_code
		FROM employee
		WHERE emp_name = '전지연') AND emp_name != '전지연';
        
-- 부서별 급여의 합이 가장 큰 부서의 부서 코드, 급여의 합을 조회
SELECT dept_code, sum(salary)
FROM employee
GROUP BY dept_code
ORDER BY 2 desc
LIMIT 1;

-- 서브쿼리 사용!
SELECT dept_code, sum(salary) sum_sal
FROM employee
GROUP BY dept_code;   -- >> 결과값이 테이블! 

-- 부서별 합이 가장 큰 값
SELECT max(sum_sal)
FROM (SELECT dept_code, sum(salary) sum_sal
	  FROM employee
	  GROUP BY dept_code) as dept_sum;

-- 합치기 
SELECT dept_code, sum(salary)
FROM employee
GROUP BY dept_code
HAVING sum(salary) = (SELECT max(sum_sal)
					  FROM (SELECT dept_code, sum(salary) sum_sal
							FROM employee
							GROUP BY dept_code) as dept_sum);

/*
	2. 다중행 서브쿼리
    - 서브쿼리의 조회 결과 값의 개수가 여러 행 일 때 (여러행 한열)
    
    IN 서브쿼리 : 여러개의 결과값 중에서 한 개라도 일치하는 값이 있다면 
*/
-- 각 부서별 최고 급여를 받는 직원의 이름, 직급코드, 부서코드, 급여 조회
-- 각 부서별 최고 급여 조회 (조건)
SELECT dept_code, max(salary) 
FROM employee
GROUP BY dept_code;

-- 위의 값들을 받은 직원의 이름, 직급코드, 부서코드, 급여 조회
SELECT emp_name, job_code, dept_code, salary
FROM employee
WHERE salary IN (SELECT max(salary)
				 FROM employee
				 GROUP BY dept_code);

-- 직원에 대해 사번, 이름, 부서코드, 구분(사수/사원) 조회
SELECT * from employee;

SELECT emp_id, emp_name, dept_code, if(manager_id is not null,'사원', '사수')구분
FROM employee;
-- 200사수, 201사수, 202 사원, 203 사원, 204 사수, 205 사원, 206 사원, 207 사수, 211, 214사수 나머지 사원

-- 사수 테이블 조회
SELECT emp_id, emp_name, dept_code, '사수' AS '구분'
FROM employee
WHERE emp_id 
iN(select distinct(manager_id)
FROM employee
WHERE manager_id IS NOT NULL)

UNION

-- 사원 테이블 조회
SELECT emp_id, emp_name, dept_code, '사원' AS '구분'
FROM employee
WHERE emp_id 
 NOT iN(select distinct(manager_id)
FROM employee
WHERE manager_id IS NOT NULL)
ORDER BY 1;

-- >> 오로지 서브쿼리로만 사용하는 방법! 힌트 : SELECT절에서도 서브쿼리를 사용할 수 있다
-- >> if~
SELECT 
	emp_id, emp_name, dept_code, 
    if(emp_id iN(select distinct manager_id
				FROM employee
				WHERE manager_id IS NOT NULL), '사수', '사원') 구분
FROM employee;

-- >> case~
SELECT 
	emp_id, emp_name, dept_code, 
   CASE
		WHEN emp_id iN(select distinct manager_id
						FROM employee
						WHERE manager_id IS NOT NULL) THEN '사수'
		ELSE '사원'
        END '구분'
FROM employee;

/*
	컬럼 > ANY (서브쿼리) : 여러개의 결과값 중에서 "한개라도" 클 경우
							(여러개의 결과값 중에서 가장 작은 값보다 클 경우)
	컬럼 < ANY (서브쿼리) : 여러개의 결과값 중에서 "한개라도" 작을 경우 
							(여러개의 결과값 중에서 가장 큰 값보다 작을 경우)
	--> OR
*/
-- 대리 직금임에도 과장 직급들의 최소 급여보다 많이 받는 직원의 사번, 이름, 직급, 급여 조회
SELECT emp_id, emp_name, job_name, salary
FROM employee
	JOIN job USING (job_code)
WHERE job_name = '대리' AND salary > ANY(
										SELECT min(salary)
										FROM employee
											JOIN job USING(job_code)
										WHERE job_name = '과장'
                                        );
-- salary > 2200000 OR salary > 2500000 OR salary > 3760000

/*
	컬럼 > ALL (서브쿼리) : 여러개의 "모든" 결과값들 보다 클 경우
    컬럼 < ALL (서브쿼리) : 여러개의 "모든" 결과값들 보다 작을 경우 
    --> AND 
*/
-- 과장 직급임에도 차장 직급의 최대 급여보다 더 많이 받는 직원들의 사번, 이름, 직급, 급여 조회
-- >> ANY를 쓴 경우
SELECT emp_id, emp_name, job_name, salary
FROM employee
	JOIN job USING (job_code)
WHERE job_name = '과장' 
AND salary > ANY(
SELECT max(salary)
FROM employee
	JOIN job USING(job_code)
WHERE job_name = '차장'
);

-- >> ALL을 쓴 경우
SELECT emp_id, emp_name, job_name, salary
FROM employee
	JOIN JOB USING (job_code)
WHERE job_name = '과장' 
AND salary > ALL (
SELECT salary 
FROM employee 
	JOIN job USING(job_code) 
WHERE job_name='차장');

/*
	3. 다중열 서브쿼리
		- 서브쿼리의 조회 결과값이 한 행이지만 컬럼이 여러개일 때 (한 행 여러 열)
*/
-- 하이유 사원과 같은 부서 코드, 같은 직급 코드에 해당하는 사원들의 사원명, 부서코드, 직급 코드 조회
SELECT emp_name, dept_code, job_code
FROM employee
WHERE dept_code = (
SELECT dept_code
from employee
where emp_name='하이유'
) AND job_code = (SELECT job_code
from employee
where emp_name='하이유');

-- >> 다중열 서브쿼리로!
SELECT emp_name, dept_code, job_code
FROM employee
-- WHERE dept_code = 'D5' AND job_code = 'J5';
-- WHERE (dept_code, job_code) = (('D5', 'J5'));
WHERE (dept_code, job_code) = (SELECT dept_code, job_code
								from employee
								where emp_name='하이유');


-- 박나라 사원과 직급 코드가 일치하면서 같은 사수를 가지고 있는 사원의 사번, 이름, 직급 코드, 사수 사번 조회
SELECT emp_id, emp_name, job_code, manager_id
FROM employee
WHERE (job_code, manager_id) = (
SELECT job_code, manager_id
FROM employee
WHERE emp_name = '박나라'
);

/*
	4. 다중행 다중열 서브쿼리
		- 서브쿼리의 조회 결과값이 여러 행, 여러 열일 경우
*/
-- 각 직급별로 최소 급여를 받는 사원들의 사번, 이름, 직급코드, 급여 조회
SELECT emp_id, emp_name, job_code, salary
FROM employee
WHERE (job_code, salary) IN (
SELECT job_code, min(salary)
FROM employee
GROUP BY job_code
);


-- 각 부서별 최대 급여를 받는 사원들의 사번, 이름, 부서코드, 급여 조회 (부서없음 명시)
SELECT emp_id, emp_name, if(dept_code is not null, dept_code, '부서없음')'dept_code', salary
FROM employee
WHERE (if (dept_code is not null, dept_code , "부서없음"), salary) IN (
SELECT if (dept_code is not null, dept_code , "부서없음"), max(salary)
FROM employee
GROUP BY dept_code
);
-- if 대신 ifnull(dept_code, '부서없음')으로도 표시 가능

/*
	RANK 함수 
    - RANK() OVER (정렬 기준) : 동일한 순위 이후의 등수를 동일한 인원수만큼 건너뛰고 순위를 계산한다.
								(ex. 공동 1위가 2명이면 다음 순위는 3위)
    - DENSE_RANK() OVER (정렬 기준) : 동일한 순위 이후의 등수를 무조건 1씩 증가한다.
								(ex. 공동 1위가 2명이면 다음 순위는 2위)
*/
-- 사원별 급여가 높은 순서대로 순위 매겨서 순위, 사원명, 급여 조회
SELECT rank() over(ORDER BY salary DESC) '순위', emp_name, salary
FROM employee;

-- 1~10위까지만!
SELECT 
	DENSE_RANK() OVER(ORDER BY salary DESC) '순위', emp_name, salary
FROM employee
LIMIT 10;    -- LIMIT은 MySQL만 가능 



-- 얘는 서브쿼리 다 배우고 나서 할 말
-- 서브쿼리 특징! 쿼리 자체는 직관적!
-- 쿼리 속도를 중요시! 서브쿼리는 느려요`~
-- 가급적으로 서브쿼리를 사용하지 않아도 되는거면 안쓰고 하시는 걸 추천!
