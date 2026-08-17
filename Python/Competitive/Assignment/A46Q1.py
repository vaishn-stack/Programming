import pandas as pd
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split

def AdvertisingPredictor():
    border = "-"*60
    
    # Step 1 : Get Data
    
    print(border)
    print("Step 1 : Get Data")
    print(border)
    
    df = pd.read_csv("Advertising.csv")
    
    print("Dataset loaded successfully")
    print(df)
    
    # Step 2 : Clean, Prepare and Manipulate Data
    
    print(border)
    print("Step 2 : Clean, Prepare and Manipulate Data")
    print(border)
    
    X = df[["TV", "radio", "newspaper"]]
    Y = df["sales"]
    
    print("Input Columns : ")
    print(X)
    
    print("Input Columns : ")
    print(Y)
    
    print(border)
    print("step 2 : Remove unwanted columns")
    print(border)
    
    if "Unnamed: 0" in df.columns:
        df = df.drop(columns=["Unnamed: 0"])
        
    print(df.head())
    
    # Step 3 : Train Model
    print(border)
    print("Step 3 : Train Model")
    print(border)
    
    X_train, X_test, Y_train, Y_test = train_test_split(
        X,
        Y,
        test_size=0.2,
        random_state=42
    )
    
    model = LinearRegression()
    
    model = model.fit(X_train, Y_train)
    print("Model training completed successfully")
    
    # Step 4 : Test Model
    print(border)
    print("Step 4 : Test Model")
    print(border)
    
    Y_pred = model.predict(X_test)
    
    # Step 5 : Display Results
    print(border)
    print("Step 5 : Display Results")
    print(border)
    
    result = pd.DataFrame({
        "Actual Sales" : Y_test.values,
        "Predicted Sales" : Y_pred
    })
    
    print(result)
    
def main():
    AdvertisingPredictor()


if __name__ == "__main__":
    main()