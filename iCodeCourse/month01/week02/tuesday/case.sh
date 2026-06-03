#!/bin/bash

read -p "input number (1-7): " day

case $day in
	1) echo "Monday" ;;
	2) echo "Tuesday" ;;
	3) echo "Wednesady" ;;
	4) echo "Thursday" ;;
	5) echo "Friday" ;;
	6) echo "Saturday" ;;
	7) echo "Sunday" ;;
	*) echo "Input wrong" ;;
esac
