#!/bin/bash
num=1
while [ $num -ne 0 ];
    do
    	read -p "Give me number between 1 to 10: " num
    
    	if [ $num -eq 0 ]; then
    		echo "thank you"
    		
        elif [ "$num" -ge 1 ] && [ "$num" -le 10 ]; then
          count=1
        	while [ $count -le 10 ];
                do
                    result=$((num*count))
                    echo $num "X" $count "=" $result
                    count=$((count+1))
                done
        else
          echo "Invalid input (1-10 only)"
      fi
      
      echo ""
    done