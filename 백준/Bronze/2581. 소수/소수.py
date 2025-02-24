import math, sys

def isPrime(n):
    for i in range(2, int(math.sqrt(n))+1):
        if n % i == 0:
            return False
        
    if n > 1:
        return True

m = int(input())
n = int(input())
answer = []

for i in range(m, n+1):
    if isPrime(i):
        answer.append(i)
        
if len(answer) > 0:
    print(sum(answer))
    print(answer[0])
else:
    print(-1)