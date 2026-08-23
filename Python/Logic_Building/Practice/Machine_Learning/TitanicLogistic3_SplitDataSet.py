import numpy as np
import pandas as pd
import joblib

from sklearn.linear_model import LogisticRegression
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score, confusion_matrix


# ----------------------------------------------------------------------------------------------------------------------------
#
#   Function name : LoadData
#   Description   : Load the Data from CSV
#   Input         : Name of CSV file
#   Output        : Data Frame
#   Author        : Vaishnavi Deepak Morankar
#   Date          : 16/08/2026
#
# ----------------------------------------------------------------------------------------------------------------------------

def LoadData(filename):
    df = pd.read_csv(filename)

    print("Dataset loaded Successfully")
    print(df.head())

    return df


# ----------------------------------------------------------------------------------------------------------------------------
#
#   Function name : PreprocessData
#   Description   : It performs the Data Preprocessing
#   Input         : Data Frame
#   Output        : Updated Data Frame
#   Author        : Vaishnavi Deepak Morankar
#   Date          : 16/08/2026
#
# ----------------------------------------------------------------------------------------------------------------------------

def PreprocessData(df):

    df = df.drop(
        [
            "Passengerid",
            "zero",
            "name"
        ],
        axis=1,
        errors="ignore"
    )

    # Handle missing values

    if "Age" in df.columns: df["Age"] = df["Age"].fillna(df["Age"].median())

    if "Fare" in df.columns: df["Fare"] = df["Fare"].fillna(df["Fare"].median())

    if "Embarked" in df.columns: df["Embarked"] = df["Embarked"].fillna(df["Embarked"].mode()[0])

    # Convert categorical columns into numeric form
    df = pd.get_dummies(
        df,
        columns=["Sex", "Embarked"],
        drop_first=True
    )

    return df


# ----------------------------------------------------------------------------------------------------------------------------
#
#   Function name : Split Data
#   Description   : It performs Spliting activity
#   Input         : Data Frame
#   Output        : 4 subsets for training and testing
#   Author        : Vaishnavi Deepak Morankar
#   Date          : 16/08/2026
#
# ----------------------------------------------------------------------------------------------------------------------------

def SplitData(df):
    X = df.drop("Survived", axis = 1)
    Y = df["Survived"]
    
    X_train, X_test, Y_train, Y_test = train_test_split(
        X, 
        Y,
        test_size=0.2,
        random_state=42
    )
    
    print("Dataset Spliting Done successfully.")
    
    return X_train, X_test, Y_train, Y_test


# ----------------------------------------------------------------------------------------------------------------------------
#
#   Function name : main
#   Description   : Entry point Function
#   Input         : None
#   Output        : None
#   Author        : Vaishnavi Deepak Morankar
#   Date          : 16/08/2026
#
# ----------------------------------------------------------------------------------------------------------------------------

def main():

    # Step 1 : Load Data

    df = LoadData("MarvellousTitanicDataset.csv")

    # Step 2 : Preprocess Data

    df = PreprocessData(df)

    # Step 3 : Split Data

    X_train, X_test, Y_train, Y_test = SplitData(df)
   
    #print("\nTraining Data :", X_train.shape)
   # print("Testing Data  :", X_test.shape)

    # Step 5 : Train Model

    #model = TrainModel(X_train, Y_train)

    # Step 6 : Evaluate Model

    #EvaluateModel(model, X_test, Y_test)

    # Step 7 : Save Model

    #joblib.dump(model, "Titanic_LogisticRegression.pkl")

    print("\nModel saved successfully.")


if __name__ == "__main__":
    main()

# MLops - ML Pipelines