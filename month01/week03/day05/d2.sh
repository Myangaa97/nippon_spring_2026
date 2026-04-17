#!/bin/bash
max=-1000000
count=1

while [ "$count" -le 5 ]; do
  read -p "Input a: " a
  if [ "$a" -gt "$max" ]; then
    max=$a
  fi
  count=$((count + 1))
done

echo "hamgiin ih too bol $max"