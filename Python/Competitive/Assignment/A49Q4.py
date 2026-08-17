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

# 4. Euclidean Distance Before and After Feature Scaling

# Points 
P1 = data[0]
P2 = data[1]

# Distance before scaling
distance_before = np.linalg.norm(P1 - P2)

scaled_P1 = scaled_data[0]
scaled_P2 = scaled_data[1]

# Distance after scaling
distance_after = np.linalg.norm(
    scaled_P1 - scaled_P2
)

print("Distance Before Scaling :", distance_before)
print("Distance After Scaling  :", distance_after)
