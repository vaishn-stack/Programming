import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_squared_error, r2_score

def MarvellousRegression(DataPath):
    border = "-"*60
    
    # step 1 : Load the data
    print(border)
    print("step 1 : Load the data")
    print(border)
    
    df = pd.read_csv(DataPath)
    print(df.head())
    
    # step 2 : Remove unwanted columns
    
    print(border)
    print("step 2 : Remove unwanted columns")
    print(border)
    
    if "Unnamed: 0" in df.columns:
        df = df.drop(columns=["Unnamed: 0"])
        
    print(df.head())
        
    # step 3 : Check Missing values
            
    print(border)
    print("step 3 : Check Missing values")
    print(border)
    
    print("Total missing values : ")
    print(df.isnull().sum())
    print(border)
    
    # step 4 : Statistical Summary
                
    print(border)
    print("step 4 : Statistical Summary")
    print(border)
    
    print(df.describe())
    
    # step 5 : Correlation
                    
    print(border)
    print("step 5 : Correlation")
    print(border)
    
    print(df.corr())
    
    # step 6 : separate independent and dependent variables
                        
    print(border)
    print("step 6 : separate independent and dependent variables")
    print(border)
    
    X = df[["TV", "radio", "newspaper"]]
    Y = df["sales"]
    
    print("Independent variables : ")
    print(X.head())
    
    print("Dependent variables : ")
    print(Y.head())
    
    # step 7 : split the dataset
                            
    print(border)
    print("step 7 : split the dataset")
    print(border)
    
    X_train, X_test, Y_train, Y_test = train_test_split(
        X,
        Y,
        test_size = 0.2,
        random_state = 42
    )
    
    print("Training Data : ", X_train.shape)
    print("Testing Data : ", X_test.shape)
    
    # step 8 : Create and Train the model
                                
    print(border)
    print("step 8 : Create and Train the model")
    print(border)
    
    model = LinearRegression()
    
    model = model.fit(X_train, Y_train)
    print("Model trained successfully...")
    
    # step 9 : Test the model
                                    
    print(border)
    print("step 9 : Test the model")
    print(border)
    
    Y_pred = model.predict(X_test)
    
    print("Expected Answers : ")
    print(Y_test[:3])
    
    print("Predicted Answers : ")
    print(Y_pred[:3])
    
    
    
    
    
def main():
    MarvellousRegression("Advertising.csv")

if __name__ == "__main__":
    main()