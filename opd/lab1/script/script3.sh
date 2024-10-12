#3 задание
cd lab0
ln -s wormadam2 swampert2/conkeldurrwormadam
cp wormadam2 sceptile5/ponytawormadam
cat swampert2/amoonguss swampert2/conkeldurr > eelektrik6_15
ln -s swampert2 Copy_13

#ln wormadam2 azurill4/vulpixwormadam
# Команда выдаст ошибку, т.к. у директории azurill4
# нет права на запись (571)
# Выдаем необходимые права и убираем их после выполнения
chmod u+w azurill4; ln wormadam2 azurill4/vulpixwormadam; chmod u-w azurill4

#cp -R azurill4 sceptile5
#mv sceptile5/azurill4 azurill4/meganium
# Команда выдаст ошибку, т.к. у директории azurill4
# нет права на запись (571)
# Команда выдаст ошибку, т.к. у директории azurill4/meganium
# нет права на запись (511)
# Команда выдаст ошибку, т.к. у директории azurill4/tepig
# нет права на чтение (337)
# Выдаем необходимые права и убираем их после копирование
chmod u+w azurill4; chmod u+w azurill4/meganium; chmod u+r azurill4/tepig
cp -R azurill4 sceptile5; mv sceptile5/azurill4 azurill4/meganium
chmod u-w azurill4; chmod u-w azurill4/meganium; chmod u-r azurill4/tepig

cp sudowoodo7 sceptile5/vileplume

cd ..

