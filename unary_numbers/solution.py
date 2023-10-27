import sys

for line in sys.stdin.readlines():
    num = int(line)
    print(f"{num} {'1' * (num - 1)}0")

exit()
