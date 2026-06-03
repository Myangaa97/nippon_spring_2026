#!/bin/bash

remove_file(){
  echo "file name: $1"
  
}

remove_file math.sh

is_positive(){
 if [ $1 -gt 0 ]; then
    echo "eyreg too"
	else
	echo "surug too"
 fi
}

is_positive 12

backup(){
  echo "bak file completed: $(cp "$1" "$1".bak)"
}

backup math.sh

login(){
if [ "$1" == "admin123" ]; then
    echo "newterlee"
        else
        echo "wrong Pass"
 fi
}

login admin123

create_files(){
  echo "$(touch) "$1".html"
    echo "$(touch) "$1".css"
  echo "$(touch) "$1".jss"
}

create_files index
