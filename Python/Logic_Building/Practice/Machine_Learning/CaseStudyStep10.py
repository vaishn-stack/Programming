import pandas as pd
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split
from sklearn.tree import DecisionTreeClassifier
from sklearn.metrics import accuracy_score, confusion_matrix, classification_report

Border = "-" * 60

# ----------------------------------------------------------
# Step 1 : Load Dataset
# ----------------------------------------------------------

def LoadDataset():

    print(Border)
    print("Step 1 : Load Dataset")
    print(Border)

    df = pd.read_csv("iris.csv")

    print("Dataset Loaded Successfully")
    print(df.head())

    return df

# ----------------------------------------------------------
# Step 2 : Data Analysis
# ----------------------------------------------------------

def DataAnalysis(df):

    print(Border)
    print("Step 2 : Exploratory Data Analysis")
    print(Border)

    print("Shape :", df.shape)
    print("Columns :", df.columns.tolist())

    print("\nMissing Values")
    print(df.isnull().sum())

    print("\nClass Distribution")
    print(df["species"].value_counts())

    print("\nStatistical Summary")
    print(df.describe())

# ----------------------------------------------------------
# Step 3 : Decide Variables
# ----------------------------------------------------------

def DecideVariable(df):

    print(Border)
    print("Step 3 : Independent and Dependent Variables")
    print(Border)

    feature_cols = [
        "sepal length (cm)",
        "sepal width (cm)",
        "petal length (cm)",
        "petal width (cm)"
    ]

    X = df[feature_cols]
    Y = df["species"]

    print("X Shape :", X.shape)
    print("Y Shape :", Y.shape)

    return X, Y

# ----------------------------------------------------------
# Step 4 : Visualization
# ----------------------------------------------------------

def Visualize(df):

    print(Border)
    print("Step 4 : Visualization")
    print(Border)

    plt.figure(figsize=(7,5))

    for sp in df["species"].unique():

        temp = df[df["species"] == sp]

        plt.scatter(
            temp["petal length (cm)"],
            temp["petal width (cm)"],
            label=sp
        )

    plt.title("Iris Dataset")
    plt.xlabel("Petal Length")
    plt.ylabel("Petal Width")
    plt.legend()
    plt.grid()
    plt.show()

# ----------------------------------------------------------
# Step 5 : Split Data
# ----------------------------------------------------------

def SplitData(X, Y):

    print(Border)
    print("Step 5 : Train-Test Split")
    print(Border)

    X_train, X_test, Y_train, Y_test = train_test_split(
        X,
        Y,
        test_size=0.5,
        random_state=42
    )

    print("X_train :", X_train.shape)
    print("X_test  :", X_test.shape)
    print("Y_train :", Y_train.shape)
    print("Y_test  :", Y_test.shape)

    return X_train, X_test, Y_train, Y_test

# ----------------------------------------------------------
# Step 6 : Build Model
# ----------------------------------------------------------

def BuildModel():

    print(Border)
    print("Step 6 : Build Model")
    print(Border)

    model = DecisionTreeClassifier(max_depth=5)

    print("Model Created Successfully")

    return model

# ----------------------------------------------------------
# Step 7 : Train Model
# ----------------------------------------------------------

def TrainModel(model, X_train, Y_train):

    print(Border)
    print("Step 7 : Train Model")
    print(Border)

    model.fit(X_train, Y_train)

    print("Model Trained Successfully")

    return model

# ----------------------------------------------------------
# Step 8 : Prediction
# ----------------------------------------------------------

def Predict(model, X_test):

    print(Border)
    print("Step 8 : Prediction")
    print(Border)

    Y_pred = model.predict(X_test)

    return Y_pred

# ----------------------------------------------------------
# Step 9 : Evaluate Model
# ----------------------------------------------------------

def Evaluate(Y_test, Y_pred):

    print(Border)
    print("Step 9 : Model Performance")
    print(Border)

    accuracy = accuracy_score(Y_test, Y_pred)

    print("Accuracy :", accuracy)

    cm = confusion_matrix(Y_test, Y_pred)

    print("\nConfusion Matrix")
    print(cm)

    print("\nClassification Report")
    print(classification_report(Y_test, Y_pred))

# ----------------------------------------------------------
# Main Function
# ----------------------------------------------------------

def main():

    df = LoadDataset()

    DataAnalysis(df)

    Visualize(df)

    X, Y = DecideVariable(df)

    X_train, X_test, Y_train, Y_test = SplitData(X, Y)

    model = BuildModel()

    model = TrainModel(model, X_train, Y_train)

    Y_pred = Predict(model, X_test)

    print("\nActual Values")
    print(Y_test.values)

    print("\nPredicted Values")
    print(Y_pred)

    Evaluate(Y_test, Y_pred)

# ----------------------------------------------------------
# Driver Code
# ----------------------------------------------------------

if __name__ == "__main__":
    main()