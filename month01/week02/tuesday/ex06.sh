#!/bin/bash

read -p "Input month (1-12): " month

case $month in
	1) echo "Winter" ;;
	2) echo "Winter" ;;
	3) echo "Spring" ;;
	4) echo "Spring" ;;
	5) echo "Spring" ;;
	6) echo "Summer" ;;
	7) echo "Summer" ;;
	8) echo "Summer" ;;
	9) echo "Autumn" ;;
	10) echo "Autumn" ;;
	11) echo "Autumn" ;;
	12) echo "Winter" ;;
	*) echo "Input wrong" ;;
esac
