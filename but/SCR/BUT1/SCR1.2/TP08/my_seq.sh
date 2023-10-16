#!/bin/bash

if [[ $# -lt 1 ]]
then
	echo "Usage : my_seq.sh <integer>"
	exit
fi
if [[ $1 -lt 0 ]]
then
	echo "Argument must be positive"
	exit
fi
for ((i=1;i<=$1;i++))
do
	echo $i
done
exit

