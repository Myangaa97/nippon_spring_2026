#!/bin/bash

FOLDER=$1

if [ -d $FOLDER ]; then
	echo not created
else
	mkdir "$FOLDER"
	echo "craeted a folder" 
fi
