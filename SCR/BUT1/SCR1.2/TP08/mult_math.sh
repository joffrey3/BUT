#!/bin/bash                                   

if [[ $# -lt 2 ]]
then
  echo "Usage : mult_mat <int1> <int2>"
  exit
fi
if [[ $1 -lt 0 ]]                                                               
then
  echo "Arg1 must be positive"
  exit
fi
if [[ $2 -lt 0 ]]                                                               
then
  echo "Arg2 must be positive"
  exit
fi
if [[ $2 -lt $1 ]]                                                               
then
  echo "Arg1 must be less down Arg2"
  exit
fi

for ((i=$1;i<=$2;i++))
do
  for ((j=$1;j<=$2;j++))
  do
    echo -ne "$((i*j))\t"
  done
  echo -e "\n"
done
exit
 
