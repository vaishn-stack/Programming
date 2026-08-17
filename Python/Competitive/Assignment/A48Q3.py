import pandas as pd
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression

def main():

    # Dataset
    data = {
        "Experience": [1, 2, 3, 4, 5],
        "Salary": [20000, 25000, 30000, 35000, 40000]
    }

    df = pd.DataFrame(data)

    # Input and output
    X = df[["Experience"]]
    Y = df["Salary"]

    # Create model
    model = LinearRegression()

    # Train model
    model.fit(X, Y)

    # Predict salary for 6 years
    prediction = model.predict([[6]])

    print("Coefficient :", model.coef_[0])
    print("Intercept   :", model.intercept_)

    print("\nPredicted Salary for 6 Years Experience: ₹",
          prediction[0])

    # Plot data points
    plt.scatter(X, Y, label="Data Points")

    # Regression line
    plt.plot(X, model.predict(X),
             label="Regression Line")

    plt.xlabel("Experience")
    plt.ylabel("Salary")
    plt.title("Experience vs Salary")

    plt.legend()
    plt.show()


if __name__ == "__main__":
    main()