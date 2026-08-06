from sklearn.datasets import load_iris

def main():
    print("-"*40)
    print("Iris Classification Case Study")
    print("-"*40)
    
    Dataset = load_iris()
    
    print(Dataset)
    
if __name__ == "__main__":
    main()