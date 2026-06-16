def Marvellous(value1,value2):
    print("Inside Marvellous...")
    add = value1 + value2
    sub = value1 - value2
    return add, sub

add_result, sub_result = Marvellous(11, 10)

print("Addition is :", add_result)
print("Subtraction is :", sub_result)