D = int(input())

E = int(input())

remaining_donuts = D

for _ in range(E):
    event_type = input().strip()
    Q = int(input())
    
    if event_type == '+':
        remaining_donuts += Q
    elif event_type == '-':
        remaining_donuts -= Q

print(remaining_donuts)
