#!/bin/bash
[ ! -d ./bin/ ] && mkdir ./bin/
javac -d ./bin ./src/**/*.java
java -cp ./bin pandemic $@