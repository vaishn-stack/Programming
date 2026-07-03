String = lambda s : len(s) > 5

def main():
    names = ["Ram","Harshal","Rohit","Amit","Ritesh","Vaishnavi"]
    
    result = list(filter(String,names))
    
    print("list of strings having length greater than 5 : ",result)
    
if __name__ == "__main__":
    main()