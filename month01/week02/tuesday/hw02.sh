#!/bin/bash
count=1
while [ $count -le 3 ]; do
  read -p "Input number {1-3}" add

   case $add in
        1) echo "myangaa" ;;
        2) echo "$(date)" ;;
        3) echo "exit"
	break 
	;;
        *)wrong operation ;;
   esac
   count=$((count + 1))
done

