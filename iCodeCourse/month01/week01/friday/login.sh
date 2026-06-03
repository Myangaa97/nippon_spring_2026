#!/bin/bash

PASS=$1

if [ "$PASS" = "1234" ]; then
	echo "Login Complete"
else 
	echo "Wrong Password"

fi
