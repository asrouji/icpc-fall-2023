import sys; print([ sum(range(small + 1, big)) - mid for [small, mid, big] in [sorted([int(str_num) for str_num in sys.stdin.readline().split(" ")])]][0]); exit()
