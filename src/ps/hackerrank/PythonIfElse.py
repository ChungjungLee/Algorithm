'''
    https://www.hackerrank.com/challenges/py-if-else/problem
'''
#!/bin/python3

import math
import os
import random
import re
import sys

def sol(n):
    if n % 2 == 1:
        print("Weird")
    elif 2 <= n and n <= 5:
        print("Not Weird")
    elif 6 <= n and n <= 20:
        print("Weird")
    else:
        print("Not Weird")

if __name__ == '__main__':
    n = int(input().strip())
    sol(n)