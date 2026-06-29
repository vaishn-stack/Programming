def ChkPalindrome(No):
    Temp = No
    Rev = 0
    
    while No > 0:
        Digit = No % 10
        Rev = Rev * 10 + Digit
        No = No // 10
        
    if Temp == Rev:
        return True
    else:
        return False

def main():
    value = int(input("Enter a number : "))
    Ans = ChkPalindrome(value)
    
    if(Ans == True):
        print("Number is Palindrome")
    else:
        print("Number is not Palindrome")
        
if __name__ == "__main__":
    main()