import sys

value = int(input("Enter the Value : "))

print("Value is : ",value)
print("Data type : ",type(value))
print("Memory Address : ",id(value))
print("Size in Bytes : ",sys.getsizeof(value))