#!/bin/bash
    read -p "a toogoo oruul" a
    read -p "b toogoo oruul" b
    read -p "temdegtee oruul +,-,*,/" c
    if [ "$b" -le 0 ]; then
        echo "aldaa"
            elif [ "$c" = "+" ]; then
                echo $((a + b))
            elif [ "$c" = "-" ]; then
                echo $((a - b))
            elif [ "$c" = "*" ]; then
                echo $((a * b))
            elif [ "$c" = "/" ]; then
                echo $((a / b))
    fi