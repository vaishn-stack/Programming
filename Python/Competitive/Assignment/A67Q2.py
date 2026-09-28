import numpy as np

from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.neural_network import MLPClassifier
from sklearn.metrics import accuracy_score

# ============================================================
# 1. Dataset
# ============================================================

X = np.array([
    [25000, 600, 200000, 10000, 0],
    [40000, 700, 300000, 8000, 1],
    [60000, 750, 500000, 12000, 1],
    [20000, 550, 150000, 15000, 0],
    [80000, 800, 700000, 10000, 1],
    [35000, 650, 250000, 9000, 1],
    [18000, 500, 100000, 12000, 0],
    [90000, 850, 800000, 15000, 1],
    [30000, 580, 200000, 14000, 0],
    [70000, 780, 600000, 10000, 1]
])

y = np.array([
    0, 1, 1, 0, 1,
    1, 0, 1, 0, 1
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
# 7. Test New Applicant
# ============================================================

new_applicant = np.array([
    [55000, 720, 400000, 10000, 1]
])

new_applicant_scaled = scaler.transform(new_applicant)

prediction = model.predict(new_applicant_scaled)

if prediction[0] == 0:
    print("Prediction: Loan Rejected")
else:
    print("Prediction: Loan Approved")