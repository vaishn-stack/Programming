import os               # module of operating system

def main():
    print("Number of cores are : ",os.cpu_count())
    
if __name__ == "__main__":
    main()