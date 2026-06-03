#!/bin/bash

pass=0
guess=0

echo "Give me number between 1 to 10: "

while [ $guess -ne $pass ]
do
	read -p "Your guesss: " guess

	if [ $guess -eq $pass ]; then
		echo "thank you"
	elif [ $guess -en $pass ]; then
		while [ "$count" -le 10 ];
            do
                result=$((a*count))
                echo $a "X" $count "="$result
                count=$((count+1))
            done
	fi

done