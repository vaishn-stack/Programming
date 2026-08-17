import pandas as pd
from sklearn.linear_model import LinearRegression

def main():
    print("Linear Regression")
    print("-" * 60)

    # Dataset
    data = {
        "StudyHours": [1, 2, 3, 4, 5],
        "Marks": [50, 55, 60, 65, 70]
    }

    df = pd.DataFrame(data)

    print("\nDataset:")
    print(df)

    # Input and Output
    X = df[["StudyHours"]]
    Y = df["Marks"]

    # Create Linear Regression model
    model = LinearRegression()

    # Train the model
    model.fit(X, Y)

    # Print coefficient
    print("\nCoefficient :", model.coef_[0])

    # Print intercept
    print("Intercept   :", model.intercept_)


if __name__ == "__main__":
    main()