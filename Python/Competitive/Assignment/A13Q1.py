def AreaRectangle(Length,Width):
    return Length * Width

def main():
    length = float(input("Enter length : "))
    Width = float(input("Enter Width:"))
    
    Ans = AreaRectangle(length,Width)
    
    print("Area of Rectangle : ",Ans)
    
if __name__ == "__main__":
    main()