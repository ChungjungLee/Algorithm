'''
    https://www.hackerrank.com/challenges/whats-your-name/problem
'''
def print_full_name(first, last):
    str_list = []
    str_list.append("Hello ")
    str_list.append(first)
    str_list.append(" ")
    str_list.append(last)
    str_list.append("! You just delved into python.")
    print(''.join(str_list))

if __name__ == '__main__':
    first_name = input()
    last_name = input()
    print_full_name(first_name, last_name)