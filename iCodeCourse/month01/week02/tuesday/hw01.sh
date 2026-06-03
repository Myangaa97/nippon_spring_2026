#!/bin/bash

count=1
read -p "Input number pls" num
while [ $count -le $num ];  do
	echo "$num"
	num=$((num - 1))
done
