import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.neural_network import MLPClassifier
from sklearn.metrics import accuracy_score, confusion_matrix, ConfusionMatrixDisplay

# ============================================================
# 1. Load Dataset
# ============================================================

df = pd.read_csv("Employee_Attrition.csv")

print("1. Load the Dataset")
print(df)

# ============================================================
# 2. Display Shape, Columns and First Five Records
# ============================================================

print("\n================ SHAPE =================")
print(df.shape)
print("\n================ Columns =================")
print(df.columns)
print("\n================ First 5 Records =================")
print(df.head())

# ============================================================
# 3. Check Missing Values
# ============================================================

print("\n================ MISSING VALUES =================")
print(df.isnull().sum())

# ============================================================
# 4. Identify Numerical and Categorical Features
# ============================================================

numerical_features = df.select_dtypes(include = np.number).columns
categorical_features = df.select_dtypes(exclude = np.number).columns

print("\n================ NUMERICAL FEATURES =================")
print(list(numerical_features))

print("\n================ CATEGORICAL FEATURES =================")
print(list(categorical_features))

# ============================================================
# 5. Convert Categorical Feature OverTime into Numerical
# ============================================================

df["OverTime"] = df["OverTime"].map({
    "Yes" : 1,
    "No" : 0
})

# ============================================================
# 6. Convert Target Attrition into 0 and 1
# ============================================================

df["Attrition"] = df["Attrition"].map({
    "Yes" : 1,
    "No" : 0
})

print("\n================ AFTER ENCODING =================")
print(df.head())

# ============================================================
# 7. Separate Independent and Dependent Variables
# ============================================================

X = df.drop("Attrition", axis = 1)
Y = df["Attrition"]

print("\n================ INDEPENDENT VARIABLES =================")
print(X.head())

print("\n================ DEPENDENT VARIABLE =================")
print(Y.head())

# ============================================================
# 8. Divide Dataset into Training and Testing Data
# ============================================================

X_train, X_test, y_train, y_test = train_test_split(
    X,
    Y,
    test_size = 0.2,
    random_state = 42,
    stratify = Y
)

print("\n================ DATA SPLIT =================")
print("Training data :", X_train.shape)
print("Testing data  :", X_test.shape)

# ============================================================
# 9. Feature Scaling
# ============================================================

scaler = StandardScaler()

X_train_scaled = scaler.fit_transform(X_train)

X_test_scaled = scaler.transform(X_test)

# ============================================================
# 10. Design MLP with At Least Two Hidden Layers
# ============================================================

model = MLPClassifier(
    hidden_layer_sizes = (16, 8),
    activation = "relu",
    solver = "adam",
    max_iter = 1000,
    random_state = 42
)

# ============================================================
# 11. Train the Network
# ============================================================

model.fit(X_train_scaled, y_train)

# ============================================================
# 12. Display Number of Iterations Required
# ============================================================

print("\n================ TRAINING INFORMATION =================")

print("Number of iterations required:", model.n_iter_)


# ============================================================
# 13. Calculate Training Accuracy
# ============================================================

y_train_pred = model.predict(X_train_scaled)

train_accuracy = accuracy_score(
    y_train,
    y_train_pred
)

print("\nTraining Accuracy:", train_accuracy * 100, "%")

# ============================================================
# 14. Calculate Testing Accuracy
# ============================================================

y_test_pred = model.predict(X_test_scaled)

test_accuracy = accuracy_score(
    y_test,
    y_test_pred
)

print("Testing Accuracy:", test_accuracy * 100, "%")

# ============================================================
# 15. Generate Confusion Matrix
# ============================================================

cm = confusion_matrix(
    y_test,
    y_test_pred
)

print("\n================ CONFUSION MATRIX =================")
print(cm)

disp = ConfusionMatrixDisplay(
    confusion_matrix = cm,
    display_labels = ["Stay", "Leave"]
)

disp.plot()

plt.title("Employee Attrition Confusion Matrix")
plt.show()


