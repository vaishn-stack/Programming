import pandas as pd
from sklearn.linear_model import LinearRegression

def main():
    # Dataset
    data = {
        "StudyHours": [1, 2, 3, 4, 5],
        "Marks": [50, 55, 60, 65, 70]
    }

    df = pd.DataFrame(data)

    # Input and Output
    X = df[["StudyHours"]]
    Y = df["Marks"]

    # Create model
    model = LinearRegression()

    # Train model
    model.fit(X, Y)

    # Predict marks for 6 study hours
    prediction = model.predict([[6]])

    print("Predicted Marks for 6 Study Hours :", prediction[0])


if __name__ == "__main__":
    main()