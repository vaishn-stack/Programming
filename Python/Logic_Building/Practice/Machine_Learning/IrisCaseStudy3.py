from sklearn.datasets import load_iris

def main():
    print("-"*40)
    print("Iris Classification Case Study")
    print("-"*40)
    
    Dataset = load_iris()
    
    # Metadata of the dataset
    
    print("Independent variables are : ")
    print(Dataset.feature_names)
    
    print("Length of independent variable : ", len(Dataset.feature_names))
    
    print("Dependent variables are : ")
    print(Dataset.target_names)
    
    print("Length of Dependent variable : ", len(Dataset.target_names))
    
if __name__ == "__main__":
    main()