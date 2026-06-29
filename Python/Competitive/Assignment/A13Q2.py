def AreaCircle(Radius):
    PI = 3.14
    return PI * Radius * Radius

def main():
    radius = float(input("Enter radius : "))
    
    Ans = AreaCircle(radius)
    
    print("Area of Circle : ",Ans)
    
if __name__ == "__main__":
    main()