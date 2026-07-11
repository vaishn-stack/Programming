no = 11                                          # Global Variable --> wall clock

def Display():
    a = 21                                       # Local variable--> Hand Watch
    print("From Display:",no)
    print("From Display value of a is : ",a)

def Demo():
    print("From Demo value of a is : ",a)        # Error
    print("From Demo:",no)

Display()
Demo()
    