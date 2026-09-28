import math

# Input values
x1 = 2
x2 = 3

w1 = 0.4
w2 = 0.6

bias = 0.5

# 1. Calculate weighted sum
z = (x1 * w1) + (x2 * w2) + bias

# 2. Sigmoid activation function
output = 1 / (1 + math.exp(-z))

# 3. Display output
print("Weighted Sum:", z)
print("Sigmoid Output:", output)

# 4. Explain output
if output < 0.5:
    print("Output is close to 0")
else:
    print("Output is close to 1")