import sys

games = sys.stdin.readlines()[0].strip()

winning_k = []

for k in range(1, len(games)):
    alice_points = bob_points = alice_wins = bob_wins = 0

    for character in games:
        (alice_points, bob_points) = ((alice_points, bob_points + 1), (alice_points + 1, bob_points))[character == 'A']
        if (alice_won := alice_points >= k) or bob_points >= k:
            alice_points = bob_points = 0
            (alice_wins, bob_wins) = ((alice_wins, bob_wins + 1), (alice_wins + 1, bob_wins))[alice_won]

    if alice_wins > bob_wins:
        winning_k.append(k)

print(len(winning_k))

for k in winning_k:
    print(k, end=" ")
