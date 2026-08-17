import numpy as np
from sklearn.preprocessing import StandardScaler

# 3. Feature Scaling Using StandardScaler
border = "-" * 60

print(border)

data = np.array([
    [25, 200000],
    [30, 400000],
    [35, 800000]
])

scaler = StandardScaler()

scaled_data = scaler.fit_transform(data)

print("Original Dataset : ")
print(data)

print("Scaled Dataset : ")
print(scaled_data)





