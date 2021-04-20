'''
    https://www.hackerrank.com/challenges/python-print/problem
'''
def sol(n):
    for i in range(n):
        print(i + 1, end = '')

if __name__ == '__main__':
    n = int(input())
    sol(n)