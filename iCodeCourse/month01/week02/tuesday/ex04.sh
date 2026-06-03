#!/bin/bash
count=1
while [ $count -le 5 ]; do
	echo "Number: $count"
	count=$((count + 1))
done
echo "finish"
