@echo off
cls
path="C:\Python27"
cd C:\Users\phantom\Desktop\libsvm-3.20\libsvm-3.20\python
plotroc.py -v 10 -s 0 -t 0 -g 0.03125 -c 4.0 "C:\Users\phantom\Desktop\project\calculations\variants\TF_MutualInformation.txt"
exit

