no = 11                                        

def Display():
    # use global no (no will be 21)
    # global --> global variable used inside function then use the global keyword initialise with global variable as modify the global variable 
    # global keyword as a declaration initialised kraychi
    
    global no                       # extern keyword sarakh ahe
    no = 21
    print("From Display : ",no)

print("Before : ",no)
Display()
print("After : ",no)
    