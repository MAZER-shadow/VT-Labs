Как собрать jar:
```sh
#1 компиляция 
javac -cp libs/Pokemon.jar -d classes src/**/*.java
echo "==========1.done"
#2 создание манифеста
echo -e "Manifest-Version: 1.0\nMain-Class: Main\nClass-Path: libs/Pokemon.jar" > MANIFEST.mf
echo "==========2.done"
#3 сборка jar
jar cvfm app.jar MANIFEST.mf -C classes .
echo "==========3.done"
#4 запуск
java -jar app.jar
```
Как собрать fat jar:
```sh
#1 компиляция
javac -d bin -cp libs/Pokemon.jar src/**/*.java 
cd bin
#2 сборка fat jar
jar xf ../libs/Pokemon.jar 
jar cfe lab2-fat.jar Main .
#3 запуск
java -jar lab2-fat.jar
```
На основе базового класса Pokemon написать свои классы для заданных видов покемонов. Каждый вид покемона должен иметь один или два типа и стандартные базовые характеристики:

    очки здоровья (HP)
    атака (attack)
    защита (defense)
    специальная атака (special attack)
    специальная защита (special defense)
    скорость (speed)

Классы покемонов должны наследоваться в соответствии с цепочкой эволюции покемонов. На основе базовых классов PhysicalMove, SpecialMove и StatusMove реализовать свои классы для заданных видов атак.

Атака должна иметь стандартные тип, силу (power) и точность (accuracy). Должны быть реализованы стандартные эффекты атаки. Назначить каждому виду покемонов атаки в соответствии с вариантом. Уровень покемона выбирается минимально необходимым для всех реализованных атак.

Используя класс симуляции боя Battle, создать 2 команды покемонов (каждый покемон должен иметь имя) и запустить бой.
