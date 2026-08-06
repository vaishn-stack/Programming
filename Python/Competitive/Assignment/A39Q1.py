# ==========================================================
# Decision Tree Classification Assignment
# ==========================================================

# -----------------------------
# 1. Import Required Libraries
# -----------------------------

import pandas as pd
import matplotlib.pyplot as plt

from sklearn.model_selection import train_test_split
from sklearn.tree import DecisionTreeClassifier
from sklearn.metrics import accuracy_score
from sklearn.metrics import confusion_matrix
from sklearn.metrics import ConfusionMatrixDisplay

# -----------------------------
# 2. Load Dataset
# -----------------------------
df = pd.read_csv("student_performance_ml.csv")

print("First 5 Records:\n")
print(df.head())

print("\nDataset Information:\n")
print(df.info())

print("\nColumn Names:")
print(df.columns.tolist())

# Remove extra spaces from column names
df.columns = df.columns.str.strip()

print("\nMissing Values:")
print(df.isnull().sum())

print("\nStatistical Summary:")
print(df.describe())

# -----------------------------
# 3. Detect Target Column
# -----------------------------
if "PassFail" in df.columns:
    target = "PassFail"
elif "Result" in df.columns:
    target = "Result"
elif "Performance" in df.columns:
    target = "Performance"
else:
    print("\nERROR: Target column not found.")
    print("Available Columns:", df.columns.tolist())
    exit()

# -----------------------------
# 4. Visualization
# -----------------------------
df[target].value_counts().plot(kind="bar")
plt.title("Class Distribution")
plt.xlabel(target)
plt.ylabel("Count")
plt.show()

# -----------------------------
# 5. Prepare Data
# -----------------------------
X = df.drop(columns=[target])
y = df[target]

# -----------------------------
# 6. Train Test Split
# -----------------------------
X_train, X_test, y_train, y_test = train_test_split(
    X,
    y,
    test_size=0.2,
    random_state=42
)

# -----------------------------
# 7. Train Model
# -----------------------------
model = DecisionTreeClassifier(random_state=42)

model.fit(X_train, y_train)

# -----------------------------
# 8. Prediction
# -----------------------------
y_pred = model.predict(X_test)

print("\nActual vs Predicted\n")

result = pd.DataFrame({
    "Actual": y_test.values,
    "Predicted": y_pred
})

print(result)

# -----------------------------
# 9. Testing Accuracy
# -----------------------------
accuracy = accuracy_score(y_test, y_pred)

print("\nTesting Accuracy = {:.2f}%".format(accuracy * 100))

# -----------------------------
# 10. Confusion Matrix
# -----------------------------
cm = confusion_matrix(y_test, y_pred)

print("\nConfusion Matrix")
print(cm)

ConfusionMatrixDisplay(confusion_matrix=cm).plot()
plt.show()

if cm.shape == (2, 2):
    TN, FP, FN, TP = cm.ravel()

    print("\nTrue Positive :", TP)
    print("True Negative :", TN)
    print("False Positive:", FP)
    print("False Negative:", FN)

# -----------------------------
# 11. Training Accuracy
# -----------------------------
train_pred = model.predict(X_train)

train_accuracy = accuracy_score(y_train, train_pred)

print("\nTraining Accuracy = {:.2f}%".format(train_accuracy * 100))

# -----------------------------
# 12. Compare Accuracy
# -----------------------------
print("\nTraining Accuracy :", round(train_accuracy * 100, 2))
print("Testing Accuracy  :", round(accuracy * 100, 2))

difference = train_accuracy - accuracy

if difference > 0.10:
    print("Model is Overfitting")
elif difference < -0.05:
    print("Model is Underfitting")
else:
    print("Model is Well Fitted")

# -----------------------------
# 13. Compare max_depth
# -----------------------------
print("\nComparison of Different max_depth\n")

for depth in [1, 3, None]:

    dt = DecisionTreeClassifier(max_depth=depth, random_state=42)

    dt.fit(X_train, y_train)

    pred = dt.predict(X_test)

    acc = accuracy_score(y_test, pred)

    print(f"max_depth = {depth} --> Accuracy = {acc*100:.2f}%")

# -----------------------------
# 14. Predict New Student
# -----------------------------
new_student = pd.DataFrame({
    "StudyHours": [6],
    "Attendance": [85],
    "PreviousScore": [66],
    "AssignmentsCompleted": [7],
    "SleepHours": [7]
})

prediction = model.predict(new_student)

print("\nPrediction for New Student:", prediction[0])

if str(prediction[0]).lower() in ["pass", "1"]:
    print("Student will PASS")
else:
    print("Student will FAIL")
    
# -----------------------------
# End of program
# -----------------------------