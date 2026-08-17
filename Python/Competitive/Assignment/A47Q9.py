import pandas as pd
from sklearn.linear_model import LinearRegression

def main():
    print("Multiple Linear Regression")
    print("-" * 60)

    # Dataset
    data = {
        "StudyHours": [1, 2, 3, 4, 5],
        "SleepHours": [7, 6, 7, 6, 8],
        "Marks": [50, 55, 60, 65, 70]
    }

    df = pd.DataFrame(data)

    print("\nDataset:")
    print(df)

    # Input features
    X = df[["StudyHours", "SleepHours"]]

    # Output
    Y = df["Marks"]

    # Create model
    model = LinearRegression()

    # Train model
    model.fit(X, Y)

    # Print coefficients
    print("\nCoefficient of StudyHours :",
          model.coef_[0])

    print("Coefficient of SleepHours :",
          model.coef_[1])

    # Print intercept
    print("Intercept :", model.intercept_)


if __name__ == "__main__":
    main()