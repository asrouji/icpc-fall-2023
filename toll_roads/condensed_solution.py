import sys
import functools

for line in (input := sys.stdin.readlines())[(br := input.index('\n')) + 1:]:
    print('{:.3f}'.format(functools.reduce(lambda prob, char: prob * ({ letter: float(prob) for letter, prob in (line.split(' ') for line in input[:br]) }.get(char) or 1), line.strip(), 1)))

exit()