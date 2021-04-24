'''
    https://www.hackerrank.com/challenges/finding-the-percentage/problem
'''
def sol(scores):
    sum = 0.0
    for score in scores:
        sum = sum + score
    return "{:.2f}".format(sum / len(scores))

if __name__ == '__main__':
    n = int(input())
    student_marks = {}
    for _ in range(n):
        name, *line = input().split()
        scores = list(map(float, line))
        student_marks[name] = scores
    query_name = input()
    print(sol(student_marks[query_name]))