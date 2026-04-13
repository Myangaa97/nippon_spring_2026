#!/bin/bash

say_hi() {
    echo "Hello, students"
}

say_hi


add_number() {
   sum=$(($1 + $2))
   echo "Total: $sum"	
}

add_number 30 40
add_number 10 11
add_number 5 6

user(){
   echo "Hello user $1, your product is $2"
}

user "myangaa" "website"
user "user 2" "pro2"
user "user 3" "pro3"

create_folder(){
   mkdir html css js
   echo "created a Folder completed "
}

create_folder

my_pc(){
echo "odoogiin hayg: $(pwd)"
echo "user name: $(whoami)"
}

my_pc

count_items(){
count=$(ls | wc -l)
echo "total items: $count"
}

count_items
