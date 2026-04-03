#!/bin/bash

AGE=$1

if [ $AGE -ge 18 ]; then
	echo "You can vote"
else
	echo "You can't vote"
fi
