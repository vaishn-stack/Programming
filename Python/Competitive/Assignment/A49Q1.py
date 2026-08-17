import numpy as np

# Q1. Calculate Mean Using NumPy
border = "-" * 60

print(border)

data = np.array([6,7, 8, 9, 10, 11, 12])

mean = np.mean(data)

print("Dataset : ", data)
print("Mean : ", mean)

print(border)
