# print("-"*40)   --> Fancy programming part

print("-------------------------------------------------------")     # Industrial Panel or Banner
print("---------------Ticket Pricing Software-----------------")
print("-------------------------------------------------------")

print("Please enter the Age : ")
Age = int(input())

if(Age <= 5):
    print("Free Entry...")
elif(Age > 5 and Age <= 18):
    print("Ticket Price : 900")
elif(Age > 18 and Age <= 40):
    print("Ticket Price : 1200")
else:
    print("Ticket Price : 500")
    
print("-------------------------------------------------------")    
print("---------------Thank you for Visiting------------------")
print("-------------------------------------------------------")