def main():

    X = [1, 2, 3, 4, 5]
    Y = [3, 4, 2, 4, 5]

    # Regression equation
    m = 0.4
    c = 2.4

    predicted = []

    # Predict Y values
    for x in X:
        y_pred = (m * x) + c
        predicted.append(y_pred)

    print("Actual Y    :", Y)
    print("Predicted Y :", predicted)

    # Calculate MSE
    squared_error = 0

    for i in range(len(Y)):
        error = Y[i] - predicted[i]
        squared_error = squared_error + (error ** 2)

    mse = squared_error / len(Y)

    print("\nSum of Squared Error :", squared_error)
    print("Mean Squared Error   :", mse)

    # Calculate R2
    mean_y = sum(Y) / len(Y)

    total_sum = 0

    for y in Y:
        total_sum = total_sum + ((y - mean_y) ** 2)

    r2 = 1 - (squared_error / total_sum)

    print("R2 Score             :", r2)


if __name__ == "__main__":
    main()