#!/usr/bin/env bash

. ../../../testdata_tools/gen.sh

use_solution wikicpp.cpp


samplegroup
sample sample1

group group1 40
tc_manual small1
tc_manual small2
tc_manual small3
tc_manual small4
tc_manual small5

group group2 60
include_group sample
include_group group1
tc_manual secret1
tc_manual secret2
tc_manual secret3
