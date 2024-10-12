#!/bin/bash

chmod -R 777 lab0
rm -r lab0
# 1 задание
mkdir lab0
cd lab0
mkdir azurill4; cd azurill4
mkdir tepig; mkdir darumaka; mkdir blissey; touch vulpix; mkdir meganium
cd ..
touch eelektrik6
mkdir sceptile5; cd sceptile5
mkdir yamask; mkdir vileplume; touch ponyta; touch palpitoad;
cd ..
touch sudowoodo7
mkdir swampert2; cd swampert2;
touch amoonguss; touch blastoise; touch conkeldurr;
cd ..
touch wormadam2

echo "weigth=21.8 height=24.0 atk=4 def=4" >> azurill4/vulpix
echo -e "Развитые\nспособности Lightningrod" >> eelektrik6
echo -e "Способности Tackle Growl Tail Whip\nEmber Flame Wheel Stomp Flame Charge Fire Spin Take Down Inferno\nAgility Fire Blast Bounce Flare Blitz" >> sceptile5/ponyta
echo -e "Способности\nSupersonic Round Bubblebeam Mud Shot Aqua Ring Uproar Muddy Water Rain\nDance Flail Echoed Voice Hydro Pump Hyper Voice" >> sceptile5/palpitoad
echo -e "Живет\nForest Taiga" >> sudowoodo7
echo -e "Развитые способности\nRegenerator" >> swampert2/amoonguss
echo -e "Развитые способности Rain Dish\nSniper" >> swampert2/blastoise
echo -e "Возможности Overland=9 Surface=7 Jump=5 Power=7\nIntelligence=4" >> swampert2/conkeldurr
echo "weigth=14.3 height=20.0 atk=6 def=9" >> wormadam2
cd ..

