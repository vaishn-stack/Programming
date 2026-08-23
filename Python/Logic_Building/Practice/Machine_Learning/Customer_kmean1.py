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
    
    

if __name__ == "__main__":
    main()