'''
    https://www.hackerrank.com/challenges/itertools-combinations/problem
'''
# Enter your code here. Read input from STDIN. Print output to STDOUT
from itertools import combinations

def solution(string, size):
    for outputSize in range(0, size):
        for combination in combinations(string, outputSize+1):
            print(''.join(combination))

if __name__ == '__main__':
    string, size = input().split()
    solution(sorted(string), int(size))
