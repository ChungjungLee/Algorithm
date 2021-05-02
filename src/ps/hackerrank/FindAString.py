"""
    https://www.hackerrank.com/challenges/find-a-string/problem
"""
def count_substring(string, sub_string):
    count = 0
    
    for i in range(0, len(string)):
        candidate = string[i:i + len(sub_string)]
        if (sub_string == candidate):
            count = count + 1
    
    return count

if __name__ == '__main__':
    string = input().strip()
    sub_string = input().strip()
    
    count = count_substring(string, sub_string)
    print(count)