# ============================================================
# 16. Plot Loss Curve
# ============================================================

plt.figure(figsize = (8, 5))

plt.plot(model.loss_curve_)

plt.xlabel("Iterations")
plt.ylabel("Loss")

plt.title("MLP Training Loss Curve")

plt.grid()

plt.show()


# ============================================================
# 17. PredictAttribution Function
# ============================================================

def PredictAttribution(employee_data):

    # Convert input dictionary into DataFrame
    employee_df = pd.DataFrame(
        [employee_data]
    )

    # Scale input data
    employee_scaled = scaler.transform(
        employee_df
    )

    # Prediction
    prediction = model.predict(
        employee_scaled
    )[0]

    # Probability
    probability = model.predict_proba(
        employee_scaled
    )[0][1]

    if prediction == 1:
        result = "Employee is likely to leave"
    else:
        result = "Employee is likely to stay"

    print("\n--------------------------------")
    print("Employee Prediction")
    print("----------------------------------")
    print("Prediction:", prediction)
    print("Probability of Leaving:", round(probability * 100, 2), "%")
    print("Result:", result)

    return prediction


# ============================================================
# 18. Test Using Five New Employee Records
# ============================================================

employee1 = {
    "Age": 25,
    "MonthlyIncome": 3000,
    "YearsAtCompany": 1,
    "TotalWorkingYears": 2,
    "DistanceFromHome": 15,
    "JobSatisfaction": 2,
    "WorkLifeBalance": 2,
    "OverTime": 1,
    "NumCompaniesWorked": 2,
    "TrainingTimesLastYear": 2
}


employee2 = {
    "Age": 40,
    "MonthlyIncome": 8000,
    "YearsAtCompany": 10,
    "TotalWorkingYears": 15,
    "DistanceFromHome": 5,
    "JobSatisfaction": 4,
    "WorkLifeBalance": 4,
    "OverTime": 0,
    "NumCompaniesWorked": 1,
    "TrainingTimesLastYear": 4
}


employee3 = {
    "Age": 30,
    "MonthlyIncome": 4000,
    "YearsAtCompany": 3,
    "TotalWorkingYears": 5,
    "DistanceFromHome": 20,
    "JobSatisfaction": 2,
    "WorkLifeBalance": 2,
    "OverTime": 1,
    "NumCompaniesWorked": 3,
    "TrainingTimesLastYear": 1
}


employee4 = {
    "Age": 45,
    "MonthlyIncome": 10000,
    "YearsAtCompany": 15,
    "TotalWorkingYears": 20,
    "DistanceFromHome": 3,
    "JobSatisfaction": 4,
    "WorkLifeBalance": 4,
    "OverTime": 0,
    "NumCompaniesWorked": 2,
    "TrainingTimesLastYear": 5
}


employee5 = {
    "Age": 28,
    "MonthlyIncome": 3500,
    "YearsAtCompany": 2,
    "TotalWorkingYears": 4,
    "DistanceFromHome": 25,
    "JobSatisfaction": 1,
    "WorkLifeBalance": 2,
    "OverTime": 1,
    "NumCompaniesWorked": 4,
    "TrainingTimesLastYear": 2
}


print("\n================ FIVE NEW EMPLOYEES =================")

PredictAttribution(employee1)

PredictAttribution(employee2)

PredictAttribution(employee3)

PredictAttribution(employee4)

PredictAttribution(employee5)


# ============================================================
# 19. Check Overfitting / Underfitting
# ============================================================

print("\n================ MODEL ANALYSIS =================")

difference = train_accuracy - test_accuracy

print("Training Accuracy:", round(train_accuracy * 100, 2), "%")

print("Testing Accuracy:", round(test_accuracy * 100, 2), "%")

if train_accuracy > 0.95 and difference > 0.10:

    print("Model may be suffering from OVERFITTING.")

elif train_accuracy < 0.70 and test_accuracy < 0.70:

    print("Model may be suffering from UNDERFITTING.")

else:

    print("Model has reasonably good generalization.")