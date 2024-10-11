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
