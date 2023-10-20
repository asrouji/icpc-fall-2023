import sys

# stores probability of each character
probs = {}

# first we process probs (false) then later queries (true)
query = False

for line in sys.stdin.readlines():
    line = line.strip().split()
    if len(line) == 0:
        query = True
    elif not query:
        probs[line[0]] = float(line[1])
    else:
        prob = 1
        for char in line[0]:
            if char in probs:
                prob *= probs[char]
        print('{:.3f}'.format(prob))
