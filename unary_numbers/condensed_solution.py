
# print(*[f"{line.strip()} {''.join([*['1' for _ in range(1, int(line))], '0'])}\n" for line in sys.stdin.readlines()], end='')

import sys

for line in sys.stdin.readlines():
    print(
        f"{line.strip()} {'1' * (int(line) - 1)}0")

exit()
