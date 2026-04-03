#!/bin/bash

hour=$(date +%H)

if [ $hour -le 12 ]; then
	echo "Good morning"
else
	echo "Good Evening"
fi
