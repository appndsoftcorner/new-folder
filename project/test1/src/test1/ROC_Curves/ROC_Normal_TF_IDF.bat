@echo off
cls
path="C:\Python27"
cd C:\Users\phantom\Desktop\libsvm-3.20\libsvm-3.20\python
plotroc.py -v 10 -s 0 -t 0 -g 0.0001220703125 -c 32.0 "C:\Users\phantom\Desktop\project\calculations\variants\Normal TF_IDF.txt"
exit

