#!/usr/bin/env bash

. ../../../testdata_tools/gen.sh

use_solution sol.cpp


samplegroup
sample 1

group group1 20
tc_manual small1
tc_manual small2


group group2 80
include_group sample
include_group group1
tc_manual tc1
tc_manual tc2
tc_manual tc3
