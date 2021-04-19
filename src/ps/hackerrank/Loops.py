'''
    https://www.hackerrank.com/challenges/python-loops/problem
'''
def sol(n):
    for i in range(n):
        print(i * i)

if __name__ == '__main__':
    n = int(input())
    sol(n)