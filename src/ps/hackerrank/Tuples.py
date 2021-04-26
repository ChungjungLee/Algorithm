'''
    https://www.hackerrank.com/challenges/python-tuples/problem
'''
def sol(integer_list):
    return hash(tuple(integer_list))

if __name__ == '__main__':
    n = int(input())
    integer_list = map(int, input().split())
    print(sol(integer_list))