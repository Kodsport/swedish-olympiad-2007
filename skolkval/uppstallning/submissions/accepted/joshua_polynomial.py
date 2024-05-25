#!/usr/bin/python3
n = int(input())
p = []
for i in range(n):
  p.append([int(i) for i in input().split()])

for i in range(len(p)):
  p[i].append(i)

p.sort(key=lambda s: s[0]+s[1])


final = []
for i in range(n):
  final.append(-1)


for barn in reversed(p):
  gc = 0
  for i in range(len(final)):
    if final[i] == -1:
      gc+=1
    if gc == barn[0]+1:
      final[i] = barn
      break



res = ""
for i in final:
  res += chr(i[2]+65)
print(res)
