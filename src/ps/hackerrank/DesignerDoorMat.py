'''
    https://www.hackerrank.com/challenges/designer-door-mat/problem
'''
# Enter your code here. Read input from STDIN. Print output to STDOUT
DASH = '---'
PATTERN = '.|.'
WELCOME = '-WELCOME-'

def solution(N, M):
    middleCol = int(N / 2)
    
    # upper
    for i in range(0, middleCol):
        print((DASH * (middleCol - i)) + (PATTERN * (i * 2 + 1)) + (DASH * (middleCol - i)))
    
    # middle
    print((DASH * (middleCol - 1)) + WELCOME + (DASH * (middleCol - 1)))
    
    # down
    for i in range(middleCol + 1, N):
        print((DASH * (i - middleCol)) + (PATTERN * ((N - i) * 2 - 1)) + (DASH * (i - middleCol)))

if __name__ == '__main__':
    N, M = map(int, input().split())
    solution(N, M)