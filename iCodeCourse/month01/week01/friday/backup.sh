#!/bin/bash

FILE=$1

if [ -f "$FILE" ]; then
	cp "$FILE" "$FILE.bak"
	echo "FILE created, $FILE.bak "
else
	echo "not found"

fi 
