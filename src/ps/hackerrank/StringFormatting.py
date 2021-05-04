'''
    https://www.hackerrank.com/challenges/python-string-formatting/problem
'''
def print_formatted(number):
    width = len(format(number, "b"))
    
    for i in range(0, number):
        print(format(i+1, "d").rjust(width) + " " + format(i+1, "o").rjust(width) + " " + format(i+1, "X").rjust(width) + " " + format(i+1, "b").rjust(width))

if __name__ == '__main__':
    n = int(input())
    print_formatted(n)