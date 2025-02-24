n = int(input())
numeric = list(map(int, input().split()))
numeric.sort()
answer = 0

for i in range(len(numeric)):
    count = 0
    for j in range(2, numeric[i]+1):
        if numeric[i] % j == 0:
            count += 1
        
    if count == 1:
        answer += 1

print(answer)