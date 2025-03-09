SELECT Н_ЛЮДИ.ИМЯ  as name_student,
       Н_СЕССИЯ.ИД as id_session
FROM Н_ЛЮДИ
         LEFT JOIN Н_СЕССИЯ
                   ON Н_ЛЮДИ.ИД = Н_СЕССИЯ.ЧЛВК_ИД
WHERE Н_ЛЮДИ.ИМЯ > 'Александр'
  AND Н_СЕССИЯ.УЧГОД > '2001/2002';