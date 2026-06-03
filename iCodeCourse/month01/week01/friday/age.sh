#!/bin/bash

AGE=$1

if [ $AGE -ge 18 ]; then
	echo "Adult"
else
	echo "young"
fi
