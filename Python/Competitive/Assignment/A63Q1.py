import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.neural_network import MLPClassifier

from sklearn.metrics import (
    accuracy_score,
    confusion_matrix,
    ConfusionMatrixDisplay,
    classification_report,
    precision_score,
    recall_score,
    f1_score
)

# ============================================================
# 1. Load and Understand the Dataset
# ============================================================

df = pd.read_csv("Loan_Default.csv")

print("\n================ DATASET =================")
print(df)

print("\n================ SHAPE =================")
print(df.shape)

print("\n================ COLUMNS =================")
print(df.columns)

print("\n================ FIRST 5 RECORDS =================")
print(df.head())

print("\n================ DATA TYPES =================")
print(df.dtypes)

print("\n================ DATASET INFORMATION =================")
print(df.info())

# ============================================================
# 2. Exploratory Data Analysis
# ============================================================

print("\n================ STATISTICAL SUMMARY =================")
print(df.describe())

print("\n================ UNIQUE VALUES =================")

for column in df.columns:
    print(column, ":", df[column].unique())
    
# ============================================================
# 3. Find Missing Values
# ============================================================

print("\n================ MISSING VALUES =================")
print(df.isnull().sum())

if df.isnull().sum().sum() > 0:
    print("\nMissing values are present.")

    # Fill numerical columns with median
    numerical_columns = df.select_dtypes(include=np.number).columns

    for column in numerical_columns:
        df[column] = df[column].fillna(df[column].median())

    # Fill categorical columns with mode
    categorical_columns = df.select_dtypes(exclude=np.number).columns
    
    for column in categorical_columns:
        df[column] = df[column].fillna(df[column].mode()[0])

else:
    print("\nNo missing values found.")

# ============================================================
# 4. Check Whether Target Classes are Balanced
# ============================================================

print("\n================ TARGET CLASS DISTRIBUTION =================")

print(df["Default"].value_counts())

print("\nTarget Class Percentage:")
print(df["Default"].value_counts(normalize=True) * 100)

plt.figure(figsize = (6, 4))

df["Default"].value_counts().plot(kind="bar")

plt.xlabel("Default Class")
plt.ylabel("Number of Applicants")
plt.title("Loan Default Class Distribution")

plt.show()

# ============================================================
# 5. Encode Categorical Variables
# ============================================================

print("\n================ CATEGORICAL VARIABLES =================")

categorical_columns = df.select_dtypes(exclude=np.number).columns

print(list(categorical_columns))

# PreviousDefault: Yes/No
if "PreviousDefault" in df.columns:

    df["PreviousDefault"] = df["PreviousDefault"].map({
        "Yes": 1,
        "No": 0
    })
    
# HomeOwnership: Rent/Own/Mortgage
if "HomeOwnership" in df.columns:

    df["HomeOwnership"] = df["HomeOwnership"].map({
        "Rent": 0,
        "Own": 1,
        "Mortgage": 2
    })

print("\n================ AFTER ENCODING =================")
print(df.head())

# ============================================================
# 6. Separate X and Y
# ============================================================

X = df.drop("Default", axis=1)
Y = df["Default"]

print("\n================ INDEPENDENT VARIABLES X =================")
print(X.head())

print("\n================ TARGET VARIABLE Y =================")
print(Y.head())

# ============================================================
# 7. Stratified Train-Test Split
# ============================================================

X_train, X_test, Y_train, Y_test = train_test_split(
    X,
    Y,
    test_size = 0.2,
    random_state = 42,
    stratify = Y
)


print("\n================ DATA SPLIT =================")

print("Training data : ", X_train.shape)
print("Testing data  : ", X_test.shape)

print("\nTraining class distribution:")
print(Y_train.value_counts())

print("\nTesting class distribution:")
print(Y_test.value_counts())

# ============================================================
# 8. Feature Scaling
# ============================================================

scaler = StandardScaler()

X_train_scaled = scaler.fit_transform(X_train)

X_test_scaled = scaler.transform(X_test)

# ============================================================
# 9. Create MLP Classifier
# ============================================================

model = MLPClassifier(
    hidden_layer_sizes = (32, 16),
    activation = "relu",
    solver = "adam",
    max_iter = 1000,
    random_state = 42
)

# ============================================================
# 10. Train the Model
# ============================================================

print("\n================ MODEL TRAINING =================")

model.fit(X_train_scaled, Y_train)

print("Model training completed.")

# ============================================================
# 11. Calculate Accuracy
# ============================================================

Y_pred = model.predict(X_test_scaled)

accuracy = accuracy_score(Y_test, Y_pred) 

print("\n================ ACCURACY =================")

print("Testing Accuracy:", round(accuracy * 100, 2), "%")

# ============================================================
# 12. Generate Confusion Matrix
# ============================================================

cm = confusion_matrix(
    Y_test,
    Y_pred
)

print("\n================ CONFUSION MATRIX =================")
print(cm)

disp = ConfusionMatrixDisplay(
    confusion_matrix = cm,
    display_labels = [
        "Low Risk",
        "High Risk"
    ]
)

