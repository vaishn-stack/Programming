import pandas as pd

from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.impute import SimpleImputer

from sklearn.linear_model import LogisticRegression

from sklearn.metrics import (
    accuracy_score,
    precision_score,
    recall_score,
    f1_score,
    confusion_matrix,
    classification_report
)


# --------------------------------------------------
# 1. Load Dataset
# --------------------------------------------------

df = pd.read_csv("Fraudulent_Transaction_Detection.csv")

print("First 5 records:")
print(df.head())

print("\nDataset Shape:")
print(df.shape)


# --------------------------------------------------
# 2. Check Missing Values
# --------------------------------------------------

print("\nMissing Values:")
print(df.isnull().sum())


# --------------------------------------------------
# 3. Separate Features and Target
# --------------------------------------------------

X = df.drop("Fraud", axis=1)
y = df["Fraud"]


# --------------------------------------------------
# 4. Handle Missing Values
# --------------------------------------------------

imputer = SimpleImputer(strategy="mean")

X = pd.DataFrame(
    imputer.fit_transform(X),
    columns=X.columns
)


# --------------------------------------------------
# 5. Split Dataset
# --------------------------------------------------

X_train, X_test, y_train, y_test = train_test_split(
    X,
    y,
    test_size=0.2,
    random_state=42,
    stratify=y
)


# --------------------------------------------------
# 6. Feature Scaling
# --------------------------------------------------

scaler = StandardScaler()

X_train_scaled = scaler.fit_transform(X_train)

X_test_scaled = scaler.transform(X_test)


# --------------------------------------------------
# 7. Create Model
# --------------------------------------------------

model = LogisticRegression(
    max_iter=1000,
    random_state=42
)


# --------------------------------------------------
# 8. Train Model
# --------------------------------------------------

model.fit(
    X_train_scaled,
    y_train
)


# --------------------------------------------------
# 9. Make Predictions
# --------------------------------------------------

y_pred = model.predict(
    X_test_scaled
)


# --------------------------------------------------
# 10. Calculate Metrics
# --------------------------------------------------

accuracy = accuracy_score(
    y_test,
    y_pred
)

precision = precision_score(
    y_test,
    y_pred,
    zero_division=0
)

recall = recall_score(
    y_test,
    y_pred,
    zero_division=0
)

f1 = f1_score(
    y_test,
    y_pred,
    zero_division=0
)


# --------------------------------------------------
# 11. Confusion Matrix
# --------------------------------------------------

cm = confusion_matrix(
    y_test,
    y_pred
)


# --------------------------------------------------
# 12. Display Results
# --------------------------------------------------

print("\nPerformance Metrics:")

print("Accuracy :", accuracy)

print("Precision:", precision)

print("Recall   :", recall)

print("F1 Score :", f1)

print("\nConfusion Matrix:")
print(cm)

print("\nClassification Report:")
print(
    classification_report(
        y_test,
        y_pred,
        zero_division=0
    )
)