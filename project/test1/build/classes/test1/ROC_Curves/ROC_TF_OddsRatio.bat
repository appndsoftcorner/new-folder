@echo off
cls
path="C:\Python27"
cd C:\Users\phantom\Desktop\libsvm-3.20\libsvm-3.20\python
plotroc.py -v 10 -s 0 -t 0 -g 0.0078125 -c 2.0 "C:\Users\phantom\Desktop\project\calculations\variants\TF_OddsRatio.txt"
exit

