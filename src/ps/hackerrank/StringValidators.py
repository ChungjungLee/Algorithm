'''
    https://www.hackerrank.com/challenges/string-validators/problem
'''
if __name__ == '__main__':
    s = input()
    isAlphanumeric = False
    isAlphabetical = False
    isDigit = False
    isLower = False
    isUpper = False
    
    for char in s:
        if(char.isalnum()):
            isAlphanumeric = True
        if(char.isalpha()):
            isAlphabetical = True
        if(char.isdigit()):
            isDigit = True
        if(char.islower()):
            isLower = True
        if(char.isupper()):
            isUpper = True
    
    print(isAlphanumeric)
    print(isAlphabetical)
    print(isDigit)
    print(isLower)
    print(isUpper)