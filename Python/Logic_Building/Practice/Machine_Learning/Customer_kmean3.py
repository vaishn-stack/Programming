import pandas as pd
import matplotlib.pyplot as plt

from sklearn.preprocessing import StandardScaler
from sklearn.cluster import KMeans

def main():
    # step1 : Load the data
    
    df = pd.read_csv("Mall_Customers.csv")
    print("Dataset loaded with values")
    print(df.head())
    
    print("Missing values : ")
    print(df.isnull().sum())
    
    # step 2 : feature selection
    X = df[["AnnualIncome", "SpendingScore"]]
    
    print("Selected features : ")
    print(X.head())
    
    # step 3: Scaled the data
    
    scalar = StandardScaler()
    
    X_Scaled = scalar.fit_transform(X)
    print("Scaled data : ")
    print(X_Scaled[:5])
    
    
    

if __name__ == "__main__":
    main()