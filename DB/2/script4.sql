SELECT ГРУППА,
       count(DISTINCT ЧЛВК_ИД)
FROM Н_УЧЕНИКИ
WHERE (((('2011-12-31' BETWEEN НАЧАЛО AND КОНЕЦ)
    OR ('2011-01-01' BETWEEN НАЧАЛО AND КОНЕЦ))
    AND (КОНЕЦ != '9999-09-09 00:00:00.000000'))
    OR (НАЧАЛО BETWEEN '2011-01-01' AND '2011-12-31'))
  AND ПЛАН_ИД IN (SELECT ИД
                  FROM Н_ПЛАНЫ
                  WHERE ОТД_ИД_ЗАКРЕПЛЕН_ЗА = (SELECT ИД
                                               FROM Н_ОТДЕЛЫ
                                               WHERE КОРОТКОЕ_ИМЯ = 'ВТ'))
GROUP BY ГРУППА
HAVING count(DISTINCT ЧЛВК_ИД) = 5;