#!/bin/bash

greet(){
  echo "Hello, $1. have a niceday"
}

greet myangaa

mkcd(){
   mkdir $1
   cd $1
   echo "folder completed"
   echo "odoogiin hayg: $(pwd)"
}

mkcd version

check_age(){
  if [ $1 -ge 18 ]; then
	echo "adult"
  else
	echo "child"
  fi
}
check_age 16


file_info(){
echo "file name: $1"
echo "line num: $(wc -l < "$1")"
echo "word number: $(wc -w < "$1")"
}

file_info j1.sh

math(){

}
