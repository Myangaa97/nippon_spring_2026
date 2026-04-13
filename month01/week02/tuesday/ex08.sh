#!/bin/bash

say_hello() {
	echo "good morning!: $name"
}

read -p "input name" name

say_hello
