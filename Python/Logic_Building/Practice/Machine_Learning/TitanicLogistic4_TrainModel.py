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
    
    df["Age"] = df["Age"].fillna(df["Age"].median())

    df["Fare"] = df["Fare"].fillna(df["Fare"].median())

    df["Embarked"] = df["Embarked"].fillna(df["Embarked"].mode()[0])

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
#   Function name : TrainModel
#   Description   : It performs model training
#   Input         : Training features and labels
#   Output        : Trained model
#   Author        : Vaishnavi Deepak Morankar
#   Date          : 16/08/2026
#
# ----------------------------------------------------------------------------------------------------------------------------

def TrainModel(X_train, Y_train):
    model = LogisticRegression(max_iter=1000)
    
    model = model.fit(X_train, Y_train)
    
    print("Model Trained Successfully.")
    
    return model

# ----------------------------------------------------------------------------------------------------------------------------
#
#   Function name : EvaluateModel
#   Description   : It performs model testing
#   Input         : Model, X_test, Y_test (testing data(Features, labels))
#   Output        : None
#   Author        : Vaishnavi Deepak Morankar
#   Date          : 16/08/2026
#
# ----------------------------------------------------------------------------------------------------------------------------

def EvaluateModel(model, X_test, Y_test):
    Y_pred = model.predict(X_test)
    
    Accuracy = accuracy_score(Y_test, Y_pred)
    
    print("Accuracy is : ", Accuracy)
    
    print("\nConfusion Matrix :")
    print(confusion_matrix(Y_test, Y_pred))
    
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

    # Step 4 : Train Model

    model = TrainModel(X_train, Y_train)

    # Step 5 : Evaluate Model

    EvaluateModel(model, X_test, Y_test)

    # Step 6 : Save Model

    #joblib.dump(model, "Titanic_LogisticRegression.pkl")

    print("\nModel saved successfully.")


if __name__ == "__main__":
    main()

# MLops - ML Pipelines