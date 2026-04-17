#!/bin/bash

a=0
b=1
count=0

read -p "Input number" n

        while [ $count -lt $n ];
                do
                        temp=$((a + b))
                        a=$b
                        b=$temp
                        count=$((count + 1))
                done


echo "Total: $a"
