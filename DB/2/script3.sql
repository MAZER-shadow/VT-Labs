SELECT count(DISTINCT ЧЛВК_ИД)
FROM Н_УЧЕНИКИ
WHERE ПЛАН_ИД IN (SELECT ИД
                  FROM Н_ПЛАНЫ
                  WHERE ОТД_ИД = (SELECT ИД
                                  FROM Н_ОТДЕЛЫ
                                  WHERE КОРОТКОЕ_ИМЯ = 'КТиУ'))
  AND ЧЛВК_ИД IN (SELECT ЧЛВК_ИД
                  FROM Н_ОБУЧЕНИЯ
                  WHERE ЧЛВК_ИД IN (SELECT ИД
                                    FROM Н_ЛЮДИ
                                    WHERE ОТЧЕСТВО = '.'));