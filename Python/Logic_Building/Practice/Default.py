def Area(Radius, PI = 3.14):                # Default value - 3.14
    Ans = PI * Radius * Radius
    return Ans
      
def main():
    Ret = Area(10.5)
    print("Area of circle is :", Ret)
    
    Ret = Area(10.5, 7.12)
    print("Area of circle is :", Ret)
    
if __name__ == "__main__":
    main()