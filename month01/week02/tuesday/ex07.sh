#!/bin/bash
read -p "First number:" num1
read -p "Second number:" num2
read -p "temdegt oruul (+, -, *, %):" sent

case "$sent" in
	"+") num=$((num1 + num2)) ;;
	"-") num=$((num2 - num1)) ;;
	"*") num=$((num1 * num2)) ;;
	"%") num=$((num2 / num1)) ;;
	*) echo "unknown operator" ;;
esac

echo "$num"
