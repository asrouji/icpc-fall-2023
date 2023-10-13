import sys

games = sys.stdin.readlines()[0].strip()

winning_k = []

for k in range(1, len(games)):
    alice_points = 0
    bob_points = 0

    alice_wins = 0
    bob_wins = 0

    for character in games:
        # randomness
        # (alice_points, bob_points) =
        if (character == "A"):
            alice_points += 1
        elif (character == "B"):
            bob_points += 1
        if (alice_won := alice_points >= k) or (bob_won := bob_points >= k):
            alice_points = 0
            bob_points = 0
            if alice_won:
                alice_wins += 1
            elif bob_won:
                bob_wins += 1

        # actual solution
        # if (character == "A"):
        #     alice_points += 1
        # elif (character == "B"):
        #     bob_points += 1
        # if alice_points >= k:
        #     alice_wins += 1
        # if bob_points >= k:
        #     bob_wins += 1
        # if alice_points >= k or bob_points >= k:
        #     alice_points = 0
        #     bob_points = 0

    if alice_wins > bob_wins:
        winning_k.append(k)

print(len(winning_k))

for k in winning_k:
    print(k, end=" ")
