'''
    https://www.hackerrank.com/challenges/capitalize/problem
'''
#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the solve function below.
def solve(s):
    result = []
    
    patternWhitespace = re.compile('\s')
    patternNoWhitespace = re.compile('\S')
    prevChar = " "
    currChar = " "
    
    for char in s:
        currChar = char
        if (patternWhitespace.match(prevChar) and patternNoWhitespace.match(currChar)):
            char = char.upper()
        result.append(char)
        prevChar = currChar
        
    return "".join(result)

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = solve(s)

    fptr.write(result + '\n')

    fptr.close()
