cd lab0
echo "===========№4.1==========="

wc -m `echo *e */*e */*/*e` | sort 

echo "===========№4.2==========="

ls -Rl 2>/tmp/s465722 |grep "^-" | sort -r -nk6 -k7 | head -3

echo "===========№4.3==========="

cat b* */b* */*/b* | sort -r

echo "===========№4.4==========="

ls -lR ./ | grep '^-' | grep 'do' | head -2 | sort -k2

echo "===========№4.5==========="

ls -l sceptile5 2>/dev/null | grep "^-" | sort -r

echo "===========№4.6==========="

cat -n sceptile5/* | grep -E '(r|R)$' 2>&1

cd ..
