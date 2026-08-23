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
#   Function name : TrainModel
#   Description   : Train Logistic Regression model
#   Input         : X_train, Y_train
#   Output        : Trained model
#   Author        : Vaishnavi Deepak Morankar
#   Date          : 16/08/2026
#
# ----------------------------------------------------------------------------------------------------------------------------

#def TrainModel(X_train, Y_train):

    #model = LogisticRegression(max_iter=1000)

    #model.fit(X_train, Y_train)

    #return model


# ----------------------------------------------------------------------------------------------------------------------------
#
#   Function name : EvaluateModel
#   Description   : Evaluate trained model
#   Input         : Model, X_test, Y_test
#   Output        : None
#   Author        : Vaishnavi Deepak Morankar
#   Date          : 16/08/2026
#
# ----------------------------------------------------------------------------------------------------------------------------

#def EvaluateModel(model, X_test, Y_test):

   # Y_pred = model.predict(X_test)

    #Accuracy = accuracy_score(Y_test, Y_pred)

   # print("\nAccuracy :", Accuracy)

   # print("\nConfusion Matrix :")
   # print(confusion_matrix(Y_test, Y_pred))


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


if __name__ == "__main__":
    main()

# MLops - ML Pipelines