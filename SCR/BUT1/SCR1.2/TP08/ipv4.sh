#!/bin/bash                                   

if [[ $# -lt 2 ]]
then
  echo "Usage : bin_ipv4_address.dat <SCR_FILE> <DEST_FILE>"
  exit
fi
if [[ ! -f $1 ]]                                                               
then
  echo "File $1 does not exist§"
  exit
fi
if [[ -f $2 ]]                                                               
then
  echo -n "File $2 already exists. Owerride ? YES/NO -->"
  read answer
  if [[ $answer != "YES" ]]
  then 
    exit
  fi
  if [[ $answer == "YES" ]]
  then 
    cp /dev/null $2
  fi
fi
lignes=$(cat $1)
for i in $lignes
do
  x=$(expr substr $i 1 8)
  y=$(expr substr $i 9 8)
  z=$(expr substr $i 17 8)
  t=$(expr substr $i 25 8)
  echo "$((2#$x)).$((2#$y)).$((2#$z)).$((2#$t))" >> $2
done 
exit
