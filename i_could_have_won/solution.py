import sys

games = sys.stdin.readlines()[0].strip()

winning_k = []

for k in range(1, len(games)):
    alice_points = 0
    bob_points = 0

    alice_wins = 0
    bob_wins = 0

    for character in games:
        # add win to person's points
        if (character == "A"):
            alice_points += 1
        elif (character == "B"):
            bob_points += 1

        # check if they met k points
        if alice_points >= k:
            alice_wins += 1
        if bob_points >= k:
            bob_wins += 1

        # reset points if k points was reached by either
        if alice_points >= k or bob_points >= k:
            alice_points = 0
            bob_points = 0

    # did alice win?
    if alice_wins > bob_wins:
        winning_k.append(k)

print(len(winning_k))

for k in winning_k:
    print(k, end=" ")
