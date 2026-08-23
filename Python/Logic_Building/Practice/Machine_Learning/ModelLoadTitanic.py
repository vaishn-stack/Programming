import pandas as pd
import joblib


def LoadModel(Filename):
    model = joblib.load(Filename)

    print("Model Loaded Successfully...")

    print("Model Features:")
    print(model.feature_names_in_)

    return model


def PredictPassenger(model):
    print("\nEnter information")

    Pclass = int(input("Enter Pclass (1/2/3) : "))
    Sex = int(input("Enter Sex (0 : M / 1 : F) : "))
    Age = float(input("Enter Age : "))
    sibsp = int(input("Enter sibling / spouse : "))
    Parch = int(input("Enter Parent / Child : "))
    Fare = float(input("Enter Fare : "))
    Embarked = float(input("Enter Embarked (0/1/2) : "))

    passenger = pd.DataFrame([{
        "Pclass": Pclass,
        "Sex": Sex,
        "Age": Age,
        "sibsp": sibsp,
        "Parch": Parch,
        "Fare": Fare,
        "Embarked_1.0": 1 if Embarked == 1 else 0,
        "Embarked_2.0": 1 if Embarked == 2 else 0
    }])

    # Arrange columns exactly as required by the trained model
    passenger = passenger[model.feature_names_in_]

    result = model.predict(passenger)

    if result[0] == 1:
        print("\nPrediction : Passenger Survived")
    else:
        print("\nPrediction : Passenger Did Not Survive")


def main():
    model = LoadModel("MarvellousTitanic.pkl")

    PredictPassenger(model)


if __name__ == "__main__":
    main()