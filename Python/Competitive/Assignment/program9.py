lst = [3, 5, 7, 9, 3, 2]

max_num = lst[0]

for i in lst:
    if i > max_num:
        max_num = i

print("Maximum number is :", max_num)