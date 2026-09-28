# Input
x = 2

# Initial weight and bias
weight = 0.5
bias = 0.1

# Target output
target = 1

# Learning rate
learning_rate = 0.1

# Calculate prediction
prediction = (x * weight) + bias

# Calculate error
error = target - prediction

# Gradient Descent weight update
weight = weight + (learning_rate * error * x)

# Bias update
bias = bias + (learning_rate * error)

# Display results
print("Prediction:", prediction)
print("Error:", error)
print("Updated Weight:", weight)
print("Updated Bias:", bias)