#!/bin/bash

javac $1/${1^}PatternProcessor.java
javac -processor $1.${1^}PatternProcessor $1/*.java