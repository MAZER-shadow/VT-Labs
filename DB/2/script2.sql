SELECT Н_ЛЮДИ.ИД,
       Н_ОБУЧЕНИЯ.ЧЛВК_ИД,
       Н_УЧЕНИКИ.НАЧАЛО
FROM Н_ЛЮДИ
         LEFT JOIN Н_ОБУЧЕНИЯ
                   ON Н_ЛЮДИ.ИД = Н_ОБУЧЕНИЯ.ЧЛВК_ИД
         LEFT JOIN Н_УЧЕНИКИ
                   ON Н_ОБУЧЕНИЯ.ЧЛВК_ИД = Н_УЧЕНИКИ.ЧЛВК_ИД
WHERE Н_ЛЮДИ.ИД > 163484 AND Н_ОБУЧЕНИЯ.ЧЛВК_ИД = 163484 AND Н_УЧЕНИКИ.ИД = 100410;