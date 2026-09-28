import numpy as np

# Actual and predicted values
actual = np.array([1, 0, 1, 1, 0])
predicted = np.array([0.9, 0.2, 0.8, 0.7, 0.1])

# -----------------------------
# Mean Squared Error
# -----------------------------

mse = np.mean((actual - predicted) ** 2)

print("Mean Squared Error:", mse)

# -----------------------------
# Binary Cross Entropy
# -----------------------------

epsilon = 1e-15

predicted = np.clip(predicted, epsilon, 1 - epsilon)

bce = -np.mean(
    actual * np.log(predicted) +
    (1 - actual) * np.log(1 - predicted)
)

print("Binary Cross Entropy:", bce)

# Explanation
print("\nMSE is mainly used for Regression.")
print("Binary Cross Entropy is mainly used for Binary Classification.")