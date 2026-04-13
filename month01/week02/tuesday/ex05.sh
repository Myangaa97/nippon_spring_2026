#!/bin/bash

correct_password="icode2024"
count=3

while [ $count -gt 0 ];
 do
	read -p "Enter Password:" password

	if [ "$password" = "$correct_password" ]; then
		echo "Login completed"
		exit 0
	else

		count=$((count - 1))
		if [ $count -gt 0 ]; then
			echo "Wrong password!"
		else
			echo "Blocked"
		fi
	fi
done

