'''
    https://www.hackerrank.com/challenges/py-set-union/problem
'''
# Enter your code here. Read input from STDIN. Print output to STDOUT
def solution(numSet1, numSet2):
    return len(numSet1.union(numSet2))

if __name__ == '__main__':
    num1 = int(input())
    numSet1 = set(map(int, input().split()))
    num2 = int(input())
    numSet2 = set(map(int, input().split()))
    
    print(solution(numSet1, numSet2))