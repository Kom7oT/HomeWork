-- 1.ошибки в расписании (фильмы накладываются друг на друга), 
-- отсортированные по возрастанию времени. Выводить надо колонки «фильм 1», 
-- «время начала», «длительность», «фильм 2», «время начала», «длительность»;

SELECT t1.title, t1.session_date, t1.session_time, t1.duration, t2.title, t2.session_date, t2.session_time, t2.duration 
FROM (
  SELECT s.id, s.hall_id, m.title, s.session_date, s.session_time, m.duration,
         TIMESTAMP(s.session_date, s.session_time) AS starts_at,
         TIMESTAMPADD(MINUTE, m.duration, TIMESTAMP(s.session_date, s.session_time)) AS ends_at
  FROM sessions s
  JOIN movies m ON s.movie_id = m.id) AS t1
JOIN (
  SELECT s.id, s.hall_id, m.title, s.session_date, s.session_time, m.duration, 
         TIMESTAMP(s.session_date, s.session_time) AS starts_at,
         TIMESTAMPADD(MINUTE, m.duration, TIMESTAMP(s.session_date, s.session_time)) AS ends_at
  FROM sessions s
  JOIN movies m ON s.movie_id = m.id) AS t2
WHERE t1.starts_at BETWEEN t2.starts_at AND t2.ends_at AND 
      t1.id <> t2.id AND
      t1.hall_id = t2.hall_id
ORDER BY t1.session_date ASC, t1.session_time ASC;

-- 2 Перерывы 30 минут и более между фильмами — выводить по уменьшению длительности перерыва. 
-- Колонки «фильм 1», «время начала», «длительность», «время начала второго фильма», «длительность перерыва»;

SELECT * 
FROM (
  WITH timestamps_table AS (
  SELECT s.id, s.hall_id, m.title, s.session_date, s.session_time, m.duration, 
         TIMESTAMP(s.session_date, s.session_time) AS starts_at,
         TIMESTAMPADD(MINUTE, m.duration, TIMESTAMP(s.session_date, s.session_time)) AS ends_at
  FROM sessions s
  JOIN movies m ON s.movie_id = m.id
  WHERE s.hall_id = @checked_hall_id
  ORDER BY s.session_date ASC, s.session_time ASC)
  SELECT tt.title, tt.starts_at, tt.duration,
       LEAD(starts_at, 1) OVER () next_session_starts_at,
       TIMESTAMPDIFF(MINUTE, ends_at, LEAD(starts_at, 1) OVER ()) minutes_between_sessions,
       CASE
           WHEN TIMESTAMPDIFF(MINUTE, ends_at, LEAD(starts_at, 1) OVER ()) < 0 
		        THEN 'Наложение сеансов'
           WHEN TIMESTAMPDIFF(MINUTE, ends_at, LEAD(starts_at, 1) OVER ()) = 0
                THEN 'Нет перерыва'
           WHEN TIMESTAMPDIFF(MINUTE, ends_at, LEAD(starts_at, 1) OVER ()) >= 30
                THEN 'Длинный перерыв'
       END AS error_comment
  FROM timestamps_table tt) AS result_table
  WHERE minutes_between_sessions <=0 OR minutes_between_sessions >=30;
  
  -- 3. список фильмов, для каждого — с указанием общего числа посетителей за все время, 
  -- среднего числа зрителей за сеанс и общей суммы сборов по каждому фильму (отсортировать по убыванию прибыли). 
  -- Внизу таблицы должна быть строчка «итого», содержащая данные по всем фильмам сразу;
  
  (WITH tmp AS (
  SELECT s.id, s.movie_id, SUM(p.price) total_sum, COUNT(t.id) viewers
  FROM tickets t
  JOIN sessions s ON s.id = t.session_id
  JOIN prices p ON s.id = p.session_id
  GROUP BY t.session_id)
SELECT m.title, SUM(viewers) total_viewers,
  FORMAT(AVG(viewers), 1) avg_per_session, 
  total_sum
FROM tmp
JOIN movies m ON m.id = tmp.movie_id 
GROUP BY movie_id
ORDER BY total_sum DESC)

UNION
SELECT 'TOTAL', SUM(viewers), FORMAT(AVG(viewers), 1), SUM(total_sum)
FROM tmp;

-- 4. число посетителей и кассовые сборы, сгруппированные по времени начала фильма: с 9 до 15, с 15 до 18, с 18 до 21, с 21 до 00:00 (сколько посетителей пришло с 9 до 15 часов и т.д.). 

SELECT m.title,
       SUM(CASE WHEN s.session_time >= "09:00:00" AND s.session_time < "15:00:00" THEN 1 ELSE 0 END) AS "09_15_viewers",
       SUM(CASE WHEN s.session_time >= "09:00:00" AND s.session_time < "15:00:00" THEN p.price ELSE 0 END) AS "09_15_fee",
       SUM(CASE WHEN s.session_time >= "15:00:00" AND s.session_time < "18:00:00" THEN 1 ELSE 0 END) AS "15_18_viewers",
       SUM(CASE WHEN s.session_time >= "15:00:00" AND s.session_time < "18:00:00" THEN p.price ELSE 0 END) AS "15_18_fee",
       SUM(CASE WHEN s.session_time >= "18:00:00" AND s.session_time < "21:00:00" THEN 1 ELSE 0 END) AS "18_21_viewers",
       SUM(CASE WHEN s.session_time >= "18:00:00" AND s.session_time < "21:00:00" THEN p.price ELSE 0 END) AS "18_21_fee",
       SUM(CASE WHEN s.session_time >= "21:00:00" AND s.session_time <= "23:59:59" THEN 1 ELSE 0 END) AS "21_00_viewers",
       SUM(CASE WHEN s.session_time >= "21:00:00" AND s.session_time <= "23:59:59" THEN p.price ELSE 0 END) AS "21_00_fee"
FROM tickets t
JOIN sessions s ON s.id = t.session_id
JOIN prices p ON s.id = p.session_id
JOIN movies m ON s.movie_id = m.id
GROUP BY m.id;