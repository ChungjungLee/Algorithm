'''
    https://www.hackerrank.com/challenges/collections-counter/problem
'''
# Enter your code here. Read input from STDIN. Print output to STDOUT
def solution(shoes):
    numPurchase = int(input())
    money = 0
    for i in range(0, numPurchase):
        size, price = map(int, input().split())
        if shoes.count(size) > 0:
            money = money + price
            shoes.remove(size)
        
    return money

if __name__ == '__main__':
    numWhole = input()
    shoes = list(map(int, input().split()))
    print(solution(shoes))
