'''
    https://www.hackerrank.com/challenges/find-second-maximum-number-in-a-list/problem
'''
def sol(arr):
    thisset = set()
    for num in arr:
        thisset.add(num)

    thislist = list(thisset)
    thislist.sort(reverse = True)

    return thislist[1]

if __name__ == '__main__':
    n = int(input())
    arr = map(int, input().split())
    print(sol(arr))