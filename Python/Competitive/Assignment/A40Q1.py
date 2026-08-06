import pandas as pd

from sklearn.model_selection import train_test_split
from sklearn.tree import DecisionTreeClassifier
from sklearn.metrics import accuracy_score

# Load Dataset
df = pd.read_csv("student_performance_ml.csv")

# Features and Target
X = df.drop("FinalResult", axis=1)
y = df["FinalResult"]

# Train-Test Split
X_train, X_test, y_train, y_test = train_test_split(
    X,
    y,
    test_size=0.2,
    random_state=42
)

# Train Model
model = DecisionTreeClassifier(random_state=42)
model.fit(X_train, y_train)

# Prediction
y_pred = model.predict(X_test)

# Accuracy
accuracy = accuracy_score(y_test, y_pred)

# -----------------------------
# 1. Feature Importance
# -----------------------------

print("\nFeature Importance\n")

importance = pd.DataFrame({
    "Feature": X.columns,
    "Importance": model.feature_importances_
})

print(importance)

print("\nMost Important Feature :",
      importance.loc[importance["Importance"].idxmax(), "Feature"])

print("Least Important Feature :",
      importance.loc[importance["Importance"].idxmin(), "Feature"])

# -----------------------------
# 2. Remove SleepHours
# -----------------------------

X_new = df.drop(["SleepHours", "FinalResult"], axis=1)
y_new = df["FinalResult"]

X_train2, X_test2, y_train2, y_test2 = train_test_split(
    X_new,
    y_new,
    test_size=0.2,
    random_state=42
)

model2 = DecisionTreeClassifier(random_state=42)

model2.fit(X_train2, y_train2)

pred2 = model2.predict(X_test2)

accuracy2 = accuracy_score(y_test2, pred2)

print("\nAccuracy after removing SleepHours = {:.2f}%".format(accuracy2 * 100))
print("Previous Accuracy = {:.2f}%".format(accuracy * 100))

if accuracy2 > accuracy:
    print("Accuracy Improved")
elif accuracy2 < accuracy:
    print("Accuracy Reduced")
else:
    print("No Change in Accuracy")
    
# -----------------------------
# 3. StudyHours + Attendance
# -----------------------------

X_small = df[["StudyHours", "Attendance"]]
y_small = df["FinalResult"]

X_train3, X_test3, y_train3, y_test3 = train_test_split(
    X_small,
    y_small,
    test_size=0.2,
    random_state=42
)

model3 = DecisionTreeClassifier(random_state=42)

model3.fit(X_train3, y_train3)

pred3 = model3.predict(X_test3)

accuracy3 = accuracy_score(y_test3, pred3)

print("\nAccuracy using only StudyHours and Attendance = {:.2f}%".format(accuracy3 * 100))
print("Accuracy using all features = {:.2f}%".format(accuracy * 100))

# -----------------------------
# 4. Predict 5 Students
# -----------------------------

students = pd.DataFrame({

    "StudyHours":[2,4,6,7,8],
    "Attendance":[60,72,85,91,95],
    "PreviousScore":[45,58,66,75,88],
    "AssignmentsCompleted":[3,5,7,8,9],
    "SleepHours":[5,6,7,7,8]

})

students["PredictedResult"] = model.predict(students)

print("\nPrediction for 5 Students\n")
print(students)

# -----------------------------
# 5. Manual Accuracy
# -----------------------------

correct = (y_test.values == y_pred).sum()

manual_accuracy = (correct / len(y_test)) * 100

print("\nManual Accuracy = {:.2f}%".format(manual_accuracy))
print("Sklearn Accuracy = {:.2f}%".format(accuracy * 100))

# -----------------------------
# 6. Misclassified Students
# -----------------------------

misclassified = X_test[y_test != y_pred].copy()

misclassified["Actual"] = y_test[y_test != y_pred].values
misclassified["Predicted"] = y_pred[y_test != y_pred]

print("\nMisclassified Students\n")
print(misclassified)

print("\nNumber of Misclassified Students :", len(misclassified))

