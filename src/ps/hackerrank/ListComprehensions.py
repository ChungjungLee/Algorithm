'''
    https://www.hackerrank.com/challenges/list-comprehensions/problem
'''
def sol(x, y, z, n):
    result = []

    for i in range(x + 1):
        for j in range(y + 1):
            for k in range(z + 1):
                if i + j + k != n:
                    result.append([i, j, k])

    return result

if __name__ == '__main__':
    x = int(input())
    y = int(input())
    z = int(input())
    n = int(input())
    print(sol(x, y, z, n))