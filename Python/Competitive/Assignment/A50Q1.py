import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import accuracy_score, confusion_matrix, classification_report


def BreastCancerPredictor():

    print("Breast Cancer Classification")

    border = "-" * 60

    # --------------------------------------------------
    # Step 1 : Load Dataset
    # --------------------------------------------------

    print(border)
    print("Step 1 : Load Dataset")
    print(border)

    df = pd.read_csv("breast-cancer-wisconsin.csv")

    print("Data Loaded Successfully.")

    print("Dataset:")
    print(df)

    print("Number of Records :", df.shape[0])
    print("Number of Features :", df.shape[1])

    print("Column Names:")
    for column in df.columns:
        print(column)

    print("First 5 Records:")
    print(df.head())

    # --------------------------------------------------
    # Separate Input and Output
    # --------------------------------------------------

    X = df.drop(["CodeNumber", "CancerType"], axis=1)

    Y = df["CancerType"]

    print("Input Features:")
    print(X.columns)

    print("Target Column:")
    print(Y.name)

    # --------------------------------------------------
    # Convert ? into NaN
    # --------------------------------------------------

    X = X.replace("?", np.nan)

    # Convert all columns into numeric
    X = X.apply(pd.to_numeric)

    # --------------------------------------------------
    # Step 2 : Explore Dataset
    # --------------------------------------------------

    print(border)
    print("Step 2 : Explore Dataset")
    print(border)

    print("Dataset Information:")
    X.info()

    print("Target Values:")
    print(Y.value_counts())

    print("Target Names:")
    print("2 = Benign")
    print("4 = Malignant")

    print("Summary Statistics:")
    print(X.describe())

    # --------------------------------------------------
    # Step 3 : Check Missing Values
    # --------------------------------------------------

    print(border)
    print("Step 3 : Check Missing Values")
    print(border)

    missing_values = X.isnull().sum()

    print("Missing Values:")
    print(missing_values)

    if missing_values.sum() == 0:
        print("No missing values found.")
    else:
        print("Missing values are present.")
        print("Handling missing values using Median...")

        X = X.fillna(X.median())

        print("Missing values handled successfully.")

    print("Missing Values After Treatment:")
    print(X.isnull().sum())

    # --------------------------------------------------
    # Step 4 : Feature Scaling
    # --------------------------------------------------

    print(border)
    print("Step 4 : Feature Scaling")
    print(border)

    scaler = StandardScaler()

    X_scaled = scaler.fit_transform(X)

    print("Feature scaling completed successfully.")

    print("Scaled Dataset:")
    print(X_scaled)

    # --------------------------------------------------
    # Step 5 : Exploratory Data Analysis
    # --------------------------------------------------

    print(border)
    print("Step 5 : Exploratory Data Analysis")
    print(border)

    correlation = X.corr()

    print("Correlation Matrix:")
    print(correlation)

    plt.figure(figsize=(14, 10))

    sns.heatmap(
        correlation,
        cmap="coolwarm",
        annot=False
    )

    plt.title("Feature Correlation Heatmap")
    plt.tight_layout()
    plt.show()

    # --------------------------------------------------
    # Step 6 : Train Test Split
    # --------------------------------------------------

    print(border)
    print("Step 6 : Train Test Split")
    print(border)

    X_train, X_test, Y_train, Y_test = train_test_split(
        X_scaled,
        Y,
        test_size=0.2,
        random_state=42,
        stratify=Y
    )

    print("Training Records :", X_train.shape[0])
    print("Testing Records  :", X_test.shape[0])

    # --------------------------------------------------
    # Step 7 : Build Machine Learning Model
    # --------------------------------------------------

    print(border)
    print("Step 7 : Build Machine Learning Model")
    print(border)

    model = LogisticRegression(max_iter=1000)

    model.fit(X_train, Y_train)

    print("Model training completed successfully.")

    # --------------------------------------------------
    # Step 8 : Prediction
    # --------------------------------------------------

    print(border)
    print("Step 8 : Prediction")
    print(border)

    Y_pred = model.predict(X_test)

    print("Prediction completed successfully.")

    # --------------------------------------------------
    # Step 9 : Model Evaluation
    # --------------------------------------------------

    print(border)
    print("Step 9 : Model Evaluation")
    print(border)

    accuracy = accuracy_score(
        Y_test,
        Y_pred
    )

    print("Accuracy :", accuracy)

    print("Accuracy Percentage :", accuracy * 100, "%")

    # --------------------------------------------------
    # Step 10 : Confusion Matrix
    # --------------------------------------------------

    print(border)
    print("Step 10 : Confusion Matrix")
    print(border)

    cm = confusion_matrix(
        Y_test,
        Y_pred
    )

    print("Confusion Matrix:")
    print(cm)

    plt.figure(figsize=(6, 5))

    sns.heatmap(
        cm,
        annot=True,
        fmt="d",
        cmap="Blues",
        xticklabels=["Benign", "Malignant"],
        yticklabels=["Benign", "Malignant"]
    )

    plt.xlabel("Predicted")
    plt.ylabel("Actual")
    plt.title("Confusion Matrix")
    plt.tight_layout()
    plt.show()

    # --------------------------------------------------
    # Step 11 : Classification Report
    # --------------------------------------------------

    print(border)
    print("Step 11 : Classification Report")
    print(border)

    print(
        classification_report(
            Y_test,
            Y_pred,
            target_names=["Benign", "Malignant"]
        )
    )

    # --------------------------------------------------
    # Step 12 : Observations
    # --------------------------------------------------

    print(border)
    print("Step 12 : Observations")
    print(border)

    print("1. Breast Cancer Wisconsin dataset contains", X.shape[0], "records.")

    print("2. Dataset contains", X.shape[1], "features.")

    print("3. CodeNumber was removed because it is an ID.")

    print("4. '?' values in BareNuclei were treated as missing values.")

    print("5. Missing values were replaced using median.")

    print("6. Features were standardized using StandardScaler.")

    print("7. Logistic Regression was used for binary classification.")

    print("8. Model performance was evaluated using Accuracy,")

    print("   Confusion Matrix, Precision, Recall and F1-Score.")

    print("9. CancerType 2 represents Benign.")

    print("10. CancerType 4 represents Malignant.")


def main():

    BreastCancerPredictor()


if __name__ == "__main__":

    main()