#!/usr/bin/env bash

. ../../../testdata_tools/gen.sh

use_solution area_js.cc

compile gen_rand.py

samplegroup
sample sample01

group group1 30
tc_manual area1
tc g1-1 gen_rand n=50 k=50
tc g1-2 gen_rand n=1 k=50
tc g1-3 gen_rand n=50 k=1
tc g1-4 gen_rand n=1 k=1
tc g1-5 gen_rand n=2 k=1
tc g1-6 gen_rand n=1 k=2
tc g1-7 gen_rand n=2 k=2


group group2 70
include_group sample
include_group group1
tc_manual area2
tc_manual area3
tc_manual area4
tc_manual area5
