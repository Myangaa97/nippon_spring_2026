#!/bin/bash

a=1
pass=0
count=1
result=1

echo "Give me number between 1 to 10: "

while [ $a -ne $pass ]
do
	read -p "Your guesss: " a

	if [ $a -eq $pass ]; then
		echo "thank you"
	elif [ $a -ne $pass ]; then
		while [ "$count" -le 10 ];
            do
                result=$((a*count))
                echo $a "X" $count "="$result
                count=$((count+1))
            done
	fi
done