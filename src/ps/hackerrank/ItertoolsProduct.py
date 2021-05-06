'''
    https://www.hackerrank.com/challenges/itertools-product/problem
'''
# Enter your code here. Read input from STDIN. Print output to STDOUT
from itertools import product

def solution(aList, bList):
    result = []
    for a in list(product(aList, bList)):
        result.append(str(a))
    return " ".join(result)

if __name__ == '__main__':
    a = map(int, input().split())
    b = map(int, input().split())
    print(solution(list(a), list(b)))