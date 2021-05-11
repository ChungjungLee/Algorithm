'''
    https://www.hackerrank.com/challenges/py-set-add/problem
'''
# Enter your code here. Read input from STDIN. Print output to STDOUT
if __name__ == '__main__':
    n = int(input())
    
    s = set('')
    for i in range(0, n):
        s.add(input())
        
    print(len(s))