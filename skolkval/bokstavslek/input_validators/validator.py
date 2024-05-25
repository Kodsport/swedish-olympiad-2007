#!/usr/bin/python3
import re, sys

strreg = "(\w+)"
intreg = "([1-9][0-9]*)"
fullreg1 = re.compile("^"+strreg+"$")
fullreg2 = re.compile("^"+intreg+"$")
line1 = sys.stdin.readline()
assert fullreg1.match(line1), "Row 1 does not consist of one string"
line = sys.stdin.readline()
assert fullreg2.match(line), "Row 2 does not consist of one int"
N = int(line)
assert 1 <= N and N <= 100, "N out of bounds"
if len(sys.stdin.readline()) != 0:
	print("Garbage input")
	sys.exit(0)
assert len(set(line1))==len(line1), "Not all are characters are unique"
sys.exit(42)
