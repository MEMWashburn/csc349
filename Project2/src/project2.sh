#!/bin/bash

num=1
for file in *.in;do
   echo -e "Test $num:"
   java MatrixWork <$file
   let "num+=1"
   echo ""
done
