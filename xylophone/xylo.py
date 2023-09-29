import sys

if __name__ == "__main__":

    input = sys.stdin.readlines()

    input = input[0].split(" ")

    for i in range(len(input)):
        input[i] = int(input[i])

    input.sort()

    biggest = input[2]
    mid = input[1]
    smallest = input[0]

    total_cost = 0

    for new_bar in range(smallest + 1, biggest):
        total_cost += new_bar

    total_cost -= mid

    print(total_cost)

    exit()
