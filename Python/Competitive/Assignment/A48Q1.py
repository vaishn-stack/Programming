def main():

    X = [1, 2, 3, 4, 5]
    Y = [3, 4, 2, 4, 5]

    n = len(X)

    # Mean of X
    mean_x = sum(X) / n

    # Mean of Y
    mean_y = sum(Y) / n

    # Calculate numerator and denominator
    numerator = 0
    denominator = 0

    for i in range(n):
        numerator = numerator + ((X[i] - mean_x) *
                                 (Y[i] - mean_y))

        denominator = denominator + ((X[i] - mean_x) ** 2)

    # Calculate slope
    m = numerator / denominator

    # Calculate intercept
    c = mean_y - (m * mean_x)

    print("Mean of X =", mean_x)
    print("Mean of Y =", mean_y)

    print("Slope (m) =", m)
    print("Intercept (c) =", c)

    print("\nRegression Equation:")
    print("Y =", m, "X +", c)

    # Prediction
    x = 6
    predicted_y = (m * x) + c

    print("\nPredicted Y for X =", x, ":", predicted_y)


if __name__ == "__main__":
    main()