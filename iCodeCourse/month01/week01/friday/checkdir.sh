#!/bin/bash

DIR=$1

if [ -d "$DIR" ];then
	ls "$DIR"
else
	echo "not found folder"

fi
