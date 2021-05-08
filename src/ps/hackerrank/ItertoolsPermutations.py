'''
    https://www.hackerrank.com/challenges/itertools-permutations/problem
'''
# Enter your code here. Read input from STDIN. Print output to STDOUT
from itertools import permutations

def solution(string, size):
    for permutation in permutations(string, size):
        print(''.join(permutation))

if __name__ == '__main__':
    string, size = input().split()
    solution(sorted(string), int(size))
