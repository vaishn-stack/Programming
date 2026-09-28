import numpy as np

from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.neural_network import MLPClassifier
from sklearn.metrics import accuracy_score

# ============================================================
# 1. Dataset
# ============================================================

X = np.array([
    [25, 500, 12, 1, 2],
    [30, 700, 24, 0, 1],
    [45, 1200, 6, 5, 8],
    [50, 1500, 5, 6, 10],
    [28, 600, 18, 1, 1],
    [35, 800, 30, 0, 0],
    [48, 1400, 4, 7, 9],
    [52, 1600, 3, 8, 12],
    [27, 550, 20, 0, 1],
    [42, 1300, 8, 4, 7]
])

y = np.array([
    0, 0, 1, 1, 0,
    0, 1, 0, 1, 1
])

# ============================================================
# 2. Feature Scaling
# ============================================================

scaler = StandardScaler()

X_scaled = scaler.fit_transform(X)

# ============================================================
# 3. Train-Test Split
# ============================================================

X_train, X_test, y_train, y_test = train_test_split(
    X_scaled,
    y,
    test_size=0.2,
    random_state=42
)

# ============================================================
# 4. Create Neural Network
# ============================================================

model = MLPClassifier(
    hidden_layer_sizes=(10, 5),
    activation='relu',
    max_iter=2000,
    random_state=42
)

# ============================================================
# 5. Train Model
# ============================================================

model.fit(X_train, y_train)

# ============================================================
# 6. Evaluate Model
# ============================================================

y_pred = model.predict(X_test)

accuracy = accuracy_score(y_test, y_pred)

print("Model Accuracy:", accuracy)

# ============================================================
# 7. Test New Customer
# ============================================================

new_customer = np.array([
    [46, 1450, 5, 6, 9]
])

new_customer_scaled = scaler.transform(new_customer)

prediction = model.predict(new_customer_scaled)

if prediction[0] == 0:
    print("Prediction: Customer will stay")
else:
    print("Prediction: Customer may leave")