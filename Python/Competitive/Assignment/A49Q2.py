import numpy as np

# 1. Calculate Mean Using NumPy
border = "-" * 60

print(border)

data = np.array([6,7, 8, 9, 10, 11, 12])

mean = np.mean(data)

print("Dataset : ", data)
print("Mean : ", mean)

print(border)

# 2. Calculate Variance and Standard Deviation

variance = np.var(data)
standard_deviation = np.std(data)

print("Variance : ", variance)
print("Standard Deviation : ", standard_deviation)

print(border)

