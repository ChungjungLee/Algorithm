'''
    https://www.hackerrank.com/challenges/swap-case/problem
'''
def swap_case(s):
    result = []
    
    for a in s:
        if a.isupper():
            result.append(a.lower())
        elif a.islower():
            result.append(a.upper())
        else:
            result.append(a)
            
    return ''.join(result)

if __name__ == '__main__':
    s = input()
    result = swap_case(s)
    print(result)