#!/bin/bash

finish="goal"
guess="goal"

echo "Give me number between 1 to 100: "

while [ $guess != $finish ]
do
	read -p "Your guesss: " guess

	if [ $guess = $finish ]; then
		echo "finished"
	else
		echo "mkdir $finish"
    fi
done
