#!/bin/bash

read -p "Input numbers" a
read -p "Input numbers" b
read -p "Input numbers" c
if [ $a -lt $b ];then
	temp=$a
	a=$b
	b=$temp
fi

if [ $a -lt $c ];then
        temp=$a
        a=$c
        c=$temp
fi

if [ $b -lt $c ];then
        temp=$b
        b=$c
        c=$temp
fi

echo "sorted: $a, $b, $c"
