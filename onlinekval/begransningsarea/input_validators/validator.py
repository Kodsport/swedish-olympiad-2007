#!/usr/bin/python3
import re
import sys

int_pat = "(0|[1-9][0-9]*)"
int_space = "( (0|[1-9][0-9]*))*"

input_re = "^" + int_pat + " " + int_pat + "$"
input2_re = "^" + int_pat + int_space + "$"

line = sys.stdin.readline()
assert re.match(input_re, line)

r, k = [int(x) for x in line.split()]

for i in range(r):
	line = sys.stdin.readline()
	assert re.match(input2_re, line)
	assert len([int(x) for x in line.split()]) == k

line = sys.stdin.readline()
assert len(line) == 0
sys.exit(42)
