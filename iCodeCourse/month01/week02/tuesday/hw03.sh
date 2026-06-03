#!/bin/bash

read -p "Input name:" name

read -p "Input age:" age

greet() {
	echo "Hello, $name. $age years old. have a nice day!":
}

greet
