#!/bin/bash
# build.sh

mkdir -p bin
javac -d bin/ -sourcepath src/ src/soprasteria/code24h/marabunta/strategie/Main.java