disp.plot()

plt.title("Loan Default Confusion Matrix")

plt.show()

# ============================================================
# 13. Classification Report
# ============================================================

print("\n================ CLASSIFICATION REPORT =================")

print(classification_report(
        Y_test,
        Y_pred
    )
)

# ============================================================
# 14. Precision
# ============================================================

precision = precision_score(
    Y_test,
    Y_pred,
    zero_division = 0
)

print("\nPrecision:", round(precision, 4))


# ============================================================
# 15. Recall
# ============================================================

recall = recall_score(
    Y_test,
    Y_pred,
    zero_division = 0
)

print("Recall:", round(recall, 4))


# ============================================================
# 16. F1 Score
# ============================================================

f1 = f1_score(
    Y_test,
    Y_pred,
    zero_division=0
)

print("F1 Score:", round(f1, 4))


# ============================================================
# 17. Plot Training Loss
# ============================================================

plt.figure(figsize = (8, 5))

plt.plot(model.loss_curve_)

plt.xlabel("Iterations")
plt.ylabel("Loss")

plt.title("MLP Training Loss Curve")

plt.grid()

plt.show()

# ============================================================
# 18. Test Model on New Loan Applicants
# ============================================================

def PredictLoanDefault(applicant_data) :

    applicant_df = pd.DataFrame([applicant_data])

    applicant_scaled = scaler.transform(applicant_df)

    prediction = model.predict(
        applicant_scaled
    )[0]

    probability = model.predict_proba(
        applicant_scaled
    )[0][1]

    print("\n----------------------------------------")
    print("Loan Default Prediction")
    print("------------------------------------------")

    print("Prediction:", prediction)

    print("Probability of High Default Risk:", round(probability * 100, 2), "%")

    if prediction == 1:
        print("Result: High default risk")
    else:
        print("Result: Low default risk")

    return prediction

# ============================================================
# New Applicant 1
# ============================================================

applicant1 = {
    "Age": 25,
    "Income": 30000,
    "LoanAmount": 15000,
    "CreditScore": 580,
    "EmploymentYears": 2,
    "ExistingLoans": 3,
    "MonthlyDebt": 12000,
    "LoanTerm": 60,
    "PreviousDefault": 1,
    "HomeOwnership": 0
}

# ============================================================
# New Applicant 2
# ============================================================

applicant2 = {
    "Age": 40,
    "Income": 90000,
    "LoanAmount": 20000,
    "CreditScore": 780,
    "EmploymentYears": 15,
    "ExistingLoans": 1,
    "MonthlyDebt": 5000,
    "LoanTerm": 36,
    "PreviousDefault": 0,
    "HomeOwnership": 1
}

print("\n================ NEW LOAN APPLICANTS =================")

PredictLoanDefault(applicant1)
PredictLoanDefault(applicant2)

# ============================================================
# 19. Hyperparameter Experiment 1
# Activation Function
# ============================================================

print("\n================ EXPERIMENT 1: ACTIVATION =================")

activations = [
    "identity",
    "logistic",
    "tanh",
    "relu"
]

for activation in activations:

    experiment_model = MLPClassifier(
        hidden_layer_sizes=(32, 16),
        activation=activation,
        solver="adam",
        max_iter=1000,
        random_state=42
    )

    experiment_model.fit(
        X_train_scaled,
        Y_train
    )

    prediction = experiment_model.predict(
        X_test_scaled
    )

    score = accuracy_score(
        Y_test,
        prediction
    )

    print(activation, "Accuracy =", round(score * 100, 2), "%")

# ============================================================
# 20. Hyperparameter Experiment 2
# Hidden Layers
# ============================================================

print("\n================ EXPERIMENT 2: HIDDEN LAYERS =================")

hidden_layers = [
    (10,),
    (20, 10),
    (50, 25),
    (100, 50, 25)
]

for layers in hidden_layers:

    experiment_model = MLPClassifier(
        hidden_layer_sizes=layers,
        activation="relu",
        solver="adam",
        max_iter=1000,
        random_state=42
    )

    experiment_model.fit(
        X_train_scaled,
        Y_train
    )

    prediction = experiment_model.predict(
        X_test_scaled
    )

    score = accuracy_score(
        Y_test,
        prediction
    )

    print(layers, "Accuracy =", round(score * 100, 2), "%")


# ============================================================
# 21. Hyperparameter Experiment 3
# Learning Rate
# ============================================================

print("\n================ EXPERIMENT 3: LEARNING RATE =================")

learning_rates = [
    0.0001,
    0.001,
    0.01
]

for learning_rate in learning_rates:

    experiment_model = MLPClassifier(
        hidden_layer_sizes=(32, 16),
        activation="relu",
        solver="adam",
        learning_rate_init=learning_rate,
        max_iter=1000,
        random_state=42
    )

    experiment_model.fit(
        X_train_scaled,
        Y_train
    )

    prediction = experiment_model.predict(
        X_test_scaled
    )

    score = accuracy_score(
        Y_test,
        prediction
    )

    print(learning_rate, "Accuracy = ", round(score * 100, 2),"%")
